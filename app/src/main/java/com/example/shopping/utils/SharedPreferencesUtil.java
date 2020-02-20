package com.example.shopping.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesUtil {

    private static SharedPreferences.Editor editor;

    //添加ui模式
    public static void addModeUI(Context context, boolean bool){
        editor = context.getSharedPreferences("ModeUI", Context.MODE_PRIVATE).edit();
        editor.putBoolean("mode_ui",bool);
        editor.commit();
    }

    public static void setLogin(Context context, String username,String password){
        editor = context.getSharedPreferences("user", Context.MODE_PRIVATE).edit();
        editor.putString("username",username);
        editor.putString("password",password);
        editor.commit();
    }

}
