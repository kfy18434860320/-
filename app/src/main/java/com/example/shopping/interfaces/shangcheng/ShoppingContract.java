package com.example.shopping.interfaces.shangcheng;

import com.example.shopping.interfaces.IBasePersenter;
import com.example.shopping.interfaces.IBaseView;
import com.example.shopping.models.bean.CardListBean;

public interface ShoppingContract {
    interface View extends IBaseView {
        void getCardListReturn(CardListBean result);
    }
    interface Persenter extends IBasePersenter<View> {
        void getCardList();
    }
}
