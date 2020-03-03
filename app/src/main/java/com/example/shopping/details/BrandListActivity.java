package com.example.shopping.details;

import android.content.Intent;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopping.R;
import com.example.shopping.adapter.shouye.BrandListAdapter;
import com.example.shopping.base.BaseActivity;
import com.example.shopping.base.BaseAdapter;
import com.example.shopping.interfaces.shangcheng.BrandListContract;
import com.example.shopping.models.bean.BrandListBean;
import com.example.shopping.persenter.home.BrandListPersenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class BrandListActivity extends BaseActivity<BrandListContract.Persenter> implements BrandListContract.View , BaseAdapter.ItemClickHandler {


    @BindView(R.id.rv_barand_list)
    RecyclerView rvBarandList;
    private BrandListAdapter listAdapter;
    private List<BrandListBean.DataBeanX.DataBean> data;

    @Override
    protected int getLayout() {
        return R.layout.activity_brand_list;
    }
    @Override
    protected void initView() {
        rvBarandList.setLayoutManager(new LinearLayoutManager(this));
        rvBarandList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        ArrayList<BrandListBean.DataBeanX.DataBean> dataBeans = new ArrayList<>();
        listAdapter = new BrandListAdapter(dataBeans, this);
        rvBarandList.setAdapter(listAdapter);
        listAdapter.setOnItemClickHandler(this);
    }

    @Override
    protected void initData() {
        persenter.getBrandList(1,100);
    }

    @Override
    protected BrandListContract.Persenter createPersenter() {
        return new BrandListPersenter();
    }


    @Override
    public void getBrandListReturn(BrandListBean result) {
        data = result.getData().getData();
        listAdapter.updata(result.getData().getData());
    }

    @Override
    public void itemClick(int position, BaseAdapter.BaseViewHolder holder) {
        BrandListBean.DataBeanX.DataBean dataBean = data.get(position);
        int id = dataBean.getId();
        Intent intent = new Intent(this, BrandDetailActivity.class);
        intent.putExtra("id",id);
        startActivity(intent);

    }
}
