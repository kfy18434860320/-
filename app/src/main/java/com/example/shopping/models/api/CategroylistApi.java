package com.example.shopping.models.api;

import com.example.shopping.models.bean.CategroyListBean;
import com.example.shopping.models.bean.CurrentCategoryRvBean;
import com.example.shopping.models.bean.SortDetailGoodsBean;
import com.example.shopping.models.bean.SortDetailTabBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CategroylistApi {
    @GET("api/catalog/index")
    Flowable<CategroyListBean> getCategroy();

    @GET("api/catalog/current")
    Flowable<CurrentCategoryRvBean> getcurrentcategory(@Query("id") int id);


}
