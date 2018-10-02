package com.naufalrafizi.dewarumah.AfterLogin.SC.NotifSC.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.naufalrafizi.dewarumah.R;

public class DetailNotifSC extends AppCompatActivity {

    TextView txtNamaDetailNotifSC,txtContentDetailSC;
    private String nama,content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_notif_sc);

        txtContentDetailSC= (TextView)findViewById(R.id.txtContentDetailNotifSC);
        txtNamaDetailNotifSC = (TextView)findViewById(R.id.txtNamaDetailNotifSC);

        nama = getIntent().getStringExtra("nama");
        content = getIntent().getStringExtra("content");

        txtNamaDetailNotifSC.setText(nama);
        txtContentDetailSC.setText(content);

    }
}
