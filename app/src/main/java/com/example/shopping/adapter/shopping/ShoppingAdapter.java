package com.example.shopping.adapter.shopping;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shopping.R;
import com.example.shopping.base.BaseAdapter;
import com.example.shopping.models.bean.CardListBean;

import java.util.List;

public class ShoppingAdapter extends BaseAdapter {
    public ShoppingAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.item_shop;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
        ImageView img = (ImageView) holder.getView(R.id.item_img_shop);
        TextView txt_name = (TextView) holder.getView(R.id.item_name_shop);
        TextView txt_price = (TextView) holder.getView(R.id.item_price_shop);
        TextView txt_nums = (TextView) holder.getView(R.id.item_number_shop);

        CardListBean.DataBean.CartListBean cartListBean = (CardListBean.DataBean.CartListBean) o;

        Glide.with(mContext).load(cartListBean.getList_pic_url()).into(img);
        txt_name.setText(cartListBean.getGoods_name());
        txt_price.setText(cartListBean.getMarket_price()+"");
        txt_nums.setText(cartListBean.getNumber()+"");
    }
}
