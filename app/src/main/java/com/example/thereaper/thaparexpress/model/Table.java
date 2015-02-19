package com.example.thereaper.thaparexpress.model;

/**
 * Completed on 18/2/2015 by Ayush Pahwa
 */
public class Table {

    private String tclass,troom,tteacher;

    public Table(){
    }

    public Table(String tclass,String troom,String tteacher){
        this.tclass = tclass;
        this.troom = troom;
        this.tteacher = tteacher;
    }

    public String getTClass(){
        return tclass;
    }

    public String getTRoom(){
        return troom;
    }

    public String getTTeacher() {
        return tteacher;
    }

    public void setTClass(String tclass){
        this.tclass = tclass;
    }

    public void setTRoom(String troom){
        this.troom = troom;
    }

    public void setTTeacher(String tteacher){
        this.tteacher = tteacher;
    }
}
