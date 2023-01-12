package com.example.deporte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu5diasBrazos extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu5dias_brazos);

        b1 = (Button) findViewById(R.id.buttonUpperArm);
        b2 = (Button) findViewById(R.id.buttonLegsArm);
        b3 = (Button) findViewById(R.id.buttonPushArm);
        b4 = (Button) findViewById(R.id.buttonPullArm);
        b5 = (Button) findViewById(R.id.buttonLowerarm);
        b6 = (Button) findViewById(R.id.buttonPreviaArms);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentb1 = new Intent(menu5diasBrazos.this, mostrarUpperArms.class);
                startActivity(intentb1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentb2 = new Intent(menu5diasBrazos.this, mostrarLegs.class);
                startActivity(intentb2);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentb3 = new Intent(menu5diasBrazos.this, mostrarPushArms.class);
                startActivity(intentb3);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentb4 = new Intent(menu5diasBrazos.this, mostrarPullArms.class);
                startActivity(intentb4);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentb5 = new Intent(menu5diasBrazos.this, mostrarLegsArms.class);
                startActivity(intentb5);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentb6 = new Intent(menu5diasBrazos.this, VistaPreviaArms.class);
                startActivity(intentb6);
            }
        });
    }
}