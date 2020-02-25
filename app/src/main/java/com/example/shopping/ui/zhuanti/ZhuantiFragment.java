package com.example.shopping.ui.zhuanti;



import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopping.R;
import com.example.shopping.adapter.ZhuantiAdapter;
import com.example.shopping.base.BaseFragment;
import com.example.shopping.interfaces.shangcheng.ZhuantiContract;
import com.example.shopping.models.bean.ZhuantiBean;
import com.example.shopping.persenter.zhuanti.ZhuantiPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ZhuantiFragment extends BaseFragment<ZhuantiContract.Persenter> implements ZhuantiContract.View {


    @BindView(R.id.rv_zhuanti)
    RecyclerView rvZhuanti;
    private ArrayList<ZhuantiBean.DataBeanX.DataBean> dataBeans;
    private ZhuantiAdapter adapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_zhuanti;
    }

    @Override
    protected void initView() {
        rvZhuanti.setLayoutManager(new LinearLayoutManager(context));
        dataBeans = new ArrayList<>();
        adapter = new ZhuantiAdapter(dataBeans,context);
        rvZhuanti.setAdapter(adapter);
    }


    @Override
    protected void initData() {
        int page = 1;
        int size = 10;
        persenter.getZhuantibean(page,size);
    }

    @Override
    protected ZhuantiContract.Persenter createPersenter() {
        return new ZhuantiPresenter();
    }



    @Override
    public void getZhuantiResult(ZhuantiBean result) {
        List<ZhuantiBean.DataBeanX.DataBean> data = result.getData().getData();
        dataBeans.addAll(data);
        adapter.notifyDataSetChanged();
    }
}