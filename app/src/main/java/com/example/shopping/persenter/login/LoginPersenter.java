package com.example.shopping.persenter.login;

import com.example.shopping.base.BasePersenter;
import com.example.shopping.common.CommonSubscriber;
import com.example.shopping.interfaces.shangcheng.details.LoginContract;
import com.example.shopping.models.HttpManager;
import com.example.shopping.models.bean.UserBean;
import com.example.shopping.utils.RxUtils;

public class LoginPersenter extends BasePersenter<LoginContract.View> implements LoginContract.Persenter {
    @Override
    public void login(String nickname, String password) {
        addSubscribe(HttpManager.getInstance().getShouyeApi().login(nickname,password)
                .compose(RxUtils.<UserBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<UserBean>(mView){

                    @Override
                    public void onNext(UserBean userBean) {
                        if(userBean.getErrno() == 0){
                            mView.loginReturn(userBean);
                        }else{
                            mView.showTips(userBean.getErrmsg());
                        }
                    }
                }));
    }
}
