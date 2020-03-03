package com.example.shopping.adapter.details;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shopping.R;
import com.example.shopping.base.BaseAdapter;
import com.example.shopping.models.bean.NewDataBean;

import java.util.List;

public class NewHotAdapter extends BaseAdapter {
    public int tag = 1;
    public NewHotAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.item_new_hot;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
        ImageView img = (ImageView) holder.getView(R.id.img_item_new_hot);
        TextView name = (TextView) holder.getView(R.id.name_item_new_hot);
        TextView price = (TextView) holder.getView(R.id.price_item_new_hot);
        if (tag == 1){
            NewDataBean.DataBeanX.DataBean dataBean = (NewDataBean.DataBeanX.DataBean) o;
            Glide.with(mContext).load(dataBean.getList_pic_url()).into(img);
            name.setText(dataBean.getName());
            price.setText(dataBean.getRetail_price());
        }else{
            NewDataBean.DataBeanX.DataBean dataBean = (NewDataBean.DataBeanX.DataBean) o;
            Glide.with(mContext).load(dataBean.getList_pic_url()).into(img);
            name.setText(dataBean.getName());
            price.setText(dataBean.getRetail_price());
        }
    }
}
