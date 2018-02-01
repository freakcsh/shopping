package com.freak.shopping.activity.official;

import android.content.Context;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.bumptech.glide.Glide;
import com.freak.shopping.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/11/30.
 */

public class OfficialOrderAdapter extends BaseAdapter implements View.OnClickListener {
    private Context context;
    private List<OfficialOrderDishBean> orderDishBeen;


    OfficialOrderDishBean bean = new OfficialOrderDishBean();
    ListView listView;


    public OfficialOrderAdapter(Context context, List<OfficialOrderDishBean> orderDishBeen, ListView listView) {
        this.context = context;
        this.orderDishBeen = orderDishBeen;
        this.listView = listView;
    }

    @Override
    public int getCount() {
        return orderDishBeen.size();
    }

    @Override
    public Object getItem(int i) {
        return orderDishBeen.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder orderViewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.official_order_dishes_item, null);
            orderViewHolder = new ViewHolder(view);
            view.setTag(orderViewHolder);
        } else {
            orderViewHolder = (ViewHolder) view.getTag();
        }
        Glide.with(context).load(orderDishBeen.get(i).order_dish_img).centerCrop().placeholder(R.mipmap.ic_launcher).into(orderViewHolder.officialOrderDishImg);
        orderViewHolder.officialOrderDishName.setText(orderDishBeen.get(i).order_dish_name);
        orderViewHolder.officialOrderDishMore.setText(orderDishBeen.get(i).order_dish_more);
        orderViewHolder.officialOrderDishPrice.setText(orderDishBeen.get(i).order_dish_price);
        orderViewHolder.officialOrderDishPriceYuan.setText(orderDishBeen.get(i).order_dish_price_yuan);
        orderViewHolder.officialOrderDishPriceYuan.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);//中间横线
//        orderViewHolder.officialOrderDishPriceYuan.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//下划线
//        orderViewHolder.officialOrderDishPriceYuan.getPaint().setAntiAlias(true);//抗锯齿
        return view;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.official_order_dish_jia:

                break;
            case R.id.official_order_dish_minus:
                break;
        }
    }

    static class ViewHolder {
        @BindView(R.id.official_order_dish_img)
        ImageView officialOrderDishImg;
        @BindView(R.id.official_order_dish_name)
        TextView officialOrderDishName;
        @BindView(R.id.official_order_dish_more)
        TextView officialOrderDishMore;
        @BindView(R.id.official_order_dish_price)
        TextView officialOrderDishPrice;
        @BindView(R.id.official_order_dish_price_yuan)
        TextView officialOrderDishPriceYuan;
        @BindView(R.id.official_order_dish_minus)
        ImageView officialOrderDishMinus;
        @BindView(R.id.official_order_dish_num)
        EditText officialOrderDishNum;
        @BindView(R.id.official_order_dish_jia)
        ImageView officialOrderDishJia;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
