package com.example.shopping.interfaces.shangcheng;

import com.example.shopping.interfaces.IBasePersenter;
import com.example.shopping.interfaces.IBaseView;
import com.example.shopping.models.bean.CategroyListBean;
import com.example.shopping.models.bean.CurrentCategoryRvBean;

public interface CategroyListContract {
    interface View extends IBaseView {
        void getCategroyListReturn(CategroyListBean result);

        void getCurrentCategroyReturn(CurrentCategoryRvBean result);
    }
    interface Persenter extends IBasePersenter<View> {
        void getCategroylist();

        void getCurrentCategroy(int id);
    }
}
