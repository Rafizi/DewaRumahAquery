package com.naufalrafizi.dewarumah.AfterLogin.SC;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.naufalrafizi.dewarumah.AfterLogin.SA.ProspekSA.Activity.ProspekActivitySA;
import com.naufalrafizi.dewarumah.AfterLogin.SC.BonusSC.Activity.BonusSC;
import com.naufalrafizi.dewarumah.AfterLogin.SC.DataAgentSC.Activity.DataAgentSC;
import com.naufalrafizi.dewarumah.AfterLogin.SC.DataProspekSC.Activity.DataProspekSC;
import com.naufalrafizi.dewarumah.AfterLogin.SC.NotifSC.Activity.NotifSC;
import com.naufalrafizi.dewarumah.AfterLogin.SC.ProgressSC.Activity.ProgressSC;
import com.naufalrafizi.dewarumah.BeforeLogin.Activity.Login;
import com.naufalrafizi.dewarumah.R;

import me.relex.circleindicator.CircleIndicator;

public class MainActivitySConsultan extends AppCompatActivity {

    ViewPager viewPagerSc;
    ViewPagerAdapterSC vpAdapterSC;
    CircleIndicator indicatorSC;
    RecyclerViewAdapterSC rvAdapterSC;
    ImageView btnDataAgentSC,btnDataProspek,btnProgress,btnNotifSC,btnBonus;
    TextView tvNama,tvAlamat,tvTTL,tvNoTelp,tvRek,tvMail,tvPekerjaan;
    Button logout;

    int [] ImagePromoSC = {

            R.drawable.alana,
            R.drawable.ayana,
            R.drawable.rgv,
            R.drawable.felfest,
            R.drawable.felhill,
            R.drawable.gd2,
            R.drawable.gd3,
            R.drawable.gd4,
            R.drawable.rgdi

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_sc);


        setUpMenuNav();

        inisialisasi();

        setUpViewPager();
        setUpRecylerView();
        setMenu();

        String namaSc = getIntent().getStringExtra("nama");

        tvNama.setText(namaSc);




        NavigationView nv = (NavigationView)findViewById(R.id.nav_view_sc);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                switch (id){
                    case R.id.nav_profile_sa:
                        break;
                }
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_sc);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    private void setUpMenuNav() {
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbarr_sc);
        setSupportActionBar(toolbar);
        DrawerLayout dl = (DrawerLayout)findViewById(R.id.drawer_layout_sc);
        ActionBarDrawerToggle t = new ActionBarDrawerToggle(
                this, dl,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        dl.addDrawerListener(t);
        t.syncState();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_sc);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void setMenu() {

        btnBonus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), BonusSC.class));
            }
        });

        btnNotifSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), NotifSC.class));
            }
        });

        btnDataAgentSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DataAgentSC.class));
            }
        });

        btnDataProspek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DataProspekSC.class));
            }
        });

        btnProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), ProgressSC.class));

            }
        });

    }

    private void inisialisasi() {

        tvNama = (TextView)findViewById(R.id.tvNamaNav);

        btnNotifSC = (ImageView)findViewById(R.id.notifSC);
        btnDataAgentSC = (ImageView)findViewById(R.id.btnDataAgentSC);
        btnDataProspek = (ImageView)findViewById(R.id.btnDataProspek);
        btnProgress = (ImageView)findViewById(R.id.btnTimeline);
        btnBonus = (ImageView)findViewById(R.id.btnBonus);

        logout = (Button)findViewById(R.id.btnLogout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
            }
        });

    }

    private void setUpViewPager() {
        viewPagerSc = (ViewPager) findViewById(R.id.vPagerSC);
        indicatorSC = (CircleIndicator)findViewById(R.id.circleSC);
        vpAdapterSC = new ViewPagerAdapterSC(this);
        viewPagerSc.setAdapter(vpAdapterSC);
        indicatorSC.setViewPager(viewPagerSc);
    }

    private void setUpRecylerView() {

        RecyclerView rvListPromoSA = (RecyclerView) findViewById(R.id.rvListPromoSC);
        rvListPromoSA.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rvAdapterSC = new RecyclerViewAdapterSC(getApplication(),ImagePromoSC);
        rvListPromoSA.setAdapter(rvAdapterSC);

    }
}
