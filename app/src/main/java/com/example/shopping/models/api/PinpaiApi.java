package com.example.shopping.models.api;

import com.example.shopping.models.bean.GoodListBean;
import com.example.shopping.models.bean.PinpaiDetailsBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PinpaiApi {
    @GET("api/brand/detail")
    Flowable<PinpaiDetailsBean> getZhuantiData(@Query("id") int id);

    @GET("api/goods/list")
    Flowable<GoodListBean> getGoodListData(@Query("id") int id, @Query("page") int page, @Query("size") int size);
}

