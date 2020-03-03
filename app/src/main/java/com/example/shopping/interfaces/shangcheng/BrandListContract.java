package com.example.shopping.interfaces.shangcheng;

import com.example.shopping.interfaces.IBasePersenter;
import com.example.shopping.interfaces.IBaseView;
import com.example.shopping.models.bean.BrandListBean;
import com.example.shopping.models.bean.BrandListDetailBean;
import com.example.shopping.models.bean.BrandTopImgBean;

public interface BrandListContract {
    interface View extends IBaseView {
        void getBrandListReturn(BrandListBean result);
    }
    interface Persenter extends IBasePersenter<View> {
        void getBrandList(int page, int size);
    }

    interface BrandDetailView extends IBaseView {
        void getBrandTopImgReturn(BrandTopImgBean result);

        void getBrandListDetailReturn(BrandListDetailBean result);
    }
    interface BrandDetailPersenter extends IBasePersenter<BrandDetailView> {
        void getBrandTopImg(int id);

        void getBrandListDetail(int id, int page, int size);
    }
}
