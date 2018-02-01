package com.freak.shopping.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.freak.shopping.R;
import com.freak.shopping.adapter.My_bill_Adapter;
import com.freak.shopping.bean.My_Bill_Bean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/10/17.
 */

public class My_Bill_Activity extends Activity {
    @BindView(R.id.my_bill_list)
    ListView myBillList;
    @BindView(R.id.title_return)
    ImageView titleReturn;
    @BindView(R.id.title_name)
    TextView titleName;
    ArrayList<My_Bill_Bean> list;
    private String type_res[] = {"账单", "诚意金", "账单", "诚意金", "账单", "诚意金", "账单", "诚意金"};
    private String time_res[] = {"2017-07-13 20:00", "2017-07-13 20:00", "2017-07-13 20:00", "2017-07-13 20:00",
            "2017-07-13 20:00", "2017-07-13 20:00", "2017-07-13 20:00", "2017-07-13 20:00"};
    private String older_res[] = {"60004540", "46570541", "60004541", "46570542", "60004542", "46570543", "60004543", "46570544"};
    private String money_res[] = {"+300.0", "-500.0", "+300.0", "-500.0", "+300.0", "-500.0", "+300.0", "-500.0"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_bill);
        ButterKnife.bind(this);
        titleName.setText("账单");
        getRes();
    }

    public void getRes() {
        list = new ArrayList<>();
        for (int i = 0; i < type_res.length; i++) {
            list.add(new My_Bill_Bean(
                    type_res[i],
                    time_res[i],
                    older_res[i],
                    money_res[i]
                    ));
        }
        My_bill_Adapter myBillAdapter=new My_bill_Adapter(My_Bill_Activity.this,list);
        myBillList.setAdapter(myBillAdapter);

    }

    @OnClick(R.id.title_return)
    public void onViewClicked() {
        finish();
    }
}
