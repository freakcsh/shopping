package com.freak.shopping;





import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.freak.shopping.adapter.MyFragmentAdapter;
import com.freak.shopping.custom.ChangeColorIconWithText;
import com.freak.shopping.fragment.DemandFragment;
import com.freak.shopping.fragment.HomeFragment;
import com.freak.shopping.fragment.MeFragment;
import com.freak.shopping.fragment.OfficialFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener ,ViewPager.OnPageChangeListener{
    private ImageView image_fa_bu;
    private List<ChangeColorIconWithText> mTab = new ArrayList<>();
    private ViewPager mViewpager;
    private List<Fragment> mFragment = new ArrayList<>();
    private FragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initView();
        mFragment.add(new HomeFragment());
        mFragment.add(new OfficialFragment());
        mFragment.add(new DemandFragment());
        mFragment.add(new MeFragment());
        adapter = new MyFragmentAdapter(getSupportFragmentManager(), mFragment);
        mViewpager = (ViewPager) findViewById(R.id.viewpager);
        mViewpager.setAdapter(adapter);
        mViewpager.setOnClickListener(this);
        mViewpager.setOnPageChangeListener(this);
    }

    private void initView() {
        ChangeColorIconWithText home = (ChangeColorIconWithText) findViewById(R.id.home);
        mTab.add(home);
        ChangeColorIconWithText official = (ChangeColorIconWithText) findViewById(R.id.official);
        mTab.add(official);
        ChangeColorIconWithText demand = (ChangeColorIconWithText) findViewById(R.id.demand);
        mTab.add(demand);
        ChangeColorIconWithText me = (ChangeColorIconWithText) findViewById(R.id.me);
        mTab.add(me);
        image_fa_bu = (ImageView) findViewById(R.id.image_fa_bu);
        home.setOnClickListener(this);
        official.setOnClickListener(this);
        demand.setOnClickListener(this);
        me.setOnClickListener(this);
        home.setIconAlpha(1.0f);
        image_fa_bu.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        resetOtherTabs();
        switch (view.getId()) {
            case R.id.home:
                mTab.get(0).setIconAlpha(1.0f);
                mViewpager.setCurrentItem(0,false);
                break;
            case R.id.official:
                mTab.get(1).setIconAlpha(1.0f);
                mViewpager.setCurrentItem(1,false);
                break;
            case R.id.image_fa_bu:
                Toast.makeText(MainActivity.this, "发布", Toast.LENGTH_LONG).show();
                break;
            case R.id.demand:
                mTab.get(2).setIconAlpha(1.0f);
                mViewpager.setCurrentItem(2,false);
                break;
            case R.id.me:
                mTab.get(3).setIconAlpha(1.0f);
                mViewpager.setCurrentItem(3,false);
                break;
        }
    }

    /**
     * 重置其他的TabIndicator的颜色
     */
    private void resetOtherTabs() {
        for (int i = 0; i < mTab.size(); i++)
        {
            mTab.get(i).setIconAlpha(0);
        }
    }

    private long lastClickTime=0;
    @Override
    public void onBackPressed() {
        if (lastClickTime <= 0) {
            Toast.makeText(MainActivity.this, "再点一次退出程序", Toast.LENGTH_SHORT).show();
            lastClickTime = System.currentTimeMillis();
        } else {
            long currentClickTime = System.currentTimeMillis();
            if (currentClickTime - lastClickTime < 1000) {
                finish();
            } else {
                lastClickTime = currentClickTime;
            }
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (positionOffset > 0)
        {
            ChangeColorIconWithText left = mTab.get(position);
            ChangeColorIconWithText right = mTab.get(position + 1);
            left.setIconAlpha(1 - positionOffset);
            right.setIconAlpha(positionOffset);
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
