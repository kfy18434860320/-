package com.example.shopping.ui.mine;


import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopping.R;
import com.example.shopping.adapter.MineAdapter;
import com.example.shopping.base.BaseFragment;
import com.example.shopping.interfaces.IBasePersenter;

import java.util.ArrayList;

import butterknife.BindView;

public class MineFragment extends BaseFragment {

    @BindView(R.id.img_mine)
    ImageView imgMine;
    @BindView(R.id.tv_mine)
    TextView tvMine;
    @BindView(R.id.rv_mine)
    RecyclerView rvMine;

    @Override
    protected int getLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {
        rvMine.setLayoutManager(new GridLayoutManager(context,3));
        ArrayList<String> strings = new ArrayList<>();
        strings.add("我的订单");
        strings.add("优惠券");
        strings.add("礼品卡");
        strings.add("我的收藏");
        strings.add("我的足迹");
        strings.add("会员福利");
        strings.add("地址管理");
        strings.add("账号安全");
        strings.add("联系客服");
        strings.add("帮助中心");
        strings.add("意见反馈");
        MineAdapter adapter = new MineAdapter(strings, context);
        rvMine.setAdapter(adapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected IBasePersenter createPersenter() {
        return null;
    }
}
