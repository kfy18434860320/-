package com.example.shopping.interfaces.shangcheng;


import com.example.shopping.interfaces.IBasePersenter;
import com.example.shopping.interfaces.IBaseView;
import com.example.shopping.models.bean.JobGoShoppingBean;
import com.example.shopping.models.bean.SortDetailItemBean;

//分类里边详情列表购买数据接口
public interface CartConstart {
    interface View extends IBaseView {
        //分类详情购买返回
        void getSortDetailItemDataReturn(SortDetailItemBean sortDetailItemBean);

        //加入到购物车
        void getJobGoShoppingReturn(JobGoShoppingBean jobGoShoppingBean);
    }
    interface  Persenter extends IBasePersenter<View> {
        void getSortDetailItemData(int id);

        void getJobGoShopping(int goodsId, int number, int productId);
    }
}
