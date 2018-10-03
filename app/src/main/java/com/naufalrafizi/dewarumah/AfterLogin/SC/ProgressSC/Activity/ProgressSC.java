package com.naufalrafizi.dewarumah.AfterLogin.SC.ProgressSC.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.naufalrafizi.dewarumah.AfterLogin.SC.ProgressSC.Adapter.RecyclerAdapterProgressSC;
import com.naufalrafizi.dewarumah.R;

public class ProgressSC extends AppCompatActivity {

    RecyclerAdapterProgressSC rvAdapterProgressSC;

    String [] namaSA = {

            "Saiful",
            "Saiful",
            "Ella",
            "Stev"
    };

    String [] project ={

            "Greend River Villa",
            "Alana Boutique Townhouse",
            "Greenland Darul Istiqomah",
            "Ayana Townhouse"

    };

    String [] progres = {

            "",
            "",
            "",
            ""

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_sc);

        inisialisasi();

        setUpRecyclerView();

    }

    private void inisialisasi() {



    }

    private void setUpRecyclerView() {

        RecyclerView rvListProgressSC = (RecyclerView)findViewById(R.id.rvListProgressSC);
        rvListProgressSC.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        rvAdapterProgressSC = new RecyclerAdapterProgressSC(getApplicationContext(),namaSA,project,progres);
        rvListProgressSC.setAdapter(rvAdapterProgressSC);

    }


}