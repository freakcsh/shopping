package com.freak.shopping.activity.official;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.freak.shopping.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/11/28.
 */

public class OfficialOrderDishesFragment extends Fragment {
    @BindView(R.id.official_order_list)
    ListView officialOrderList;
    @BindView(R.id.official_order_price)
    TextView officialOrderPrice;
    @BindView(R.id.official_order_all_num)
    TextView officialOrderAllNum;
    @BindView(R.id.official_order_ok)
    TextView officialOrderOk;
    Unbinder unbinder;
    private List<OfficialOrderDishBean> orderDishBeen;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View orderDish = inflater.inflate(R.layout.official_order_dishes_fragment, container, false);
        unbinder = ButterKnife.bind(this, orderDish);
        return orderDish;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getRes();
    }

    private void getRes() {
    orderDishBeen=new ArrayList<>();
        for (int i=0;i<10;i++){
            orderDishBeen.add(new OfficialOrderDishBean(
               R.drawable.tx,
                    "蛋炒饭",
                    "扬州炒饭又名扬州蛋炒饭，是江苏扬州的经典小吃。主食有米饭、火腿、鸡蛋。",
                    "￥35",
                    "￥45",
                    false
            ));
        }
        OfficialOrderAdapter orderAdapter=new OfficialOrderAdapter(getActivity(),orderDishBeen,officialOrderList);
        officialOrderList.setAdapter(orderAdapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.official_order_ok)
    public void onViewClicked() {
        Toast.makeText(getActivity(), "选好了", Toast.LENGTH_LONG).show();
    }
}
