package com.example.shopping.adapter.shouye;


import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shopping.R;
import com.example.shopping.base.BaseAdapter;
import com.example.shopping.models.bean.ShouYeBean;

import java.util.List;

public class ZhuantiRvAdapter extends BaseAdapter {
    private static final String TAG = "ZhuantiRvAdapter";

    public ZhuantiRvAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.item_rv_zhuannti;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
        ShouYeBean.DataBean.TopicListBean topicListBean = (ShouYeBean.DataBean.TopicListBean) o;
        ImageView img = (ImageView) holder.getView(R.id.img_zhuanti);
        TextView title = (TextView) holder.getView(R.id.titlezhuanti);
        Glide.with(mContext).load(topicListBean.getScene_pic_url()).into(img);
        title.setText(topicListBean.getTitle());
        Log.i(TAG, "bindData: "+topicListBean.getTitle());
    }
}
