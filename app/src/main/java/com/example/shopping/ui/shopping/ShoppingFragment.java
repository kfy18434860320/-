package com.example.shops.ui.goShopping;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.shopping.R;
import com.example.shopping.base.BaseAdapter;
import com.example.shopping.base.BaseFragment;
import com.example.shopping.interfaces.shangcheng.ShoppingConstract;
import com.example.shopping.models.bean.CartGoodsCheckedBean;
import com.example.shopping.models.bean.DeleteCartGoodsBean;
import com.example.shopping.models.bean.GoShoppingBean;
import com.example.shopping.models.bean.UpdateCartGoodsBean;
import com.example.shopping.persenter.Shopping.GoshoppingPresenter;
import com.example.shopping.ui.login.LoginActivity;
import com.example.shopping.ui.shopping.adapter.GoShoppingAdapter;
import com.example.shopping.utils.SpUtils;
import com.example.shopping.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ShoppingFragment extends BaseFragment<ShoppingConstract.Presenter> implements ShoppingConstract.View, BaseAdapter.ItemClickHandler {
    @BindView(R.id.rv_shopping)
    RecyclerView rvShopping;
    @BindView(R.id.ck_allselect)
    CheckBox ckAllselect;
    @BindView(R.id.tv_allprice)
    TextView tvAllprice;
    @BindView(R.id.tv_buy)
    TextView tvBuy;
    @BindView(R.id.tv_edit)
    TextView tvEdit;
    @BindView(R.id.con_select)
    ConstraintLayout conSelect;

    GoShoppingAdapter goShoppingAdapter;
    List<GoShoppingBean.DataBean.CartListBean> cartListBeans;

    @Override
    protected int getLayout() {
        return R.layout.fragment_shopping;
    }

    @Override//加载数据
    protected void initData() {
        //切换到购物车界面先判断是否登录  登录之后记录token
        String token = SpUtils.getInstance().getString("token");
        //先判断是否token为空
        if (TextUtils.isEmpty(token)) {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivityForResult(intent, 200);
        } else {//已经登录
            persenter.getGoShoppingCart();
        }
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        if (requestCode == 200) {
            if (persenter != null) {
                persenter.getGoShoppingCart();
            }
        }
    }

    //购物界面初适化
    @Override
    protected void initView() {
        cartListBeans = new ArrayList<>();
        goShoppingAdapter = new GoShoppingAdapter(cartListBeans, getActivity());
        rvShopping.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvShopping.setAdapter(goShoppingAdapter);

        goShoppingAdapter.setOnItemClickHandler(this);

    }

    @Override
    protected ShoppingConstract.Presenter createPersenter() {
        return new GoshoppingPresenter();
    }

    //获取购物车商品界面数据返回
    @Override
    public void getGoShoppingCartReturn(GoShoppingBean goShoppingBean) {
        goShoppingAdapter.updata(goShoppingBean.getData().getCartList());
        //判断当前的类型数据是否全部选中
        int totailPrice = 0;
        int nums = 0;
        boolean isSelectAll = true;
        for (GoShoppingBean.DataBean.CartListBean cart : goShoppingBean.getData().getCartList()) {
            if (isSelectAll) {
                if (!cart.isSelect) {
                    isSelectAll = false;
                }
            }
            if (cart.isSelect) {
                totailPrice += cart.getRetail_price() * cart.getNumber();
                nums += cart.getNumber();
            }
        }
        if (isSelectAll) {
            ckAllselect.setChecked(true);
        }
        tvAllprice.setText("¥ " + totailPrice);
        ckAllselect.setText("全选(" + nums + ")");
    }

    //购物车商品数据是否被选中返回
    @Override
    public void setCartGoodsCheckedReturn(CartGoodsCheckedBean cartGoodsCheckedReturn) {

    }

    //购物车更新数据返回
    @Override
    public void updateCartGoodsReturn(UpdateCartGoodsBean updateCartGoodsBean) {
        for (UpdateCartGoodsBean.DataBean.CartListBean bean : updateCartGoodsBean.getData().getCartList()) {
            GoShoppingBean.DataBean.CartListBean listbean = getItemDataById(bean.getId());//得到购物车里的商品条目id
            if (listbean != null) {
                listbean.setNumber(bean.getNumber());
            }
            //更新后刷新
            goShoppingAdapter.notifyDataSetChanged();
        }
    }

    //购物车删除数据返回
    @Override
    public void deleteCartGoodsReturn(DeleteCartGoodsBean deleteCartGoodsBean) {
        for (int i = 0; i < cartListBeans.size(); i++) {
            GoShoppingBean.DataBean.CartListBean bean = cartListBeans.get(i);
            boolean bool = false;//检查购物车界面中第i条数据是否被删除
            for (DeleteCartGoodsBean.DataBean.CartListBean item : deleteCartGoodsBean.getData().getCartList()) {
                if (bean.getId() == item.getId()) {
                    bool = true;
                    break;
                }
            }
            if (!bool) {//如果数据不存在  删掉集合此条目 并刷新
                cartListBeans.remove(i);
            }
            goShoppingAdapter.notifyDataSetChanged();
        }
    }

    //通过购物车界面列表数据里的id获取对应的商品数据
    private GoShoppingBean.DataBean.CartListBean getItemDataById(int id) {
        for (GoShoppingBean.DataBean.CartListBean bean : cartListBeans) {
            if (bean.getId() == id) {
                return bean;
            }
        }
        return null;
    }


    /**
     * 多选框
     * radio状态变化
     * 接口回调实现的方法
     * 作用：1.处理正常状态下的列表item选中状态的变化
     * 2.处理编辑状态下列表item的数据更新
     */
    @Override
    public void itemClick(int position, BaseAdapter.BaseViewHolder holder) {
        boolean bool = getPageIsEditor();
        if (!bool) {//默认的正常页面
            updateSelectAll();//更新商品选中状态
            int[] ids = new int[1];
            ids[0] = cartListBeans.get(position).getId();
            int ischecked = cartListBeans.get(position).isSelect ? 0:1;
            updateCartGoodsChecked(ids,ischecked);
        }else {
            //更新商品数量
            String pids = String.valueOf(cartListBeans.get(position).getProduct_id());
            String goodsid = String.valueOf(cartListBeans.get(position).getGoods_id());
            int  number = cartListBeans.get(position).getNumber();
            int  id = cartListBeans.get(position).getId();
            //发送更新商品数量的请求方法
            persenter.updateCartGoods(pids,goodsid,number,id);

        }
    }

    //检查是否全选
    private void updateSelectAll() {
        int totalPrice = 0;
        int totalNum = 0;
        boolean isAll = true;
        for (int i = 0; i < cartListBeans.size(); i++) {
            if (goShoppingAdapter.isEdit) {
                boolean isSelect = cartListBeans.get(i).isSelect;
                //记录判断是否全选
                if (isAll) {//编辑页面全选
                    isAll = isSelect;
                }
                //计算选中的商品数量和价格
                if (isSelect) {
                    totalNum += cartListBeans.get(i).getNumber();
                    totalPrice += cartListBeans.get(i).getRetail_price() * cartListBeans.get(i).getNumber();
                }
            }
            //默认界面
            else {
                boolean isDeleteSelect = cartListBeans.get(i).isDeleteSelect;
                if (isAll) {
                    isAll = isDeleteSelect;
                }
                if (isDeleteSelect) {
                    totalNum += cartListBeans.get(i).getNumber();
                }
            }
        }
        ckAllselect.setChecked(isAll);
        ckAllselect.setText("全选（"+totalNum+")");
        if (!goShoppingAdapter.isEdit) {
            tvAllprice.setText("¥ "+totalPrice);
        }else {
            tvAllprice.setText("");
        }
    }

    @OnClick({R.id.ck_allselect, R.id.tv_buy, R.id.tv_edit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ck_allselect://点击全选的监听
                boolean isChecked = ckAllselect.isChecked();//全选按钮是否被选中
                setSlectAll(isChecked);
                goShoppingAdapter.notifyDataSetChanged();//刷新界面
                break;
            case R.id.tv_buy:
                boolean isEditor = getPageIsEditor();
                if (isEditor) {//当前界面是编辑界面  可以删除
                    deleteGoods();
                } else {//否则就是默认界面  可以购买下单
                    goBuy();
                }
                break;
            case R.id.tv_edit:
                boolean bool = getPageIsEditor();//界面是否处于编辑界面
                if (!bool) {//界面不是编辑界面  默认界面购物车下单界面
                    tvEdit.setText("完成");//对控件重新赋值
                    tvBuy.setText("删除所选");
                    goShoppingAdapter.isEdit = true;
                    //刷新编辑页面数据
                    goShoppingAdapter.notifyDataSetChanged();
                }else {
                    tvEdit.setText("编辑");//对控件重新赋值
                    tvBuy.setText("下单");
                    goShoppingAdapter.isEdit = false;
                    //扇形编辑页面数据
                    goShoppingAdapter.notifyDataSetChanged();
                }
                break;
        }
    }

    //下单购买
    private void goBuy() {
        for (GoShoppingBean.DataBean.CartListBean item:cartListBeans) {
            if (item.isSelect) {
               /* Intent intent = new Intent(getActivity(), BuyGoodsActivity.class);
                startActivity(intent);*/
            }else {
                showTips("请选择下单的商品");
            }
        }
    }

    //编辑界面 删除条目
    private void deleteGoods() {
        //查找当前列表条目选中删除的商品
        StringBuilder sb = new StringBuilder();
        for (GoShoppingBean.DataBean.CartListBean bean : cartListBeans) {
            if (bean.isDeleteSelect) {
                sb.append(bean.getProduct_id());
                sb.append(",");
            }
        }
        if (sb.length() > 0) {
            //去掉末尾的逗号
            sb.deleteCharAt(sb.length() - 1);
            String pids = sb.toString();
            //调用删除商品的接口
            persenter.deleteCartGoods(pids);
        } else {
            showTips("没有选中任何商品");
        }

    }

    //当前界面是否是编辑界面
    private boolean getPageIsEditor() {
        String editor = tvEdit.getText().toString();
        return editor.equals("编辑") ? false : true;
    }


    //购物车界面全选按钮选中状态
    private void setSlectAll(boolean isChecked) {
        int totalprice = 0;
        int totalnum = 0;
        int[] is = new int[cartListBeans.size()];
        for (int i = 0; i < cartListBeans.size(); i++) {
            cartListBeans.get(i).isSelect = isChecked;
            is[i] = cartListBeans.get(i).getId();
            if (isChecked) {
                totalprice += cartListBeans.get(i).getNumber() * cartListBeans.get(i).getRetail_price();
                totalnum += cartListBeans.get(i).getNumber();
            }
        }
        int checked = isChecked ? 0 : 1;
        updateCartGoodsChecked(is, checked);//刷新界面数量 总价

        if (isChecked) {
            tvAllprice.setText("¥ " + totalprice);
            ckAllselect.setText("全选（" + totalnum + ")");
        } else {
            tvAllprice.setText("");
        }

    }

    //更新购物车商品数据选中状态
    private void updateCartGoodsChecked(int[] is, int checked) {
        String ids = StringUtils.splitArray(is);
        persenter.setCartGoodsChecked(ids, checked);
    }

}
