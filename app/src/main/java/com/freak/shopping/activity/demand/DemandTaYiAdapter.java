package com.freak.shopping.activity.demand;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.freak.shopping.R;

import java.util.List;

/**
 * Created by Administrator on 2017/11/24.
 */

public class DemandTaYiAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<DemandTaYiBean> list;
    private Context context;

    public DemandTaYiAdapter(Context context, List<DemandTaYiBean> list) {
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
        DemandTaDaiAdapter.ViewHolder taYiHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.demand_ta_item, null);
            taYiHolder = new DemandTaDaiAdapter.ViewHolder(view);
            view.setTag(taYiHolder);
        } else {
            taYiHolder = (DemandTaDaiAdapter.ViewHolder) view.getTag();
        }
//        taYiHolder.demandTaImg.setBackgroundResource(list.get(i).ta_yi_img);
        Glide.with(context).load(list.get(i).ta_yi_img).centerCrop().placeholder(R.mipmap.ic_launcher).into(taYiHolder.demandTaImg);
        taYiHolder.demandTaName.setText(list.get(i).ta_yi_name);
        taYiHolder.demandTaAgeSex.setText(list.get(i).ta_yi_age_sex);
        taYiHolder.demandTaDistance.setText(list.get(i).ta_yi_distance);
        taYiHolder.demandTaServer.setText(list.get(i).ta_yi_server);
        Glide.with(context).load(list.get(i).ta_yi_sj).centerCrop().placeholder(R.mipmap.ic_launcher).into(taYiHolder.demandTaSj);
        Glide.with(context).load(list.get(i).ta_yi_sfz).centerCrop().placeholder(R.mipmap.ic_launcher).into(taYiHolder.demandTaCqc);
        Glide.with(context).load(list.get(i).ta_yi_wx).centerCrop().placeholder(R.mipmap.ic_launcher).into(taYiHolder.demandTaWx);
//        taYiHolder.demandTaSj.setBackgroundResource(list.get(i).ta_yi_sj);
//        taYiHolder.demandTaCqc.setBackgroundResource(list.get(i).ta_yi_sfz);
//        taYiHolder.demandTaWx.setBackgroundResource(list.get(i).ta_yi_wx);
        taYiHolder.demandTaYy.setText(list.get(i).ta_yi_yy);
        taYiHolder.demandTaYy.setBackgroundResource(R.drawable.text_view_green);

        return view;
    }
}

