package com.example.shopping.ui.fenlei.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopping.R;
import com.example.shopping.base.BaseActivity;
import com.example.shopping.common.RecycleGridDivider;
import com.example.shopping.interfaces.shangcheng.SortConstract;
import com.example.shopping.models.bean.SortDetailGoodsBean;
import com.example.shopping.models.bean.SortDetailTabBean;
import com.example.shopping.persenter.fenlei.SortDetailPersenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class SortDetailActivity extends BaseActivity<SortConstract.DetailPersenter> implements SortConstract.DetailView,
        TabLayout.OnTabSelectedListener {
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.txt_name)
    TextView txtName;
    @BindView(R.id.txt_des)
    TextView txtDes;
    @BindView(R.id.layout_infos)
    ConstraintLayout layoutInfos;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    List<SortDetailTabBean.DataBean.BrotherCategoryBean> tabs;

    List<SortDetailGoodsBean.DataBeanX.GoodsListBean> goodsList;
    DetailGoodsAdapter detailGoodsAdapter;


    @Override
    protected int getLayout() {
        return R.layout.activity_sort_detail;
    }

    @Override
    protected void initView() {
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.addOnTabSelectedListener(this);

        goodsList = new ArrayList<>();
        detailGoodsAdapter = new DetailGoodsAdapter(goodsList,this);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(detailGoodsAdapter);
        recyclerView.addItemDecoration(new RecycleGridDivider());

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {
        int id = getIntent().getIntExtra("sortId", 0);
        persenter.getSortDetailTab(id);
    }

    @Override
    protected SortConstract.DetailPersenter createPersenter() {
        return (SortConstract.DetailPersenter) new SortDetailPersenter();
    }

    @Override
    public void getSortDetailTabReturn(SortDetailTabBean result) {

        int position = -1;
        tabs = result.getData().getBrotherCategory();
        //动态添加tab导航的内容
        for (int i=0; i<result.getData().getBrotherCategory().size(); i++){
            SortDetailTabBean.DataBean.BrotherCategoryBean item = result.getData().getBrotherCategory().get(i);
            TabLayout.Tab tab = tabLayout.newTab();
            tab.setText(item.getName());
            tab.setTag(item.getId());
            tabLayout.addTab(tab);

            if(result.getData().getCurrentCategory().getId() == item.getId()){
                position = i;
            }
        }
        if(position >= 0){
            tabLayout.getTabAt(position).select();
        }
    }

    @Override
    public void getSortDetailGoodsReturn(SortDetailGoodsBean result) {
        detailGoodsAdapter.updata(result.getData().getGoodsList());
    }

    //选中tab
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        //刷新显示的名字描述信息
        SortDetailTabBean.DataBean.BrotherCategoryBean bean = tabs.get(tab.getPosition());
        txtName.setText(bean.getFront_name());
        txtDes.setText(bean.getFront_desc());
        int id = (int) tab.getTag();
        //获取商品列表数据
        persenter.getSortDetailGoods(id,1,1000);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
