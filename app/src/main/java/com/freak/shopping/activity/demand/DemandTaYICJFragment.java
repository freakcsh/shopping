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

public class DemandTaYICJFragment extends Fragment {
    @BindView(R.id.demand_ta_yi_cj)
    ListView demandTaYiCj;
    Unbinder unbinder;
    private List<DemandTaYiCJBean> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View ta_yi_cj = inflater.inflate(R.layout.demand_ta_yi_cj_list, container,false);
        unbinder = ButterKnife.bind(this, ta_yi_cj);
        return ta_yi_cj;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getYiCjList();
    }

    private void getYiCjList() {
        list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new DemandTaYiCJBean(
                    R.drawable.timg4,
                    "乖蜀黍",
                    "19",
                    "1.5km",
                    "服务：逛商场",
                    R.drawable.shouji_huang1,
                    R.drawable.shenfenzheng_huang1,
                    R.drawable.weixin_kui1,
                    "已成交"
            ));
        }
        DemandTaYiCJAdapter adapter=new DemandTaYiCJAdapter(getActivity(),list);
        demandTaYiCj.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
