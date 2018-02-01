package com.freak.shopping.activity.official;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.freak.shopping.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/11/23.
 */

public class OfficialListViewAdapter extends BaseAdapter implements View.OnClickListener {
    private Context context;
    private List<OfficialListViewBean> listViewBeen;

    public OfficialListViewAdapter(Context context, List<OfficialListViewBean> listViewBeen) {
        this.context = context;
        this.listViewBeen = listViewBeen;
    }

    @Override
    public int getCount() {
        return listViewBeen.size();
    }

    @Override
    public Object getItem(int i) {
        return listViewBeen.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder officialViewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.official_list_item, null);
            officialViewHolder = new ViewHolder(view);
            view.setTag(officialViewHolder);
        } else {
            officialViewHolder = (ViewHolder) view.getTag();
        }
//        Glide.with(context).load(listViewBeen.get(i).img_small).centerCrop().placeholder(R.mipmap.ic_launcher).into(officialViewHolder.officialImgSmall);
//        Glide.with(context).load(listViewBeen.get(i).img_big).centerCrop().placeholder(R.mipmap.ic_launcher).into(officialViewHolder.officialImgBig);
        officialViewHolder.officialImgSmall.setBackgroundResource(listViewBeen.get(i).img_small);
        officialViewHolder.officialImgBig.setBackgroundResource(listViewBeen.get(i).img_big);
        officialViewHolder.officialActivity.setText(listViewBeen.get(i).activity_res);
        officialViewHolder.officialPersonNum.setText(listViewBeen.get(i).person_num);
        officialViewHolder.officialLookNum.setText(listViewBeen.get(i).look_num);
        officialViewHolder.officialOrder.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
//        Intent intent=new Intent();
//        intent.setClass()
        Toast.makeText(context, "点击点菜按钮", Toast.LENGTH_LONG).show();
    }

    static class ViewHolder {
        @BindView(R.id.official_img_big)
        ImageView officialImgBig;
        @BindView(R.id.official_img_small)
        ImageView officialImgSmall;
        @BindView(R.id.official_activity)
        TextView officialActivity;
        @BindView(R.id.official_person_num)
        TextView officialPersonNum;
        @BindView(R.id.official_look_num)
        TextView officialLookNum;
        @BindView(R.id.official_order)
        TextView officialOrder;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
