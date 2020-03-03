package com.example.shopping.persenter.home;

import com.example.shopping.base.BasePersenter;
import com.example.shopping.common.CommonSubscriber;
import com.example.shopping.interfaces.shangcheng.BrandListContract;
import com.example.shopping.models.HttpManager;
import com.example.shopping.models.bean.BrandListBean;
import com.example.shopping.utils.RxUtils;

public class BrandListPersenter extends BasePersenter<BrandListContract.View> implements BrandListContract.Persenter {
    @Override
    public void getBrandList(int page, int size) {
        addSubscribe(HttpManager.getShouyeApi().getBrandList(page,size)
                .compose(RxUtils.<BrandListBean> rxScheduler())
                .subscribeWith(new CommonSubscriber<BrandListBean>(mView){
                    @Override
                    public void onNext(BrandListBean result) {
                        mView.getBrandListReturn(result);
                    }
                }));
    }
}
