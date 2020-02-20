package com.example.shopping.utils;

import android.content.Context;

public class StringUtils {

    /**
     * 获取values strings中的内容
     * @param context
     * @param tipsname
     * @return
     */
    public static String getStringValues(Context context,int tipsname){
        String result;
        result = context.getString(tipsname);
        return result;
    }

}
