package com.freak.shopping.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.freak.shopping.R;

/**
 * Created by Administrator on 2017/8/5.
 */

public class ShareActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share_to_friend);
    }
}
