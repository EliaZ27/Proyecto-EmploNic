package com.emplonic.brothersapp.emplonic;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

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

        mbtn.setOnClickListener(new View.OnClickListener() {
            public String TAG;

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main_Drawer_Emplofind.class);
                startActivity(intent);
            }
        });


        btnRegistrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main_Cuentas.class);
                startActivity(intent);
            }
        });

        btnpymes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main_Drawer_Pymes.class);
                startActivity(intent);
            }
        });

        btnempleador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main_Drawer_Empleador.class);
                startActivity(intent);
            }
        });

    }

    //private void Validar() {
        //EditText etEmail = (EditText) findViewById(R.id.user);
        //EditText etPass = (EditText) findViewById(R.id.pass);

        //final String Email = etEmail.getText().toString();
        //final String Pass = etPass.getText().toString();

        //final String Email1 = "Jefferson@gmail.com";
        //final String Pass1 = "1234";

        //final String Email2 = "Elias@gmail.com";
        //final String Pass2 = "1234";

        //final String Email3 = "Bryant@gmail.com";
        //final String Pass3 = "1234";-->



        //if (Email == Email1 & Pass == Pass1){
          //  Intent intent1 = new Intent(MainActivity.this, Main_Drawer_Emplofind.class);
            //startActivity(intent1);
        //} else {
          //  if (Email2 == Email & Pass == Pass2) {
            //    Intent intent2 = new Intent(MainActivity.this, Main_Drawer_Empleador.class);
              //  startActivity(intent2);
            //} else {
              //  if (Email3 == Email & Pass == Pass3) {
                //    Intent intent3 = new Intent(MainActivity.this, Main_Drawer_Pymes.class);
                  //  startActivity(intent3);
                //}
            //}


        //}


    //}
}
