package com.example.shopping.persenter.home;

import com.example.shopping.base.BasePersenter;
import com.example.shopping.common.CommonSubscriber;
import com.example.shopping.interfaces.shangcheng.ShouyeContract;
import com.example.shopping.models.HttpManager;
import com.example.shopping.models.bean.ShouYeBean;
import com.example.shopping.utils.RxUtils;

public class ShouyePresenter extends BasePersenter<ShouyeContract.View> implements ShouyeContract.Persenter{

    @Override
    public void getshouye() {
        addSubscribe(HttpManager.getShouyeApi().getShouyeData()
                .compose(RxUtils.<ShouYeBean> rxScheduler())
                .subscribeWith(new CommonSubscriber<ShouYeBean>(mView){
                    @Override
                    public void onNext(ShouYeBean result) {
                        mView.getshouyeReturn(result);
                    }
                }));
    }
}
