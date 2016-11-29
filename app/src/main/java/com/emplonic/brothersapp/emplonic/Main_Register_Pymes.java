package com.emplonic.brothersapp.emplonic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Main_Register_Pymes extends AppCompatActivity {

    Spinner spinner1;
    Button mbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__register__pymes);
        //spinner1 = (Spinner)findViewById(R.id.Categoria);
        //ArrayAdapter<String> adapter1 =
          //      new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.Pymes));
        //spinner1.setAdapter(adapter1);

        EditText etNombreDeLaPymes = (EditText) findViewById(R.id.nombrePymes);
        EditText etDirrecion = (EditText) findViewById(R.id.Dirrecion1);
        EditText etEmail = (EditText) findViewById(R.id.emailPymes);
        EditText etPass = (EditText) findViewById(R.id.pass1);
        EditText etCategoria = (EditText) findViewById(R.id.Categoria);
        final String nombre = etNombreDeLaPymes.getText().toString();
        final String dirrecion = etDirrecion.getText().toString();
        final String email = etEmail.getText().toString();
        final String pass = etPass.getText().toString();
        final String categoria = etCategoria.getText().toString();


        final BaseHelper helper = new BaseHelper(this);
        mbtn = (Button)findViewById(R.id.btnRegistratePymes);
        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.insertarRegistroPymes(nombre, dirrecion, email, pass, categoria);
                helper.listarRegistrosPymes();
            }
        });



    }
}
