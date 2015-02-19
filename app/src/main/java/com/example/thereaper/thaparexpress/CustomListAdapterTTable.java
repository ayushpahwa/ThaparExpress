package com.example.thereaper.thaparexpress;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.thereaper.thaparexpress.model.Socs;
import com.example.thereaper.thaparexpress.model.Table;

import java.util.List;

/**
 *Completed on 18/02/2015 by Ayush Pahwa
 */
public class CustomListAdapterTTable extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<Table> tableItems;

    public CustomListAdapterTTable(Activity activity, List<Table> socItems){
        this.activity = activity;
        this.tableItems = socItems;
    }

    @Override
    public int getCount() {
        return tableItems.size();
    }

    @Override
    public Object getItem(int position) {
        return tableItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (inflater==null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView==null)
            convertView = inflater.inflate(R.layout.list_row_table,null);

        TextView classL = (TextView) convertView.findViewById(R.id.tableClass);
        TextView roomL = (TextView) convertView.findViewById(R.id.tableRoom);
        TextView teacherL = (TextView) convertView.findViewById(R.id.tableTeacher);

        Table table = tableItems.get(position);

        classL.setText(table.getTClass());
        roomL.setText(table.getTRoom());
        teacherL.setText(table.getTTeacher());

        return convertView;
    }


}
