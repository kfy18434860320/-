package com.example.shopping.adapter.shouye;


import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shopping.R;
import com.example.shopping.base.BaseAdapter;
import com.example.shopping.models.bean.ShouYeBean;

import java.util.List;

public class RenqiRvAdapter extends BaseAdapter {


    public RenqiRvAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.item_rv_renqi;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
        ShouYeBean.DataBean.HotGoodsListBean hotGoodsListBean = (ShouYeBean.DataBean.HotGoodsListBean) o;
        ImageView img = (ImageView) holder.getView(R.id.img_renqi);
        TextView name = (TextView) holder.getView(R.id.name_renqi);
        TextView price = (TextView) holder.getView(R.id.price_renqi);
        TextView brief = (TextView) holder.getView(R.id.brief_renqi);
        Glide.with(mContext).load(hotGoodsListBean.getList_pic_url()).into(img);
        name.setText(hotGoodsListBean.getName());
        price.setText(hotGoodsListBean.getRetail_price());
        brief.setText(hotGoodsListBean.getGoods_brief());
    }
}
