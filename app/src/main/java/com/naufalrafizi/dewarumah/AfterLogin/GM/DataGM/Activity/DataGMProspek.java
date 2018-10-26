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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_gmprospek);

        setUpRecyclerView();

    }

    private void setUpRecyclerView() {

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvDataGmProspek);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvAdapterDataGMProspek = new RecyclerViewAdapterDataGMProspek(getApplicationContext(), prospek,progres);
        recyclerView.setAdapter(rvAdapterDataGMProspek);

    }
}
