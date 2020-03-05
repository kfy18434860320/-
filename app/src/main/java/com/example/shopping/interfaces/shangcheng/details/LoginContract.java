package com.example.shopping.interfaces.shangcheng.details;

import com.example.shopping.interfaces.IBasePersenter;
import com.example.shopping.interfaces.IBaseView;
import com.example.shopping.models.bean.UserBean;

public interface LoginContract {
    interface View extends IBaseView {
        void loginReturn(UserBean result);
    }

    interface Persenter extends IBasePersenter<View> {
        void login(String nickname, String password);
    }
}
