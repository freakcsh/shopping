package com.freak.shopping.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.freak.shopping.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/11/23.
 */

public class My_CQC_Activity extends Activity {
    @BindView(R.id.title_return)
    ImageView titleReturn;
    @BindView(R.id.title_name)
    TextView titleName;
    @BindView(R.id.cqc_sj_zt)
    TextView cqcSjZt;
    @BindView(R.id.cqc_sj)
    LinearLayout cqcSj;
    @BindView(R.id.cqc_sfz_zt)
    TextView cqcSfzZt;
    @BindView(R.id.cqc_sfz)
    LinearLayout cqcSfz;
    @BindView(R.id.cqc_wx_zt)
    TextView cqcWxZt;
    @BindView(R.id.cqc_wx)
    LinearLayout cqcWx;
    @BindView(R.id.cqc_zfb_zt)
    TextView cqcZfbZt;
    @BindView(R.id.cqc_zfb)
    LinearLayout cqcZfb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_cqc);
        ButterKnife.bind(this);
        titleName.setText("认证中心");
    }

    @OnClick({R.id.title_return, R.id.cqc_sj_zt, R.id.cqc_sj, R.id.cqc_sfz_zt, R.id.cqc_sfz})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_return:
                finish();
                break;
            case R.id.cqc_sj_zt:
                break;
            case R.id.cqc_sj:
                break;
            case R.id.cqc_sfz_zt:
                break;
            case R.id.cqc_sfz:
                break;
        }
    }
}
