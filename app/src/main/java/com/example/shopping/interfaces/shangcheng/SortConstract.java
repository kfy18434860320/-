package com.example.shopping.interfaces.shangcheng;


import com.example.shopping.interfaces.IBasePersenter;
import com.example.shopping.interfaces.IBaseView;
import com.example.shopping.models.bean.SortDetailGoodsBean;
import com.example.shopping.models.bean.SortDetailTabBean;

public interface SortConstract {





    interface DetailView extends IBaseView{

        void getSortDetailTabReturn(SortDetailTabBean result);

        void getSortDetailGoodsReturn(SortDetailGoodsBean result);

    }


    interface DetailPersenter extends IBasePersenter<DetailView>{

        //获取分类详情页的导航列表数据
        void getSortDetailTab(int id);

        //获取分类详情页当前的商品列表数据
        void getSortDetailGoods(int id, int page, int size);
    }



}
