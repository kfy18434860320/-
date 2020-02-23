package com.example.shopping.models.api;



import com.example.shopping.models.bean.SortDetailGoodsBean;
import com.example.shopping.models.bean.SortDetailTabBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ShopApi {



    //获取分类详情页的tab数据
    @GET("goods/category")
    Flowable<SortDetailTabBean> getSortDetailTab(@Query("id") int id);

    //获取分类详情页的商品列表数据
    @GET("goods/list")
    Flowable<SortDetailGoodsBean> getSortDetailGoods(@Query("categoryId") int id, @Query("page") int page, @Query("size") int size);

}
