package com.freak.shopping.bean;

/**
 * Created by Administrator on 2017/11/10.
 */

public class My_Collect_Bean {
    public int collect_img;
    public String collect_name;
    public String collect_time;
    public int collect_img_da;
    public String collect_server;
    public String collect_introduce;

    public My_Collect_Bean(int collect_img, String collect_name, String collect_time, int collect_img_da, String collect_server, String collect_introduce) {
        this.collect_img = collect_img;
        this.collect_name = collect_name;
        this.collect_time = collect_time;
        this.collect_img_da = collect_img_da;
        this.collect_server = collect_server;
        this.collect_introduce = collect_introduce;
    }
}
