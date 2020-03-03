package com.example.shopping.details;


import android.content.Context;
import android.content.Intent;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shopping.R;
import com.example.shopping.adapter.details.BuyListRvAdapter;
import com.example.shopping.adapter.details.BuyWentiAdapter;
import com.example.shopping.base.BaseActivity;
import com.example.shopping.interfaces.shangcheng.details.BuyDetailContract;
import com.example.shopping.models.bean.BuyBean;
import com.example.shopping.models.bean.GoodsRelatedbean;
import com.example.shopping.persenter.details.BuyPersenter;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class NewHotDetailActivity extends BaseActivity<BuyDetailContract.Persenter> implements BuyDetailContract.View {


    @BindView(R.id.name_new_hot_detail)
    TextView nameNewHotDetail;
    @BindView(R.id.brief_new_hot_detail)
    TextView briefNewHotDetail;
    @BindView(R.id.price_new_hot_detail)
    TextView priceNewHotDetail;
    @BindView(R.id.shu)
    TextView shu;
    @BindView(R.id.jiantou_new_top_detail)
    TextView jiantouNewTopDetail;
    @BindView(R.id.chicun_new_hot_detail)
    TextView chicunNewHotDetail;
    @BindView(R.id.chicunValue_new_hot_detail)
    TextView chicunValueNewHotDetail;
    @BindView(R.id.color_new_hot_detail)
    TextView colorNewHotDetail;
    @BindView(R.id.colorValue_new_hot_detail)
    TextView colorValueNewHotDetail;
    @BindView(R.id.caizhi_new_hot_detail)
    TextView caizhiNewHotDetail;
    @BindView(R.id.caizhiValue_new_hot_detail)
    TextView caizhiValueNewHotDetail;
    @BindView(R.id.chandi_new_hot_detail)
    TextView chandiNewHotDetail;
    @BindView(R.id.chandiValue_new_hot_detail)
    TextView chandiValueNewHotDetail;
    @BindView(R.id.webView_new_hot_detail)
    WebView webViewNewHotDetail;
    @BindView(R.id.shoucang_new_top_detail)
    TextView shoucangNewTopDetail;
    @BindView(R.id.wentiRv_new_top_detail)
    RecyclerView wentiRvNewTopDetail;
    @BindView(R.id.listRv_new_top_detail)
    RecyclerView listRvNewTopDetail;
    @BindView(R.id.banner_new_hot_detail)
    Banner bannerNewHotDetail;
    private String aNew;
    private int id;
    private ArrayList<BuyBean.DataBeanX.IssueBean> issueBeans;
    private BuyWentiAdapter wentiAdapter;
    private BuyListRvAdapter buyListRvAdapter;
    private ArrayList<GoodsRelatedbean.DataBean.GoodsListBean> goodsListBeans;

    @Override
    protected int getLayout() {
        return R.layout.activity_new_hot_detail;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        aNew = intent.getStringExtra("new");
        wentiRvNewTopDetail.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        listRvNewTopDetail.setLayoutManager(new GridLayoutManager(this, 2) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        issueBeans = new ArrayList<>();
        wentiAdapter = new BuyWentiAdapter(issueBeans, this);
        wentiRvNewTopDetail.setAdapter(wentiAdapter);
        goodsListBeans = new ArrayList<>();
        buyListRvAdapter = new BuyListRvAdapter(goodsListBeans, this);
        listRvNewTopDetail.setAdapter(buyListRvAdapter);
    }

    @Override
    protected void initData() {
        persenter.getBuy(id);
        persenter.getGoodsRelaterd(id);
    }

    @Override
    protected BuyPersenter createPersenter() {
        return new BuyPersenter();
    }


    @Override
    public void getBuyReturn(BuyBean result) {
        List<?> specificationList = result.getData().getSpecificationList();
        wentiAdapter.updata(result.getData().getIssue());
        List<BuyBean.DataBeanX.GalleryBean> gallery = result.getData().getGallery();
        ArrayList<String> strings = new ArrayList<>();
        for (BuyBean.DataBeanX.GalleryBean galleryBean : gallery) {
            String img_url = galleryBean.getImg_url();
            strings.add(img_url);
        }
        setbanner(bannerNewHotDetail,strings);
        BuyBean.DataBeanX.InfoBean info = result.getData().getInfo();
        setTextViewValues(info.getName(),info.getGoods_brief(),info.getRetail_price()+"");
    }

    private void setTextViewValues(String name, String goods_brief, String retail_price) {
        nameNewHotDetail.setText(name);
        briefNewHotDetail.setText(goods_brief);
        priceNewHotDetail.setText("￥"+retail_price);
    }

    @Override
    public void getGoodsRelatedReturn(GoodsRelatedbean result) {
        buyListRvAdapter.updata(result.getData().getGoodsList());
    }

    private static void setbanner(Banner bannerShouye, ArrayList<String> strings) {
        bannerShouye.setImages(strings)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        Glide.with(context).load(path).into(imageView);
                    }
                }).start();
    }

}
