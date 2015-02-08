package com.example.thereaper.thaparexpress;


import android.app.Application;

/**
 * Created by Ayush Pahwa on 17/1/15.
 */
public class Global extends Application {

    int roll_No= 0;
    String group,name,year,branch;



    public String getYear()

    {
        if (roll_No > 101400000 && roll_No < 101500000) {
            year = "first";
        }
        else if (roll_No >101300000){
            year = "second";
        }
        else if (roll_No>101200000){
            year = "third";
        }
        else if (roll_No > 101100000){
            year = "fourth";
        }
        else {
            year = "Invalid roll number input";
        }

        return year;
    }


    // TODO: Cross check the roll numbers with database to retrieve the name.
    public String getName(){

        name = "XYZ";
        return name;
    }

    // TODO: Write a solution to retrieve the branches from the roll numbers.
    public String getBranch(){

        branch="Engineering";
        return branch;
    }

    public String getGroup(){
        return this.group;
    }

    public int getRoll_No(){
        return this.roll_No;
    }

    public void setGroup(String group){
        this.group=group;
    }

    public void setRoll_No(int roll_no){
        this.roll_No=roll_no;
    }

}
