package com.freak.shopping.activity.demand;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.freak.shopping.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/11/24.
 */

public class DemandTaYiCJAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<DemandTaYiCJBean> list;
    private Context context;

    public DemandTaYiCJAdapter(Context context, List<DemandTaYiCJBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        DemandTaDaiAdapter.ViewHolder taYiCJHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.demand_ta_item, null);
            taYiCJHolder = new DemandTaDaiAdapter.ViewHolder(view);
            view.setTag(taYiCJHolder);
        } else {
            taYiCJHolder = (DemandTaDaiAdapter.ViewHolder) view.getTag();
        }
//        taYiCJHolder.demandTaImg.setBackgroundResource(list.get(i).ta_yi_cj_img);
        Glide.with(context).load(list.get(i).ta_yi_cj_img).centerCrop().placeholder(R.mipmap.ic_launcher).into(taYiCJHolder.demandTaImg);
        taYiCJHolder.demandTaName.setText(list.get(i).ta_yi_cj_name);
        taYiCJHolder.demandTaAgeSex.setText(list.get(i).ta_yi_cj_age_sex);
        taYiCJHolder.demandTaDistance.setText(list.get(i).ta_yi_cj_distance);
        taYiCJHolder.demandTaServer.setText(list.get(i).ta_yi_cj_server);
        Glide.with(context).load(list.get(i).ta_yi_cj_sj).centerCrop().placeholder(R.mipmap.ic_launcher).into(taYiCJHolder.demandTaSj);
        Glide.with(context).load(list.get(i).ta_yi_cj_sfz).centerCrop().placeholder(R.mipmap.ic_launcher).into(taYiCJHolder.demandTaCqc);
        Glide.with(context).load(list.get(i).ta_yi_cj_wx).centerCrop().placeholder(R.mipmap.ic_launcher).into(taYiCJHolder.demandTaWx);
//        taYiCJHolder.demandTaSj.setBackgroundResource(list.get(i).ta_yi_cj_sj);
//        taYiCJHolder.demandTaCqc.setBackgroundResource(list.get(i).ta_yi_cj_sfz);
//        taYiCJHolder.demandTaWx.setBackgroundResource(list.get(i).ta_yi_cj_wx);
        taYiCJHolder.demandTaYy.setText(list.get(i).ta_yi_cj_yy);
        taYiCJHolder.demandTaYy.setBackgroundResource(R.drawable.text_view_hui);
        return view;
    }
}
