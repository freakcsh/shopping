package com.freak.shopping.activity.demand;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.freak.shopping.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Administrator on 2017/11/27.
 */

public class DemandMeAllAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private Context context;
    private List<DemandMeAllBean> allBeen;
     DemandMeAllGirdViewAdapter meAllGirdViewAdapter;
    private List<DemandMeAllGirdViewBean> gird_list;

    public DemandMeAllAdapter(Context context, List<DemandMeAllBean> allBeen, List<DemandMeAllGirdViewBean> gird_list) {
        this.context = context;
        this.allBeen = allBeen;
        this.gird_list = gird_list;
    }

    private int first_res[] = {R.drawable.tx, R.drawable.tx, R.drawable.timg4, R.drawable.tx, R.drawable.timg4, R.drawable.tx, R.drawable.timg4, R.drawable.tx, R.drawable.timg4, R.drawable.tx, R.drawable.timg4
            , R.drawable.tx, R.drawable.timg4, R.drawable.tx, R.drawable.timg4, R.drawable.tx, R.drawable.timg4, R.drawable.tx, R.drawable.timg4, R.drawable.tx};

    public DemandMeAllAdapter(Context context, List<DemandMeAllBean> allBeen) {
        this.context = context;
        this.allBeen = allBeen;
    }

    @Override
    public int getCount() {
        return allBeen.size();
    }

    @Override
    public Object getItem(int i) {
        return allBeen.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder demand_all_holder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.demand_item, null);
            demand_all_holder = new ViewHolder(view);
            view.setTag(demand_all_holder);
        } else {
            demand_all_holder = (ViewHolder) view.getTag();
        }
//        demand_all_holder.demandAllImg.setImageResource(allBeen.get(i).demand_me_all_img);
        Glide.with(context).load(allBeen.get(i).demand_me_all_img).centerCrop().placeholder(R.mipmap.ic_launcher).into(demand_all_holder.demandAllImg);
        demand_all_holder.demandAllName.setText(allBeen.get(i).demand_me_all_name);
        demand_all_holder.demandAllZt.setText(allBeen.get(i).demand_me_all_zt);
        demand_all_holder.demandAllYyNum.setText(allBeen.get(i).demand_me_all_yy_num);
//        demand_all_holder.demandAllGirdView.setAdapter(allBeen.get(i).demand_me_all_gird_view);
//        gird_list = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            gird_list.add(new DemandMeAllGirdViewBean(
//                    first_res[i]
//            ));
//        }

        return view;
    }



     class ViewHolder {
        @BindView(R.id.demand_all_img)
        CircleImageView demandAllImg;
        @BindView(R.id.demand_all_name)
        TextView demandAllName;
        @BindView(R.id.demand_all_zt)
        TextView demandAllZt;
        @BindView(R.id.demand_all_yy_num)
        TextView demandAllYyNum;
        @BindView(R.id.demand_all_gird_view)
        NoScrollGridView demandAllGirdView;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
            meAllGirdViewAdapter = new DemandMeAllGirdViewAdapter(context, gird_list);
            demandAllGirdView.setAdapter(meAllGirdViewAdapter);
        }
    }


}
