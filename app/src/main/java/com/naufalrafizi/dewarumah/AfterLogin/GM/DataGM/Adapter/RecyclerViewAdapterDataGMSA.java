package com.naufalrafizi.dewarumah.AfterLogin.GM.DataGM.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.naufalrafizi.dewarumah.AfterLogin.GM.DataGM.Activity.DataGMProspek;
import com.naufalrafizi.dewarumah.R;

/**
 * Created by Asus on 10/24/2018.
 */

public class RecyclerViewAdapterDataGMSA extends RecyclerView.Adapter<RecyclerViewAdapterDataGMSA.ViewHolder> {

    private String [] SA  =new String[0];
    private Context c;
    LayoutInflater inflater;

    public RecyclerViewAdapterDataGMSA(Context c, String[] SA) {

        this.SA = SA;
        this.c = c.getApplicationContext();
        this.inflater = LayoutInflater.from(c);

    }

    @Override
    public RecyclerViewAdapterDataGMSA.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.costume_layout_gm,parent,false);
        RecyclerViewAdapterDataGMSA.ViewHolder viewHolder = new RecyclerViewAdapterDataGMSA.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapterDataGMSA.ViewHolder holder, int position) {

        holder.txtDataSCGM.setText("SA : " + SA[position]);
        holder.cvDataGM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(c, DataGMProspek.class);
                c.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return SA.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView cvDataGM;
        TextView txtDataSCGM;

        public ViewHolder(View itemView) {
            super(itemView);

            cvDataGM = (CardView)itemView.findViewById(R.id.cvGM);
            txtDataSCGM = (TextView)itemView.findViewById(R.id.txtDataGM);

        }
    }
}
