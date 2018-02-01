package com.freak.shopping.activity.demand;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.freak.shopping.R;
import com.freak.shopping.adapter.MyFragmentPagerAdapter;
import com.freak.shopping.custom.ViewPagerIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/11/23.
 */

public class DemandMeFragment extends Fragment implements ViewPager.OnPageChangeListener {
    @BindView(R.id.demand_all)
    TextView demandAll;
    @BindView(R.id.demand_no)
    TextView demandNo;
    @BindView(R.id.demand_yes)
    TextView demandYes;
    @BindView(R.id.demand_old)
    TextView demandOld;
    @BindView(R.id.demand_me_viewpager)
    ViewPager demandMeViewpager;
    Unbinder unbinder;
    @BindView(R.id.demand_indicator)
    ViewPagerIndicator demandIndicator;
    private List<Fragment> list;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View me = inflater.inflate(R.layout.demand_ta_me, container, false);
        unbinder = ButterKnife.bind(this, me);
        return me;
    }

    private void getFragment() {
        list = new ArrayList<>();
        list.add(new DemandMeAllFragment());
        list.add(new DemandMeNoFragment());
        list.add(new DemandMeYiFragment());
        list.add(new DemandMeOldFragment());
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getFragmentManager(), list);
        demandMeViewpager.setAdapter(adapter);
        demandMeViewpager.setOnPageChangeListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.demand_all, R.id.demand_no, R.id.demand_yes, R.id.demand_old})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.demand_all:
                break;
            case R.id.demand_no:
                break;
            case R.id.demand_yes:
                break;
            case R.id.demand_old:
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        demandIndicator.scroll(position, positionOffset);
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
