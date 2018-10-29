package com.naufalrafizi.dewarumah.AfterLogin.SC.EditProfil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.naufalrafizi.dewarumah.R;

public class EditProfil extends AppCompatActivity {

    String nama,alamat,email,nomor,rek,ttl,pekerjaan;
    EditText edtNama,edtAlamat,edtEmail,edtNomor,edtRek,edtTtl,edtPekerjaan;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profil);

        inisialisasi();
        setEditText();

    }

    private void setEditText() {

        nama = getIntent().getStringExtra("nama");
        alamat = getIntent().getStringExtra("alamat");
        email = getIntent().getStringExtra("email");
        nomor = getIntent().getStringExtra("nomor");
        rek = getIntent().getStringExtra("rek");
        ttl = getIntent().getStringExtra("ttl");
        pekerjaan = getIntent().getStringExtra("pekerjaan");

        edtNama.setText(nama);
        edtAlamat.setText(alamat);
        edtEmail.setText(email);
        edtNomor.setText(nomor);
        edtRek.setText(rek);
        edtTtl.setText(ttl);
        edtPekerjaan.setText(pekerjaan);


    }

    private void inisialisasi() {

        btnSubmit = (Button)findViewById(R.id.btnSubmitProfil);
        edtNama = (EditText)findViewById(R.id.edtNamaProfil);
        edtAlamat = (EditText)findViewById(R.id.edtAlamatProfil);
        edtEmail = (EditText)findViewById(R.id.edtEmailProfil);
        edtNomor = (EditText)findViewById(R.id.edtNomorTelponProfil);
        edtRek = (EditText)findViewById(R.id.edtNoRekProfil);
        edtTtl = (EditText)findViewById(R.id.edtTtlProfil);
        edtPekerjaan = (EditText)findViewById(R.id.edtPekerjaanProfil);

    }
}
