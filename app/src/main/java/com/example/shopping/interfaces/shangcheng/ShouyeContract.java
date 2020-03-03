package com.example.shopping.interfaces.shangcheng;

import com.example.shopping.interfaces.IBasePersenter;
import com.example.shopping.interfaces.IBaseView;
import com.example.shopping.models.bean.BannerInfoTopBean;
import com.example.shopping.models.bean.NewDataBean;
import com.example.shopping.models.bean.ShouYeBean;

public interface ShouyeContract {
    interface View extends IBaseView {
        void getshouyeReturn(ShouYeBean shouYeBean);
    }

    interface Persenter extends IBasePersenter<View> {
        void getshouye();
    }

    interface NewHotView extends IBaseView{
        void getBannerInfoTopReturn(BannerInfoTopBean result);

        void getNewDataReturn(NewDataBean result);

        void getHotDataReturn(NewDataBean result);
    }
    interface NewHotPersenter extends IBasePersenter<NewHotView>{
        void getBannerInfoTop();

        void getNewData(int isNew,int page, int size,String order,String sort,int id);

        void getHotData(int isHot,int page, int size,String order,String sort,int id);
    }
}
