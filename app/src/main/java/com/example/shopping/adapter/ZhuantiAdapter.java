package com.example.shopping.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shopping.R;
import com.example.shopping.base.BaseAdapter;
import com.example.shopping.models.bean.ZhuantiBean;

import java.util.List;

public class ZhuantiAdapter extends BaseAdapter {


    public ZhuantiAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.item_zhuanti;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
        ZhuantiBean.DataBeanX.DataBean dataBean = (ZhuantiBean.DataBeanX.DataBean) o;
        ImageView img = (ImageView) holder.getView(R.id.img_rv_zhuanti);
        TextView title = (TextView) holder.getView(R.id.title_zhaunti);
        TextView subtitle = (TextView) holder.getView(R.id.subtitle);
        Glide.with(mContext).load(dataBean.getScene_pic_url()).into(img);
        title.setText(dataBean.getTitle());
        subtitle.setText(dataBean.getSubtitle());
    }
}
