package com.freak.shopping.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import com.freak.shopping.R;
import com.freak.shopping.adapter.PersonGridViewAdapter;
import com.freak.shopping.adapter.PhotoGridViewAdapter;
import com.freak.shopping.bean.PersonGridViewItem;
import com.freak.shopping.bean.PhotoItemBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/5.
 */

public class PersonInformationActivity extends Activity implements View.OnClickListener {
    private GridView per_grid_view, pt_grid_view;
    private TextView share;
    int per_res[] = {R.drawable.tx, R.drawable.tx1, R.drawable.tx11, R.drawable.timg,};
    private ArrayList<PersonGridViewItem> per_list;
    private ArrayList<PhotoItemBean> pt_list;
    private int pt_res[] = { R.drawable.timg4};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.persona_information);
        per_grid_view = findViewById(R.id.person_grid_view);
        pt_grid_view = findViewById(R.id.pt_grid_view);
        share = findViewById(R.id.share);
        share.setOnClickListener(this);
        getItem();
        getPhoto();
    }

    public void getItem() {
        per_list = new ArrayList<>();
        for (int i = 0; i < per_res.length; i++) {
            per_list.add(new PersonGridViewItem(per_res[i]));
        }
        PersonGridViewAdapter per_adapter = new PersonGridViewAdapter(PersonInformationActivity.this, per_list);
        per_grid_view.setAdapter(per_adapter);
    }

    @Override
    public void onClick(View view) {
//        Intent share_intent = new Intent();
//        share_intent.setClass(PersonInformationActivity.this, ShareActivity.class);
//        startActivity(share_intent);
//        AlertDialog.Builder builder=new AlertDialog.Builder();
    }

    public void getPhoto() {
        pt_list = new ArrayList<>();
        for (int i=0;i<pt_res.length;i++){
             pt_list.add(new PhotoItemBean(
                     pt_res[i],
                     pt_res[i],
                     pt_res[i],
                     pt_res[i],
                     pt_res[i],
                     pt_res[i],
                     pt_res[i],
                     pt_res[i]
             ));
        }
        PhotoGridViewAdapter pt_adapter=new PhotoGridViewAdapter(PersonInformationActivity.this,pt_list);
        pt_grid_view.setAdapter(pt_adapter);
    }
}
