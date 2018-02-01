package com.freak.shopping.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.freak.shopping.R;
import com.freak.shopping.adapter.My_photo_Adapter;
import com.freak.shopping.bean.My_photo_bean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/10/16.
 */

public class My_Photo_Activity extends Activity {
    @BindView(R.id.title_return)
    ImageView titleReturn;
    @BindView(R.id.title_name)
    TextView titleName;
    @BindView(R.id.photo_list)
    ListView photoList;
    private ArrayList<My_photo_bean> list;
    private int one_res[] = {R.drawable.timg4, R.drawable.timg, R.drawable.tx, R.drawable.tx1, R.drawable.tx1, R.drawable.tx11};
    private String name_res[] = {"恋恋baby", "看看baby", "宿舍baby", "打的baby", "问问baby", "波比baby"};
    private String time_res[] = {"6月15日", "6月16日", "6月17日", "6月18日", "6月19日", "6月20日"};
    private String text_res[] = {"新食堂的味道相当不错，装修风格也很小清新。大中午的食堂已经被我霸占了",
            "新食堂的味道相当不错，装修风格也很小清新。大中午的食堂已经被我霸占了",
            "新食堂的味道相当不错，装修风格也很小清新。大中午的食堂已经被我霸占了",
            "新食堂的味道相当不错，装修风格也很小清新。大中午的食堂已经被我霸占了",
            "新食堂的味道相当不错，装修风格也很小清新。大中午的食堂已经被我霸占了",
            "新食堂的味道相当不错，装修风格也很小清新。大中午的食堂已经被我霸占了",};
    private int img_one[]={R.drawable.timg4, R.drawable.timg, R.drawable.tx,R.drawable.timg, R.drawable.tx, R.drawable.tx1};
    private int img_two[]={R.drawable.timg, R.drawable.tx, R.drawable.tx1, R.drawable.tx1,R.drawable.timg4,R.drawable.tx11};
    private int img_three[]={R.drawable.timg4, R.drawable.timg, R.drawable.tx, R.drawable.tx1, R.drawable.tx1, R.drawable.tx11};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_album);
        ButterKnife.bind(this);
        titleName.setText("我的相册");
        getRes();
    }

    @OnClick(R.id.title_return)
    public void onViewClicked() {
        finish();
    }

    public void getRes() {
      list=new ArrayList<>();
        for (int i=0;i<one_res.length;i++){
            list.add(new My_photo_bean(
                    one_res[i],
                    name_res[i],
                    time_res[i],
                    text_res[i],
                    img_one[i],
                    img_two[i],
                    img_three[i]
            ));
        }
        My_photo_Adapter myPhotoAdapter=new My_photo_Adapter(My_Photo_Activity.this,list);
        photoList.setAdapter(myPhotoAdapter);
    }
}
