package com.example.shopping.ui.shopping;



import android.content.Intent;
import android.text.TextUtils;

import com.example.shopping.R;
import com.example.shopping.base.BaseFragment;
import com.example.shopping.interfaces.IBasePersenter;
import com.example.shopping.ui.login.LoginActivity;
import com.example.shopping.utils.SpUtils;


public class ShoppingFragment extends BaseFragment {
    @Override
    protected int getLayout() {
        return R.layout.fragment_shopping;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        //如果用户没有登录就要
        String token = SpUtils.getInstance().getString("token");
        if (TextUtils.isEmpty(token)) {
            Intent intent = new Intent(context, LoginActivity.class);
            startActivityForResult(intent,100);
        } else {
          // 已登录则展示购物车页面
        }
    }

    @Override
    protected IBasePersenter createPersenter() {
        return null;
    }
}
