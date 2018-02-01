package com.freak.shopping.activity.demand;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import com.freak.shopping.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/11/23.
 */

public class DemandMeAllFragment extends Fragment implements AbsListView.OnScrollListener{
    @BindView(R.id.demand_me_all)
    ListView demandMeAll;
    Unbinder unbinder;
    private List<DemandMeAllBean> list;
    private DemandMeAllGirdViewAdapter meAllGirdViewAdapter;
    private List<DemandMeAllGirdViewBean> gird_list;
    boolean mIsScroll;
    private int num = 5;
    private int first_res[] = {R.drawable.tx, R.drawable.tx, R.drawable.timg4, R.drawable.tx, R.drawable.timg4, R.drawable.tx, R.drawable.timg4, R.drawable.tx, R.drawable.timg4, R.drawable.tx, R.drawable.timg4
            , R.drawable.tx, R.drawable.timg4, R.drawable.tx, R.drawable.timg4, R.drawable.tx, R.drawable.timg4, R.drawable.tx, R.drawable.timg4, R.drawable.tx};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View me_all = inflater.inflate(R.layout.demand_me_all_list, null);
        unbinder = ButterKnife.bind(this, me_all);
        return me_all;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getList();
    }

    private void getList() {
        list = new ArrayList<>();
        gird_list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            gird_list.add(new DemandMeAllGirdViewBean(
                    first_res[i]
            ));
        }
//        meAllGirdViewAdapter = new DemandMeAllGirdViewAdapter(getActivity(), gird_list);
        for (int i = 0; i < 5; i++) {
            list.add(new DemandMeAllBean(
                    R.drawable.tx1,
                    "陪聊天",
                    "未成交",
                    "应邀（" + num + i + ")"
            ));
        }
        DemandMeAllAdapter demandMeAllAdapter = new DemandMeAllAdapter(getActivity(), list,gird_list);
        demandMeAll.setAdapter(demandMeAllAdapter);
        demandMeAll.setOnScrollListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i==AbsListView.OnScrollListener.SCROLL_STATE_IDLE){
            mIsScroll=false;
        }else {
            mIsScroll=true;
        }
    }

    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2) {

    }
}
