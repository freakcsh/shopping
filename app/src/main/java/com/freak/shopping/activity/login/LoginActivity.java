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

import com.freak.shopping.MainActivity;
import com.freak.shopping.R;
import com.freak.shopping.activity.LoginBean.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;

import static android.text.InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD;

/**
 * Created by Administrator on 2017/11/21.
 */

public class LoginActivity extends Activity {
    @BindView(R.id.title_return)
    ImageView titleReturn;
    @BindView(R.id.title_name)
    TextView titleName;
    @BindView(R.id.login_img)
    ImageView loginImg;
    @BindView(R.id.login_phone)
    EditText loginPhone;
    @BindView(R.id.login_password)
    EditText loginPassword;
    @BindView(R.id.login_password_show)
    ImageView loginPasswordShow;
    @BindView(R.id.login_btn)
    TextView loginBtn;
    @BindView(R.id.login_forget_password)
    TextView loginForgetPassword;
    @BindView(R.id.login_register)
    TextView loginRegister;
    @BindView(R.id.login_we_chat)
    TextView loginWeChat;
    boolean show = true;
    Intent intent = new Intent();
    String edtUserPhone = null;
    String edtUserPassword = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ButterKnife.bind(this);
        Bmob.initialize(this, "b37ca9b24b2b7159acee68818d501393");
        titleName.setText("登录");
        loginBtn.setText("登录");
    }

    @OnClick({R.id.title_return, R.id.login_img, R.id.login_password_show, R.id.login_btn, R.id.login_forget_password, R.id.login_register, R.id.login_we_chat})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_return:
                finish();
                break;
            case R.id.login_img:
                break;
            case R.id.login_password_show:
                if (show) {
                    loginPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    show = false;
                } else {
                    loginPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    show = true;
                }
                break;
            case R.id.login_btn:
                edtUserPhone = loginPhone.getText().toString();
                edtUserPassword = loginPassword.getText().toString();
                BmobUser user2 = new BmobUser();
               user2.loginByAccount(edtUserPhone, edtUserPassword, new LogInListener<User>() {
                   @Override
                   public void done(User user, BmobException e) {
                      if (user!=null){
                          intent.setClass(LoginActivity.this, MainActivity.class);
                          startActivity(intent);
                          finish();
                      }
                      else {
                          Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                      }
                   }
               });
                break;
            case R.id.login_forget_password:
                break;
            case R.id.login_register:
                intent.setClass(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.login_we_chat:
                break;
        }
    }
}
