package com.emplonic.brothersapp.emplonic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import static com.emplonic.brothersapp.emplonic.R.id.Nombre;

public class Main_Register extends AppCompatActivity {

    public static final int FORM_KEY = 1;

    public static final String NOMBRE_KEY = "nombre";
    public static final String APELLIDO_KEY = "apellido";
    public static final String EMAIL_KEY = "email";
    public static final String PASS_KEY = "pass";
    public static final String DESEMPEÑA_KEY = "desempaña";
    public static final String DIRECCION_KEY = "direccion";
    public static final String PROFECCION_KEY = "profeccion";

    Spinner spinner1;
    Spinner spinner2;
    Button mbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__register);

        //Llenado De Spinner
        //spinner1 = (Spinner)findViewById(R.id.Desempeña);
        //ArrayAdapter<String> adapter1 =
        //      new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.Empleos));
        //spinner1.setAdapter(adapter1);

        //spinner2 = (Spinner)findViewById(R.id.Sexo);
        //ArrayAdapter<String> adapter2 =
        //      new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.Sexo));
        //spinner2.setAdapter(adapter2);

        //Llenado de Las Variables de Los EditText y Spinner
        EditText etNombre = (EditText) findViewById(R.id.nombre);
        EditText etApellido = (EditText) findViewById(R.id.apellido);
        EditText spSexo = (EditText) findViewById(R.id.Sexo);
        EditText etUser = (EditText) findViewById(R.id.user);
        EditText etPass = (EditText) findViewById(R.id.pass);
        EditText spDesempeña = (EditText) findViewById(R.id.Desempeña);
        EditText etDirrecion = (EditText) findViewById(R.id.Direccion);
        EditText etProfeccion = (EditText) findViewById(R.id.profeccion);
        final String nombre = etNombre.getText().toString();
        final String apellido = etApellido.getText().toString();
        final String sexo = spSexo.getText().toString();
        final String email = etUser.getText().toString();
        final String pass = etPass.getText().toString();
        final String desempeña = spDesempeña.getText().toString();
        final String dirrecion = etDirrecion.getText().toString();
        final String profeccion = etProfeccion.getText().toString();

        //Base De Datos
        final EmploFindHelper helper = new EmploFindHelper(this);
        mbtn = (Button) findViewById(R.id.btnRegistrateEmplofind);
        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.insertarRegistro(nombre, apellido, sexo, email, pass, desempeña, dirrecion, profeccion);
                helper.listarRegistros();
            }
        });


}

}
