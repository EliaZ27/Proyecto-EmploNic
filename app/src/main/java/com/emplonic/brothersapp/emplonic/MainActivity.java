package com.emplonic.brothersapp.emplonic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity{

    Button mbtn;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbtn = (Button) findViewById(R.id.btnLogin);
        btn = (Button) findViewById(R.id.btnRegistrate);
        mbtn.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, Main_Drawer_Emplofind.class);
                    startActivity(intent);
            }
        });

        btn.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main_Register.class);
                startActivity(intent);
            }
        });


    }


}
