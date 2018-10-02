package com.naufalrafizi.dewarumah.AfterLogin.GM.NotifGM.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.naufalrafizi.dewarumah.R;

public class DetailNotifGM extends AppCompatActivity {

    TextView txtNamaDetailNotifGM,txtContentDetailGM;
    private String nama,content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_notif_gm);

        txtContentDetailGM= (TextView)findViewById(R.id.txtContentDetailNotifGM);
        txtNamaDetailNotifGM = (TextView)findViewById(R.id.txtNamaDetailNotifGM);

        nama = getIntent().getStringExtra("nama");
        content = getIntent().getStringExtra("content");

        txtNamaDetailNotifGM.setText(nama);
        txtContentDetailGM.setText(content);

    }
}
