package com.example.alwafaataskandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class AddAddressEditText extends AppCompatActivity {

    EditText mcity,marea,mstreetname,mbuildingname,mnearbylandmark,mphone;

    Button cnfmbtn;

    String url="https://demo.softwarecompany.ae/winsa/Services/add_update_address";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address_edit_text);

        mcity=findViewById(R.id.cityedittext);
        marea=findViewById(R.id.areaedittext);
        mstreetname=findViewById(R.id.streetedittext);
        mbuildingname=findViewById(R.id.buildingnameedittext);
        mnearbylandmark=findViewById(R.id.landmarkedittext);
        mphone=findViewById(R.id.phonenoedittext);

        cnfmbtn=findViewById(R.id.confirmbtn);

        cnfmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String city=mcity.getText().toString();
                String area=marea.getText().toString();
                String streetname=mstreetname.getText().toString();
                String buildingname=mbuildingname.getText().toString();
                String nearbylandmark=mnearbylandmark.getText().toString();
                String phone=mphone.getText().toString();

                UploadData(city,area,streetname,buildingname,nearbylandmark,phone);



            }


        });


    }

    private void UploadData(String city, String area, String streetname, String buildingname, String nearbylandmark, String phone) {

        ProgressDialog progressDialog=new ProgressDialog(AddAddressEditText.this);
        progressDialog.setTitle("Uploading");
        progressDialog.setMessage("Please Wait...");
        progressDialog.show();

        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                progressDialog.dismiss();

                Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();

                Intent intentt=new Intent(AddAddressEditText.this,AddressListView.class);
                startActivity(intentt);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                progressDialog.dismiss();

                Toast.makeText(getApplicationContext(),"error:"+error.toString(),Toast.LENGTH_LONG).show();

            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {

                Map<String, String> params=new HashMap<>();

                params.put("building_name",buildingname);
                params.put("city_name",city);
                params.put("area",area);
                params.put("street_name",streetname);
                params.put("nearest_landmark",nearbylandmark);
                params.put("mobile_number",phone);
                return params;



            }
        };

        MySingleton.getInstance(AddAddressEditText.this).addToRequestQue(stringRequest);


    }
}