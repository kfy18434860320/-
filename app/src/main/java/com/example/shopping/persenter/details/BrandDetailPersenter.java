package com.example.shopping.persenter.details;

import com.example.shopping.base.BasePersenter;
import com.example.shopping.common.CommonSubscriber;
import com.example.shopping.interfaces.shangcheng.BrandListContract;
import com.example.shopping.models.HttpManager;
import com.example.shopping.models.bean.BrandListDetailBean;
import com.example.shopping.models.bean.BrandTopImgBean;
import com.example.shopping.utils.RxUtils;

public class BrandDetailPersenter extends BasePersenter<BrandListContract.BrandDetailView> implements BrandListContract.BrandDetailPersenter {
    @Override
    public void getBrandTopImg(int id) {
        addSubscribe(HttpManager.getShouyeApi().getBrandTopImg(id)
                .compose(RxUtils.<BrandTopImgBean> rxScheduler())
                .subscribeWith(new CommonSubscriber<BrandTopImgBean>(mView){
                    @Override
                    public void onNext(BrandTopImgBean result) {
                        mView.getBrandTopImgReturn(result);
                    }
                }));
    }

    @Override
    public void getBrandListDetail(int id, int page, int size) {
        addSubscribe(HttpManager.getShouyeApi().getBrandListDetail(id,page,size)
                .compose(RxUtils.<BrandListDetailBean> rxScheduler())
                .subscribeWith(new CommonSubscriber<BrandListDetailBean>(mView){
                    @Override
                    public void onNext(BrandListDetailBean result) {
                        mView.getBrandListDetailReturn(result);
                    }
                }));

    }
}
