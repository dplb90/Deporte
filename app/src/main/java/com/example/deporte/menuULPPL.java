package com.example.deporte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menuULPPL extends AppCompatActivity {

    Button b1,b2,b3,b4,b5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_ulppl);

        b1 = (Button) findViewById(R.id.buttonPush);
        b2 = (Button) findViewById(R.id.buttonPull);
        b3 = (Button) findViewById(R.id.buttonLegs);
        b4 = (Button) findViewById(R.id.buttonUpper);
        b5 = (Button) findViewById(R.id.buttonLower);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentb1 = new Intent(menuULPPL.this, mostrarPush.class);
                startActivity(intentb1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentb2 = new Intent(menuULPPL.this, mostrarPull.class);
                startActivity(intentb2);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentb3 = new Intent(menuULPPL.this, mostrarLegs.class);
                startActivity(intentb3);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentb4 = new Intent(menuULPPL.this, mostrarUpperBrazo.class);
                startActivity(intentb4);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentb5 = new Intent(menuULPPL.this, mostrarLower.class);
                startActivity(intentb5);
            }
        });
    }
}