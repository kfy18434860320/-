package com.example.shopping.ui.fenlei.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import com.example.shopping.R;
import com.example.shopping.base.BaseActivity;
import com.example.shopping.interfaces.shangcheng.CartConstart;
import com.example.shopping.models.bean.JobGoShoppingBean;
import com.example.shopping.models.bean.SortDetailItemBean;
import com.example.shopping.persenter.fenlei.CartPersenter;
import com.example.shopping.ui.login.LoginActivity;
import com.example.shopping.utils.SpUtils;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class GoodsSortDetailActivity extends BaseActivity<CartConstart.Persenter> implements CartConstart.View {


    @BindView(R.id.baner_sortDetailItem)
    Banner banerSortDetailItem;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.txt_desc)
    TextView txtDesc;
    @BindView(R.id.txt_pri)
    TextView txtPri;
    @BindView(R.id.tv_nums)
    TextView tvNums;
    @BindView(R.id.iv_select)
    ImageView ivSelect;
    @BindView(R.id.con_nums)
    ConstraintLayout conNums;
    @BindView(R.id.txt_param)
    TextView txtParam;
    @BindView(R.id.txt_size)
    TextView txtSize;
    @BindView(R.id.con_meterial)
    ConstraintLayout conMeterial;
    @BindView(R.id.txt_color)
    TextView txtColor;
    @BindView(R.id.con_color)
    ConstraintLayout conColor;
    @BindView(R.id.txt_caizhi)
    TextView txtCaizhi;
    @BindView(R.id.con_caizhi)
    ConstraintLayout conCaizhi;
    /*@BindView(R.id.txt_adds)
    TextView txtAdds;
    @BindView(R.id.con_adds)
    ConstraintLayout conAdds;*/
    @BindView(R.id.web_sortitem)
    WebView webSortitem;
    @BindView(R.id.con_quest)
    ConstraintLayout conQuest;
    @BindView(R.id.rv_sortItem)
    RecyclerView rvSortItem;
    @BindView(R.id.scro)
    ScrollView scro;
    @BindView(R.id.iv_collect)
    ImageView ivCollect;
    @BindView(R.id.iv_shop)
    ImageView ivShop;
    @BindView(R.id.tv_liji)
    TextView tvLiji;
    @BindView(R.id.tv_job)
    TextView tvJob;
    @BindView(R.id.txt_standerd)
    TextView txtStanderd;
    @BindView(R.id.con_standerd)
    ConstraintLayout conStanderd;
    @BindView(R.id.tv_caizhi)
    TextView tvCaizhi;
    @BindView(R.id.tv_size)
    TextView tvSize;
    @BindView(R.id.tv_color)
    TextView tvColor;
    @BindView(R.id.tv_standerd)
    TextView tvStanderd;

    @BindView(R.id.con_parent)
    ConstraintLayout conParent;
    /*@BindView(R.id.tv_remark)
    TextView tvRemark;
    @BindView(R.id.txt_remark)
    TextView txtRemark;
    @BindView(R.id.con_remark)
    ConstraintLayout conRemark;
    @BindView(R.id.tv_adds)
    TextView tvAdds;*/
    private ArrayList<SortDetailItemBean.DataBeanX.GalleryBean> banners;

    private PopupWindow popupWindow;
    int amount = 0;
    private int sortDetailId;
    private int prodectId;

    @Override
    protected void initData() {
        sortDetailId = getIntent().getIntExtra("sortDetailId", 0);
        persenter.getSortDetailItemData(sortDetailId);

    }

    @Override
    protected CartConstart.Persenter createPersenter() {
        return new CartPersenter();
    }

    @Override
    protected void initView() {
        WebSettings webSettings = webSortitem.getSettings();
        webSettings.setJavaScriptEnabled(true);
        ivSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPop_num();
            }
        });
        tvJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GoodsSortDetailActivity.this, "请添加数量", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void showPop_num() {
        View view = LayoutInflater.from(this).inflate(R.layout.pop_selectnum, null);
        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        backgroungAlpha(0.5f);
        popupWindow.setOutsideTouchable(true);
        if (!popupWindow.isShowing()) {
            popupWindow.showAtLocation(conParent, Gravity.BOTTOM, 0, -120);
        }
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                amount =0;
                backgroungAlpha(1.0f);
            }
        });
        TextView name = view.findViewById(R.id.tv_popname);
        TextView price = view.findViewById(R.id.tv_popprice);
        TextView num = view.findViewById(R.id.tv_num);
        TextView subtract = view.findViewById(R.id.tv_subtract);
        TextView add = view.findViewById(R.id.tv_add);
        ImageView iv = view.findViewById(R.id.iv_pop_close);
        TextView job = view.findViewById(R.id.tv_job);
        name.setText(txtTitle.getText().toString());
        price.setText(txtPri.getText().toString());
        job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int math = Integer.parseInt(num.getText().toString());
               //点击加入购物车先判断是否已登录
                String token = SpUtils.getInstance().getString("token");
                //先判断是否token为空
                if (TextUtils.isEmpty(token)) {
                    showTips("还未登录，请先登录");
                    Intent intent = new Intent(GoodsSortDetailActivity.this, LoginActivity.class);
                    startActivityForResult(intent, 200);
                } else {//已经登录
                    if (math>0) {
                        persenter.getJobGoShopping(sortDetailId,math,prodectId);
                        Toast.makeText(GoodsSortDetailActivity.this, "添加购物车成功", Toast.LENGTH_SHORT).show();
                        popupWindow.dismiss();
                    }else {
                        Toast.makeText(GoodsSortDetailActivity.this, "请添加数量", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num.setText((++amount)+"");
            }
        });
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (amount >1) {
                    num.setText((--amount)+"");
                }
            }
        });
    }

    private void backgroungAlpha(float v) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = v;
        getWindow().setAttributes(attributes);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_goodscart_sort_detail;
    }

    @Override
    public void getSortDetailItemDataReturn(SortDetailItemBean sortDetailItemBean) {
        prodectId = sortDetailItemBean.getData().getProductList().get(0).getId();

//更新banner数据
        updataBanner(sortDetailItemBean.getData().getGallery());

        String price = getResources().getString(R.string.price_news_model).replace("$", String.valueOf(sortDetailItemBean.getData().getInfo().getRetail_price()));
        //更新条目标题 详情 价格 
        updataItemTitle(sortDetailItemBean.getData().getInfo().getName(),
                sortDetailItemBean.getData().getInfo().getGoods_brief(),
                price);
        //更新web数据
        updataWebs(sortDetailItemBean.getData().getInfo());

        //规格数据
        updataParam(sortDetailItemBean.getData().getAttribute());
    }

    @Override
    public void getJobGoShoppingReturn(JobGoShoppingBean jobGoShoppingBean) {

    }

    private void updateJobCart(List<JobGoShoppingBean.DataBean.CartListBean> cartList) {
    }

    //商品参数attribute 集合的长度根据不同id有4，→有5  有6 避免下标越界attribute.size取4
    private void updataParam(List<SortDetailItemBean.DataBeanX.AttributeBean> attribute) {
        if (attribute.size() > 0) {
            tvCaizhi.setText(attribute.get(0).getName());
            txtCaizhi.setText(attribute.get(0).getValue());

            tvSize.setText(attribute.get(1).getName());
            txtSize.setText(attribute.get(1).getValue());

            tvColor.setText(attribute.get(2).getName());
            txtColor.setText(attribute.get(2).getValue());

            tvStanderd.setText(attribute.get(3).getName());
            txtStanderd.setText(attribute.get(3).getValue());

            /*tvAdds.setText(attribute.get(4).getName());
            txtAdds.setText(attribute.get(4).getValue());

            tvRemark.setText(attribute.get(5).getName());
            txtRemark.setText(attribute.get(5).getValue());*/
        }

    }

    //对WebViews进行渲染数据
    private void updataWebs(SortDetailItemBean.DataBeanX.InfoBean info) {
        //商品介绍描述信息
        String cs = getResources().getString(R.string.cs_goods);
        StringBuilder builder = new StringBuilder();
        builder.append("<html><head>");
        builder.append("<style>" + cs + "</style></head></body>");
        builder.append(info.getGoods_desc() + "</body></html>");
        webSortitem.loadData(builder.toString(), "text/html", "utf-8");
    }

    //对条目商品赋值
    private void updataItemTitle(String name, String goods_brief, String price) {
        txtTitle.setText(name);
        txtDesc.setText(goods_brief);
        txtPri.setText(price);
    }

    private void updataBanner(List<SortDetailItemBean.DataBeanX.GalleryBean> sortDetailItemBean) {
        List<String> imgs = new ArrayList<>();
        for (int i = 0; i < sortDetailItemBean.size(); i++) {
            SortDetailItemBean.DataBeanX.GalleryBean galleryBean = sortDetailItemBean.get(i);
            String img = galleryBean.getImg_url();
            imgs.add(img);
        }
        banerSortDetailItem.setBannerStyle(BannerConfig.NUM_INDICATOR)
                .setImages(imgs)
                .setImageLoader(new GlidImageLoad())
                .start();
    }


    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        if (requestCode == 200) {
            if (persenter != null) {
               persenter.getSortDetailItemData(sortDetailId);
            }
        }
    }
}
