package com.example.shopping.ui.home;


import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopping.R;
import com.example.shopping.base.BaseFragment;
import com.example.shopping.interfaces.shangcheng.ShouyeContract;
import com.example.shopping.models.bean.ShouYeBean;
import com.example.shopping.persenter.home.ShouyePresenter;

import butterknife.BindView;

public class JujiaFragment extends BaseFragment<ShouyeContract.Persenter> implements ShouyeContract.View{
    @BindView(R.id.rv_jujia)
    RecyclerView rvJujia;

    @Override
    protected int getLayout() {
        return R.layout.fragment_jujia;
    }

    @Override
    protected void initView() {
        rvJujia.setLayoutManager(new GridLayoutManager(context,2));
    }


    @Override
    protected void initData() {
        ((ShouyePresenter)persenter).getshouye();
    }

    @Override
    protected ShouyeContract.Persenter createPersenter() {
        return new ShouyePresenter();
    }


    @Override
    public void getshouyeReturn(ShouYeBean shouYeBean) {
        ShouYeBean.DataBean data = shouYeBean.getData();

    }
}
