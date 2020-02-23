package com.example.shopping.persenter.fenlei;

import com.example.shopping.base.BasePersenter;
import com.example.shopping.common.CommonSubscriber;
import com.example.shopping.interfaces.shangcheng.CategroyListContract;
import com.example.shopping.models.HttpManager;
import com.example.shopping.models.bean.CategroyListBean;
import com.example.shopping.models.bean.CurrentCategoryRvBean;
import com.example.shopping.utils.RxUtils;

public class CategroyPersenter extends BasePersenter<CategroyListContract.View> implements CategroyListContract.Persenter {
    @Override
    public void getCategroylist() {
        addSubscribe(HttpManager.getCategroylistApii().getCategroy()
                .compose(RxUtils.<CategroyListBean> rxScheduler())
                .subscribeWith(new CommonSubscriber<CategroyListBean>(mView){
                    @Override
                    public void onNext(CategroyListBean result) {
                        mView.getCategroyListReturn(result);
                    }
                }));
    }

    @Override
    public void getCurrentCategroy(int id) {
        addSubscribe(HttpManager.getCategroylistApii().getcurrentcategory(id)
                .compose(RxUtils.<CurrentCategoryRvBean> rxScheduler())
                .subscribeWith(new CommonSubscriber<CurrentCategoryRvBean>(mView){
                    @Override
                    public void onNext(CurrentCategoryRvBean result) {
                        mView.getCurrentCategroyReturn(result);
                    }
                }));
    }
}
