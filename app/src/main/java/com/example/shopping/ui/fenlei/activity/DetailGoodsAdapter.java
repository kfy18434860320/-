package com.example.shopping.ui.fenlei.activity;


import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shopping.R;
import com.example.shopping.base.BaseAdapter;
import com.example.shopping.models.bean.SortDetailGoodsBean;

import java.util.List;

public class DetailGoodsAdapter extends BaseAdapter {
    public DetailGoodsAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.layout_sortdetail_goodsitem;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
        SortDetailGoodsBean.DataBeanX.GoodsListBean bean = (SortDetailGoodsBean.DataBeanX.GoodsListBean) o;
        ImageView img = (ImageView)holder.getView(R.id.img_icon);
        TextView txtName = (TextView)holder.getView(R.id.txt_name);
        TextView txtPrice = (TextView)holder.getView(R.id.txt_price);
        Glide.with(mContext).load(bean.getList_pic_url()).into(img);
        txtName.setText(bean.getName());
        String price = mContext.getResources().getString(R.string.price_news_model);
        txtPrice.setText(price.replace("$",String.valueOf(bean.getRetail_price())));

    }
}
