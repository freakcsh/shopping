package com.freak.shopping.activity.demand;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class DemandTaDaiFragment extends Fragment {
    @BindView(R.id.demand_ta_dai)
    ListView demandTaDai;
    Unbinder unbinder;
    private List<DemandTaDaiBean> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View ta_dai = inflater.inflate(R.layout.demand_ta_dai_list, container,false);
        unbinder = ButterKnife.bind(this, ta_dai);

        return ta_dai;
    }

    private void getListViewRes() {
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new DemandTaDaiBean(
                    R.drawable.timg4,
                    "乖蜀黍",
                    "19" + i,
                    "1.5" + i,
                    "服务：逛商场",
                    R.drawable.shouji_huang1,
                    R.drawable.shenfenzheng_huang1,
                    R.drawable.weixin_kui1
            ));
        }
        DemandTaDaiAdapter taAdapter = new DemandTaDaiAdapter(getActivity(), list);
        demandTaDai.setAdapter(taAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getListViewRes();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
