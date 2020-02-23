package com.example.shopping.ui.fenlei;


import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shopping.R;
import com.example.shopping.adapter.CategroyAdapter;
import com.example.shopping.base.BaseFragment;
import com.example.shopping.interfaces.shangcheng.CategroyListContract;
import com.example.shopping.models.bean.CategroyCommunityBean;
import com.example.shopping.models.bean.CategroyListBean;
import com.example.shopping.models.bean.CurrentCategoryRvBean;
import com.example.shopping.persenter.fenlei.CategroyPersenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.QTabView;
import q.rorbin.verticaltablayout.widget.TabView;


public class FenleiFragment extends BaseFragment<CategroyListContract.Persenter> implements CategroyListContract.View, VerticalTabLayout.OnTabSelectedListener {


    @BindView(R.id.verticalTab)
    VerticalTabLayout verticalTab;
    @BindView(R.id.img_categroy)
    ImageView imgCategroy;
    @BindView(R.id.name_categroy)
    TextView nameCategroy;
    @BindView(R.id.desccategroy)
    TextView desccategroy;
    @BindView(R.id.rv_categroy)
    RecyclerView rvCategroy;
    private ArrayList<String> titles;
    private TabAdapter tabAdapter;
    private List<CategroyListBean.DataBean.CategoryListBean> categoryList;
    private ArrayList<CategroyCommunityBean> beans;
    private CategroyAdapter categroyAdapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_fenlei;
    }


    @Override
    protected void initView() {
        titles = new ArrayList<>();
        verticalTab.addOnTabSelectedListener(this);
        tabAdapter = new TabAdapter() {
            @Override
            public int getCount() {
                return titles.size();
            }

            @Override
            public ITabView.TabBadge getBadge(int position) {
                return null;
            }

            @Override
            public ITabView.TabIcon getIcon(int position) {
                return null;
            }

            @Override
            public ITabView.TabTitle getTitle(int position) {
                QTabView.TabTitle title = new QTabView.TabTitle.Builder()
                        .setContent(titles.get(position))//设置数据   也有设置字体颜色的方法
                        .build();
                return title;
            }

            @Override
            public int getBackground(int position) {
                return Color.parseColor("#D81B60");
            }
        };
        beans = new ArrayList<>();
        rvCategroy.setLayoutManager(new GridLayoutManager(context, 2) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        categroyAdapter = new CategroyAdapter(beans, context);
        rvCategroy.setAdapter(categroyAdapter);

    }

    @Override
    protected void initData() {
        persenter.getCategroylist();
    }

    @Override
    protected CategroyListContract.Persenter createPersenter() {
        return new CategroyPersenter();
    }

    @Override
    public void getCategroyListReturn(CategroyListBean result) {
        categoryList = result.getData().getCategoryList();
        updateInfo(result.getData().getCurrentCategory().getWap_banner_url(),result.getData().getCurrentCategory().getFront_desc(),
                result.getData().getCurrentCategory().getName());

        for (CategroyListBean.DataBean.CategoryListBean categoryListBean : categoryList) {
            titles.add(categoryListBean.getName());
        }

        for (CategroyListBean.DataBean.CurrentCategoryBean.SubCategoryListBean subCategoryListBean : result.getData().getCurrentCategory().getSubCategoryList()) {
            CategroyCommunityBean categroyCommunityBean = new CategroyCommunityBean();
            categroyCommunityBean.id = subCategoryListBean.getId();
            categroyCommunityBean.name = subCategoryListBean.getName();
            categroyCommunityBean.url = subCategoryListBean.getWap_banner_url();
            beans.add(categroyCommunityBean);
        }
        categroyAdapter.notifyDataSetChanged();
        verticalTab.setTabAdapter(tabAdapter);
    }

    @Override
    public void getCurrentCategroyReturn(CurrentCategoryRvBean result) {
        beans.clear();
        updateInfo(result.getData().getCurrentCategory().getWap_banner_url(),result.getData().getCurrentCategory().getFront_desc(),
                result.getData().getCurrentCategory().getName());
        List<CurrentCategoryRvBean.DataBean.CurrentCategoryBean.SubCategoryListBean> subCategoryList = result.getData().getCurrentCategory().getSubCategoryList();
        for (CurrentCategoryRvBean.DataBean.CurrentCategoryBean.SubCategoryListBean subCategoryListBean : subCategoryList) {
            CategroyCommunityBean categroyCommunityBean = new CategroyCommunityBean();
            categroyCommunityBean.id = subCategoryListBean.getId();
            categroyCommunityBean.name = subCategoryListBean.getName();
            categroyCommunityBean.url = subCategoryListBean.getWap_banner_url();
            beans.add(categroyCommunityBean);
        }
        categroyAdapter.notifyDataSetChanged();
    }

    private void updateInfo(String imgUrl,String des,String title){
        if(!TextUtils.isEmpty(imgUrl)){
            Glide.with(context).load(imgUrl).into(imgCategroy);
        }
        nameCategroy.setText(des);
        desccategroy.setText(title+"分类");
    }
    @Override
    public void onTabSelected(TabView tab, int position) {
        if (categoryList !=null){
            int id = categoryList.get(position).getId();
            persenter.getCurrentCategroy(id);
        }
    }

    @Override
    public void onTabReselected(TabView tab, int position) {

    }
}