package com.freak.shopping.activity.official;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.freak.shopping.R;
import com.freak.shopping.custom.CircleImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/12/1.
 */

public class OfficialCommentAdapter extends BaseAdapter {
    private Context context;
    private List<OfficialCommentBean> beanList;

    public OfficialCommentAdapter(Context context, List<OfficialCommentBean> beanList) {
        this.context = context;
        this.beanList = beanList;
    }

    @Override
    public int getCount() {
        return beanList.size();
    }

    @Override
    public Object getItem(int i) {
        return beanList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.official_comment_item, null);
            viewHolder=new ViewHolder(view);
            view.setTag(viewHolder);
        }
        else {
            viewHolder= (ViewHolder) view.getTag();
        }
        Glide.with(context).load(beanList.get(i).comment_img).centerCrop().placeholder(R.mipmap.ic_launcher).into(viewHolder.officialCommentImg);
        viewHolder.officialCommentName.setText(beanList.get(i).comment_name);
        viewHolder.officialCommentTime.setText(beanList.get(i).comment_time);
        viewHolder.officialCommentEdt.setText(beanList.get(i).comment_edt);
        return view;
    }

    static class ViewHolder {
        @BindView(R.id.official_comment_img)
        CircleImageView officialCommentImg;
        @BindView(R.id.official_comment_name)
        TextView officialCommentName;
        @BindView(R.id.official_comment_time)
        TextView officialCommentTime;
        @BindView(R.id.official_comment_edt)
        TextView officialCommentEdt;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
