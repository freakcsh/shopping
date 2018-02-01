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
 * Created by Administrator on 2017/11/23.
 */

public class DemandTaDaiAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<DemandTaDaiBean> list;
    Context context;

    public DemandTaDaiAdapter(Context context, List<DemandTaDaiBean> list) {
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
        ViewHolder taDaiHolder;

        if (view==null){

            view=LayoutInflater.from(context).inflate(R.layout.demand_ta_item,null);
            taDaiHolder=new ViewHolder(view);
            view.setTag(taDaiHolder);
        }
        else {
            taDaiHolder= (ViewHolder) view.getTag();
        }
//        taDaiHolder.demandTaImg.setBackgroundResource(list.get(i).ta_img);
        Glide.with(context).load(list.get(i).ta_img).centerCrop().placeholder(R.mipmap.ic_launcher).into(taDaiHolder.demandTaImg);
        taDaiHolder.demandTaName.setText(list.get(i).ta_name);
        taDaiHolder.demandTaAgeSex.setText(list.get(i).ta_age_sex);
        taDaiHolder.demandTaDistance.setText(list.get(i).ta_distance);
        taDaiHolder.demandTaServer.setText(list.get(i).ta_server);
        Glide.with(context).load(list.get(i).ta_sj).centerCrop().placeholder(R.mipmap.ic_launcher).into(taDaiHolder.demandTaSj);
        Glide.with(context).load(list.get(i).ta_sfz).centerCrop().placeholder(R.mipmap.ic_launcher).into(taDaiHolder.demandTaCqc);
        Glide.with(context).load(list.get(i).ta_wx).centerCrop().placeholder(R.mipmap.ic_launcher).into(taDaiHolder.demandTaWx);
//        taDaiHolder.demandTaSj.setBackgroundResource(list.get(i).ta_sj);
//        taDaiHolder.demandTaCqc.setBackgroundResource(list.get(i).ta_sfz);
//        taDaiHolder.demandTaWx.setBackgroundResource(list.get(i).ta_wx);

        return view;
    }

    static class ViewHolder {
        @BindView(R.id.demand_ta_img)
        ImageView demandTaImg;
        @BindView(R.id.demand_ta_name)
        TextView demandTaName;
        @BindView(R.id.demand_ta_server)
        TextView demandTaServer;
        @BindView(R.id.textView27)
        TextView textView27;
        @BindView(R.id.demand_ta_sj)
        ImageView demandTaSj;
        @BindView(R.id.demand_ta_cqc)
        ImageView demandTaCqc;
        @BindView(R.id.demand_ta_wx)
        ImageView demandTaWx;
        @BindView(R.id.demand_ta_age_sex)
        TextView demandTaAgeSex;
        @BindView(R.id.imageView11)
        ImageView imageView11;
        @BindView(R.id.demand_ta_distance)
        TextView demandTaDistance;
        @BindView(R.id.demand_ta_yy)
        TextView demandTaYy;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

