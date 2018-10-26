package com.naufalrafizi.dewarumah.AfterLogin.GM.DataGM.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.naufalrafizi.dewarumah.R;

/**
 * Created by Asus on 10/24/2018.
 */

public class RecyclerViewAdapterDataGMProspek extends RecyclerView.Adapter<RecyclerViewAdapterDataGMProspek.ViewHolder>{

    private String [] Prospek  =new String[0];
    private String [] progres  =new String[0];
    private Context c;
    LayoutInflater inflater;

    public RecyclerViewAdapterDataGMProspek(Context c, String[] prospek, String[] progres) {

        this.progres = progres;
        this.Prospek = prospek;
        this.c = c.getApplicationContext();
        this.inflater = LayoutInflater.from(c);

    }

    @Override
    public RecyclerViewAdapterDataGMProspek.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.costume_layout_gm_prospek,parent,false);
        RecyclerViewAdapterDataGMProspek.ViewHolder viewHolder = new RecyclerViewAdapterDataGMProspek.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapterDataGMProspek.ViewHolder holder, int position) {

        holder.txtDataProspekGM.setText(Prospek[position]);
        holder.txtDataProgresGM.setText(progres[position]);

    }

    @Override
    public int getItemCount() {
        return Prospek.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView cvDataGM;
        TextView txtDataProspekGM,txtDataProgresGM;

        public ViewHolder(View itemView) {
            super(itemView);

            cvDataGM = (CardView)itemView.findViewById(R.id.cvGMProspek);
            txtDataProspekGM = (TextView)itemView.findViewById(R.id.txtDataGMProspek);
            txtDataProgresGM = (TextView)itemView.findViewById(R.id.txtDataGMProgres);

        }
    }
}
