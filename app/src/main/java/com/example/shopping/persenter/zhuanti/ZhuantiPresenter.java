package com.example.shopping.persenter.zhuanti;

import com.example.shopping.base.BasePersenter;
import com.example.shopping.common.CommonSubscriber;
import com.example.shopping.interfaces.shangcheng.ZhuantiContract;
import com.example.shopping.models.HttpManager;
import com.example.shopping.models.bean.ZhuantiBean;
import com.example.shopping.utils.RxUtils;

public class ZhuantiPresenter extends BasePersenter<ZhuantiContract.View> implements ZhuantiContract.Persenter {


    @Override
    public void getZhuantibean(int page, int size) {
        addSubscribe(HttpManager.getShouyeApi().getZhuantiData(1,10)
                .compose(RxUtils.<ZhuantiBean> rxScheduler())
                .subscribeWith(new CommonSubscriber<ZhuantiBean>(mView){
                    @Override
                    public void onNext(ZhuantiBean result) {
                        mView.getZhuantiResult(result);
                    }
                }));
    }
}
