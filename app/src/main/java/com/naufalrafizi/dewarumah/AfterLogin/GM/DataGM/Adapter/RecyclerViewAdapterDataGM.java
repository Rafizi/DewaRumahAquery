package com.naufalrafizi.dewarumah.AfterLogin.GM.DataGM.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.naufalrafizi.dewarumah.AfterLogin.GM.DataGM.Activity.DataGMSA;
import com.naufalrafizi.dewarumah.R;

/**
 * Created by Asus on 9/24/2018.
 */

public class RecyclerViewAdapterDataGM extends RecyclerView.Adapter<RecyclerViewAdapterDataGM.ViewHolder> {

    private String [] SC =new String[0];
    private String [] SA =new String[0];
    private Context c;
    LayoutInflater inflater;



    public RecyclerViewAdapterDataGM(Context c, String[] SCsaiful, String[] SADella) {

        this.SA = SADella;
        this.SC = SCsaiful;
        this.c = c.getApplicationContext();
        this.inflater = LayoutInflater.from(c);

    }

    @Override
    public RecyclerViewAdapterDataGM.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.costume_layout_gm,parent,false);
        RecyclerViewAdapterDataGM.ViewHolder viewHolder = new RecyclerViewAdapterDataGM.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewAdapterDataGM.ViewHolder holder, int position) {

        holder.txtDataSCGM.setText("SC : " + SC[position]);
        holder.cvDataGM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(c,DataGMSA.class);

                i.putExtra("SA",SA);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                c.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return SC.length;
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
