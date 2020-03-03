package com.example.shopping.details;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shopping.R;
import com.example.shopping.adapter.details.BrandDetailRvAdapter;
import com.example.shopping.base.BaseActivity;
import com.example.shopping.interfaces.shangcheng.BrandListContract;
import com.example.shopping.models.bean.BrandListDetailBean;
import com.example.shopping.models.bean.BrandTopImgBean;
import com.example.shopping.persenter.details.BrandDetailPersenter;

import java.util.ArrayList;

import butterknife.BindView;

public class BrandDetailActivity extends BaseActivity<BrandListContract.BrandDetailPersenter> implements BrandListContract.BrandDetailView {


    @BindView(R.id.img_brand_detail)
    ImageView imgBrandDetail;
    @BindView(R.id.name_brand_detail)
    TextView nameBrandDetail;
    @BindView(R.id.desc_brand_detail)
    TextView descBrandDetail;
    @BindView(R.id.rv_brand_detail)
    RecyclerView rvBrandDetail;
    private BrandDetailRvAdapter brandDetailRvAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_brand_detail;
    }

    @Override
    protected void initView() {
        ArrayList<BrandListDetailBean.DataBeanX.DataBean> dataBeans = new ArrayList<>();
        brandDetailRvAdapter = new BrandDetailRvAdapter(dataBeans, this);
        rvBrandDetail.setLayoutManager(new GridLayoutManager(this,2));
        rvBrandDetail.setAdapter(brandDetailRvAdapter);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        persenter.getBrandTopImg(id);
        persenter.getBrandListDetail(id, 1, 100);
    }

    @Override
    protected BrandListContract.BrandDetailPersenter createPersenter() {
        return new BrandDetailPersenter();
    }

    @Override
    public void getBrandTopImgReturn(BrandTopImgBean result) {
        Glide.with(this).load(result.getData().getBrand().getList_pic_url()).into(imgBrandDetail);
        nameBrandDetail.setText(result.getData().getBrand().getName());
        descBrandDetail.setText(result.getData().getBrand().getSimple_desc());
    }

    @Override
    public void getBrandListDetailReturn(BrandListDetailBean result) {
        brandDetailRvAdapter.updata(result.getData().getData());
    }
}
