package com.example.thereaper.thaparexpress;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 *Completed on 18/02/2015 by Ayush Pahwa
 */
public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new Department();
                break;
            case 1:
                fragment  = new Technical();
                break;
            case 2:
                fragment = new Cultural();
                break;
            case 3:
                fragment = new StudentChapters();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = new String();
        switch (position){
            case 0:
                title="Department";
                break;
            case 1:
                title="Technical";
                break;
            case 2:
                title="Cultural";
                break;
            case 3:
                title="Student Chapters";
                break;
            default:
                title=null;
                break;
        }
        return title;
    }
}

