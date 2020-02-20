package com.example.shopping.details;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shopping.R;
import com.example.shopping.adapter.details.GoodsAdapter;
import com.example.shopping.base.BaseActivity;
import com.example.shopping.interfaces.shangcheng.details.PinpaiDetailsContract;
import com.example.shopping.models.bean.GoodListBean;
import com.example.shopping.models.bean.PinpaiDetailsBean;
import com.example.shopping.persenter.details.PinpaiDetailsPersenter;

import java.util.ArrayList;

import butterknife.BindView;

public class PinpaiDetailsActivity extends BaseActivity<PinpaiDetailsContract.Persenter> implements PinpaiDetailsContract.View {

    @BindView(R.id.img_pinpaiDetails)
    ImageView imgPinpaiDetails;
    @BindView(R.id.name_pinpaidetails)
    TextView namePinpaidetails;
    @BindView(R.id.desc_pinpaidetails)
    TextView descPinpaidetails;
    @BindView(R.id.rv_pinpaidetails)
    RecyclerView rvPinpaidetails;
    private int id;
    private ArrayList<GoodListBean.DataBeanX.GoodsListBean> dataBeans;
    private GoodsAdapter pinpaiAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_pinpai_details;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        dataBeans = new ArrayList<>();
        pinpaiAdapter = new GoodsAdapter(dataBeans, this);
        rvPinpaidetails.setLayoutManager(new GridLayoutManager(this, 2));
        rvPinpaidetails.setAdapter(pinpaiAdapter);
    }

    @Override
    protected void initData() {
        persenter.getPinpaiDetail(id);
        persenter.getGoodList(id,1,100);
    }

    @Override
    protected PinpaiDetailsContract.Persenter createPersenter() {
        return new PinpaiDetailsPersenter();
    }

    @Override
    public void getPinpaiDetailsBeanReturn(PinpaiDetailsBean result) {
        PinpaiDetailsBean.DataBean.BrandBean brand = result.getData().getBrand();
        Glide.with(this).load(brand.getApp_list_pic_url()).into(imgPinpaiDetails);
        namePinpaidetails.setText(brand.getName());
        descPinpaidetails.setText(brand.getSimple_desc());
    }

    @Override
    public void getGoodlistBeanReturn(GoodListBean result) {
        dataBeans.clear();
        dataBeans.addAll(result.getData().getGoodsList());
        pinpaiAdapter.notifyDataSetChanged();
    }


}
