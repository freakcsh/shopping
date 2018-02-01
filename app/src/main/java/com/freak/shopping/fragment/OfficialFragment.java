package com.freak.shopping.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.freak.shopping.R;
import com.freak.shopping.activity.official.OfficialActivityParticulars;
import com.freak.shopping.activity.official.OfficialListViewAdapter;
import com.freak.shopping.activity.official.OfficialListViewBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/7/29.
 */

public class OfficialFragment extends Fragment implements AdapterView.OnItemClickListener{

    @BindView(R.id.official_message)
    TextView officialMessage;
    @BindView(R.id.official_listView)
    ListView officialListView;
    Unbinder unbinder;

    private List<OfficialListViewBean> list;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View official = inflater.inflate(R.layout.official_fragment, container, false);
        unbinder = ButterKnife.bind(this, official);
        getRes();
        return official;
    }

    private void getRes() {
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new OfficialListViewBean(
                    R.drawable.timg1,
                    R.drawable.tx,
                    "海底捞夏日活动，满100减50",
                    "报名人数：100",
                    "浏览量：46467"
                    ));
        }
        OfficialListViewAdapter officialListViewAdapter=new OfficialListViewAdapter(getActivity(),list);
        officialListView.setAdapter(officialListViewAdapter);
        officialListView.setOnItemClickListener(this);
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

    @OnClick(R.id.official_message)
    public void onViewClicked() {
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getActivity(),"点击item"+i,Toast.LENGTH_LONG).show();
        Intent intent=new Intent();
        intent.setClass(getActivity(), OfficialActivityParticulars.class);
        startActivity(intent);
    }
}
