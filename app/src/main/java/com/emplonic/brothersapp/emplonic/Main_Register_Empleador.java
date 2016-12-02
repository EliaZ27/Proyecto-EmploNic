package com.emplonic.brothersapp.emplonic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Main_Register_Empleador extends AppCompatActivity {
    Button mbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__register__empleador);

        EditText etNombreDeLaPymes = (EditText) findViewById(R.id.nombreempleador);
        EditText etDirrecion = (EditText) findViewById(R.id.DirrecionEmpleador);
        EditText etEmail = (EditText) findViewById(R.id.emailempleador);
        EditText etPass = (EditText) findViewById(R.id.passemepleador);
        EditText etDescripccion = (EditText) findViewById(R.id.descripcion);
        final String nombre = etNombreDeLaPymes.getText().toString();
        final String dirrecion = etDirrecion.getText().toString();
        final String email = etEmail.getText().toString();
        final String pass = etPass.getText().toString();
        final String descripccion = etDescripccion.getText().toString();

        final BaseHelper helper = new BaseHelper(this);
        mbtn = (Button)findViewById(R.id.btnregistrateempleador);
        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean result=
                        helper.insertarRegistroEmpleador(nombre, dirrecion, email, pass, descripccion);
                if(result) {
                    Log.d("Se Incerto", "Bien");
                    helper.listarRegistrosEmpleador();
                }
            }
        });

    }
}
