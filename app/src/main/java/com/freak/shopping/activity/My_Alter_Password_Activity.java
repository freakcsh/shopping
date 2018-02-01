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

public class My_Alter_Password_Activity extends Activity {
    @BindView(R.id.old_password)
    TextView oldPassword;
    @BindView(R.id.new_password)
    TextView newPassword;
    @BindView(R.id.verify_password)
    TextView verifyPassword;
    @BindView(R.id.title_return)
    ImageView titleReturn;
    @BindView(R.id.title_name)
    TextView titleName;
    @BindView(R.id.verify_alter)
    TextView verifyAlter;
    Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_alter_password);
        ButterKnife.bind(this);
        titleName.setText("修改支付密码");
        verifyAlter.setText("确认修改");
        intent = new Intent();
    }

    @OnClick({R.id.title_return, R.id.verify_alter})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_return:
                finish();
                break;
            case R.id.verify_alter:
                intent.setClass(My_Alter_Password_Activity.this,My_Alter_Password_Activity.class);
                finish();
                break;
        }
    }
}
