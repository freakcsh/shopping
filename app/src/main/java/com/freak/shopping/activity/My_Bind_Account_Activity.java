package com.freak.shopping.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.freak.shopping.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/10/20.
 */

public class My_Bind_Account_Activity extends Activity {
    @BindView(R.id.title_return)
    ImageView titleReturn;
    @BindView(R.id.title_name)
    TextView titleName;
    @BindView(R.id.bill_zhi_fu_bao)
    RelativeLayout billZhiFuBao;
    @BindView(R.id.bill_we_chat)
    RelativeLayout billWeChat;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_account_binding);
        ButterKnife.bind(this);
        titleName.setText("账户绑定");
    }

    @OnClick({R.id.title_return, R.id.bill_zhi_fu_bao, R.id.bill_we_chat})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_return:
                finish();
                break;
            case R.id.bill_zhi_fu_bao:
                Toast.makeText(My_Bind_Account_Activity.this,"绑定支付宝",Toast.LENGTH_LONG).show();
                break;
            case R.id.bill_we_chat:
                Toast.makeText(My_Bind_Account_Activity.this,"绑定微信",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
