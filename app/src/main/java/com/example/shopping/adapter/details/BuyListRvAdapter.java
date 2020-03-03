package com.example.shopping.adapter.details;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shopping.R;
import com.example.shopping.base.BaseAdapter;
import com.example.shopping.models.bean.GoodsRelatedbean;

import java.util.List;

public class BuyListRvAdapter extends BaseAdapter {
    public BuyListRvAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.item_new_hot;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
        GoodsRelatedbean.DataBean.GoodsListBean goodsListBean = (GoodsRelatedbean.DataBean.GoodsListBean) o;
        ImageView img = (ImageView) holder.getView(R.id.img_item_new_hot);
        TextView name = (TextView) holder.getView(R.id.name_item_new_hot);
        TextView price = (TextView) holder.getView(R.id.price_item_new_hot);
        Glide.with(mContext).load(goodsListBean.getList_pic_url()).into(img);
        name.setText(goodsListBean.getName());
        price.setText("￥"+goodsListBean.getRetail_price());
    }
}
