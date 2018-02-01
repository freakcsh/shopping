package com.freak.shopping.activity.demand;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.freak.shopping.R;

/**
 * Created by Administrator on 2017/11/23.
 */

public class DemandMeNoFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View me_no=inflater.inflate(R.layout.demand_me_no_list,container,false);

        return me_no;
    }
}
