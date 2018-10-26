package com.naufalrafizi.dewarumah.AfterLogin.GM.DataGM.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.naufalrafizi.dewarumah.AfterLogin.GM.DataGM.Adapter.RecyclerViewAdapterDataGM;
import com.naufalrafizi.dewarumah.R;

public class DataGMSC extends AppCompatActivity {

    RecyclerViewAdapterDataGM rvAdapterDataGM;

    String [] SC = {

            "Della"

    };

    String SADella []  = {
            "Ayen",
            "Ramli"
    };

    String ProspekAyen [] = {
            "Rona",
            "Ilahm",
            "Diki",
    };

    String ProspekDella [] = {
            "Tari",
            "Ikha",
            "Robert"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_gm_sc);


        setUpRecycler();

    }

    private void setUpRecycler() {

        RecyclerView rvListDataGM = (RecyclerView)findViewById(R.id.rvListDataGM);
        rvListDataGM.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rvAdapterDataGM = new RecyclerViewAdapterDataGM(getApplicationContext(),SC,SADella);
        rvListDataGM.setAdapter(rvAdapterDataGM);

    }
}
