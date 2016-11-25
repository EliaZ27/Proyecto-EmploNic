package com.emplonic.brothersapp.emplonic;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Main_Drawer_Emplofind extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = Main_Drawer_Emplofind.class.getSimpleName();

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__drawer__emplofind);

        // Inicializar Animes
        List<Empleo> items = new ArrayList<>();

        items.add(new Empleo(R.drawable.imagen, "Albañil","Nesecito Albañil Para una Pequeña Contruccion, El Pago Lo Veremos Juntos Llamar Al 88776499"));
        items.add(new Empleo(R.drawable.imagen, "Death Note","Hola"));
        items.add(new Empleo(R.drawable.imagen, "Fate Stay Night","Hola"));
        items.add(new Empleo(R.drawable.imagen, "Welcome to the NHK", "Hola"));
        items.add(new Empleo(R.drawable.imagen, "Suzumiya Haruhi", "Hola"));

        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        adapter = new EmpleoAdapter(items);
        recycler.setAdapter(adapter);


        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView = (NavigationView)findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(this);
        actionBarDrawerToggle =
                new ActionBarDrawerToggle(this, drawerLayout,toolbar, R.string.app_name,R.string.bottom_sheet_behavior);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Log.d(TAG, "onOptionsItemSelected: " + item.getItemId());
        switch (item.getItemId()){
            case R.id.dOpt_perfil:
                Intent opc1 = new Intent(Main_Drawer_Emplofind.this, Main_perfil.class);
                startActivity(opc1);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            case R.id.dOption2:
                Intent opc2 = new Intent(Main_Drawer_Emplofind.this, Main_buscar.class);
                startActivity(opc2);
                return true;
            case R.id.dOption3:
                Intent opc3 = new Intent(Main_Drawer_Emplofind.this, Main_Dt_Personales.class);
                startActivity(opc3);
                return true;
            case R.id.dOption4:
                Intent opc4 = new Intent(Main_Drawer_Emplofind.this, Main_Curriculum.class);
                startActivity(opc4);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
