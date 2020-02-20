package com.example.shopping.persenter.details;

import com.example.shopping.base.BasePersenter;
import com.example.shopping.common.CommonSubscriber;
import com.example.shopping.interfaces.shangcheng.details.PinpaiDetailsContract;
import com.example.shopping.models.HttpManager;
import com.example.shopping.models.bean.GoodListBean;
import com.example.shopping.models.bean.PinpaiDetailsBean;
import com.example.shopping.utils.RxUtils;

public class PinpaiDetailsPersenter extends BasePersenter<PinpaiDetailsContract.View> implements PinpaiDetailsContract.Persenter {
    @Override
    public void getPinpaiDetail(int id) {
        addSubscribe(HttpManager.getPinpaiApi().getZhuantiData(id)
                .compose(RxUtils.<PinpaiDetailsBean> rxScheduler())
                .subscribeWith(new CommonSubscriber<PinpaiDetailsBean>(mView){
                    @Override
                    public void onNext(PinpaiDetailsBean result) {
                        mView.getPinpaiDetailsBeanReturn(result);
                    }
                }));
    }

    @Override
    public void getGoodList(int id, int page, int size) {
        addSubscribe(HttpManager.getPinpaiApi().getGoodListData(id,page,size)
                .compose(RxUtils.<GoodListBean> rxScheduler())
                .subscribeWith(new CommonSubscriber<GoodListBean>(mView){
                    @Override
                    public void onNext(GoodListBean result) {
                        mView.getGoodlistBeanReturn(result);
                    }
                }));
    }
}
