package com.freak.shopping.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.freak.shopping.R;
import com.freak.shopping.activity.MyHomePageActivity;
import com.freak.shopping.activity.My_Alter_information_Activity;
import com.freak.shopping.activity.My_CQC_Activity;
import com.freak.shopping.activity.My_Collect_Activity;
import com.freak.shopping.activity.My_Photo_Activity;
import com.freak.shopping.activity.My_Setting_Activity;
import com.freak.shopping.activity.My_account_Activity;
import com.freak.shopping.activity.My_skill_activity;
import com.freak.shopping.custom.CircleImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/7/29.
 */

public class MeFragment extends Fragment {
    @BindView(R.id.me_massage)
    TextView meMassage;
    @BindView(R.id.me_imageView)
    CircleImageView meImageView;
    @BindView(R.id.me_name)
    TextView meName;
    @BindView(R.id.me_account)
    ImageView meAccount;
    @BindView(R.id.me_photo)
    ImageView mePhoto;
    @BindView(R.id.me_collect)
    ImageView meCollect;
    @BindView(R.id.me_homepage)
    ImageView meHomepage;
    @BindView(R.id.me_authentication)
    TextView meAuthentication;
    @BindView(R.id.me_skill)
    TextView meSkill;
    @BindView(R.id.me_alter_information)
    TextView meAlterInformation;
    @BindView(R.id.me_share)
    TextView meShare;
    @BindView(R.id.me_notebook)
    TextView meNotebook;
    @BindView(R.id.me_setting)
    TextView meSetting;
    @BindView(R.id.my_cqc)
    LinearLayout myCqc;
    @BindView(R.id.my_skill)
    LinearLayout mySkill;
    @BindView(R.id.my_order)
    LinearLayout myOrder;
    @BindView(R.id.my_alter_information)
    LinearLayout myAlterInformation;
    @BindView(R.id.my_share)
    LinearLayout myShare;
    @BindView(R.id.my_notebook)
    LinearLayout myNotebook;
    @BindView(R.id.my_setting)
    LinearLayout mySetting;
    private Unbinder unbinder;
    private Intent intent = new Intent();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View me = inflater.inflate(R.layout.my_fragment, container, false);
        unbinder = ButterKnife.bind(this, me);
        return me;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.me_massage, R.id.me_imageView, R.id.me_name, R.id.me_account, R.id.me_photo, R.id.me_collect, R.id.me_homepage, R.id.my_cqc, R.id.my_skill,R.id.my_order, R.id.my_alter_information, R.id.my_share, R.id.my_notebook, R.id.my_setting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.me_massage:
                break;
            case R.id.me_imageView:
                break;
            case R.id.me_name:
                break;
            case R.id.me_account:
                intent.setClass(getActivity(), My_account_Activity.class);
                startActivity(intent);
                break;
            case R.id.me_photo:
                intent.setClass(getActivity(), My_Photo_Activity.class);
                startActivity(intent);
                break;
            case R.id.me_collect:
                intent.setClass(getActivity(), My_Collect_Activity.class);
                startActivity(intent);
                break;
            case R.id.me_homepage:
                intent.setClass(getActivity(), MyHomePageActivity.class);
                startActivity(intent);
                break;
            case R.id.my_cqc:
                intent.setClass(getActivity(), My_CQC_Activity.class);
                startActivity(intent);
                break;
            case R.id.my_skill:
                intent.setClass(getActivity(), My_skill_activity.class);
                startActivity(intent);
                break;
            case R.id.my_order:
                Toast.makeText(getActivity(),"我的订单",Toast.LENGTH_LONG).show();
                break;
            case R.id.my_alter_information:
                intent.setClass(getActivity(), My_Alter_information_Activity.class);
                startActivity(intent);
                break;
            case R.id.my_share:
                Toast.makeText(getActivity(),"分享",Toast.LENGTH_LONG).show();
                break;
            case R.id.my_notebook:
                Toast.makeText(getActivity(),"使用手册",Toast.LENGTH_LONG).show();
                break;
            case R.id.my_setting:
                intent.setClass(getActivity(), My_Setting_Activity.class);
                startActivity(intent);
                break;
        }
    }
}
