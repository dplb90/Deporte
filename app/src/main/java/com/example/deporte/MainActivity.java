package com.example.deporte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6,b7,b8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.buttonULPPL);
        b2 = (Button) findViewById(R.id.button6Days);
        b3 = (Button) findViewById(R.id.buttonGirls);
        b4 = (Button) findViewById(R.id.button5diasbrazos);
        b5 = (Button) findViewById(R.id.buttonCustomUpper);
        b6 = (Button) findViewById(R.id.buttonCustomLower);
        b7 = (Button) findViewById(R.id.buttonRegistro);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent intent1 = new Intent(MainActivity.this, menuULPPL.class);
                startActivity(intent1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent intent2 = new Intent(MainActivity.this, menuPPL.class);
                startActivity(intent2);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent intent3 = new Intent(MainActivity.this, menu4diasMiriam.class);
                startActivity(intent3);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent intent4 = new Intent(MainActivity.this, menu5diasBrazos.class);
                startActivity(intent4);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v5) {
                Intent intent5 = new Intent(MainActivity.this, mostrarCustomUpper.class);
                startActivity(intent5);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v6) {
                Intent intent6 = new Intent(MainActivity.this, mostrarCustomLower.class);
                startActivity(intent6);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v7) {
                Intent intent7 = new Intent(MainActivity.this, registrosUpperLower.class);
                startActivity(intent7);
            }
        });


    }
}