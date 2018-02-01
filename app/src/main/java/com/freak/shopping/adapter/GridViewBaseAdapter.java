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
import com.freak.shopping.bean.GridItemBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/2.
 */

public class GridViewBaseAdapter extends BaseAdapter {
    private ArrayList<GridItemBean> list;
    private Context context;

    public GridViewBaseAdapter(Context context, ArrayList<GridItemBean> list) {
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
        //创建viewHolder类的对象
        ViewHolder viewHolder;
        if (view == null) {

            //绑定GridView的布局
            view = LayoutInflater.from(context).inflate(R.layout.grid_view_item, null);
            viewHolder = new ViewHolder(view);
            /*
            设置与此视图关联的标签。标签可用于标记其层次结构中的视图，
            并且不必在层次结构中是唯一的。标签也可以用于在视图中存储数据而不使用其他数据结构。
             */
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        //设置GridView的图片文件
//        viewHolder.imageView.setImageResource(list.get(i).itemImg);
        Glide.with(context).load(list.get(i).itemImg).centerCrop().placeholder(R.mipmap.ic_launcher).into(viewHolder.gridViewItemChat);
        //设置GridView的名字
        viewHolder.gridViewItemName.setText(list.get(i).itemName);
        return view;
    }


    class ViewHolder {
        @BindView(R.id.grid_view_item_chat)
        ImageView gridViewItemChat;
        @BindView(R.id.grid_view_item_name)
        TextView gridViewItemName;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
