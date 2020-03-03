package com.example.shopping.details;


import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shopping.R;
import com.example.shopping.adapter.details.NewHotAdapter;
import com.example.shopping.base.BaseActivity;
import com.example.shopping.base.BaseAdapter;
import com.example.shopping.interfaces.shangcheng.ShouyeContract;
import com.example.shopping.models.bean.BannerInfoTopBean;
import com.example.shopping.models.bean.NewDataBean;
import com.example.shopping.persenter.details.NewHotPersenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class NewHotActivity extends BaseActivity<ShouyeContract.NewHotPersenter> implements ShouyeContract.NewHotView, View.OnClickListener {

    @BindView(R.id.img_new_hot)
    ImageView imgNewHot;
    @BindView(R.id.name_new_hot)
    TextView nameNewHot;
    @BindView(R.id.zonghe_new_hot)
    Button zongheNewHot;
    @BindView(R.id.jiage_new_hot)
    Button jiageNewHot;
    @BindView(R.id.fenlei_new_hot)
    Button fenleiNewHot;
    @BindView(R.id.rv_new_hot)
    RecyclerView rvNewHot;
    private String ORDER = "asc";
    private String SORT = "default";
    private int tag;
    private ArrayList<NewDataBean.DataBeanX.DataBean> newList;
    private ArrayList<NewDataBean.DataBeanX.DataBean> hotList;
    private NewHotAdapter newAdapter;
    private NewHotAdapter hotAdapter;
    private List<NewDataBean.DataBeanX.FilterCategoryBean> filterCategory;
    private List<NewDataBean.DataBeanX.FilterCategoryBean> hotfilterCategory;

    @Override
    protected int getLayout() {
        return R.layout.activity_new_hot;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        tag = intent.getIntExtra("tag", 0);
        rvNewHot.setLayoutManager(new GridLayoutManager(this, 2));
        if (tag == 1) {
            newList = new ArrayList<>();
            newAdapter = new NewHotAdapter(newList, this);
            newAdapter.tag = 1;
            rvNewHot.setAdapter(newAdapter);
            newAdapter.setOnItemClickHandler(new BaseAdapter.ItemClickHandler() {
                @Override
                public void itemClick(int position, BaseAdapter.BaseViewHolder holder) {
                    NewDataBean.DataBeanX.DataBean dataBean = newList.get(position);
                    int id = dataBean.getId();
                  /*  Intent intent1 = new Intent(NewHotActivity.this, NewHotDetailActivity.class);
                    intent1.putExtra("new","新品");
                    intent1.putExtra("id",id);
                    startActivity(intent1);*/
                }
            });
        } else {
            hotList = new ArrayList<>();
            hotAdapter = new NewHotAdapter(hotList, this);
            hotAdapter.tag = 2;
            rvNewHot.setAdapter(hotAdapter);
            hotAdapter.setOnItemClickHandler(new BaseAdapter.ItemClickHandler() {
                @Override
                public void itemClick(int position, BaseAdapter.BaseViewHolder holder) {
                    NewDataBean.DataBeanX.DataBean dataBean = hotList.get(position);
                    int id = dataBean.getId();
                    /*Intent intent1 = new Intent(NewHotActivity.this, NewHotDetailActivity.class);
                    intent1.putExtra("new","人气");
                    intent1.putExtra("id",id);
                    startActivity(intent1);*/
                }
            });
        }
        zongheNewHot.setOnClickListener(this);
        jiageNewHot.setOnClickListener(this);
        fenleiNewHot.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        persenter.getBannerInfoTop();

        if (tag == 1) {
            persenter.getNewData(1, 1, 100, ORDER, SORT, 0);
        } else {
            persenter.getHotData(1, 1, 100, ORDER, SORT, 0);
        }
    }

    @Override
    protected ShouyeContract.NewHotPersenter createPersenter() {
        return new NewHotPersenter();
    }

    @Override
    public void getBannerInfoTopReturn(BannerInfoTopBean result) {
        Glide.with(this).load(result.getData().getBannerInfo().getImg_url()).into(imgNewHot);
        nameNewHot.setText(result.getData().getBannerInfo().getName());
    }

    @Override
    public void getNewDataReturn(NewDataBean result) {
        newAdapter.updata(result.getData().getData());
        filterCategory = result.getData().getFilterCategory();
    }

    @Override
    public void getHotDataReturn(NewDataBean result) {
        hotAdapter.updata(result.getData().getData());
        hotfilterCategory = result.getData().getFilterCategory();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.zonghe_new_hot:
                if (tag == 1) {
                    SORT = "default";
                    persenter.getNewData(1, 1, 100, ORDER, SORT, 0);
                } else {
                    SORT = "default";
                    persenter.getHotData(1, 1, 100, ORDER, SORT, 0);
                }
                break;
            case R.id.jiage_new_hot:
                SORT = "price";
                if (tag == 1) {
                    if (ORDER.equals("asc")) {
                        ORDER = "desc";
                        persenter.getNewData(1, 1, 100, ORDER, SORT, 0);
                    } else {
                        ORDER = "asc";
                        persenter.getNewData(1, 1, 100, ORDER, SORT, 0);
                    }
                } else {
                    if (ORDER.equals("asc")) {
                        ORDER = "desc";
                        persenter.getHotData(1, 1, 100, ORDER, SORT, 0);
                    } else {
                        ORDER = "asc";
                        persenter.getHotData(1, 1, 100, ORDER, SORT, 0);
                    }
                }
                break;
            case R.id.fenlei_new_hot:
                pop();
                break;
        }
    }

    private void pop() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.item_pop, null);
        PopupWindow popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.dismiss();
        if (!popupWindow.isShowing()) {
            popupWindow.showAsDropDown(fenleiNewHot, 0, 2);
        }
        TextView all = inflate.findViewById(R.id.all_pop);
        TextView jujia = inflate.findViewById(R.id.jujia_pop);
        TextView yingtong = inflate.findViewById(R.id.yingtong_pop);
        TextView yinshi = inflate.findViewById(R.id.yinshi_pop);
        TextView canchu = inflate.findViewById(R.id.canchu_pop);
        TextView zahuo = inflate.findViewById(R.id.zahuo_pop);
        if (tag == 1) {
            all.setText(filterCategory.get(0).getName());
            jujia.setText(filterCategory.get(1).getName());
            canchu.setText(filterCategory.get(2).getName());
            yingtong.setText(filterCategory.get(3).getName());
            zahuo.setText(filterCategory.get(4).getName());
            yinshi.setText(filterCategory.get(5).getName());
            yinshi.setBackgroundResource(R.drawable.minebian);
            yinshi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SORT = "category";
                    persenter.getNewData(1, 1, 100, ORDER, SORT, filterCategory.get(5).getId());

                }
            });
        } else {
            all.setText(hotfilterCategory.get(0).getName());
            jujia.setText(hotfilterCategory.get(1).getName());
            canchu.setText(hotfilterCategory.get(2).getName());
            yingtong.setText(hotfilterCategory.get(3).getName());
            zahuo.setText(hotfilterCategory.get(4).getName());
            yinshi.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBai));
        }
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tag == 1) {
                    SORT = "category";
                    persenter.getNewData(1, 1, 100, ORDER, SORT, 0);
                } else {
                    SORT = "category";
                    persenter.getHotData(1, 1, 100, ORDER, SORT, 0);
                }
            }
        });
        jujia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tag == 1) {
                    SORT = "category";
                    persenter.getNewData(1, 1, 100, ORDER, SORT, filterCategory.get(1).getId());
                } else {
                    SORT = "category";
                    persenter.getHotData(1, 1, 100, ORDER, SORT, hotfilterCategory.get(1).getId());
                }
            }
        });
        yingtong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tag == 1) {
                    SORT = "category";
                    persenter.getNewData(1, 1, 100, ORDER, SORT, filterCategory.get(3).getId());
                } else {
                    SORT = "category";
                    persenter.getHotData(1, 1, 100, ORDER, SORT, hotfilterCategory.get(3).getId());
                }
            }
        });

        canchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tag == 1) {
                    SORT = "category";
                    persenter.getNewData(1, 1, 100, ORDER, SORT, filterCategory.get(2).getId());
                } else {
                    SORT = "category";
                    persenter.getHotData(1, 1, 100, ORDER, SORT, hotfilterCategory.get(2).getId());
                }
            }
        });

        zahuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tag == 1) {
                    SORT = "category";
                    persenter.getNewData(1, 1, 100, ORDER, SORT, filterCategory.get(4).getId());
                } else {
                    SORT = "category";
                    persenter.getHotData(1, 1, 100, ORDER, SORT, hotfilterCategory.get(4).getId());
                }
            }
        });

    }
}
