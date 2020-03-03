package com.example.shopping.interfaces.shangcheng.details;

import com.example.shopping.interfaces.IBasePersenter;
import com.example.shopping.interfaces.IBaseView;
import com.example.shopping.models.bean.BuyBean;
import com.example.shopping.models.bean.GoodsRelatedbean;

public interface BuyDetailContract {
    interface View extends IBaseView {
        void getBuyReturn(BuyBean result);

        void getGoodsRelatedReturn(GoodsRelatedbean result);
    }
    interface  Persenter extends IBasePersenter<View> {
        void getBuy(int id);

        void getGoodsRelaterd(int id);
    }
}
