package com.naufalrafizi.dewarumah.AfterLogin.SA.ProspekSA.Activity;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.TextView;

import com.mancj.materialsearchbar.MaterialSearchBar;
import com.mancj.materialsearchbar.SimpleOnSearchActionListener;
import com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Helper.DBAdapter;
import com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Helper.DBDataSource;
import com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Helper.DataHelper;
import com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Model.MInputProspek;
import com.naufalrafizi.dewarumah.AfterLogin.SA.ProspekSA.Adapter.RecyclerViewAdapterProspekSA;
import com.naufalrafizi.dewarumah.R;

import java.util.ArrayList;
import java.util.List;

public class ProspekActivitySA extends AppCompatActivity {

    //inisialisasi kontroler
    DataHelper dbHelper;

    RecyclerView rvProspek;
    MInputProspek mprospek;
    //inisialisasi arraylist
    List<MInputProspek> mList = new ArrayList<>();
    List<String>sList = new ArrayList<>();
    MInputProspek p;
    TextView emptyTxt;
    android.support.v7.widget.SearchView svProspek;

    RecyclerViewAdapterProspekSA rvAdapterProspek;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prospek_sa);
        //inisialisasi widget
        dbHelper = new DataHelper(this);
        p = new MInputProspek();
        emptyTxt = (TextView)findViewById(R.id.empty_notes_view);
        svProspek = ( android.support.v7.widget.SearchView) findViewById(R.id.svProspek);
        loadsuggestlistsearch();
        svProspek.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                rvAdapterProspek = new RecyclerViewAdapterProspekSA(getApplicationContext(),mList);
                rvProspek.setAdapter(rvAdapterProspek);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText ==null){
                    rvProspek.setAdapter(rvAdapterProspek);
                }else {
                    getPlanets(newText);
                }
                return false;
            }
        });





        mList.addAll(dbHelper.getAllProspek());


        toggleEmptyNotes();
        //buka kontroler


        //ambil semua data barang
//        mList= dataSource.getAllProspek();


        rvProspek = (RecyclerView)findViewById(R.id.rvProspek);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        rvProspek.setLayoutManager(manager);

        rvAdapterProspek = new RecyclerViewAdapterProspekSA(getApplicationContext(),mList);
        rvProspek.setAdapter(rvAdapterProspek);



    }

    private void getPlanets(String searchTerm)
    {
        mList.clear();

        DBAdapter db=new DBAdapter(this);
        db.openDB();
        MInputProspek p=null;
        Cursor c=db.retrieve(searchTerm);

        while (c.moveToNext())
        {
            int id=c.getInt(0);
            String name=c.getString(1);
            String telp = c.getString(5);
            String email = c.getString(3);
            String project = c.getString(2);

            p=new MInputProspek();
            p.setId(id);
            p.setNama_prospek(name);
            p.setNotelp_prospek(telp);
            p.setEmail_prospek(email);
            p.setProject_prospek(project);

            mList.add(p);
        }

        db.closeDB();

        rvProspek.setAdapter(rvAdapterProspek);
    }

    private void startSearch(String text) {
        rvAdapterProspek = new RecyclerViewAdapterProspekSA(this,dbHelper.getSearchByName(text));
        rvProspek.setAdapter(rvAdapterProspek);
    }

    private void loadsuggestlistsearch() {
        sList = dbHelper.getName();
//        sProspek.setLastSuggestions(sList);
    }

    private void toggleEmptyNotes() {
        // you can check notesList.size() > 0

        if (dbHelper.getProjectCount() > 0) {
            emptyTxt.setVisibility(View.GONE);
        } else {
            emptyTxt.setVisibility(View.VISIBLE);
        }
    }
}
