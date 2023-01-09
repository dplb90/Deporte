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

public class mostrarPull2 extends AppCompatActivity {

    public EditText tvnombre, etrepe1, etpeso1, etrepe2, etpeso2, etrepe3, etpeso3;
    public TextView tvfechas;

    String[] EjerPull = {"REMO c/b", "Remo Unilateral", "Jalon Elastico Unilateral", "Dominadas Supinas", "Elevación Trasera", "Curl Spider ", "Curl Concentrado", "Curl Inclinado"};
    int i = 0;

    String[] RepesPull1 = {"12","12", "20", "12", "15", "15", "17", "12"};
    int j = 0;

    String[] RepesPull2 = {"8", "10", "20", "10", "12", "12", "15", "12"};
    int k = 0;

    String[] RepesPull3 = {"6", "8", "20", "10", "10", "10", "12", "10"};
    int l = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_pull2);

        Date date = new Date();

        tvfechas = findViewById(R.id.textView);
        SimpleDateFormat fecha = new SimpleDateFormat("yyyy / MM / dd");
        String Fecha = fecha.format(date);
        tvfechas.setText(Fecha);


        etrepe1 = (EditText) findViewById(R.id.et1);
        etrepe2 = (EditText) findViewById(R.id.et2);
        etrepe3 = (EditText) findViewById(R.id.et3);
        etrepe1.setText(RepesPull1[j]);
        etrepe2.setText(RepesPull2[k]);
        etrepe3.setText(RepesPull3[l]);

        etpeso1 = (EditText) findViewById(R.id.et1_1);
        etpeso2 = (EditText) findViewById(R.id.et2_2);
        etpeso3 = (EditText) findViewById(R.id.et3_3);
        tvnombre = (EditText) findViewById(R.id.textNombre);
        tvnombre.setText(EjerPull[i]);
    }
    //metodo para guardar datos serie//
    public void Registrar(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "pruebaupper", null, 1);
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

            db.insert("upper", null, registro);

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

            db.insert("upper", null, registro);

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

            db.insert("upper", null, registro);

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


        if (i < 7) {
            i++;
            tvnombre.setText(EjerPull[i]);
        } else {
            tvnombre.setText("Finalizado!!!");
        }
        if (j < 7) {
            j++;
            etrepe1.setText(RepesPull1[j]);
        } else {
            etrepe1.setText("Fin");
        }
        if (k < 7) {
            k++;
            etrepe2.setText(RepesPull2[k]);
        } else {
            etrepe2.setText("Fin");
        }
        if (l < 7) {
            l++;
            etrepe3.setText(RepesPull3[l]);
        } else {
            etrepe3.setText("Fin");
        }


    }

}