package com.example.shopping.adapter.details;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shopping.R;
import com.example.shopping.base.BaseAdapter;
import com.example.shopping.models.bean.GoodListBean;

import java.util.List;

public class GoodsAdapter extends BaseAdapter {
    public GoodsAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.item_pinpaidetails;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
//        GoodListBean.DataBeanX.DataBean dataBean = (GoodListBean.DataBeanX.DataBean) o;
        GoodListBean.DataBeanX.GoodsListBean dataBean = (GoodListBean.DataBeanX.GoodsListBean) o;
        ImageView img = (ImageView) holder.getView(R.id.img_item_pinpaidetails);
        TextView name = (TextView) holder.getView(R.id.name_item_pinpaidetails);
        TextView price = (TextView) holder.getView(R.id.price_item_pinpaidetails);
        Glide.with(mContext).load(dataBean.getList_pic_url()).into(img);
        name.setText(dataBean.getName());
        price.setText(dataBean.getRetail_price());
    }
}
