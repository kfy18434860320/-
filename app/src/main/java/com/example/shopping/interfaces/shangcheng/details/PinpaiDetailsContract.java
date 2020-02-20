package com.example.shopping.interfaces.shangcheng.details;

import com.example.shopping.interfaces.IBasePersenter;
import com.example.shopping.interfaces.IBaseView;
import com.example.shopping.models.bean.GoodListBean;
import com.example.shopping.models.bean.PinpaiDetailsBean;

public interface PinpaiDetailsContract {
    interface View extends IBaseView {
        void getPinpaiDetailsBeanReturn(PinpaiDetailsBean result);

        void getGoodlistBeanReturn(GoodListBean result);
    }
    interface Persenter extends IBasePersenter<View> {
        void getPinpaiDetail(int id);

        void getGoodList(int id, int page, int size);
    }
}
