package com.example.shopping.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.shopping.R;
import com.example.shopping.base.BaseActivity;
import com.example.shopping.interfaces.shangcheng.details.RegisterContract;
import com.example.shopping.models.bean.RegisterBean;
import com.example.shopping.persenter.login.RegisterPersenter;


import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends BaseActivity<RegisterContract.Persenter> implements RegisterContract.View {


    @BindView(R.id.edit_username)
    EditText editUsername;
    @BindView(R.id.edit_pw1)
    EditText editPw1;
    @BindView(R.id.edit_pw2)
    EditText editPw2;
    @BindView(R.id.layout_list)
    LinearLayout layoutList;
    @BindView(R.id.btn_register)
    Button btnRegister;

    @Override
    protected int getLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("name",editUsername.getText().toString());
                intent.putExtra("password",editPw1.getText().toString());
                setResult(200,intent);
                finish();
            }
        });
    }

    @Override
    protected void initData() {
        if (TextUtils.isEmpty(editUsername.getText().toString())){
            Toast.makeText(this, "账号不能为空", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(editPw1.getText().toString())){
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(editPw2.getText().toString()) &&
                editPw1.getText().toString().equals(editPw2.getText().toString())){

            persenter.getVerify(editUsername.getText().toString(),editPw1.getText().toString());
        }
    }

    @Override
    protected RegisterContract.Persenter createPersenter() {
        return new RegisterPersenter();
    }

    @Override
    public void getRegisterBeanReturn(RegisterBean result) {
        Toast.makeText(this, result.getErrmsg(), Toast.LENGTH_SHORT).show();
    }

}
