package com.naufalrafizi.dewarumah.AfterLogin.SC.DataProspekSC.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Helper.DataHelper;
import com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Model.MInputProspek;
import com.naufalrafizi.dewarumah.R;

import java.util.List;

/**
 * Created by Asus on 10/26/2018.
 */

public class RecyclerViewAdapterDataProspekSC extends RecyclerView.Adapter<RecyclerViewAdapterDataProspekSC.ViewHolder>{

    private List<MInputProspek> data;
    RecyclerViewAdapterDataProspekSC adapter;
    private Context context;
    private LayoutInflater inflater;
    private DataHelper helper;

    public RecyclerViewAdapterDataProspekSC(Context c, List<MInputProspek> mList) {

        data = mList;
//        this.mNamaPromo = NamaPromo;
        this.context = c.getApplicationContext();
        this.inflater = LayoutInflater.from(context);
        this.helper = new DataHelper(c);

    }

    @Override
    public RecyclerViewAdapterDataProspekSC.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.costum_list_prospek_sc, parent, false);
        RecyclerViewAdapterDataProspekSC.ViewHolder viewHolder = new RecyclerViewAdapterDataProspekSC.ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapterDataProspekSC.ViewHolder holder, int position) {

        final MInputProspek object = data.get(position);

        final String namaProspek = object.getNama_prospek();
        final String nomorTelpon = object.getNotelp_prospek();
        final String Project = object.getProject_prospek();
        final String Sa = object.getSa_prospek();
        final String Email = object.getEmail_prospek();

        holder.nama.setText("Nama   : " + namaProspek);
        holder.email.setText("Email : " + Email);
        holder.SA.setText("SA   : " + Sa);
        holder.notelp.setText("No Telp  : " + nomorTelpon);
        holder.project.setText("Project : " + Project);

        holder.ivChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = "https://api.whatsapp.com/send?phone="+ nomorTelpon;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                context.startActivity(i);

            }
        });

        holder.ivCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = "tel:"+nomorTelpon.trim();
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse(url));
                context.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nama, project, SA, email, notelp;
        ImageView ivCall,ivChat;
        CardView cvProspek;

        public ViewHolder(View itemView) {
            super(itemView);

            cvProspek = (CardView) itemView.findViewById(R.id.cvProspekSC);
            nama = (TextView) itemView.findViewById(R.id.txtNamaProspekSC);
            project = (TextView) itemView.findViewById(R.id.txtProjectSC);
            SA = (TextView) itemView.findViewById(R.id.txtSASC);
            email = (TextView) itemView.findViewById(R.id.txtProspelEmailSC);
            notelp = (TextView) itemView.findViewById(R.id.txtProspekNoTelpSC);
            ivChat = (ImageView)itemView.findViewById(R.id.ivWhatsApp);
            ivCall = (ImageView)itemView.findViewById(R.id.ivCall);

        }
    }
}
