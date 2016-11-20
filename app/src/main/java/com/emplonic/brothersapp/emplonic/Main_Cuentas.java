package com.emplonic.brothersapp.emplonic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main_Cuentas extends AppCompatActivity {

    Button mbtnEmplofind;
    Button mbtnPymes;
    Button mbtnEmpleador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__cuentas);
        mbtnEmplofind = (Button) findViewById(R.id.btnEmplofind);
        mbtnPymes = (Button) findViewById(R.id.btnpymes);
        mbtnEmpleador = (Button) findViewById(R.id.btnEmpleador);
        mbtnEmplofind.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main_Cuentas.this, Main_Register.class);
                startActivity(intent);
            }
        });
        mbtnPymes.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main_Cuentas.this, Main_Register_Pymes.class);
                startActivity(intent);
            }
        });

        mbtnEmpleador.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main_Cuentas.this, Main_Register_Empleador.class);
                startActivity(intent);
            }
        });



    }
}
