package com.example.shopping.persenter.fenlei;


import com.example.shopping.base.BasePersenter;
import com.example.shopping.common.CommonSubscriber;
import com.example.shopping.interfaces.shangcheng.SortConstract;
import com.example.shopping.models.HttpManager;
import com.example.shopping.models.bean.SortDetailGoodsBean;
import com.example.shopping.models.bean.SortDetailTabBean;
import com.example.shopping.utils.RxUtils;

public class SortDetailPersenter extends BasePersenter<SortConstract.DetailView> implements SortConstract.DetailPersenter {

    @Override
    public void getSortDetailTab(int id) {
       addSubscribe(HttpManager.getInstance().getShopApi().getSortDetailTab(id)
       .compose(RxUtils.<SortDetailTabBean>rxScheduler())
       .subscribeWith(new CommonSubscriber<SortDetailTabBean>(mView){
           @Override
           public void onNext(SortDetailTabBean sortDetailTabBean) {
               mView.getSortDetailTabReturn(sortDetailTabBean);
           }
       }));
    }

    @Override
    public void getSortDetailGoods(int id, int page, int size) {
        addSubscribe(HttpManager.getInstance().getShopApi().getSortDetailGoods(id,page,size)
                .compose(RxUtils.<SortDetailGoodsBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<SortDetailGoodsBean>(mView){
                    @Override
                    public void onNext(SortDetailGoodsBean sortDetailGoodsBean) {
                        mView.getSortDetailGoodsReturn(sortDetailGoodsBean);
                    }
                }));
    }

}
