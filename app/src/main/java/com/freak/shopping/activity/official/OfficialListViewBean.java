package com.freak.shopping.activity.official;

/**
 * Created by Administrator on 2017/11/23.
 */

public class OfficialListViewBean {
    public int img_small;
    public int img_big;
    public String activity_res;
    public String person_num;
    public String look_num;

    public OfficialListViewBean(int img_small, int img_big, String activity_res, String person_num, String look_num) {
        this.img_small = img_small;
        this.img_big = img_big;
        this.activity_res = activity_res;
        this.person_num = person_num;
        this.look_num = look_num;
    }
}
