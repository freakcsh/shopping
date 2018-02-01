package com.freak.shopping.bean;



/**
 * Created by Administrator on 2017/8/4.
 */

public class ListItemBean {
    public int listView_img, listView_sj, listView_sfz, listView_wx, listView_sex;
    public String listView_ju_li, listView_fu_wu, listView_price, listView_jie_s, listView_name, listView_age, listView_xin, listView_zan;
    public int listView_tou_x;

    public ListItemBean(int listView_img, int listView_tou_x, int listView_sj, int listView_sfz, int listView_wx, int listView_sex,
                        String listView_ju_li, String listView_fu_wu, String listView_price, String listView_jie_s,
                        String listView_name, String listView_age, String listView_xin, String listView_zan) {
        this.listView_img = listView_img;
        this.listView_tou_x = listView_tou_x;
        this.listView_sj = listView_sj;
        this.listView_sfz = listView_sfz;
        this.listView_wx = listView_wx;
        this.listView_sex = listView_sex;
        this.listView_ju_li = listView_ju_li;
        this.listView_fu_wu = listView_fu_wu;
        this.listView_price = listView_price;
        this.listView_jie_s = listView_jie_s;
        this.listView_name = listView_name;
        this.listView_age = listView_age;
        this.listView_xin = listView_xin;
        this.listView_zan = listView_zan;
    }
}
