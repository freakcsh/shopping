package com.freak.shopping.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.freak.shopping.R;
import com.freak.shopping.bean.PhotoItemBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/6.
 */

public class PhotoGridViewAdapter extends BaseAdapter{
    private LayoutInflater pt_inflater;
    private ArrayList<PhotoItemBean> pt_list;
    public PhotoGridViewAdapter(Context context,ArrayList<PhotoItemBean> pt_list){
        this.pt_inflater=LayoutInflater.from(context);
        this.pt_list=pt_list;
    }
    @Override
    public int getCount() {
        return pt_list.size();
    }

    @Override
    public Object getItem(int i) {
        return pt_list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        PhotoViewHolder photoViewHolder;
        if (view==null){
            photoViewHolder=new PhotoViewHolder();
            view=pt_inflater.inflate(R.layout.homepage_item,null);
            photoViewHolder.pt_one=view.findViewById(R.id.pt_one);
            photoViewHolder.pt_two=view.findViewById(R.id.pt_two);
            photoViewHolder.pt_three=view.findViewById(R.id.pt_three);
            photoViewHolder.pt_four=view.findViewById(R.id.pt_four);
            photoViewHolder.pt_five=view.findViewById(R.id.pt_five);
            photoViewHolder.pt_six=view.findViewById(R.id.pt_six);
            photoViewHolder.pt_seven=view.findViewById(R.id.pt_seven);
            photoViewHolder.pt_eight=view.findViewById(R.id.pt_eight);
            view.setTag(photoViewHolder);

        }
        else {
            photoViewHolder= (PhotoViewHolder) view.getTag();
        }
        photoViewHolder.pt_one.setImageResource(pt_list.get(i).img_one);
        photoViewHolder.pt_two.setImageResource(pt_list.get(i).img_two);
        photoViewHolder.pt_three.setImageResource(pt_list.get(i).img_three);
        photoViewHolder.pt_four.setImageResource(pt_list.get(i).img_four);
        photoViewHolder.pt_five.setImageResource(pt_list.get(i).img_five);
        photoViewHolder.pt_six.setImageResource(pt_list.get(i).img_six);
        photoViewHolder.pt_seven.setImageResource(pt_list.get(i).img_seven);
        photoViewHolder.pt_eight.setImageResource(pt_list.get(i).img_eight);
        return view;
    }
    class PhotoViewHolder{
        private ImageView pt_one,pt_two,pt_three,pt_four,pt_five,pt_six,pt_seven,pt_eight;
    }
}
