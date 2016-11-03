package com.emplonic.brothersapp.emplonic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{


    Button mbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbtn = (Button) findViewById(R.id.btnLogin);
        mbtn.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main_Drawer_Emplofind.class);
                startActivity(intent);
            }

        });
    }


}
