package com.example.thereaper.thaparexpress;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.thereaper.thaparexpress.model.Socs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Technical extends Fragment {

    public Technical(){}

    private String TAG = Department.class.getSimpleName();
    private static final String url = "http://api.androidhive.info/json/movies.json";
    private List<Socs> socList = new ArrayList<>();
    private ListView listView;
    private CustomListAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tech,container,false);

        listView = (ListView) rootView.findViewById(R.id.lvTech);
        adapter = new CustomListAdapter(this.getActivity(),socList);
        listView.setAdapter(adapter);

        JsonArrayRequest socRequest = new JsonArrayRequest(url,new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i=0;i<response.length() ; i++){
                    try {
                        JSONObject obj = response.getJSONObject(i);
                        Socs socs = new Socs();
                        socs.setDesc(obj.getString("rating"));
                        socs.setName(obj.getString("rating"));

                        socList.add(socs);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter.notifyDataSetChanged();
            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("ERROR" + error.getMessage());
            }
        });
        try {
            AppController.getInstance().addToRequestQueue(socRequest);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


        return rootView;

    }
}
