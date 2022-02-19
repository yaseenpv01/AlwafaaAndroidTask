package com.example.alwafaataskandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AddressListView extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter rcvAdapter;
    private ArrayList arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_list_view);

        recyclerView=findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        rcvAdapter=new RcvAdapter(getApplicationContext(),arrayList);
        recyclerView.setAdapter(rcvAdapter);

        fetchData();

    }

    private void fetchData() {

        String urlfetch="https://demo.softwarecompany.ae/winsa/Services/get_address";

        RequestQueue requestQueue= Volley.newRequestQueue(this);

        StringRequest stringRequest=new StringRequest(Request.Method.POST, urlfetch, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                arrayList.clear();

                try {
                    JSONObject jsonObject=new JSONObject(response);
                    if (jsonObject.getString("response").equals("success")){
                        JSONArray jsonArray=jsonObject.getJSONArray("data");
                        for (int i=0;i<jsonArray.length();i++){
                            JSONObject jo=jsonArray.getJSONObject(i);
                            String city=jo.getString("city_name");
                            String area=jo.getString("area");
                            String buildingname=jo.getString("building_name");
                            String streetname=jo.getString("street_name");
                            String nearbylandmark=jo.getString("nearest_landmark");
                            String phone=jo.getString("mobile_number");

                            Address address=new Address(city,area,buildingname,streetname,nearbylandmark,phone);

                            arrayList.add(address);

                            rcvAdapter.notifyDataSetChanged();

                        }

                    }else {
                        Toast.makeText(AddressListView.this,"Sorry, no data in database",Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        });

        requestQueue.add(stringRequest);
    }
}