package com.example.shopping.adapter.shouye;


import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shopping.R;
import com.example.shopping.base.BaseAdapter;
import com.example.shopping.models.bean.ShouYeBean;

import java.util.List;

public class XinpinRvAdapter extends BaseAdapter {

    public XinpinRvAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.item_rv_xinpin;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
        ShouYeBean.DataBean.NewGoodsListBean newGoodsListBean = (ShouYeBean.DataBean.NewGoodsListBean) o;
        ImageView img = (ImageView) holder.getView(R.id.img_xinpin);
        TextView name = (TextView) holder.getView(R.id.name_xinpin);
        TextView price = (TextView) holder.getView(R.id.price_xinpin);
        Glide.with(mContext).load(newGoodsListBean.getList_pic_url()).into(img);
        name.setText(newGoodsListBean.getName());
        price.setText(newGoodsListBean.getRetail_price());
    }
}
