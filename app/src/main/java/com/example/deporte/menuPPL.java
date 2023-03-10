package com.example.deporte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menuPPL extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6,b7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_ppl);

        b1 = (Button) findViewById(R.id.buttonPush);
        b2 = (Button) findViewById(R.id.buttonPull);
        b3 = (Button) findViewById(R.id.buttonLegs);
        b4 = (Button) findViewById(R.id.buttonPush2);
        b5 = (Button) findViewById(R.id.buttonPull2);
        b6 = (Button) findViewById(R.id.buttonLower);
        b7 = (Button) findViewById(R.id.buttonVistaPreviappl);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentb1 = new Intent(menuPPL.this, mostrarPush.class);
                startActivity(intentb1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentb2 = new Intent(menuPPL.this, mostrarPull.class);
                startActivity(intentb2);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentb3 = new Intent(menuPPL.this, mostrarLegs.class);
                startActivity(intentb3);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentb4 = new Intent(menuPPL.this, mostrarPush2.class);
                startActivity(intentb4);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentb5 = new Intent(menuPPL.this, mostrarPull2.class);
                startActivity(intentb5);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentb6 = new Intent(menuPPL.this, mostrarLower.class);
                startActivity(intentb6);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentb7 = new Intent(menuPPL.this, VistaPreviaPPL.class);
                startActivity(intentb7);
            }
        });
    }
}