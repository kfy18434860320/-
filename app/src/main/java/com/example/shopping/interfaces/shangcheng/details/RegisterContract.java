package com.example.shopping.interfaces.shangcheng.details;

import com.example.shopping.interfaces.IBasePersenter;
import com.example.shopping.interfaces.IBaseView;
import com.example.shopping.models.bean.RegisterBean;

public interface RegisterContract {
    interface View extends IBaseView {
        void getRegisterBeanReturn(RegisterBean result);
    }

    interface Persenter extends IBasePersenter<View> {
        void getVerify(String name, String passWord);
    }
}
