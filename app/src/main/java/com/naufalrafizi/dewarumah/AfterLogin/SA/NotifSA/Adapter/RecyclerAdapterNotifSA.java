package com.naufalrafizi.dewarumah.AfterLogin.SA.NotifSA.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.naufalrafizi.dewarumah.AfterLogin.SA.NotifSA.Activity.DetailNotifSA;
import com.naufalrafizi.dewarumah.R;

/**
 * Created by Asus on 9/28/2018.
 */

public class RecyclerAdapterNotifSA extends RecyclerView.Adapter<RecyclerAdapterNotifSA.ViewHolder> {

    private String [] mNama =new String[0];
    private String [] mContent = new String[0];
    private Context c;
    LayoutInflater inflater;

    public RecyclerAdapterNotifSA(Context c, String[] nama, String[] content) {

        this.mNama = nama;
        this.mContent = content;
        this.c = c.getApplicationContext();
        this.inflater = LayoutInflater.from(c);

    }

    @Override
    public RecyclerAdapterNotifSA.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.costum_list_data_agent_sc,parent,false);
        RecyclerAdapterNotifSA.ViewHolder viewHolder= new RecyclerAdapterNotifSA.ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapterNotifSA.ViewHolder holder, int position) {

        final String nama,content;

        nama = mNama[position];
        content = mContent[position];

        holder.txtNama.setText(nama);
        holder.txtContent.setText(content);
        holder.cvNotifSA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(c, DetailNotifSA.class);
                i.putExtra("nama",nama);
                i.putExtra("content",content);
                c.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mNama.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNama,txtContent;
        CardView cvNotifSA;
        public ViewHolder(View itemView) {
            super(itemView);
            cvNotifSA = (CardView)itemView.findViewById(R.id.cvNotif);
            txtNama = (TextView)itemView.findViewById(R.id.txtNamaAgentSC);
            txtContent = (TextView)itemView.findViewById(R.id.txtProjectAgentSC);

        }
    }
}
