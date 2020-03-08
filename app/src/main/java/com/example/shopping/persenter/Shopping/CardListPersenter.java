package com.example.shopping.persenter.Shopping;

import com.example.shopping.base.BasePersenter;
import com.example.shopping.common.CommonSubscriber;
import com.example.shopping.interfaces.shangcheng.ShoppingContract;
import com.example.shopping.models.HttpManager;
import com.example.shopping.models.bean.CardListBean;
import com.example.shopping.utils.RxUtils;

public class CardListPersenter extends BasePersenter<ShoppingContract.View> implements ShoppingContract.Persenter {
    @Override
    public void getCardList() {
        addSubscribe(HttpManager.getShouyeApi().getCardList()
                .compose(RxUtils.<CardListBean> rxScheduler())
                .subscribeWith(new CommonSubscriber<CardListBean>(mView){
                    @Override
                    public void onNext(CardListBean result) {
                        mView.getCardListReturn(result);
                    }
                }));
    }
}
