package com.example.thereaper.thaparexpress.option;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.thereaper.thaparexpress.CustomListAdapter;
import com.example.thereaper.thaparexpress.CustomListAdapterTTable;
import com.example.thereaper.thaparexpress.Main;
import com.example.thereaper.thaparexpress.R;
import com.example.thereaper.thaparexpress.menu.Bug;
import com.example.thereaper.thaparexpress.menu.Details;
import com.example.thereaper.thaparexpress.menu.FeedBack;
import com.example.thereaper.thaparexpress.model.Table;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by thereaper on 17/1/15.
 */
public class TimeTable extends Activity {

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String[] mActivityTitles;
    private List<Table> tableList = new ArrayList<Table>();
    private ListView listView;
    private CustomListAdapterTTable adapterTTable;

    Calendar c = Calendar.getInstance();
    int day = c.get(Calendar.DAY_OF_WEEK);
    int timeHour = c.get(Calendar.HOUR);
    int timeMinutes = c.get(Calendar.MINUTE);
    String dayS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ttable);

        mTitle = mDrawerTitle = getTitle();
        mActivityTitles = getResources().getStringArray(R.array.navDrawer);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_ttable);
        mDrawerList = (ListView) findViewById(R.id.left_drawer_ttable);
        listView = (ListView) findViewById(R.id.lvTTable);
        adapterTTable = new CustomListAdapterTTable(this,tableList);
        listView.setAdapter(adapterTTable);

        switch (day){
            case 1:
                dayS="Sunday";
                break;
            case 2:
                dayS="Monday";
                break;
            case 3:
                dayS="Tuesday";
                break;
            case 4:
                dayS="Wednesday";
                break;
            case 5:
                dayS="Thursday";
                break;
            case 6:
                dayS="Friday";
                break;
            case 7:
                dayS="Saturday";
                break;
        }

        for (int i=0;i<15;i++){
            Table table = new Table();
            table.setTClass(""+dayS);
            table.setTRoom(""+timeHour+timeMinutes);
            table.setTTeacher(""+day);

            tableList.add(table);
        }

        adapterTTable.notifyDataSetChanged();


        // set up the drawer's list view with items and click listener
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mActivityTitles));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        // enable ActionBar app icon to behave as action to toggle nav drawer
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        // ActionBarDrawerToggle ties together the the proper interactions
        // between the sliding drawer and the action bar app icon
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                R.drawable.ic_drawer,  /* nav drawer image to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description for accessibility */
                R.string.drawer_close  /* "close drawer" description for accessibility */
        ) {
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        menu.findItem(R.id.details).setVisible(!drawerOpen);
        menu.findItem(R.id.Feedback).setVisible(!drawerOpen);
        menu.findItem(R.id.Bug).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        Intent i;
        // Handle action buttons
        switch(item.getItemId()) {
            case R.id.details:
                i=new Intent(this,Details.class);
                startActivity(i);
                return true;
            case R.id.Feedback:
                i=new Intent(this,FeedBack.class);
                startActivity(i);
                return true;
            case R.id.Bug:
                i = new Intent(this,Bug.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {
        // update the main content by replacing option
        Intent i = null;
        switch (position){
            case 0:
                i = new Intent(this, Main.class);
                break;
            case 1:
                i=new Intent(this, Societies.class);
                break;
            case 2:
                i=new Intent(this, Event.class);
                break;
            case 3:
                i=new Intent(this, ThaparLogs.class);
                break;
            case 4:
                i=new Intent(this, TimeTable.class);
                break;
            case 5:
                i=new Intent(this, Contribute.class);
                break;
            default:

                break;
        }


        startActivity(i);
        mDrawerLayout.closeDrawer(mDrawerList);
        finish();
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
}
