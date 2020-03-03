package com.example.shopping.adapter.details;


import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shopping.R;
import com.example.shopping.base.BaseAdapter;
import com.example.shopping.models.bean.BrandListDetailBean;

import java.util.List;

public class BrandDetailRvAdapter extends BaseAdapter {

    public BrandDetailRvAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.item_band_detail;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
        BrandListDetailBean.DataBeanX.DataBean brandListBean = (BrandListDetailBean.DataBeanX.DataBean) o;
        ImageView img = (ImageView) holder.getView(R.id.img_item_brand_detail);
        TextView name = (TextView) holder.getView(R.id.name_item_brand_detail);
        TextView price = (TextView) holder.getView(R.id.price_item_brand_detail);
        Glide.with(mContext).load(brandListBean.getList_pic_url()).into(img);
        name.setText(brandListBean.getName());
        price.setText("￥"+brandListBean.getRetail_price());
    }
}
