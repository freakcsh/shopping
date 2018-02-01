package com.freak.shopping.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.freak.shopping.R;
import com.freak.shopping.adapter.My_Coupon_Adapter;
import com.freak.shopping.bean.My_Coupon_Bean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/10/16.
 */

public class My_account_Activity extends Activity {
    @BindView(R.id.money)
    TextView money;
    @BindView(R.id.coupon)
    TextView coupon;
    @BindView(R.id.coupon_num)
    TextView couponNum;
    @BindView(R.id.bill)
    TextView bill;
    @BindView(R.id.pay_password)
    TextView payPassword;
    @BindView(R.id.bind_account)
    TextView bindAccount;
    @BindView(R.id.recharge)
    TextView recharge;
    @BindView(R.id.title_return)
    ImageView titleReturn;
    @BindView(R.id.title_name)
    TextView titleName;
    Intent account_intent;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_account);
        ButterKnife.bind(this);
        account_intent = new Intent();
        titleName.setText("我的账户");
    }



    @OnClick({R.id.coupon, R.id.bill, R.id.pay_password, R.id.bind_account, R.id.recharge, R.id.title_return})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.coupon:
                Intent a=new Intent();
                a.setClass(My_account_Activity.this, My_Coupon_Activity.class);
                startActivity(a);
                break;
            case R.id.bill:
                account_intent.setClass(My_account_Activity.this, My_Bill_Activity.class);
                startActivity(account_intent);
                break;
            case R.id.pay_password:
                account_intent.setClass(My_account_Activity.this, My_Pay_Password_Activity.class);
                startActivity(account_intent);
                break;
            case R.id.bind_account:
                account_intent.setClass(My_account_Activity.this, My_Bind_Account_Activity.class);
                startActivity(account_intent);
                break;
            case R.id.recharge:
                finish();
                account_intent.setClass(My_account_Activity.this, My_account_Activity.class);
                startActivity(account_intent);
                break;
            case R.id.title_return:
                finish();
                break;
        }
    }

}
