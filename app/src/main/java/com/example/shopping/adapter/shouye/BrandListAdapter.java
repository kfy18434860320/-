package com.example.shopping.adapter.shouye;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shopping.R;
import com.example.shopping.base.BaseAdapter;
import com.example.shopping.models.bean.BrandListBean;

import java.util.List;

public class BrandListAdapter extends BaseAdapter {
    public BrandListAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.item_brand_list;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
        BrandListBean.DataBeanX.DataBean dataBean = (BrandListBean.DataBeanX.DataBean) o;
        ImageView img = (ImageView) holder.getView(R.id.img_brand_list);
        TextView name = (TextView) holder.getView(R.id.name_brand_list);
        Glide.with(mContext).load(dataBean.getApp_list_pic_url()).into(img);
        name.setText(dataBean.getName()+" | "+dataBean.getFloor_price()+"元起");

    }
}
