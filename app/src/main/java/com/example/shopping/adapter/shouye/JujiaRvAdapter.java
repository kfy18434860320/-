package com.example.shopping.adapter.shouye;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shopping.R;
import com.example.shopping.base.BaseAdapter;
import com.example.shopping.models.bean.ShouYeBean;

import java.util.List;

public class JujiaRvAdapter extends BaseAdapter {
    public JujiaRvAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.item_jujia_shouye;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
        ShouYeBean.DataBean.CategoryListBean.GoodsListBean goodsListBean = (ShouYeBean.DataBean.CategoryListBean.GoodsListBean) o;
        ImageView img = (ImageView) holder.getView(R.id.img_jujia_shouye);
        TextView name = (TextView) holder.getView(R.id.name_jujia_shouye);
        TextView price = (TextView) holder.getView(R.id.price_jujia_shouye);
        Glide.with(mContext).load(goodsListBean.getList_pic_url()).into(img);
        name.setText(goodsListBean.getName());
        price.setText("￥"+goodsListBean.getRetail_price());
    }

}
