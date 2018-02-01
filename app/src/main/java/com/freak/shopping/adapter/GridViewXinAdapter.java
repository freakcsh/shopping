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
import com.freak.shopping.bean.GridViewXinItemBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/2.
 */

public class GridViewXinAdapter extends BaseAdapter {
    private ArrayList<GridViewXinItemBean> xin_list;
    private Context context;

    public GridViewXinAdapter(Context context, ArrayList<GridViewXinItemBean> xin_list) {
        this.context = context;
        this.xin_list = xin_list;
    }

    @Override
    public int getCount() {
        return xin_list.size();
    }

    @Override
    public Object getItem(int i) {
        return xin_list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder xinViewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.grid_view_xing_item, null);
            xinViewHolder = new ViewHolder(view);
            view.setTag(xinViewHolder);
        } else {
            xinViewHolder = (ViewHolder) view.getTag();
        }
        Glide.with(context).load(xin_list.get(i).xin_img).centerCrop().placeholder(R.mipmap.ic_launcher).into(xinViewHolder.gridViewImg);
        xinViewHolder.gridViewName.setText(xin_list.get(i).xin_name);
        xinViewHolder.gridViewAge.setText(xin_list.get(i).xin_age);
        Glide.with(context).load(xin_list.get(i).xin_sex).centerCrop().placeholder(R.mipmap.ic_launcher).into(xinViewHolder.xinSex);
        xinViewHolder.gridViewWork.setText(xin_list.get(i).xin_work);
        xinViewHolder.gridViewPrice.setText(xin_list.get(i).xin_price);
        return view;
    }


    static class ViewHolder {
        @BindView(R.id.grid_view_img)
        ImageView gridViewImg;
        @BindView(R.id.grid_view_name)
        TextView gridViewName;
        @BindView(R.id.grid_view_age)
        TextView gridViewAge;
        @BindView(R.id.xin_sex)
        ImageView xinSex;
        @BindView(R.id.grid_view_work)
        TextView gridViewWork;
        @BindView(R.id.grid_view_price)
        TextView gridViewPrice;
        @BindView(R.id.textView18)
        TextView textView18;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
