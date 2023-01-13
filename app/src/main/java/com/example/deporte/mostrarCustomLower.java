package com.example.deporte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class mostrarCustomLower extends AppCompatActivity {

    public EditText tvnombre, etrepe1, etpeso1, etrepe2, etpeso2, etrepe3, etpeso3;
    public TextView tvfechas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_custom_lower);

        Date date = new Date();
        tvfechas = findViewById(R.id.textView);
        SimpleDateFormat fecha = new SimpleDateFormat("yyyy / MM / dd");
        String Fecha = fecha.format(date);
        tvfechas.setText(Fecha);


        etrepe1 = (EditText) findViewById(R.id.et1);
        etrepe2 = (EditText) findViewById(R.id.et2);
        etrepe3 = (EditText) findViewById(R.id.et3);
        etpeso1 = (EditText) findViewById(R.id.et1_1);
        etpeso2 = (EditText) findViewById(R.id.et2_2);
        etpeso3 = (EditText) findViewById(R.id.et3_3);
        tvnombre = (EditText) findViewById(R.id.textNombre);
        tvnombre.setText(" Inserte Ejercicio Lower");
        etrepe1.setText("1");
        etrepe2.setText("1");
        etrepe3.setText("1");

    }
    //metodo para guardar datos serie//
    public void Registrar(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "pruebalower1", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();


        String repes1 = etrepe1.getText().toString();
        String repes2 = etrepe2.getText().toString();
        String repes3 = etrepe3.getText().toString();
        String peso1 = etpeso1.getText().toString();
        String peso2 = etpeso2.getText().toString();
        String peso3 = etpeso3.getText().toString();
        String nombre = tvnombre.getText().toString();
        String tiempo = tvfechas.getText().toString();

        if (!peso1.isEmpty() && !peso2.isEmpty() && !peso3.isEmpty()) {
            int irepes3 = Integer.parseInt(repes3);
            int ipeso3 = Integer.parseInt(peso3);

            float RM = (float) (ipeso3 * (1 + 0.025 * irepes3));
            String rm = (Float.toString(RM) + " kg");

            ContentValues registro = new ContentValues();
            registro.put("nombre", nombre);
            registro.put("repes1", repes1);
            registro.put("peso1", peso1);
            registro.put("repes2", repes2);
            registro.put("peso2", peso2);
            registro.put("repes3", repes3);
            registro.put("peso3", peso3);
            registro.put("rm", rm);
            registro.put("fecha", tiempo);

            db.insert("lower", null, registro);

            db.close();

            etpeso1.setText("");
            etpeso2.setText("");
            etpeso3.setText("");

            Toast.makeText(this, "ejercicio grabado", Toast.LENGTH_SHORT).show();
        }else if(!peso1.isEmpty() && !peso2.isEmpty() && peso3.isEmpty()) {
            int irepes2 = Integer.parseInt(repes2);
            int ipeso2 = Integer.parseInt(peso2);

            float RM = (float) (ipeso2 * (1 + 0.025 * irepes2));
            String rm = (Float.toString(RM) + " kg");

            ContentValues registro = new ContentValues();
            registro.put("nombre", nombre);
            registro.put("repes1", repes1);
            registro.put("peso1", peso1);
            registro.put("repes2", repes2);
            registro.put("peso2", peso2);
            registro.put("repes3", repes3);
            registro.put("peso3", peso3);
            registro.put("rm", rm);
            registro.put("fecha", tiempo);

            db.insert("lower", null, registro);

            db.close();

            etpeso1.setText("");
            etpeso2.setText("");
            etpeso3.setText("");

            Toast.makeText(this, "ejercicio grabado", Toast.LENGTH_SHORT).show();

        }else if(!peso1.isEmpty() && peso2.isEmpty() && peso3.isEmpty()){
            int irepes1 = Integer.parseInt(repes1);
            int ipeso1 = Integer.parseInt(peso1);

            float RM = (float) (ipeso1 * (1 + 0.025 * irepes1));
            String rm = (Float.toString(RM) + " kg");

            ContentValues registro = new ContentValues();
            registro.put("nombre", nombre);
            registro.put("repes1", repes1);
            registro.put("peso1", peso1);
            registro.put("repes2", repes2);
            registro.put("peso2", peso2);
            registro.put("repes3", repes3);
            registro.put("peso3", peso3);
            registro.put("rm", rm);
            registro.put("fecha", tiempo);

            db.insert("lower", null, registro);

            db.close();

            etpeso1.setText("");
            etpeso2.setText("");
            etpeso3.setText("");

            Toast.makeText(this, "ejercicio grabado", Toast.LENGTH_SHORT).show();
        } else {


            etpeso1.setText("");
            etpeso2.setText("");
            etpeso3.setText("");

            Toast.makeText(this, "EJERCICIO NULO, NO GUARDADO", Toast.LENGTH_SHORT).show();
        }


    }
}