package com.freak.shopping.activity.demand;

/**
 * Created by Administrator on 2017/11/23.
 */

public class DemandTaDaiBean {
    public int ta_img;
    public String ta_name;
    public String ta_age_sex;
    public String ta_distance;
    public String ta_server;
    public int ta_sj;
    public int ta_sfz;
    public int ta_wx;

    public DemandTaDaiBean(int ta_img, String ta_name, String ta_age_sex, String ta_distance, String ta_server, int ta_sj, int ta_sfz, int ta_wx) {
        this.ta_img = ta_img;
        this.ta_name = ta_name;
        this.ta_age_sex = ta_age_sex;
        this.ta_distance = ta_distance;
        this.ta_server = ta_server;
        this.ta_sj = ta_sj;
        this.ta_sfz = ta_sfz;
        this.ta_wx = ta_wx;
    }
}
