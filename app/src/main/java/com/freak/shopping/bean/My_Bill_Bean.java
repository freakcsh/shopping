package com.freak.shopping.bean;

/**
 * Created by Administrator on 2017/10/23.
 */

public class My_Bill_Bean {
    public String bill_type;
    public String bill_time;
    public String bill_older_num;
    public String bill_money;

    public My_Bill_Bean(String bill_type, String bill_time, String bill_older_num, String bill_money) {
        this.bill_type = bill_type;
        this.bill_time = bill_time;
        this.bill_older_num = bill_older_num;
        this.bill_money = bill_money;
    }
}
