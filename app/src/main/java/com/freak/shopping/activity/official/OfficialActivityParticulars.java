package com.freak.shopping.activity.official;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import com.freak.shopping.R;
import com.freak.shopping.adapter.MyFragmentPagerAdapter;
import com.freak.shopping.custom.ViewPagerIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/11/27.
 */

public class OfficialActivityParticulars extends AppCompatActivity implements ViewPager.OnPageChangeListener{
    @BindView(R.id.title_return)
    ImageView titleReturn;
    @BindView(R.id.title_name)
    TextView titleName;
    @BindView(R.id.official_activity_particulars)
    TextView officialActivityParticulars;
    @BindView(R.id.official_comment)
    TextView officialComment;
    @BindView(R.id.official_order_dishes)
    TextView officialOrderDishes;
    @BindView(R.id.official_indicator)
    ViewPagerIndicator officialIndicator;
    @BindView(R.id.official_viewpager)
    ViewPager officialViewpager;
    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.official_particulars);
        ButterKnife.bind(this);
        titleName.setText("活动详情");
        getFragment();
    }

    private void getFragment() {
        fragmentList=new ArrayList<>();
        OfficialActivityFragment activityFragment=new OfficialActivityFragment();
        OfficialCommentFragment commentFragment=new OfficialCommentFragment();
        OfficialOrderDishesFragment orderDishesFragment=new OfficialOrderDishesFragment();
        fragmentList.add(activityFragment);
        fragmentList.add(commentFragment);
        fragmentList.add(orderDishesFragment);
        MyFragmentPagerAdapter adapter=new MyFragmentPagerAdapter(getSupportFragmentManager(),fragmentList);
        officialViewpager.setAdapter(adapter);
        officialViewpager.setOnPageChangeListener(this);
    }

    @OnClick({R.id.title_return, R.id.official_activity_particulars, R.id.official_comment, R.id.official_order_dishes})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_return:
                finish();
                break;
            case R.id.official_activity_particulars:
                break;
            case R.id.official_comment:
                break;
            case R.id.official_order_dishes:
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        officialIndicator.scroll(position,positionOffset);
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
