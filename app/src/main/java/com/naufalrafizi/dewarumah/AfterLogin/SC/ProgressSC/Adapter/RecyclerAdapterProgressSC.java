package com.naufalrafizi.dewarumah.AfterLogin.SC.ProgressSC.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.naufalrafizi.dewarumah.R;

/**
 * Created by Asus on 10/3/2018.
 */

public class RecyclerAdapterProgressSC extends RecyclerView.Adapter<RecyclerAdapterProgressSC.ViewHolder> {

    private String [] mNamaSA =new String[0];
    private String [] mProject = new String[0];
    private String[] mProgres = new String[0];
    private Context c;
    LayoutInflater inflater;

    public RecyclerAdapterProgressSC(Context c, String[] namaSA, String[] project, String[] progres) {

        this.mNamaSA = namaSA;
        this.mProgres = progres;
        this.mProject = project;
        this.c = c.getApplicationContext();
        this.inflater = LayoutInflater.from(c);

    }

    @Override
    public RecyclerAdapterProgressSC.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.costum_list_progress_sc,parent,false);
        RecyclerAdapterProgressSC.ViewHolder viewHolder= new RecyclerAdapterProgressSC.ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerAdapterProgressSC.ViewHolder holder, final int position) {

        String nama,project,progres;


        nama = mNamaSA[position];
        project = mProject[position];
        progres = mProgres[position];

        holder.txtProgresNamaSC.setText(nama);
        holder.txtProgresProjectSC.setText(project);

        holder.cvProgressSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final int progress;


                final View v = inflater.inflate(R.layout.dialog_view,null);
                AlertDialog.Builder b = new AlertDialog.Builder(view.getRootView().getContext());
                b.setView(v);

                final RadioGroup rg = (RadioGroup) v.findViewById(R.id.rgProgress);
                final EditText edtUnit = (EditText)v.findViewById(R.id.edtTypeUnit);

                b.setPositiveButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        int selectedId = rg.getCheckedRadioButtonId();

                        RadioButton radioButton = (RadioButton)v.findViewById(selectedId);

                        if (rg.getCheckedRadioButtonId() != -1){

                            holder.txtProgressSC.setText(radioButton.getText());
                            Toast.makeText(c,radioButton.getText(), Toast.LENGTH_SHORT).show();

                        } else {

                        }

                        String data = edtUnit.getText().toString();

                        holder.txtNamaUnit.setText(data);

                    }
                });

                AlertDialog dialog = b.create();
                dialog.show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return mNamaSA.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtProgresNamaSC, txtProgressSC, txtProgresProjectSC,txtNamaUnit;
        CardView cvProgressSC;

        public ViewHolder(View itemView) {
            super(itemView);

            cvProgressSC = (CardView)itemView.findViewById(R.id.cvProgressSC);
            txtNamaUnit = (TextView)itemView.findViewById(R.id.txtNamaUnit);
            txtProgresNamaSC = (TextView)itemView.findViewById(R.id.txtProgresNamaSC);
            txtProgressSC = (TextView)itemView.findViewById(R.id.txtProgressSC);
            txtProgresProjectSC = (TextView)itemView.findViewById(R.id.txtProgresProjectSC);

        }
    }
}
