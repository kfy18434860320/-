package com.example.shopping.persenter.details;

import com.example.shopping.base.BasePersenter;
import com.example.shopping.common.CommonSubscriber;
import com.example.shopping.interfaces.shangcheng.details.BuyDetailContract;
import com.example.shopping.models.HttpManager;
import com.example.shopping.models.bean.BuyBean;
import com.example.shopping.models.bean.GoodsRelatedbean;
import com.example.shopping.utils.RxUtils;

public class BuyPersenter extends BasePersenter<BuyDetailContract.View> implements BuyDetailContract.Persenter {
    @Override
    public void getBuy(int id) {
        addSubscribe(HttpManager.getShouyeApi().getBuyData(id)
                .compose(RxUtils.<BuyBean> rxScheduler())
                .subscribeWith(new CommonSubscriber<BuyBean>(mView){
                    @Override
                    public void onNext(BuyBean result) {
                        mView.getBuyReturn(result);
                    }
                }));
    }

    @Override
    public void getGoodsRelaterd(int id) {
        addSubscribe(HttpManager.getShouyeApi().getGoodsRelated(id)
                .compose(RxUtils.<GoodsRelatedbean> rxScheduler())
                .subscribeWith(new CommonSubscriber<GoodsRelatedbean>(mView){
                    @Override
                    public void onNext(GoodsRelatedbean result) {
                        mView.getGoodsRelatedReturn(result);
                    }
                }));
    }
}
