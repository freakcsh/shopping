package com.freak.shopping.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.freak.shopping.R;
import com.freak.shopping.bean.My_Collect_Bean;
import com.freak.shopping.custom.CircleImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/11/10.
 */

public class My_Collect_Adapter extends BaseAdapter {

    private ArrayList<My_Collect_Bean> list;
    private Context context;

    public My_Collect_Adapter(Context context, ArrayList<My_Collect_Bean> list) {
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
        ViewHolder collectViewHolder;
        if (view == null) {

            view = LayoutInflater.from(context).inflate(R.layout.my_collect_item, null);
            collectViewHolder = new ViewHolder(view);
            view.setTag(collectViewHolder);
        } else {
            collectViewHolder = (ViewHolder) view.getTag();
        }

        Glide.with(context).load(list.get(i).collect_img).centerCrop().placeholder(R.mipmap.ic_launcher).into(collectViewHolder.myCollectImg);
        Glide.with(context).load(list.get(i).collect_img_da).centerCrop().placeholder(R.mipmap.ic_launcher).into(collectViewHolder.myCollectImgDa);
        collectViewHolder.myCollectName.setText(list.get(i).collect_name);
        collectViewHolder.myCollectTime.setText(list.get(i).collect_time);
        collectViewHolder.myCollectServer.setText(list.get(i).collect_server);
        collectViewHolder.myCollectIntroduce.setText(list.get(i).collect_introduce);
        return view;
    }



    static class ViewHolder {
        @BindView(R.id.my_collect_img)
        CircleImageView myCollectImg;
        @BindView(R.id.my_collect_name)
        TextView myCollectName;
        @BindView(R.id.my_collect_time)
        TextView myCollectTime;
        @BindView(R.id.my_collect_img_da)
        ImageView myCollectImgDa;
        @BindView(R.id.textView29)
        TextView textView29;
        @BindView(R.id.my_collect_server)
        TextView myCollectServer;
        @BindView(R.id.my_collect_introduce)
        TextView myCollectIntroduce;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
