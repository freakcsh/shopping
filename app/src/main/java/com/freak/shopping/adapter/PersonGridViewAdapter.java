package com.freak.shopping.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.freak.shopping.R;
import com.freak.shopping.bean.PersonGridViewItem;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/5.
 */

public class PersonGridViewAdapter extends BaseAdapter{
    private LayoutInflater per_inflater;
    private ArrayList<PersonGridViewItem> per_list;
  public   PersonGridViewAdapter(Context context,ArrayList<PersonGridViewItem> per_list){
      this.per_inflater=LayoutInflater.from(context);
      this.per_list=per_list;
  }
    @Override
    public int getCount() {
        return per_list.size();
    }

    @Override
    public Object getItem(int i) {
        return per_list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        PersonViewHolder personViewHolder;
        if (view==null){
            personViewHolder=new PersonViewHolder();
            view=per_inflater.inflate(R.layout.person_grid_view,null);
            personViewHolder.per_img=view.findViewById(R.id.per_img);
            view.setTag(personViewHolder);
        }
        else {
            personViewHolder= (PersonViewHolder) view.getTag();
        }
        personViewHolder.per_img.setImageResource(per_list.get(i).per_image);
        return view;
    }
    class PersonViewHolder{
        private ImageView per_img;
    }
}
