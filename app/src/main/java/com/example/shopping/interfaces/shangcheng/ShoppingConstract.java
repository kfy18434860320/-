package com.example.shopping.interfaces.shangcheng;



import com.example.shopping.interfaces.IBasePersenter;
import com.example.shopping.interfaces.IBaseView;
import com.example.shopping.models.bean.AddressEditorBean;
import com.example.shopping.models.bean.BuyGoodsBean;
import com.example.shopping.models.bean.CartGoodsCheckedBean;
import com.example.shopping.models.bean.DeleteCartGoodsBean;
import com.example.shopping.models.bean.DetailAddsBean;
import com.example.shopping.models.bean.GoShoppingBean;
import com.example.shopping.models.bean.ShoppingAddsBean;
import com.example.shopping.models.bean.UpdateCartGoodsBean;

import java.util.Map;

public interface ShoppingConstract {

    interface View extends IBaseView {
        //购物车Fragment界面接口
        void getGoShoppingCartReturn(GoShoppingBean goShoppingBean);

        //设置购物车商品数据选中状态的返回
        void setCartGoodsCheckedReturn(CartGoodsCheckedBean cartGoodsCheckedReturn);

        //更新购物车列表商品数据返回
        void updateCartGoodsReturn(UpdateCartGoodsBean updateCartGoodsBean);

        //删除购物车列表数据返回接口
        void deleteCartGoodsReturn(DeleteCartGoodsBean deleteCartGoodsBean);
    }
    interface Presenter extends IBasePersenter<View> {
        ////得到购物车Fragment界面数据
        void getGoShoppingCart();

        //设置购物车选中商品数据
        void setCartGoodsChecked(String pids, int isChecked);

        //获取购物车更新数据
        void updateCartGoods(String pids, String goodsid, int num, int id);

        //购物车删除数据
        void deleteCartGoods(String productIds);
    }

    //下单接口
    interface BuyGoodsView extends IBaseView {
        void getBuyGoodsReturn(BuyGoodsBean buyGoodsBean);
    }

    interface BuyGoodsPresenter extends IBasePersenter<BuyGoodsView> {
        void getBuygoodsData(int addressId, int couponId);
    }

    //商品地址创建接口
    interface ShoppingAddsView extends IBaseView {
        void getShoppingAddsReturn(ShoppingAddsBean shoppingAddsBean);
    }

    interface ShoppingAddsPresenter extends IBasePersenter<ShoppingAddsView> {
        void getShoppingAddsData();
    }

    //新建地址接口
    interface AddressEditorView extends IBaseView {///创建地址保存

        void getAddressEditorReturn(AddressEditorBean addressEditorBean);

        //获取详细地址省市县接口
        void getDetailAddsReturn(DetailAddsBean detailAddsBean);
    }

    interface AddressEditorPresenter extends IBasePersenter<AddressEditorView> {
        void getAddressEditorData(Map<String,String> map);

        //详细地址省市县
        void getDetailAddsData(int parentId);
    }



}
