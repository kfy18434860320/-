package com.example.shopping.interfaces.shangcheng;

import com.example.shopping.interfaces.IBasePersenter;
import com.example.shopping.interfaces.IBaseView;
import com.example.shopping.models.bean.ZhuantiBean;

public interface ZhuantiContract {
    interface View extends IBaseView {
        void getZhuantiResult(ZhuantiBean result);
    }

    interface Persenter extends IBasePersenter<View> {
        void getZhuantibean(int page, int size);
    }
}
