package com.example.deporte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class registrosUpperLower extends AppCompatActivity {

     Button b1, b2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registros_upper_lower);

        b1 = (Button) findViewById(R.id.regUpper);
        b2 = (Button) findViewById(R.id.regLower);

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intentact = new Intent(registrosUpperLower.this, TablaDeRegistros.class);
                startActivity(intentact);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v2) {
                Intent intentact2 = new Intent(registrosUpperLower.this, TablaDeRegistros2.class);
                startActivity(intentact2);
            }
        });

    }
    }