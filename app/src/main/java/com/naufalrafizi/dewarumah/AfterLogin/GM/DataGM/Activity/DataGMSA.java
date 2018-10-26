package com.naufalrafizi.dewarumah.AfterLogin.GM.DataGM.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.naufalrafizi.dewarumah.AfterLogin.GM.DataGM.Adapter.RecyclerViewAdapterDataGMSA;
import com.naufalrafizi.dewarumah.R;

public class DataGMSA extends AppCompatActivity {

    RecyclerViewAdapterDataGMSA rvAdapterdataGMSA;


    String SA []  = {
            "Ayen",
            "Ramli"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_gm_sa);

        setUpRecyclerView();




    }

    private void setUpRecyclerView() {

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rvDataGMSA);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rvAdapterdataGMSA = new RecyclerViewAdapterDataGMSA(getApplicationContext(),SA);
        recyclerView.setAdapter(rvAdapterdataGMSA);

    }
}
