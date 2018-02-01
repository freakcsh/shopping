package com.freak.shopping.bean;

/**
 * Created by Administrator on 2017/10/22.
 */

public class My_Coupon_Bean {
    public int my_coupon_img;
    public  String my_coupon_money;
    public String my_coupon_limit;
    public String coupon_money;
    public String my_coupon_state;
    public String my_coupon_limit_use;
    public String my_coupon_limit_time;

    public My_Coupon_Bean(int my_coupon_img, String my_coupon_money, String my_coupon_limit, String coupon_money, String my_coupon_state, String my_coupon_limit_use, String my_coupon_limit_time) {
        this.my_coupon_img = my_coupon_img;
        this.my_coupon_money = my_coupon_money;
        this.my_coupon_limit = my_coupon_limit;
        this.coupon_money = coupon_money;
        this.my_coupon_state = my_coupon_state;
        this.my_coupon_limit_use = my_coupon_limit_use;
        this.my_coupon_limit_time = my_coupon_limit_time;
    }
}
