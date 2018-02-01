package com.freak.shopping.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.freak.shopping.R;
import com.freak.shopping.adapter.My_Coupon_Adapter;
import com.freak.shopping.bean.My_Coupon_Bean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/10/17.
 */

public class My_Coupon_Activity extends Activity {
    @BindView(R.id.my_coupon_list)
    ListView myCouponList;
    @BindView(R.id.title_return)
    ImageView titleReturn;
    @BindView(R.id.title_name)
    TextView titleName;
    private ArrayList<My_Coupon_Bean> list;
    private int[] img = {R.drawable.youhuiquan_kui, R.drawable.youhuiquan_youse, R.drawable.youhuiquan_kui, R.drawable.youhuiquan_youse};
    private String my_money[] = {"20", "30", "40", "50"};
    private String limit[] = {"满100元使用", "满100元使用", "满100元使用", "满100元使用"};
    private String my_moneys[] = {"20元优惠劵", "30元优惠劵", "40元优惠劵", "50元优惠劵"};
    private String state[] = {"已使用", "未使用", "已使用", "未使用"};
    private String limit_use[] = {"满100元可使用", "满100元可使用", "满100元可使用", "满100元可使用"};
    private String time[] = {"2017-04-01至2017-05-01", "2017-04-01至2017-05-01", "2017-04-01至2017-05-01", "2017-04-01至2017-05-01"};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_coupon);
        ButterKnife.bind(this);
        titleName.setText("我的优惠劵");
        getRes();
    }

    public void getRes() {
        list = new ArrayList<>();
        for (int i = 0; i < img.length; i++) {
            list.add(new My_Coupon_Bean(
                    img[i],
                    my_money[i],
                    limit[i],
                    my_moneys[i],
                    state[i],
                    limit_use[i],
                    time[i]));
        }
        My_Coupon_Adapter my_adapter = new My_Coupon_Adapter(My_Coupon_Activity.this, list);
        myCouponList.setAdapter(my_adapter);

    }

    @OnClick(R.id.title_return)
    public void onViewClicked() {
        finish();
    }
}
