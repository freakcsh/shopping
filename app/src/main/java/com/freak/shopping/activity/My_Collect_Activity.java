package com.freak.shopping.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.freak.shopping.R;
import com.freak.shopping.adapter.MyFragmentPagerAdapter;
import com.freak.shopping.custom.ViewPagerIndicator;
import com.freak.shopping.fragment.Collect_User_Fragment;
import com.freak.shopping.fragment.Colllect_Activity_Fragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnPageChange;

/**
 * Created by Administrator on 2017/10/27.
 */

public class My_Collect_Activity extends FragmentActivity implements ViewPager.OnPageChangeListener {
    @BindView(R.id.title_return)
    ImageView titleReturn;
    @BindView(R.id.title_name)
    TextView titleName;
    @BindView(R.id.my_collect_user)
    TextView myCollectUser;
    @BindView(R.id.my_collect_activity)
    TextView myCollectActivity;
    @BindView(R.id.collect_indicator)
    ViewPagerIndicator collectIndicator;
    @BindView(R.id.collect_viewpager)
    ViewPager collectViewpager;

    private List<Fragment> list;
    private FragmentPagerAdapter fragmentPagerAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_collect);
        ButterKnife.bind(this);
        titleName.setText("我的收藏");
        list = new ArrayList<>();

        list.add(new Collect_User_Fragment());
        list.add(new Colllect_Activity_Fragment());
        fragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), list);
        collectViewpager.setAdapter(fragmentPagerAdapter);
        collectViewpager.setOnPageChangeListener(this);
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        //偏移量 tabWidth*positionOffset+position*tabWidth
        collectIndicator.scroll(position,positionOffset);
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    @OnClick({R.id.title_return, R.id.my_collect_user, R.id.my_collect_activity})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_return:
                finish();
                break;
            case R.id.my_collect_user:
                break;
            case R.id.my_collect_activity:
                break;
        }
    }
}
