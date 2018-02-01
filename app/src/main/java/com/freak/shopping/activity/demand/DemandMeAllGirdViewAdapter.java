package com.freak.shopping.activity.demand;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.freak.shopping.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/11/27.
 */

public class DemandMeAllGirdViewAdapter extends BaseAdapter {
    LayoutInflater mInflater;
    List<DemandMeAllGirdViewBean> list;
    List<DemandMeAllGirdViewBean> girdViewBeen;
    private Context context;


    public DemandMeAllGirdViewAdapter(Context context, List<DemandMeAllGirdViewBean> list) {
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
        ViewHolder allGirdHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.demand_gird_view_item, null);
            allGirdHolder=new ViewHolder(view);
            view.setTag(allGirdHolder);
        }
        else {
            allGirdHolder= (ViewHolder) view.getTag();
        }
//        allGirdHolder.girdImg.setImageResource(list.get(i).demand_all_gird_img);
        Glide.with(context).load(list.get(i).demand_all_gird_img).centerCrop().placeholder(R.mipmap.ic_launcher).into(allGirdHolder.girdImg);
        return view;
    }

    static class ViewHolder {
        @BindView(R.id.gird_img)
        ImageView girdImg;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
