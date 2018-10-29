package com.naufalrafizi.dewarumah.AfterLogin.SA;

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
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.naufalrafizi.dewarumah.AfterLogin.SA.BonusSA.Activity.BonusActivitySA;
import com.naufalrafizi.dewarumah.AfterLogin.SA.NotifSA.Activity.NotifSA;
import com.naufalrafizi.dewarumah.AfterLogin.SA.ProfilSA.ProfilActivitySA;
import com.naufalrafizi.dewarumah.AfterLogin.SA.TokoSA.Activity.TokoActivitySA;
import com.naufalrafizi.dewarumah.AfterLogin.SA.InputProspekSA.Activity.InputProspekSA;
import com.naufalrafizi.dewarumah.AfterLogin.SA.ProspekSA.Activity.ProspekActivitySA;
import com.naufalrafizi.dewarumah.BeforeLogin.Activity.Login;
import com.naufalrafizi.dewarumah.R;

import org.w3c.dom.Text;

import me.relex.circleindicator.CircleIndicator;

public class MainActivitySAgent extends AppCompatActivity {

    ViewPager viewPagerSA;
    ViewPagerAdapterSA vpAdapterSA;
    CircleIndicator indicator;
    RecylerViewAdapterSA rvAdapterSA;
    ImageView btnToko,btnProfil,btnProspek,btnInput,btnBonus,btnNotifSA;
    Button btnLogout;
    String nama,nomor,email;
    TextView tvNama,tvEmail,tvNomor;

    int [] ImagePromoSA = {

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
        setContentView(R.layout.activity_nav_sa);

        inisialisasi();
        nama = getIntent().getStringExtra("nama");
        nomor = getIntent().getStringExtra("nomor");
        email = getIntent().getStringExtra("email");

        tvNama.setText(nama);
        tvNomor.setText(nomor);
        tvEmail.setText(email);
        setUpViewPager();
        setUpRecylerView();
        setUpMenu();
        setUpNav();


        NavigationView nv = (NavigationView)findViewById(R.id.nav_view);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                switch (id){
                    case R.id.nav_profile_sa:
                        break;
                }
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_sa);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }

    private void setUpNav() {
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbarr);
        setSupportActionBar(toolbar);
        DrawerLayout dl = (DrawerLayout)findViewById(R.id.drawer_layout_sa);
        ActionBarDrawerToggle t = new ActionBarDrawerToggle(
                this, dl,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        dl.addDrawerListener(t);
        t.syncState();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_sa);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void inisialisasi() {

        btnNotifSA = (ImageView)findViewById(R.id.notifSA);
        btnBonus = (ImageView) findViewById(R.id.btnBonus);
        btnToko = (ImageView) findViewById(R.id.btnToko);
        btnProfil = (ImageView) findViewById(R.id.btnProfil);
        btnInput = (ImageView) findViewById(R.id.btnInputProspek);
        btnProspek = (ImageView) findViewById(R.id.btnProspek);
        btnLogout = (Button)findViewById(R.id.btnLogout);

        //TextView
        tvNama = (TextView)findViewById(R.id.tvNamaNav);
        tvEmail = (TextView)findViewById(R.id.tvGmailNav);
        tvNomor = (TextView)findViewById(R.id.tvTelpNav);

    }

    private void setUpMenu() {

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
            }
        });

        btnNotifSA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 startActivity(new Intent(getApplicationContext(), NotifSA.class));
            }
        });

        btnToko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),TokoActivitySA.class));
            }
        });



        btnProspek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),ProspekActivitySA.class));

            }
        });
        btnProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),ProfilActivitySA.class);
                i.putExtra("nama",nama);
                startActivity(i);

            }
        });
        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),InputProspekSA.class);
                i.putExtra("nama",nama);
                startActivity(i);

            }
        });
        btnBonus.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),BonusActivitySA.class));

            }

        });

    }

    private void setUpRecylerView() {

        RecyclerView rvListPromoSA = (RecyclerView) findViewById(R.id.rvListPromoSA);
        rvListPromoSA.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rvAdapterSA = new RecylerViewAdapterSA(getApplication(),ImagePromoSA);
        rvListPromoSA.setAdapter(rvAdapterSA);

    }

    public void setUpViewPager() {

        viewPagerSA = (ViewPager) findViewById(R.id.vPagerSA);
        indicator = (CircleIndicator)findViewById(R.id.circleSA);
        vpAdapterSA = new ViewPagerAdapterSA(this);
        viewPagerSA.setAdapter(vpAdapterSA);
        indicator.setViewPager(viewPagerSA);

    }
}
