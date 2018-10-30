package com.naufalrafizi.dewarumah.AfterLogin.GM.DataGM.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.naufalrafizi.dewarumah.AfterLogin.GM.DataGM.Adapter.RecyclerViewAdapterDataGMProspek;
import com.naufalrafizi.dewarumah.R;

public class DataGMProspek extends AppCompatActivity {

    RecyclerViewAdapterDataGMProspek rvAdapterDataGMProspek;

    String[] prospek = {

            "Tayo",
            "Irithel",
            "Zill",
            "Areka"

    };

    String[] progres = {

            "Booking",
            "Booking",
            "Akad",
            "Follow Up"

    };
    String[]notelp = {
            "6281245889012",
            "6289957643398",
            "6280999678290",
            "6285588720098"

    };
    String[]email = {
            "tayo@gmail.com",
            "irithel@gmail.com",
            "zill@gmail.com",
            "areka@gmail.com"
    };
    String[]project = {
            "Greenland Bogor",
            "Amaya",
            "Alana",
            "Ayana",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_gmprospek);

        setUpRecyclerView();

    }

    private void setUpRecyclerView() {

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvDataGmProspek);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvAdapterDataGMProspek = new RecyclerViewAdapterDataGMProspek(getApplicationContext(), prospek,progres,email,project,notelp);
        recyclerView.setAdapter(rvAdapterDataGMProspek);

    }
}
