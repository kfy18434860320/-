package com.example.shopping.persenter.test;

import com.example.shopping.base.BasePersenter;
import com.example.shopping.common.CommonSubscriber;
import com.example.shopping.interfaces.test.TestConstract;
import com.example.shopping.models.HttpManager;
import com.example.shopping.models.bean.ChaptersBean;
import com.example.shopping.utils.RxUtils;

public class TestPersenter extends BasePersenter<TestConstract.View> implements TestConstract.Persenter {

    @Override
    public void getChapters() {
        addSubscribe(HttpManager.getInstance().getWanApi().getChapters()
        .compose(RxUtils.<ChaptersBean>rxScheduler())
        .subscribeWith(new CommonSubscriber<ChaptersBean>(mView){

            @Override
            public void onNext(ChaptersBean chaptersBean) {
                mView.getChaptersReturn(chaptersBean);
            }
        }));

        //网络请求不用背压式
        /*HttpManager.getInstance().getWanApi().getChapters()
                .compose(RxUtils.<ChaptersBean>rxScheduler())
                .subscribeWith(new ResourceSubscriber<ChaptersBean>() {
                    @Override
                    public void onNext(ChaptersBean chaptersBean) {

                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });*/
    }
}
