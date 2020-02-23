package com.example.shopping.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shopping.R;
import com.example.shopping.base.BaseAdapter;
import com.example.shopping.models.bean.CategroyCommunityBean;

import java.util.List;

public class CategroyAdapter extends BaseAdapter {

    public CategroyAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.item_categroy;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
        CategroyCommunityBean categroyCommunityBean = (CategroyCommunityBean) o;
        ImageView img = (ImageView) holder.getView(R.id.img_item_categroy);
        TextView name = (TextView) holder.getView(R.id.name_item_categroy);
        Glide.with(mContext).load(categroyCommunityBean.url).into(img);
        name.setText(categroyCommunityBean.name);

    }
}
