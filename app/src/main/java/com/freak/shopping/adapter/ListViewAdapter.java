package com.freak.shopping.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.freak.shopping.R;
import com.freak.shopping.bean.ListItemBean;
import com.freak.shopping.custom.CircleImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Administrator on 2017/8/4.
 */

public class ListViewAdapter extends BaseAdapter {
    private ArrayList<ListItemBean> listItemBeen;
    private Context context;

    public ListViewAdapter(Context context, ArrayList<ListItemBean> listItemBeen) {
        this.context = context;
        this.listItemBeen = listItemBeen;
    }

    @Override
    public int getCount() {
        return listItemBeen.size();
    }

    @Override
    public Object getItem(int i) {
        return listItemBeen.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder listViewViewHolder;
        if (view == null) {

            view = LayoutInflater.from(context).inflate(R.layout.listview_item, null);
            listViewViewHolder = new ViewHolder(view);
            view.setTag(listViewViewHolder);
        } else {
            listViewViewHolder = (ViewHolder) view.getTag();
        }
        Glide.with(context).load(listItemBeen.get(i).listView_img).centerCrop().placeholder(R.mipmap.ic_launcher).into(listViewViewHolder.listViewImg);
        Glide.with(context).load(listItemBeen.get(i).listView_tou_x).centerCrop().placeholder(R.mipmap.ic_launcher).into(listViewViewHolder.listViewTouX);
        Glide.with(context).load(listItemBeen.get(i).listView_sj).centerCrop().placeholder(R.mipmap.ic_launcher).into(listViewViewHolder.listViewSj);
        Glide.with(context).load(listItemBeen.get(i).listView_sfz).centerCrop().placeholder(R.mipmap.ic_launcher).into(listViewViewHolder.listViewSfz);
        Glide.with(context).load(listItemBeen.get(i).listView_wx).centerCrop().placeholder(R.mipmap.ic_launcher).into(listViewViewHolder.listViewWx);
        Glide.with(context).load(listItemBeen.get(i).listView_sex).centerCrop().placeholder(R.mipmap.ic_launcher).into(listViewViewHolder.listViewSex);
        listViewViewHolder.listViewJuLi.setText(listItemBeen.get(i).listView_ju_li);
        listViewViewHolder.listViewFuWu.setText(listItemBeen.get(i).listView_fu_wu);
        listViewViewHolder.listViewPrice.setText(listItemBeen.get(i).listView_price);
        listViewViewHolder.listViewJieS.setText(listItemBeen.get(i).listView_jie_s);
        listViewViewHolder.listViewName.setText(listItemBeen.get(i).listView_name);
        listViewViewHolder.listViewAge.setText(listItemBeen.get(i).listView_age);
        listViewViewHolder.listViewXin.setText(listItemBeen.get(i).listView_xin);
        listViewViewHolder.listViewZan.setText(listItemBeen.get(i).listView_zan);
        return view;
    }

    static class ViewHolder {
        @BindView(R.id.listView_img)
        ImageView listViewImg;
        @BindView(R.id.listView_ju_li)
        TextView listViewJuLi;
        @BindView(R.id.r1)
        RelativeLayout r1;
        @BindView(R.id.left)
        TextView left;
        @BindView(R.id.listView_fu_wu)
        TextView listViewFuWu;
        @BindView(R.id.listView_price)
        TextView listViewPrice;
        @BindView(R.id.listView_jie_s)
        TextView listViewJieS;
        @BindView(R.id.rz)
        TextView rz;
        @BindView(R.id.listView_sj)
        ImageView listViewSj;
        @BindView(R.id.listView_sfz)
        ImageView listViewSfz;
        @BindView(R.id.listView_wx)
        ImageView listViewWx;
        @BindView(R.id.r2)
        RelativeLayout r2;
        @BindView(R.id.listView_tou_x)
        CircleImageView listViewTouX;
        @BindView(R.id.listView_name)
        TextView listViewName;
        @BindView(R.id.listView_sex)
        ImageView listViewSex;
        @BindView(R.id.listView_age)
        TextView listViewAge;
        @BindView(R.id.listView_xin)
        TextView listViewXin;
        @BindView(R.id.listView_zan)
        TextView listViewZan;
        @BindView(R.id.linearLayout)
        LinearLayout linearLayout;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
