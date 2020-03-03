package com.example.shopping.adapter.details;

import android.content.Context;
import android.widget.TextView;

import com.example.shopping.R;
import com.example.shopping.base.BaseAdapter;
import com.example.shopping.models.bean.BuyBean;

import java.util.List;

public class BuyWentiAdapter extends BaseAdapter {
    public BuyWentiAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.item_buy_wenti;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
        BuyBean.DataBeanX.IssueBean issueBean = (BuyBean.DataBeanX.IssueBean) o;
        TextView question = (TextView) holder.getView(R.id.question_item_buy_wenti);
        TextView answer = (TextView) holder.getView(R.id.answer_item_buy_wenti);
        question.setText("·"+issueBean.getQuestion());
        answer.setText(issueBean.getAnswer());
    }
}
