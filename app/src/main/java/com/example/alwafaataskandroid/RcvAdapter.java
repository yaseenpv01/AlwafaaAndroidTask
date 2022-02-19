package com.example.alwafaataskandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class RcvAdapter extends RecyclerView.Adapter<RcvAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Address> arrayList;


    public RcvAdapter(Context applicationContext, ArrayList arrayList) {

        this.context=applicationContext;
        this.arrayList=arrayList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.address_row,parent,false);

        ViewHolder vh=new ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Address address=arrayList.get(position);
        holder.tvcity.setText(address.getCity());
        holder.tvarea.setText(address.getArea());
        holder.tvstreetname.setText(address.getStreetname());
        holder.tvbuildingname.setText(address.getBuildingname());
        holder.tvnearbylandmark.setText(address.getNearbylandmark());
        holder.tvphone.setText(address.getPhone());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvcity,tvarea,tvstreetname,tvbuildingname,tvnearbylandmark,tvphone;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvcity=itemView.findViewById(R.id.citytext);
            tvarea=itemView.findViewById(R.id.areatext);
            tvstreetname=itemView.findViewById(R.id.streettext);
            tvbuildingname=itemView.findViewById(R.id.buildingnametext);
            tvnearbylandmark=itemView.findViewById(R.id.landmarktext);
            tvphone=itemView.findViewById(R.id.phonenotext);

        }
    }
}
