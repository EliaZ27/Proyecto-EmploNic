package com.emplonic.brothersapp.emplonic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity{

    Button mbtn;
    Button btnRegistrate;
    Button btnpymes;
    Button btnempleador;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbtn = (Button) findViewById(R.id.btnLogin);
        btnRegistrate = (Button) findViewById(R.id.btnRegistrate);
        btnpymes = (Button) findViewById(R.id.btnPymes);
        btnempleador = (Button) findViewById(R.id.btnempleador);
        mbtn.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, Main_Drawer_Emplofind.class);
                    startActivity(intent);
            }
        });

        btnRegistrate.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main_Cuentas.class);
                startActivity(intent);
            }
        });

        btnpymes.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main_Drawer_Pymes.class);
                startActivity(intent);
            }
        });

        btnempleador.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main_Drawer_Empleador.class);
                startActivity(intent);
            }
        });

    }


}
