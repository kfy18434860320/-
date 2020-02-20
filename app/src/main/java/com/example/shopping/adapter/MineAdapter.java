package com.example.shopping.adapter;


import android.content.Context;
import android.widget.TextView;

import com.example.shopping.R;
import com.example.shopping.base.BaseAdapter;

import java.util.List;

public class MineAdapter extends BaseAdapter {
    public MineAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.item_mine;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
        String str = (String) o;
        TextView tv = (TextView) holder.getView(R.id.tv_me_item_text);
        tv.setText(str);
    }
}
