package com.example.shopping.persenter.login;

import com.example.shopping.base.BasePersenter;
import com.example.shopping.common.CommonSubscriber;
import com.example.shopping.interfaces.shangcheng.details.RegisterContract;
import com.example.shopping.models.HttpManager;
import com.example.shopping.models.bean.RegisterBean;
import com.example.shopping.utils.RxUtils;

public class RegisterPersenter extends BasePersenter<RegisterContract.View> implements RegisterContract.Persenter {
    @Override
    public void getVerify(String name,String password) {
        addSubscribe(HttpManager.getInstance().getShouyeApi().register(name, password)
                .compose(RxUtils.<RegisterBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<RegisterBean>(mView){

                    @Override
                    public void onNext(RegisterBean result) {
                        mView.getRegisterBeanReturn(result);
                    }
                }));
    }
}
