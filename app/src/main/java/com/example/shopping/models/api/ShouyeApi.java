package com.example.shopping.models.api;


import com.example.shopping.models.bean.BannerInfoTopBean;
import com.example.shopping.models.bean.BrandListBean;
import com.example.shopping.models.bean.BrandListDetailBean;
import com.example.shopping.models.bean.BrandTopImgBean;
import com.example.shopping.models.bean.BuyBean;
import com.example.shopping.models.bean.CardListBean;
import com.example.shopping.models.bean.GoodsRelatedbean;
import com.example.shopping.models.bean.NewDataBean;
import com.example.shopping.models.bean.RegisterBean;
import com.example.shopping.models.bean.ShouYeBean;
import com.example.shopping.models.bean.UserBean;
import com.example.shopping.models.bean.ZhuantiBean;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ShouyeApi {
    @GET("index")
    Flowable<ShouYeBean> getShouyeData();

    @GET("api/topic/list")
    Flowable<ZhuantiBean> getZhuantiData(@Query("page") int page, @Query("size") int size);

    //制造商列表页列表
    @GET("api/brand/list")
    Flowable<BrandListBean> getBrandList(@Query("page") int page, @Query("size") int size);

    //制造商详情页顶部图片
    @GET("api/brand/detail")
    Flowable<BrandTopImgBean> getBrandTopImg(@Query("id") int id);

    //制造商详情页列表数据
    @GET("api/goods/list")
    Flowable<BrandListDetailBean> getBrandListDetail(@Query("brandId") int id, @Query("page")int page, @Query("size")int size);

    //新品 人气商品顶部数据
    @GET("api/goods/hot")
    Flowable<BannerInfoTopBean> getBannerInfoTop();

    //新品商品列表数据
    @GET("api/goods/list")
    Flowable<NewDataBean> getNewData(@Query("isNew") int isNew, @Query("page") int page, @Query("size")int size,
                                     @Query("order") String order, @Query("sort") String sort, @Query("categoryId") int id);

    //人气商品列表数据
    @GET("api/goods/list")
    Flowable<NewDataBean> getHotData(@Query("isHot") int isHot,@Query("page") int page,@Query("size")int size,
                                     @Query("order") String order,@Query("sort") String sort,@Query("categoryId") int id);

    //商品购买详情页
    @GET("api/goods/detail")
    Flowable<BuyBean> getBuyData(@Query("id") int id);

    //商品购买详情页列表数据
    @GET("api/goods/related")
    Flowable<GoodsRelatedbean> getGoodsRelated(@Query("id") int id);

    //登录
    @POST("api/auth/login")
    @FormUrlEncoded
    Flowable<UserBean> login(@Field("nickname") String nickname, @Field("password") String password);

    //注册
    @POST("api/auth/register")
    @FormUrlEncoded
    Flowable<RegisterBean> register(@Field("nickname") String nickname, @Field("password") String password);

    //获取购物车数据
    @GET("api/cart/index")
    Flowable<CardListBean> getCardList();

}
