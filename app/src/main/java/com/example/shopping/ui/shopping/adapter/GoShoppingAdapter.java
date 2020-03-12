package com.example.shopping.ui.shopping.adapter;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;
import com.example.shopping.R;
import com.example.shopping.base.BaseAdapter;
import com.example.shopping.models.bean.GoShoppingBean;


import java.util.List;

public class GoShoppingAdapter extends BaseAdapter {
    public boolean isEdit;//判断界面状态是否是编辑状态

    public GoShoppingAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.shopping_item;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
        ConstraintLayout defaults = (ConstraintLayout) holder.getView(R.id.con_default);
        ConstraintLayout edit = (ConstraintLayout) holder.getView(R.id.con_edit);
        defaults.setVisibility(isEdit ? View.GONE : View.VISIBLE);
        edit.setVisibility(isEdit ? View.VISIBLE : View.GONE);

        GoShoppingBean.DataBean.CartListBean cartlist = (GoShoppingBean.DataBean.CartListBean) o;
        CheckBox ck_select = (CheckBox) holder.getView(R.id.ck_select_item);
        ImageView iv = (ImageView) holder.getView(R.id.iv_item);

        //默认布局的控件
        TextView namede = (TextView) holder.getView(R.id.tv_cart_name);
        TextView pricede = (TextView) holder.getView(R.id.tv_cart_price);
        TextView numde = (TextView) holder.getView(R.id.tv_cart_num);
        //编辑页面的控件
        TextView priced = (TextView) holder.getView(R.id.tv_edit_price);
        TextView subed = (TextView) holder.getView(R.id.tv_edit_subtract);
        TextView numed = (TextView) holder.getView(R.id.tv_edit_num);
        TextView added = (TextView) holder.getView(R.id.tv_edit_add);

        Glide.with(mContext).load(cartlist.getList_pic_url()).into(iv);

        ck_select.setTag(o);
        ck_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoShoppingBean.DataBean.CartListBean bean = (GoShoppingBean.DataBean.CartListBean) v.getTag();
                boolean isChecked = ck_select.isChecked();
                if (!isEdit) {
                    bean.isSelect = isChecked;
                    if (itemClickHandler != null) {
                        itemClickHandler.itemClick(holder.getLayoutPosition(), holder);
                    }
                } else {
                    bean.isDeleteSelect = isChecked;
                }
            }
        });
        //defailt状态下
        if (!isEdit) {//正常状态下显示的item
            ck_select.setChecked(cartlist.isSelect);
            namede.setText(cartlist.getGoods_name());
            pricede.setText("¥ "+cartlist.getRetail_price());
            numde.setText(String.valueOf(cartlist.getNumber()));
        }else {//编辑状态下显示item
            ck_select.setChecked(false);
            priced.setText("¥ "+cartlist.getRetail_price());
            numed.setText(cartlist.getNumber()+"");
            subed.setTag(holder);
            subed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cartlist.getNumber() == 1) return;;
                    cartlist.setNumber(cartlist.getNumber()-1);
                    //更新数据
                    BaseViewHolder vh = (BaseViewHolder) v.getTag();
                    int pos = vh.getLayoutPosition();
                    if (itemClickHandler != null) {
                        itemClickHandler.itemClick(pos,vh);
                    }
                }
            });
            added.setTag(holder);
            added.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cartlist.setNumber(cartlist.getNumber()+1);
                    //更新数据
                    BaseViewHolder vh = (BaseViewHolder) v.getTag();
                    int pos = vh.getLayoutPosition();
                    if (itemClickHandler != null) {
                        itemClickHandler.itemClick(pos,vh);
                    }
                }
            });
        }

    }
}
