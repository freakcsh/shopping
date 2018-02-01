package com.freak.shopping.activity.demand;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
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

public class DemandTaFragment extends Fragment implements ViewPager.OnPageChangeListener {
    @BindView(R.id.demand_dai)
    TextView demandDai;
    @BindView(R.id.demand_yi)
    TextView demandYi;
    @BindView(R.id.demand_success)
    TextView demandSuccess;
    Unbinder unbinder;
    @BindView(R.id.demand_ta_indicator)
    ViewPagerIndicator demandTaIndicator;
    @BindView(R.id.demand_ta_viewpager)
    ViewPager demandTaViewpager;
    private List<Fragment> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View ta = inflater.inflate(R.layout.demand_ta_fragment, container, false);
        unbinder = ButterKnife.bind(this, ta);

        return ta;
    }

    private void getFragment() {
        list = new ArrayList<>();

        list.add(new DemandTaDaiFragment());
        list.add(new DemandTaYiFragment());
        list.add(new DemandTaYICJFragment());
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getFragmentManager(), list);
        demandTaViewpager.setAdapter(adapter);
        demandTaViewpager.setOnPageChangeListener(this);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getFragment();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.demand_dai, R.id.demand_yi, R.id.demand_success})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.demand_dai:
                break;
            case R.id.demand_yi:
                break;
            case R.id.demand_success:
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        demandTaIndicator.scroll(position, positionOffset);
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
