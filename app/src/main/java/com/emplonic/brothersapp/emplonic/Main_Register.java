package com.emplonic.brothersapp.emplonic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Main_Register extends AppCompatActivity {

    Spinner spinner1;
    Spinner spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__register);
        spinner1 = (Spinner)findViewById(R.id.Desempeña);
        ArrayAdapter<String> adapter1 =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.Empleos));
        spinner1.setAdapter(adapter1);

        spinner2 = (Spinner)findViewById(R.id.Sexo);
        ArrayAdapter<String> adapter2 =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.Sexo));
        spinner2.setAdapter(adapter2);

    }
}
