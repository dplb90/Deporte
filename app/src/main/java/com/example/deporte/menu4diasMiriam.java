package com.example.deporte;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu4diasMiriam extends AppCompatActivity {

    Button b1,b2,b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu4dias_miriam);


        b1 = (Button) findViewById(R.id.buttonLegs);
        b2 = (Button) findViewById(R.id.buttonPush);
        b3 = (Button) findViewById(R.id.buttonLower);
        b4 = (Button) findViewById(R.id.buttonPull);




        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v1) {
                Intent intentb1 = new Intent(menu4diasMiriam.this, mostrarLegs.class);
                startActivity(intentb1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                Intent intentb2 = new Intent(menu4diasMiriam.this, mostrarPush.class);
                startActivity(intentb2);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v3) {
                Intent intentb3 = new Intent(menu4diasMiriam.this, mostrarLower.class);
                startActivity(intentb3);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v4) {
                Intent intentb4 = new Intent(menu4diasMiriam.this, mostrarPull.class);
                startActivity(intentb4);
            }
        });


    }
}