package com.example.thereaper.thaparexpress.model;

/**
 * Created by Ayush Pahwa on 10/2/15.
 */
public class Socs {
    private String name,desc;

    public Socs(){
    }

    public Socs(String name,String desc){
        this.name = name;
        this.desc = desc;
    }

    public String getName(){
        return name;
    }

    public String getDesc(){
        return desc;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDesc(String desc){
        this.desc = desc;
    }
}
