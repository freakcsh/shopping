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

public class My_Pay_Password_Activity extends Activity {
    @BindView(R.id.alter_password)
    TextView alterPassword;
    @BindView(R.id.forget_password)
    TextView forgetPassword;
    Intent intent;
    @BindView(R.id.title_return)
    ImageView titleReturn;
    @BindView(R.id.title_name)
    TextView titleName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_pay_password);
        ButterKnife.bind(this);
        intent = new Intent();
        titleName.setText("支付密码");
    }

    @OnClick({R.id.alter_password, R.id.forget_password})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.alter_password:
                intent.setClass(My_Pay_Password_Activity.this, My_Alter_Password_Activity.class);
                startActivity(intent);
                break;
            case R.id.forget_password:
                intent.setClass(My_Pay_Password_Activity.this, My_Forget_password_Activity.class);
                startActivity(intent);
                break;
        }
    }

    @OnClick(R.id.title_return)
    public void onViewClicked() {
        finish();
    }
}
