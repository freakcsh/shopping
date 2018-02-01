package com.freak.shopping.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.freak.shopping.R;
import com.freak.shopping.activity.demand.DemandMeFragment;
import com.freak.shopping.activity.demand.DemandTaFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/7/29.
 */

public class DemandFragment extends Fragment {

    @BindView(R.id.demand_ta)
    TextView demandTa;
    @BindView(R.id.demand_me)
    TextView demandMe;
    @BindView(R.id.demand_message)
    TextView demandMessage;
    @BindView(R.id.demand_fragment)
    FrameLayout demandFragment;
    Unbinder unbinder;
    private FragmentManager fragmentManager;
    private FragmentTransaction ft;
    Fragment mCurrentFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View demand = inflater.inflate(R.layout.demand_ta, container, false);
        unbinder = ButterKnife.bind(this, demand);
        getFragment();
        return demand;
    }

    private void getFragment() {
        fragmentManager=getActivity().getSupportFragmentManager();
        ft=fragmentManager.beginTransaction();
        DemandTaFragment taFragment=new DemandTaFragment();
        DemandMeFragment meFragment=new DemandMeFragment();
        ft.add(R.id.demand_fragment,taFragment,"taFragment").add(R.id.demand_fragment,meFragment,"meFragment").hide(meFragment).commit();
    }
    public void switchFragment(String fromTag, String toTag) {
        Fragment from = fragmentManager.findFragmentByTag(fromTag);
        Fragment to = fragmentManager.findFragmentByTag(toTag);
        if (mCurrentFragment != to) {
            mCurrentFragment = to;
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            if (!to.isAdded()) {//判断是否被添加到了Activity里面去了
                transaction.hide(from).add(R.id.demand_fragment, to).commit();
            } else {
                transaction.hide(from).show(to).commit();
            }
        }
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.demand_ta, R.id.demand_me,R.id.demand_message})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.demand_ta:
                switchFragment("meFragment","taFragment");
                demandTa.setTextColor(Color.parseColor("#333333"));
                demandMe.setTextColor(Color.parseColor("#7c6e28"));
                break;
            case R.id.demand_me:
                switchFragment("taFragment","meFragment");
                demandMe.setTextColor(Color.parseColor("#333333"));
                demandTa.setTextColor(Color.parseColor("#7c6e28"));
                break;
            case R.id.demand_message:

                break;
        }
    }
}
