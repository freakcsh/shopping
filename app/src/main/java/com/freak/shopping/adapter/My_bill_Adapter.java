package com.freak.shopping.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.freak.shopping.R;
import com.freak.shopping.bean.My_Bill_Bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/10/23.
 */

public class My_bill_Adapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private ArrayList<My_Bill_Bean> list;

    public My_bill_Adapter(Context context, ArrayList<My_Bill_Bean> list) {
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
        BillViewHolder billViewHolder;
        if (view==null){
            billViewHolder=new BillViewHolder();
            view=mInflater.inflate(R.layout.my_bill_item,null);
            billViewHolder.bill_type=view.findViewById(R.id.bill_type);
            billViewHolder.bill_time=view.findViewById(R.id.bill_time);
            billViewHolder.bill_older_num=view.findViewById(R.id.bill_older_num);
            billViewHolder.bill_money=view.findViewById(R.id.bill_money);
            view.setTag(billViewHolder);
        }
        else {
            billViewHolder= (BillViewHolder) view.getTag();
        }
        billViewHolder.bill_type.setText(list.get(i).bill_type);
        billViewHolder.bill_time.setText(list.get(i).bill_time);
        billViewHolder.bill_older_num.setText(list.get(i).bill_older_num);
        billViewHolder.bill_money.setText(list.get(i).bill_money);
        return view;
    }
}

class BillViewHolder {
    public TextView bill_type,bill_time,bill_older_num,bill_money;

}
