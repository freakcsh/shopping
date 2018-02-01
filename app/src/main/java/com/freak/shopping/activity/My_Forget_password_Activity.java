package com.freak.shopping.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.freak.shopping.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/10/17.
 */

public class My_Forget_password_Activity extends Activity {
    @BindView(R.id.phone_number)
    TextView phoneNumber;
    @BindView(R.id.send_verification_code)
    TextView sendVerificationCode;
    @BindView(R.id.verification_code)
    TextView verificationCode;
    @BindView(R.id.alter_new_password)
    TextView alterNewPassword;
    @BindView(R.id.verify_alter_new_password)
    TextView verifyAlterNewPassword;
    @BindView(R.id.forget_verify)
    TextView forgetVerify;
    @BindView(R.id.title_return)
    ImageView titleReturn;
    @BindView(R.id.title_name)
    TextView titleName;
    Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_forget_password);
        ButterKnife.bind(this);
        intent=new Intent();
        titleName.setText("忘记支付密码");
    }

    @OnClick({R.id.send_verification_code, R.id.forget_verify})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.send_verification_code:
                break;
            case R.id.forget_verify:
                intent.setClass(My_Forget_password_Activity.this,My_Forget_password_Activity.class);
                finish();
                break;
        }
    }

    @OnClick(R.id.title_return)
    public void onViewClicked() {
        finish();
    }
}
