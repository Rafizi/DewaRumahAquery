package com.naufalrafizi.dewarumah.AfterLogin.GM.DataGM.Adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.naufalrafizi.dewarumah.R;

/**
 * Created by Asus on 10/24/2018.
 */

public class RecyclerViewAdapterDataGMProspek extends RecyclerView.Adapter<RecyclerViewAdapterDataGMProspek.ViewHolder>{

    private String [] Prospek  =new String[0];
    private String [] progres  =new String[0];
    private String [] Mnotelp   = new String[0];
    private String [] Memail   = new String[0];
    private String [] Mproject   = new String[0];
    private Context c;
    LayoutInflater inflater;

    public RecyclerViewAdapterDataGMProspek(Context c, String[] prospek, String[] progres,String[] Project,String[] Email,String[] notelp) {

        this.progres = progres;
        this.Prospek = prospek;
        this.Memail = Email;
        this.Mproject = Project;
        this.Mnotelp = notelp;
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
    public void onBindViewHolder(RecyclerViewAdapterDataGMProspek.ViewHolder holder, final int position) {
        final String mEmail,mNotelp,mProject;
        mEmail = Memail[position];
        mNotelp = Mnotelp[position];
        mProject= Mproject[position];

        holder.txtDataProspekGM.setText(Prospek[position]);
        holder.txtDataProgresGM.setText(progres[position]);
        holder.cvDataGM.setOnClickListener(new View.OnClickListener() {
            int position;
            @Override
            public void onClick(View view) {
                View v = inflater.inflate(R.layout.view_prof_sa_gm, null);
                AlertDialog.Builder b = new AlertDialog.Builder(view.getRootView().getContext());

                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.MATCH_PARENT;

                final TextView email = (TextView)v.findViewById(R.id.tvEmailGM);
                final TextView notelp = (TextView)v.findViewById(R.id.tvNotelpGM);
                final TextView project = (TextView)v.findViewById(R.id.tvProjectGM);



                email.setText("Email : "+mEmail);
                notelp.setText("Nomor Telpon : "+mNotelp);
                project.setText("Project : "+mProject);
                b.setView(v);


                AlertDialog dialog = b.create();
                dialog.show();
                dialog.getWindow().setLayout(600,300);
            }
        });

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
