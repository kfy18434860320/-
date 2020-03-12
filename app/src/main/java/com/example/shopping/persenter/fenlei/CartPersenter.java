package com.example.shopping.persenter.fenlei;


import com.example.shopping.base.BasePersenter;
import com.example.shopping.common.CommonSubscriber;
import com.example.shopping.interfaces.shangcheng.CartConstart;
import com.example.shopping.models.HttpManager;
import com.example.shopping.models.bean.JobGoShoppingBean;
import com.example.shopping.models.bean.SortDetailItemBean;
import com.example.shopping.utils.RxUtils;

public class CartPersenter extends BasePersenter<CartConstart.View> implements CartConstart.Persenter {
    @Override
    public void getSortDetailItemData(int id) {
        addSubScribe(HttpManager.getInstance().getShopApi().getSortDetailItemData(id)
        .compose(RxUtils.<SortDetailItemBean>rxScheduler())
        .subscribeWith(new CommonSubscriber<SortDetailItemBean>(mView) {
            @Override
            public void onNext(SortDetailItemBean sortDetailItemBean) {
                mView.getSortDetailItemDataReturn(sortDetailItemBean);
            }
        }));
    }

    @Override
    public void getJobGoShopping(int goodsId, int number, int productId) {
        addSubScribe(HttpManager.getInstance().getShopApi().getJobGoShopping(goodsId,number,productId)
                .compose(RxUtils.<JobGoShoppingBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<JobGoShoppingBean>(mView) {
                    @Override
                    public void onNext(JobGoShoppingBean jobGoShoppingBean) {
                        mView.getJobGoShoppingReturn(jobGoShoppingBean);
                    }
                }));
    }

}
