package com.freak.shopping.custom;

import android.content.Context;


import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.freak.shopping.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by Administrator on 2017/7/30.
 */

public class carousel extends FrameLayout {
    private ViewPager carousel;
    //轮播图图片数量
    private final static int COUNT = 5;
    //自动轮播的时间间隔
    private final static int TIME = 5;
    //自动轮播启用开关
    private final static boolean isAutoPlay = true;
    //自定义轮播图的资源ID
    private int[] imgID;
    //放轮播图片的ImageView 的list
    private List<ImageView> imageViewsList;
    //放圆点的View的list
    private List<View> doViewList;
    //当前轮播页
    private int currentItem = 0;
    //定时任务
    private ScheduledExecutorService scheduledExecutorService;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            carousel.setCurrentItem(currentItem);
        }
    };

    public carousel(Context context) {
        this(context, null);
    }

    public carousel(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public carousel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData();
        initUI(context);
        if (isAutoPlay) {
            startPlay();
        }
    }

    /*
    开始图片轮播
     */
    private void startPlay() {
    }

    /*
    停止图片轮播
     */
    public void stopPlay() {

    }

    private void initUI(Context context) {
    }

    private void initData() {
        imgID = new int[]{
                R.drawable.do1,
                R.drawable.do2,
                R.drawable.do3,
                R.drawable.do4,
                R.drawable.do5
        };
        imageViewsList=new ArrayList<>();
        doViewList=new ArrayList<>();
    }


}
