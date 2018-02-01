package com.freak.shopping.activity.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.freak.shopping.R;
import com.freak.shopping.activity.LoginBean.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;


/**
 * Created by Administrator on 2017/11/21.
 */

public class RegisterActivity extends Activity {
    @BindView(R.id.title_return)
    ImageView titleReturn;
    @BindView(R.id.title_name)
    TextView titleName;
    @BindView(R.id.register_phone)
    EditText registerPhone;
    @BindView(R.id.send_register_code)
    TextView sendRegisterCode;
    @BindView(R.id.register_verification_code)
    EditText registerVerificationCode;
    @BindView(R.id.register_password)
    EditText registerPassword;
    @BindView(R.id.register_password_show)
    ImageView registerPasswordShow;
    @BindView(R.id.register_btn)
    TextView registerBtn;
    boolean show = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_register);
        ButterKnife.bind(this);
        Bmob.initialize(this, "b37ca9b24b2b7159acee68818d501393");
        titleName.setText("注册");
        registerBtn.setText("注册");
    }

    @OnClick({R.id.title_return, R.id.send_register_code, R.id.register_password_show, R.id.register_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_return:
                finish();
                break;
            case R.id.send_register_code:
                break;
            case R.id.register_password_show:
                if (show) {
                    registerPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    show = false;
                } else {
                    registerPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    show = true;
                }

                break;
            case R.id.register_btn:
                BmobUser user = new User();
                user.setUsername(registerPhone.getText().toString());
                user.setPassword(registerPassword.getText().toString());
                user.signUp(new SaveListener<User>() {
                    @Override
                    public void done(User user, BmobException e) {
                        if (e==null){
                            Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_LONG).show();
                          Intent register_intent=new Intent();
                           register_intent.setClass(RegisterActivity.this,LoginActivity.class);
                          startActivity(register_intent);
                           finish();
                        }else {
                            Toast.makeText(RegisterActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
                break;
        }
    }
}
