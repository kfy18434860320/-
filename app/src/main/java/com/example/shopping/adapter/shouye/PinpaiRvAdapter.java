package com.example.shopping.adapter.shouye;


import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shopping.R;
import com.example.shopping.base.BaseAdapter;
import com.example.shopping.models.bean.ShouYeBean;

import java.util.List;

public class PinpaiRvAdapter extends BaseAdapter {

    public PinpaiRvAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.item_rv_pinpai;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
        ShouYeBean.DataBean.BrandListBean brandListBean = (ShouYeBean.DataBean.BrandListBean) o;
        ImageView img = (ImageView) holder.getView(R.id.img_item_rv);
        TextView name = (TextView) holder.getView(R.id.name);
        TextView price = (TextView) holder.getView(R.id.price);
        Glide.with(mContext).load(brandListBean.getNew_pic_url()).into(img);
        name.setText(brandListBean.getName());
        price.setText(brandListBean.getFloor_price());
    }
}
