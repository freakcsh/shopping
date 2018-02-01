package com.freak.shopping.activity.LoginBean;


import cn.bmob.v3.BmobUser;

/**
 * Created by Administrator on 2017/11/21.
 */

public class User extends BmobUser {
private String age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
