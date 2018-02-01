package com.freak.shopping.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.freak.shopping.R;
import com.freak.shopping.adapter.My_Collect_Adapter;
import com.freak.shopping.bean.My_Collect_Bean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/10/30.
 */

public class Collect_User_Fragment extends Fragment {

private ListView userList;

    private ArrayList<My_Collect_Bean> list;
    private int img_res[] = {R.drawable.tx, R.drawable.tx11, R.drawable.tx1, R.drawable.timg4, R.drawable.tx};
    private String name_res[] = {"恋恋baby", "匹配baby", "宿舍baby", "师弟baby", "博客baby",};
    private String time_res[] = {"6月15日", "6月16日", "6月17日", "6月18日", "6月19日",};
    private int img_da_res[] = {R.drawable.tx, R.drawable.tx11, R.drawable.tx1, R.drawable.timg4, R.drawable.tx};
    private String server_res[]={"看电影","看电视","按摩","打篮球","吃饭",};
    private String introduce_res[]={"广东人，肤白貌美大长腿，喜欢去旅游和话就闪电借款",
            "广西人，肤白貌美大长腿，喜欢去旅游和话就闪电借款",
            "山东人，肤白貌美大长腿，喜欢去旅游和话就闪电借款",
            "桂林人，肤白貌美大长腿，喜欢去旅游和话就闪电借款",
            "湖南人，肤白貌美大长腿，喜欢去旅游和话就闪电借款",};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View user = inflater.inflate(R.layout.my_collect_user_fragment, container, false);
        userList=user.findViewById(R.id.user_list);
        return user;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        list=new ArrayList<>();
        for (int i=0;i<img_res.length;i++){
            list.add(new My_Collect_Bean(
                    img_res[i],
                    name_res[i],
                    time_res[i],
                    img_da_res[i],
                    server_res[i],
                    introduce_res[i]
            ));
        }
        My_Collect_Adapter collectAdapter=new My_Collect_Adapter(getActivity(),list);
        userList.setAdapter(collectAdapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
