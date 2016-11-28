package com.emplonic.brothersapp.emplonic;

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

public class Main_Drawer_Empleador extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

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
        setContentView(R.layout.activity_main__drawer__empleador);

        // Inicializar Animes
        List<Empleo> items = new ArrayList<>();

        items.add(new Empleo(R.drawable.imagen, "Albañil","Nesecito Albañil Para una Pequeña Contruccion, El Pago Lo Veremos Juntos Llamar Al 88776499"));
        items.add(new Empleo(R.drawable.imagen, "Bisutera","Necesito Bisutera Para Mi Pymes Mi Numero :88998797 O Dirrecion: Km 13 y medio Carretera Norte"));
        items.add(new Empleo(R.drawable.imagen, "Carpitero","Nesito Carpintero Para Reparar Una Comoda Mi Numero:87876677"));
        items.add(new Empleo(R.drawable.imagen, "Costurera", "Necesito Costurera Para Realizar un Vestido De Novia Numero: 86879927"));
        items.add(new Empleo(R.drawable.imagen, "Otro", "Necesito Conductor Por Dos Dias Numero: 87902369"));

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
                Snackbar.make(drawerLayout,"Option 1", Snackbar.LENGTH_LONG).show();
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            case R.id.dOpt_Buscar:
                Snackbar.make(drawerLayout,"Option 2", Snackbar.LENGTH_LONG).show();
                return true;
            case R.id.dOpt_PublicrEmpleo:
                Snackbar.make(drawerLayout,"Option 3", Snackbar.LENGTH_LONG).show();
                return true;
            case R.id.dOpt_DatosP:
                Snackbar.make(drawerLayout,"Option 4", Snackbar.LENGTH_LONG).show();
                return true;
            case R.id.dOpt_Curriculum:
                Snackbar.make(drawerLayout,"Option 4", Snackbar.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
