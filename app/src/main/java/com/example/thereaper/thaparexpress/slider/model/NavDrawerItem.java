package com.example.thereaper.thaparexpress.slider.model;

/**
 * Created by thereaper on 17/1/15.
 */
public class NavDrawerItem {

    private int icon;
    private String title;
    private String count="0";
    private boolean isCounterVisible = false;

    public NavDrawerItem(){}

    public NavDrawerItem(String title, int icon){
        this.title = title;
        this.icon = icon;
    }

    public NavDrawerItem(String title, int icon, boolean isCounterVisible,String count){
        this.title = title;
        this.icon = icon;
        this.isCounterVisible = isCounterVisible;
        this.count= count;
    }

    public String getTitle(){
        return this.title;
    }

    public int getIcon(){
        return this.icon;
    }

    public String getCount() { return this.count; }

    public boolean getCounterVisibility(){
        return this.isCounterVisible;
    }

    public void setTitle(String title){
        this.title= title;
    }

    public void setIcon(int icon){
        this.icon= icon;
    }

    public void setCounterVisibility(boolean isCounterVisible){
        this.isCounterVisible= isCounterVisible;
    }
}
