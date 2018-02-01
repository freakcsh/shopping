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
import com.freak.shopping.bean.My_photo_bean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Administrator on 2017/10/24.
 */

public class My_photo_Adapter extends BaseAdapter {
    private ArrayList<My_photo_bean> list;
    private Context context;

    public My_photo_Adapter(Context context, ArrayList<My_photo_bean> list) {
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
        ViewHolder photoViewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.photo_list_item, null);
            photoViewHolder = new ViewHolder(view);
            view.setTag(photoViewHolder);
        } else {
            photoViewHolder = (ViewHolder) view.getTag();
        }
        Glide.with(context).load(list.get(i).one).centerCrop().placeholder(R.mipmap.ic_launcher).into(photoViewHolder.ptListOne);
        Glide.with(context).load(list.get(i).five).centerCrop().placeholder(R.mipmap.ic_launcher).into(photoViewHolder.ptListFive);
        Glide.with(context).load(list.get(i).six).centerCrop().placeholder(R.mipmap.ic_launcher).into(photoViewHolder.ptListSix);
        Glide.with(context).load(list.get(i).seven).centerCrop().placeholder(R.mipmap.ic_launcher).into(photoViewHolder.ptListSeven);
        photoViewHolder.ptListTwo.setText(list.get(i).two);
        photoViewHolder.ptListThree.setText(list.get(i).three);
        photoViewHolder.ptListFour.setText(list.get(i).four);
        return view;
    }


    static class ViewHolder {
        @BindView(R.id.pt_list_one)
        CircleImageView ptListOne;
        @BindView(R.id.pt_list_two)
        TextView ptListTwo;
        @BindView(R.id.pt_list_three)
        TextView ptListThree;
        @BindView(R.id.pt_list_four)
        TextView ptListFour;
        @BindView(R.id.pt_list_five)
        ImageView ptListFive;
        @BindView(R.id.pt_list_six)
        ImageView ptListSix;
        @BindView(R.id.pt_list_seven)
        ImageView ptListSeven;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}