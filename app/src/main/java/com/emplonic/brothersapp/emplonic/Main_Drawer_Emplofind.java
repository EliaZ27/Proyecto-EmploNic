package com.emplonic.brothersapp.emplonic;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

public class Main_Drawer_Emplofind extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = Main_Drawer_Emplofind.class.getSimpleName();

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__drawer__emplofind);
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
            case R.id.dOption2:
                Snackbar.make(drawerLayout,"Option 2", Snackbar.LENGTH_LONG).show();
                return true;
            case R.id.dOption3:
                Snackbar.make(drawerLayout,"Option 3", Snackbar.LENGTH_LONG).show();
                return true;
            case R.id.dOption4:
                Snackbar.make(drawerLayout,"Option 4", Snackbar.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
