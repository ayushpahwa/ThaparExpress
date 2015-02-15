package com.example.thereaper.thaparexpress;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.thereaper.thaparexpress.model.Socs;

import java.util.List;

/**
 * Created by thereaper on 10/2/15.
 */
public class CustomListAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<Socs> socItems;

    public CustomListAdapter(Activity activity, List<Socs> socItems){
        this.activity = activity;
        this.socItems = socItems;
    }

    @Override
    public int getCount() {
        return socItems.size();
    }

    @Override
    public Object getItem(int position) {
        return socItems.get(position);
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
            convertView = inflater.inflate(R.layout.list_row,null);

        TextView nameL = (TextView) convertView.findViewById(R.id.socName);
        TextView descL = (TextView) convertView.findViewById(R.id.socDesc);

        Socs socs = socItems.get(position);

        nameL.setText(socs.getName());
        descL.setText(socs.getDesc());

        return convertView;
    }
}
