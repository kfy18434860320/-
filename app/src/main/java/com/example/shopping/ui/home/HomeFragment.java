package com.example.shopping.ui.home;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.shopping.R;
import com.example.shopping.adapter.ShouyeAdapter;
import com.example.shopping.adapter.shouye.JujiaRvAdapter;
import com.example.shopping.adapter.shouye.PinpaiRvAdapter;
import com.example.shopping.adapter.shouye.RenqiRvAdapter;
import com.example.shopping.adapter.shouye.XinpinRvAdapter;
import com.example.shopping.adapter.shouye.ZhuantiRvAdapter;
import com.example.shopping.base.BaseAdapter;
import com.example.shopping.base.BaseFragment;
import com.example.shopping.details.BrandListActivity;
import com.example.shopping.details.NewHotActivity;
import com.example.shopping.details.PinpaiDetailsActivity;
import com.example.shopping.interfaces.shangcheng.ShouyeContract;
import com.example.shopping.models.bean.ShouYeBean;
import com.example.shopping.persenter.home.ShouyePresenter;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseFragment<ShouyeContract.Persenter> implements ShouyeContract.View, View.OnClickListener {

    @BindView(R.id.banner_shouye)
    Banner bannerShouye;
    @BindView(R.id.tab_shouye)
    TabLayout tabShouye;
    @BindView(R.id.vp_shouye)
    ViewPager vpShouye;
    @BindView(R.id.rv_shouye)
    RecyclerView rvShouye;
    @BindView(R.id.tv1_shouye)
    TextView tv1Shouye;
    @BindView(R.id.tv2_shouye)
    TextView tv2Shouye;
    @BindView(R.id.rv2_shouye)
    RecyclerView rv2Shouye;
    @BindView(R.id.tv3_shouye)
    TextView tv3Shouye;
    @BindView(R.id.rv3_shouye)
    RecyclerView rv3Shouye;
    @BindView(R.id.tv4_shouye)
    TextView tv4Shouye;
    @BindView(R.id.rv4_shouye)
    RecyclerView rv4Shouye;
    @BindView(R.id.jujia_shouye)
    TextView jujiaShouye;
    @BindView(R.id.rv_jujia_shouye)
    RecyclerView rvJujiaShouye;
    private ArrayList<String> strings;
    private ArrayList<String> tabString;
    private ShouyeAdapter adapter;
    private ArrayList<Fragment> fragments;
    private PinpaiRvAdapter rvShouyeAdapter;
    private ArrayList<ShouYeBean.DataBean.BrandListBean> brandListBeans;
    private ArrayList<ShouYeBean.DataBean.NewGoodsListBean> newGoodsListBeans;
    private XinpinRvAdapter xinpinRvAdapter;
    private ArrayList<ShouYeBean.DataBean.HotGoodsListBean> hotGoodsListBeans;
    private RenqiRvAdapter renqiRvAdapter;
    private ZhuantiRvAdapter zhuantiRvAdapter;
    private ArrayList<ShouYeBean.DataBean.TopicListBean> topicListBeans;
    private ArrayList<ShouYeBean.DataBean.CategoryListBean.GoodsListBean> goodsListBeans;
    private JujiaRvAdapter jujiaRvAdapter;

    private static final String TAG = "HomeFragment";

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        strings = new ArrayList<>();
        fragments = new ArrayList<>();
        tabString = new ArrayList<>();
        adapter = new ShouyeAdapter(getActivity().getSupportFragmentManager(), tabString, fragments);
        vpShouye.setAdapter(adapter);
        tabShouye.setupWithViewPager(vpShouye);
        tv1Shouye.setOnClickListener(this);
        tv2Shouye.setOnClickListener(this);
        tv3Shouye.setOnClickListener(this);
        tv4Shouye.setOnClickListener(this);
        pinpai();
        xinpin();
        renqi();
        zhuanti();
        jujia();
    }

    private void jujia() {
        rvJujiaShouye.setLayoutManager(getGridLayoutManager());
        goodsListBeans = new ArrayList<>();
        jujiaRvAdapter = new JujiaRvAdapter(goodsListBeans, context);
        rvJujiaShouye.setAdapter(jujiaRvAdapter);
    }


    private void zhuanti() {
        tv4Shouye.setText("专题精选");
        rv4Shouye.setLayoutManager(new StaggeredGridLayoutManager(1, DividerItemDecoration.HORIZONTAL));
        topicListBeans = new ArrayList<>();
        zhuantiRvAdapter = new ZhuantiRvAdapter(topicListBeans, context);
        rv4Shouye.setAdapter(zhuantiRvAdapter);


    }

    private LinearLayoutManager getLinerlayoutManager() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        return layoutManager;
    }

    private GridLayoutManager getGridLayoutManager() {
        return new GridLayoutManager(context, 2) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
    }

    private void xinpin() {
        tv2Shouye.setText("周一周四·新品发布");
        getGridLayoutManager();
        rv2Shouye.setLayoutManager(getGridLayoutManager());
        newGoodsListBeans = new ArrayList<>();
        xinpinRvAdapter = new XinpinRvAdapter(newGoodsListBeans, context);
        rv2Shouye.setAdapter(xinpinRvAdapter);

    }


    private void renqi() {
        tv3Shouye.setText("人气推荐");
        rv3Shouye.setLayoutManager(getLinerlayoutManager());
        hotGoodsListBeans = new ArrayList<>();
        renqiRvAdapter = new RenqiRvAdapter(hotGoodsListBeans, context);
        rv3Shouye.setAdapter(renqiRvAdapter);
        rv3Shouye.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
    }

    private void pinpai() {
        tv1Shouye.setText("品牌制造商直供");
        rvShouye.setLayoutManager(getGridLayoutManager());
        brandListBeans = new ArrayList<>();
        rvShouyeAdapter = new PinpaiRvAdapter(brandListBeans, context);
        rvShouye.setAdapter(rvShouyeAdapter);
        rvShouyeAdapter.setOnItemClickHandler(new BaseAdapter.ItemClickHandler() {
            @Override
            public void itemClick(int position, BaseAdapter.BaseViewHolder holder) {
                Intent intent = new Intent(context, PinpaiDetailsActivity.class);
                ShouYeBean.DataBean.BrandListBean brandListBean = brandListBeans.get(position);
                int id = brandListBean.getId();
                intent.putExtra("id", id);
                startActivity(intent);
//                Log.i(TAG, "itemClick: "+id);
            }
        });
    }

    @Override
    protected void initData() {
        persenter.getshouye();
    }

    @Override
    protected ShouyeContract.Persenter createPersenter() {
        return new ShouyePresenter();
    }


    @Override
    public void getshouyeReturn(ShouYeBean shouYeBean) {
        ShouYeBean.DataBean data = shouYeBean.getData();
        setBannerdata(data);
        setPinpai(shouYeBean);
        setXinpin(data);
        setRenqi(data);
        setzhuanti(data);
        setjujia(data);

    }

    private void setjujia(ShouYeBean.DataBean data) {
        List<ShouYeBean.DataBean.CategoryListBean> categoryList = data.getCategoryList();
        jujiaShouye.setText(categoryList.get(0).getName());
        List<ShouYeBean.DataBean.CategoryListBean.GoodsListBean> goodsList = categoryList.get(0).getGoodsList();
        jujiaRvAdapter.updata(goodsList);
    }

    private void setzhuanti(ShouYeBean.DataBean data) {
        List<ShouYeBean.DataBean.TopicListBean> topicList = data.getTopicList();
        topicListBeans.addAll(topicList);
        zhuantiRvAdapter.notifyDataSetChanged();
    }

    private void setRenqi(ShouYeBean.DataBean data) {
        List<ShouYeBean.DataBean.HotGoodsListBean> hotGoodsList = data.getHotGoodsList();
        hotGoodsListBeans.addAll(hotGoodsList);
        renqiRvAdapter.notifyDataSetChanged();
    }

    private void setXinpin(ShouYeBean.DataBean data) {
        List<ShouYeBean.DataBean.NewGoodsListBean> newGoodsList = data.getNewGoodsList();
        newGoodsListBeans.addAll(newGoodsList);
        xinpinRvAdapter.notifyDataSetChanged();
    }

    private void setPinpai(ShouYeBean shouYeBean) {
        List<ShouYeBean.DataBean.BrandListBean> brandList = shouYeBean.getData().getBrandList();
        brandListBeans.addAll(brandList);
        rvShouyeAdapter.notifyDataSetChanged();
    }

    private void setBannerdata(ShouYeBean.DataBean data) {
        List<ShouYeBean.DataBean.BannerBean> banner = data.getBanner();
        for (ShouYeBean.DataBean.BannerBean bannerBean : banner) {
            strings.add(bannerBean.getImage_url());
        }
        setbanner(bannerShouye, strings);

        List<ShouYeBean.DataBean.ChannelBean> channel = data.getChannel();
        for (ShouYeBean.DataBean.ChannelBean channelBean : channel) {
            fragments.add(new JujiaFragment());
            tabString.add(channelBean.getName());
        }
        adapter.notifyDataSetChanged();
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

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv1_shouye:
                Intent intent1 = new Intent(context, BrandListActivity.class);
                startActivity(intent1);
                break;
            case R.id.tv2_shouye:
                int tag = 1;
                Intent intent = new Intent(context, NewHotActivity.class);
                intent.putExtra("tag",tag);
                startActivity(intent);
                break;
            case R.id.tv3_shouye:
                int tag1 = 2;
                Intent intent3 = new Intent(context, NewHotActivity.class);
                intent3.putExtra("tag",tag1);
                startActivity(intent3);
                break;
            case R.id.tv4_shouye:
                break;
        }
    }
}