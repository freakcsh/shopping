package com.freak.shopping.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.freak.shopping.R;
import com.freak.shopping.adapter.MyFragmentPagerAdapter;
import com.freak.shopping.custom.CircleImageView;
import com.freak.shopping.custom.ViewPagerIndicator;
import com.freak.shopping.fragment.MyHomePage_information;
import com.freak.shopping.fragment.MyHomePahe_skill;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/11/22.
 */

public class MyHomePageActivity extends FragmentActivity implements ViewPager.OnPageChangeListener{
    @BindView(R.id.home_return)
    TextView homeReturn;
    @BindView(R.id.relativeLayout)
    RelativeLayout relativeLayout;
    @BindView(R.id.home_imageView)
    CircleImageView homeImageView;
    @BindView(R.id.home_name)
    TextView homeName;
    @BindView(R.id.home_sex_age)
    TextView homeSexAge;
    @BindView(R.id.home_information)
    TextView homeInformation;
    @BindView(R.id.home_skill)
    TextView homeSkill;
    @BindView(R.id.home_indicator)
    ViewPagerIndicator homeIndicator;
    @BindView(R.id.home_viewpager)
    ViewPager homeViewpager;

    private List<Fragment> list;
    private FragmentPagerAdapter fragmentPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        ButterKnife.bind(this);
        list=new ArrayList<>();

        list.add(new MyHomePage_information());
        list.add(new MyHomePahe_skill());
        fragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), list);
        homeViewpager.setAdapter(fragmentPagerAdapter);
        homeViewpager.setOnPageChangeListener(this);

    }

    @OnClick({R.id.home_return, R.id.home_imageView, R.id.home_name, R.id.home_sex_age})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_return:
                finish();
                break;
            case R.id.home_imageView:
                Toast.makeText(MyHomePageActivity.this,"修改头像",Toast.LENGTH_LONG).show();
                break;
            case R.id.home_name:
                Toast.makeText(MyHomePageActivity.this,"修改名字",Toast.LENGTH_LONG).show();
                break;
            case R.id.home_sex_age:
                Toast.makeText(MyHomePageActivity.this,"修改性别和年龄",Toast.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        homeIndicator.scroll(position,positionOffset);
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
