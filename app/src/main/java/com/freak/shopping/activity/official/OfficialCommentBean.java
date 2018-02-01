package com.freak.shopping.activity.official;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2017/12/1.
 */

public class OfficialCommentBean {
    public int comment_img;



    public String comment_name;

    public void setComment_time(String comment_time) {
        this.comment_time = comment_time;
    }

    public String getComment_time() {
        return comment_time;
    }

    public String comment_time;
    public String comment_edt;

    public int getComment_img() {
        return comment_img;
    }

    public String getComment_name() {
        return comment_name;
    }



    public String getComment_edt() {
        return comment_edt;
    }

    public void setComment_img(int comment_img) {
        this.comment_img = comment_img;
    }

    public void setComment_name(String comment_name) {
        this.comment_name = comment_name;
    }



    public void setComment_edt(String comment_edt) {
        this.comment_edt = comment_edt;
    }
public OfficialCommentBean(){

}
    public OfficialCommentBean(int comment_img, String comment_name, String comment_time, String comment_edt) {
        this.comment_img = comment_img;
        this.comment_name = comment_name;
        this.comment_time = comment_time;
        this.comment_edt = comment_edt;
    }
}
