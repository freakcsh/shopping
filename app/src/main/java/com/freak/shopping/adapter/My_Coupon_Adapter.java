package com.freak.shopping.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.freak.shopping.R;
import com.freak.shopping.bean.My_Coupon_Bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/10/22.
 */

public class My_Coupon_Adapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private ArrayList<My_Coupon_Bean> list;

    public My_Coupon_Adapter(Context  context, ArrayList<My_Coupon_Bean> list) {
        this.mInflater = LayoutInflater.from(context);
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
        ViewHolder viewHolder;
        if (view==null){
            viewHolder=new ViewHolder();
            view=mInflater.inflate(R.layout.my_coupon_item,null);
            viewHolder.my_coupon_img=view.findViewById(R.id.my_coupon_img);
            viewHolder.my_coupon_money=view.findViewById(R.id.my_coupon_money);
            viewHolder.my_coupon_limit=view.findViewById(R.id.my_coupon_limit);
            viewHolder.coupon_money=view.findViewById(R.id.coupon_money);
            viewHolder.my_coupon_state=view.findViewById(R.id.my_coupon_state);
            viewHolder.my_coupon_limit_use=view.findViewById(R.id.my_coupon_limit_use);
            viewHolder.my_coupon_limit_time=view.findViewById(R.id.my_coupon_limit_time);
            view.setTag(viewHolder);

        }
        else {
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.my_coupon_img.setBackgroundResource(list.get(i).my_coupon_img);
        viewHolder.my_coupon_money.setText(list.get(i).my_coupon_money);
        viewHolder.my_coupon_limit.setText(list.get(i).my_coupon_limit);
        viewHolder.coupon_money.setText(list.get(i).coupon_money);
        viewHolder.my_coupon_state.setText(list.get(i).my_coupon_state);
        viewHolder.my_coupon_limit_use.setText(list.get(i).my_coupon_limit_use);
        viewHolder.my_coupon_limit_time.setText(list.get(i).my_coupon_limit_time);
        return view;
    }
}

class ViewHolder {
    public ImageView my_coupon_img;
    public TextView my_coupon_money;
    public TextView my_coupon_limit;
    public TextView coupon_money;
    public TextView my_coupon_state;
    public TextView my_coupon_limit_use;
    public TextView my_coupon_limit_time;
}
