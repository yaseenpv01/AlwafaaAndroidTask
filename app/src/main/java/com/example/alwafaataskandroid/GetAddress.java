package com.example.alwafaataskandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetAddress extends AppCompatActivity {

    public TextView tvcity,tvarea,tvstreetname,tvbuildingname,tvnearbylandmark,tvphone;

    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_address);

        tvcity=findViewById(R.id.getcitytext);
        tvarea=findViewById(R.id.getareatext);
        tvstreetname=findViewById(R.id.getstreettext);
        tvbuildingname=findViewById(R.id.getbuildingnametext);
        tvnearbylandmark=findViewById(R.id.getlandmarktext);
        tvphone=findViewById(R.id.getphonenotext);

        cardView=findViewById(R.id.cardview);

        getCourse();
    }

    private void getCourse() {

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://demo.softwarecompany.ae/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterfaceGet apiInterfaceGet=retrofit.create(ApiInterfaceGet.class);

        Call<AddrResponse> call=apiInterfaceGet.getAllAddress();

        call.enqueue(new Callback<AddrResponse>() {
            @Override
            public void onResponse(Call<AddrResponse> call, Response<AddrResponse> response) {

                if(response.code() == 200){
                    AddrResponse addrResponse=(AddrResponse) response.body();

                    cardView.setVisibility(View.VISIBLE);

                    tvcity.setText(response.body().getCity_name());
                    tvarea.setText(addrResponse.getArea());
                    tvstreetname.setText(addrResponse.getStreet_name());
                    tvbuildingname.setText(addrResponse.getBuilding_name());
                    tvnearbylandmark.setText(addrResponse.getNearest_landmark());
                    tvphone.setText(addrResponse.getMobile_number());

                }


                Toast.makeText(GetAddress.this,"Success",Toast.LENGTH_LONG).show();


            }

            @Override
            public void onFailure(Call<AddrResponse> call, Throwable t) {

                Toast.makeText(GetAddress.this,"Failed To Load Data",Toast.LENGTH_LONG).show();

            }
        });
    }
}