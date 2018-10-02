package com.naufalrafizi.dewarumah.AfterLogin.SA.NotifSA.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.naufalrafizi.dewarumah.R;

public class DetailNotifSA extends AppCompatActivity {

    TextView txtNamaDetailNotifSA,txtContentDetailSA;
    private String nama,content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_notif_sa);

        txtContentDetailSA= (TextView)findViewById(R.id.txtContentDetailNotifSA);
        txtNamaDetailNotifSA = (TextView)findViewById(R.id.txtNamaDetailNotifSA);

        nama = getIntent().getStringExtra("nama");
        content = getIntent().getStringExtra("content");

        txtNamaDetailNotifSA.setText(nama);
        txtContentDetailSA.setText(content);

    }
}
