package com.example.thereaper.thaparexpress;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

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

public class Department extends Fragment {

    public Department(){}

    private String TAG = Department.class.getSimpleName();
    private static final String url = "http://api.androidhive.info/json/movies.json";
    private List<Socs> socList = new ArrayList<>();
    private ListView listView;
    private CustomListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dept,container,false);

        listView = (ListView) rootView.findViewById(R.id.lvDept);
        adapter = new CustomListAdapter(Department.this.getActivity(),socList);
        listView.setAdapter(adapter);
        JsonArrayRequest socRequest = new JsonArrayRequest(url,new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i=0;i<response.length() ; i++){
                    try {
                        JSONObject obj = response.getJSONObject(i);
                        Socs socs = new Socs();
                        socs.setDesc(obj.getString("title"));
                        socs.setName(obj.getString("title"));

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

        AppController.getInstance().addToRequestQueue(socRequest);


        return rootView;
    }

}
