package com.emplonic.brothersapp.emplonic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Main_Agregar_Empleo extends AppCompatActivity {

    Spinner spinner1;
    Spinner spinner2;
    Button mbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__agregar__empleo);

        //spinner1 = (Spinner)findViewById(R.id.Empleo);
        //ArrayAdapter<String> adapter1 =
          //      new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.Empleos));
        //spinner1.setAdapter(adapter1);

        //spinner2 = (Spinner)findViewById(R.id.TipoCont);
        //ArrayAdapter<String> adapter2 =
          //      new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.Contarto));
        //spinner2.setAdapter(adapter2);

        EditText etNombrePoE = (EditText) findViewById(R.id.NombrePoE);
        EditText etEmpleo = (EditText) findViewById(R.id.Empleo1);
        EditText ettipocontrato = (EditText) findViewById(R.id.TipoContrato);
        EditText etdireccion = (EditText) findViewById(R.id.Dirrecion1);
        EditText etsueldo = (EditText) findViewById(R.id.Sueldo);
        EditText etrequisitos = (EditText) findViewById(R.id.Requisitos);
        final String nombre = etNombrePoE.getText().toString();
        final String empleo = etEmpleo.getText().toString();
        final String tipocontrato = ettipocontrato.getText().toString();
        final String direccion = etdireccion.getText().toString();
        final String sueldo = etsueldo.getText().toString();
        final String requisitos = etrequisitos.getText().toString();
        final EmpleoHelper helper = new EmpleoHelper(this);
        mbtn = (Button) findViewById(R.id.btnAgregarEmpleo);
        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.insertarRegistro(nombre, empleo, tipocontrato, direccion, sueldo, requisitos);
                helper.listarRegistros();
            }
        });
    }
}
