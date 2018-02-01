package com.freak.shopping.fragment;


import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.freak.shopping.R;
import com.freak.shopping.activity.PersonInformationActivity;
import com.freak.shopping.adapter.ListViewAdapter;
import com.freak.shopping.bean.GridItemBean;
import com.freak.shopping.adapter.GridViewBaseAdapter;
import com.freak.shopping.adapter.GridViewXinAdapter;
import com.freak.shopping.bean.GridViewXinItemBean;
import com.freak.shopping.bean.ListItemBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/29.
 */

public class HomeFragment extends Fragment implements AdapterView.OnItemClickListener{
    private GridView mGridView, gridView_xin;
    private ListView mListView;
    //设置GridView的选项名字
    String[] mes = {"聊天", "看电影", "吃饭", "品酒常识", "射箭",
            "健身", "跑步", "学唱歌", "练英文", "更多"};
    //设置GridView的选项图片
    int res[] = {R.drawable.liaotian, R.drawable.kandiany, R.drawable.chifan, R.drawable.pinjiu, R.drawable.jian,
            R.drawable.jianshen, R.drawable.paobu, R.drawable.ktv, R.drawable.yingwen, R.drawable.gengduo};
    private ArrayList<GridItemBean> list;
    private ArrayList<GridViewXinItemBean> xin_list;
    private ArrayList<ListItemBean> listItem;

    //设置每日之星的图片资源
    private int[] st_xin_img = {R.drawable.tx1, R.drawable.tx1, R.drawable.tx1};
    //设置每周之星的名字
    private String st_xin_name[] = {"唉唉baby", "欢欢baby", "恋恋baby"};
    //设置每周之星的性别
    private int st_xin_sex[] = {R.drawable.nv_hong, R.drawable.nv_hong, R.drawable.nv_hong};
    //设置每周之星的年龄
    private String st_xin_age[] = {"23", "23", "23"};
    //设置每周之星的工作类型
    private String st_xin_work[] = {"足疗", "足疗", "足疗"};
    //设置每周之星的消费价格
    private String st_xin_price[] = {"199", "98", "99"};

    //设置listView的数据
    private int list_img[] = {R.drawable.tx11, R.drawable.tx11, R.drawable.tx11, R.drawable.tx11, R.drawable.tx11,
            R.drawable.tx11, R.drawable.tx11, R.drawable.tx11, R.drawable.tx11, R.drawable.tx11};
    private int list_tx[] = {R.drawable.timg1, R.drawable.timg1, R.drawable.timg1, R.drawable.timg1, R.drawable.timg1,
            R.drawable.timg1, R.drawable.timg1, R.drawable.timg1, R.drawable.timg1, R.drawable.timg1};
    private int list_sj[] = {R.drawable.shouji_huang1, R.drawable.shouji_huang1, R.drawable.shouji_huang1, R.drawable.shouji_huang1, R.drawable.shouji_huang1,
            R.drawable.shouji_huang1, R.drawable.shouji_huang1, R.drawable.shouji_huang1, R.drawable.shouji_huang1, R.drawable.shouji_huang1};
    private int list_sfz[] = {R.drawable.shenfenzheng_huang1, R.drawable.shenfenzheng_huang1, R.drawable.shenfenzheng_huang1,
            R.drawable.shenfenzheng_huang1, R.drawable.shenfenzheng_huang1,
            R.drawable.shenfenzheng_huang1, R.drawable.shenfenzheng_huang1, R.drawable.shenfenzheng_huang1,
            R.drawable.shenfenzheng_huang1, R.drawable.shenfenzheng_huang1};
    private int list_wx[] = {R.drawable.weixin_kui1, R.drawable.weixin_kui1, R.drawable.weixin_kui1, R.drawable.weixin_kui1, R.drawable.weixin_kui1
            , R.drawable.weixin_kui1, R.drawable.weixin_kui1, R.drawable.weixin_kui1, R.drawable.weixin_kui1, R.drawable.weixin_kui1};
    private int list_sex[] = {R.drawable.nv_hong, R.drawable.nv_hong, R.drawable.nv_hong, R.drawable.nv_hong, R.drawable.nv_hong,
            R.drawable.nv_hong, R.drawable.nv_hong, R.drawable.nv_hong,
            R.drawable.nv_hong, R.drawable.nv_hong};
    private String list_jl[] = {"1.5km", "1.6km", "2.5km", "3.5km", "11.5km", "51.5km", "12.5km", "15km", "5km", "2km"};
    private String list_fw[] = {"看电影", "看电视", "听音乐", "足疗", "按摩", "游泳", "沐足", "看电影", "看电影", "看电影"};
    private String list_jg[] = {"200", "210", "220", "200", "200", "250", "280", "300", "200", "200"};
    private String list_js[] = {"广东人，肤白貌美大长腿，喜欢去旅游......", "广东人，肤白貌美大长腿，喜欢去旅游......",
            "广东人，肤白貌美大长腿，喜欢去旅游......", "广东人，肤白貌美大长腿，喜欢去旅游......",
            "广东人，肤白貌美大长腿，喜欢去旅游......", "广东人，肤白貌美大长腿，喜欢去旅游......",
            "广东人，肤白貌美大长腿，喜欢去旅游......", "广东人，肤白貌美大长腿，喜欢去旅游......",
            "广东人，肤白貌美大长腿，喜欢去旅游......", "广东人，肤白貌美大长腿，喜欢去旅游......"};
    private String list_age[] = {"24", "23", "24", "24", "21", "24", "24", "24", "24", "24"};
    private String list_xin[] = {"900", "700", "900", "100", "600", "900", "900", "90", "1900", "900"};
    private String list_zan[] = {"1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000", "1000"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View home = inflater.inflate(R.layout.homefragment, container, false);
        mGridView = home.findViewById(R.id.grid_view);
        gridView_xin = home.findViewById(R.id.grid_view_xin);
        mListView = home.findViewById(R.id.list_view);
        return home;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getRes();
        getXinRes();
        getListViewItem();
    }

    public void getRes() {
        list = new ArrayList<>();
        for (int i = 0; i < res.length; i++) {
            list.add(new GridItemBean(res[i], mes[i]));
        }
        GridViewBaseAdapter adapter = new GridViewBaseAdapter(getActivity(), list);
        mGridView.setAdapter(adapter);
    }

    public void getXinRes() {
        xin_list = new ArrayList<>();
        for (int i = 0; i < st_xin_img.length; i++) {
            xin_list.add(new GridViewXinItemBean(
                    st_xin_img[i],
                    st_xin_name[i],
                    st_xin_sex[i],
                    st_xin_age[i],
                    st_xin_work[i],
                    st_xin_price[i]));
        }
        GridViewXinAdapter xin_adapter = new GridViewXinAdapter(getActivity(), xin_list);
        gridView_xin.setAdapter(xin_adapter);

    }

    public void getListViewItem() {
        listItem = new ArrayList<>();
        for (int i = 0; i < list_img.length; i++) {
            listItem.add(new ListItemBean(
                  list_img[i],
                  list_tx[i],
                  list_sj[i],
                   list_sfz[i],
                   list_wx[i],
                  list_sex[i],
                  list_jl[i],
                    list_fw[i],

                    list_jg[i],
                    list_js[i],
                    "恋恋baby",
                  list_age[i],
                    list_xin[i],
                   list_zan[i]));
        }
        ListViewAdapter listAdapter = new ListViewAdapter(getActivity(), listItem);
        mListView.setAdapter(listAdapter);
        mListView.setOnItemClickListener(this);
    }



    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent per_intent=new Intent();
        per_intent.setClass(getActivity(), PersonInformationActivity.class);
        startActivity(per_intent);
    }
}
