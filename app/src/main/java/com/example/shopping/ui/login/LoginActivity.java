package com.example.shopping.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.shopping.R;
import com.example.shopping.base.BaseActivity;
import com.example.shopping.interfaces.IBasePersenter;
import com.example.shopping.interfaces.shangcheng.details.LoginContract;
import com.example.shopping.models.bean.UserBean;

import com.example.shopping.persenter.login.LoginPersenter;
import com.example.shopping.utils.SharedPreferencesUtil;
import com.example.shopping.utils.SpUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginContract.Persenter> implements LoginContract.View {


    @BindView(R.id.edit_username)
    EditText editUsername;
    @BindView(R.id.edit_password)
    EditText editPassword;
    @BindView(R.id.zuce_login)
    TextView zuceLogin;
    @BindView(R.id.btn_login)
    Button btnLogin;
    private String name;
    private String password;

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        zuceLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivityForResult(intent,100);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = editUsername.getText().toString();
                password = editPassword.getText().toString();
                persenter.login(name,password);
                finish();
            }
        });
    }


    @Override
    protected void initData() {

    }


    @Override
    protected LoginPersenter createPersenter() {
        return new LoginPersenter();
    }

    @Override
    public void loginReturn(UserBean result) {
        if(result.getData().getCode()==200){
            showTips("登录成功");
            //登录成功将token存入sp
            SpUtils.getInstance().setValue("token", result.getData().getToken());

        }else {
            showTips("账号重复重新登录");
        }

        finish();

    }

}
