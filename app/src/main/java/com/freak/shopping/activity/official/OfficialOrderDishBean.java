package com.freak.shopping.activity.official;

/**
 * Created by Administrator on 2017/11/30.
 */

public class OfficialOrderDishBean {
    public int order_dish_img;
    public String order_dish_name;
    public String order_dish_more;
    public String order_dish_price;
    public String order_dish_price_yuan;
    public boolean jiaZt;

    public boolean isJiaZt() {
        return jiaZt;
    }

    public void setJiaZt(boolean jiaZt) {
        this.jiaZt = jiaZt;
    }
public OfficialOrderDishBean(){

}
    public OfficialOrderDishBean(int order_dish_img, String order_dish_name, String order_dish_more, String order_dish_price, String order_dish_price_yuan,boolean jiaZt) {
        this.order_dish_img = order_dish_img;
        this.order_dish_name = order_dish_name;
        this.order_dish_more = order_dish_more;
        this.order_dish_price = order_dish_price;
        this.order_dish_price_yuan = order_dish_price_yuan;
        this.jiaZt=jiaZt;
    }
}
