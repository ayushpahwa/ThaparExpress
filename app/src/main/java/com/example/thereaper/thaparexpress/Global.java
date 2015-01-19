package com.example.thereaper.thaparexpress;


import android.app.Application;

/**
 * Created by thereaper on 17/1/15.
 */
public class Global extends Application {

    int roll_No= 0;
    String group;

    public String getGroup(){
        return this.group;
    }

    public int getRoll_No(){
        return this.roll_No;
    }

    public void setGroup(String Group){
        this.group=group;
    }

    public void setRoll_No(int roll_no){
        this.roll_No=roll_no;
    }

}
