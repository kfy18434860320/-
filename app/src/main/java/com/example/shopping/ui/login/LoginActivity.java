package com.example.shopping.ui.login;

import android.content.Intent;
import android.os.Bundle;
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

import butterknife.BindView;
import butterknife.ButterKnife;

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
        /*if (result.getData().getCode() == 200) {
            Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
            SharedPreferencesUtil.getInstance().setValue("name", editUsername.getText().toString());
            SharedPreferencesUtil.getInstance().setValue("password", editPassword.getText().toString());*/
        SharedPreferencesUtil.getInstance().setValue("token", result.getData().getToken());
       /* }else{
            Toast.makeText(this, result.getErrmsg(), Toast.LENGTH_SHORT).show();
        }*/
    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == 200){
            name = data.getStringExtra("name");
            password = data.getStringExtra("password");
            editPassword.setText(password);
            editUsername.setText(name);
        }
    }*/
}
