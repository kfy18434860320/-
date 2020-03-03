package com.example.shopping.persenter.details;

import com.example.shopping.base.BasePersenter;
import com.example.shopping.common.CommonSubscriber;
import com.example.shopping.interfaces.shangcheng.ShouyeContract;
import com.example.shopping.models.HttpManager;
import com.example.shopping.models.bean.BannerInfoTopBean;
import com.example.shopping.models.bean.NewDataBean;
import com.example.shopping.utils.RxUtils;

public class NewHotPersenter extends BasePersenter<ShouyeContract.NewHotView> implements ShouyeContract.NewHotPersenter {
    @Override
    public void getBannerInfoTop() {
        addSubscribe(HttpManager.getShouyeApi().getBannerInfoTop()
                .compose(RxUtils.<BannerInfoTopBean> rxScheduler())
                .subscribeWith(new CommonSubscriber<BannerInfoTopBean>(mView){
                    @Override
                    public void onNext(BannerInfoTopBean result) {
                        mView.getBannerInfoTopReturn(result);
                    }
                }));
    }

    @Override
    public void getNewData(int isNew, int page, int size, String order, String sort, int id) {
        addSubscribe(HttpManager.getShouyeApi().getNewData(isNew,page,size,order,sort,id)
                .compose(RxUtils.<NewDataBean> rxScheduler())
                .subscribeWith(new CommonSubscriber<NewDataBean>(mView){
                    @Override
                    public void onNext(NewDataBean result) {
                        mView.getNewDataReturn(result);
                    }
                }));
    }

    @Override
    public void getHotData(int isHot, int page, int size, String order, String sort, int id) {
        addSubscribe(HttpManager.getShouyeApi().getHotData(isHot,page,size,order,sort,id)
                .compose(RxUtils.<NewDataBean> rxScheduler())
                .subscribeWith(new CommonSubscriber<NewDataBean>(mView){
                    @Override
                    public void onNext(NewDataBean result) {
                        mView.getHotDataReturn(result);
                    }
                }));
    }
}
