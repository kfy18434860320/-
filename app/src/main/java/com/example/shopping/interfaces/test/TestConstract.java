package com.example.shopping.interfaces.test;

import com.example.shopping.interfaces.IBasePersenter;
import com.example.shopping.interfaces.IBaseView;
import com.example.shopping.models.bean.ChaptersBean;

public interface TestConstract {

    interface View extends IBaseView {
        void getChaptersReturn(ChaptersBean result);
    }

    interface Persenter extends IBasePersenter<View> {
        void getChapters();
    }

}
