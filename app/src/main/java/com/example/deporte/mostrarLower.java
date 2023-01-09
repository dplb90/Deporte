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

public class mostrarLower extends AppCompatActivity {

    public EditText tvnombre, etrepe1, etpeso1, etrepe2, etpeso2, etrepe3, etpeso3;
    public TextView tvfechas;

    String[] EjerLower = {"PESO MUERTO", "Curl Femoral", "Extensión Cuádriceps", "SENTADILLA FRONTAL", "Goblet", "Gemelos Unilateral"};
    int i = 0;

    String[] RepesLower1 = {"5","15", "20", "15", "15", "20"};
    int j = 0;

    String[] RepesLower2 = {"5", "12", "15", "15", "12", "15"};
    int k = 0;

    String[] RepesLower3 = {"5", "12", "15", "15", "12", "15"};
    int l = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_lower);

        Date date = new Date();
        tvfechas = findViewById(R.id.textView);
        SimpleDateFormat fecha = new SimpleDateFormat("yyyy / MM / dd");
        String Fecha = fecha.format(date);
        tvfechas.setText(Fecha);

        etrepe1 = (EditText) findViewById(R.id.et1);
        etrepe2 = (EditText) findViewById(R.id.et2);
        etrepe3 = (EditText) findViewById(R.id.et3);
        etrepe1.setText(RepesLower1[j]);
        etrepe2.setText(RepesLower2[k]);
        etrepe3.setText(RepesLower3[l]);
        etpeso1 = (EditText) findViewById(R.id.et1_1);
        etpeso2 = (EditText) findViewById(R.id.et2_2);
        etpeso3 = (EditText) findViewById(R.id.et3_3);
        tvnombre = (EditText) findViewById(R.id.textNombre);
        tvnombre.setText(EjerLower[i]);
    }

    //metodo para guardar datos serie//
    public void Registrar(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "pruebalower", null, 1);
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


        if (i < 5) {
            i++;
            tvnombre.setText(EjerLower[i]);
        } else {
            tvnombre.setText("Finalizado!!!");
        }
        if (j < 5) {
            j++;
            etrepe1.setText(RepesLower1[j]);
        } else {
            etrepe1.setText("Fin");
        }
        if (k < 5) {
            k++;
            etrepe2.setText(RepesLower2[k]);
        } else {
            etrepe2.setText("Fin");
        }
        if (l < 5) {
            l++;
            etrepe3.setText(RepesLower3[l]);
        } else {
            etrepe3.setText("Fin");
        }


    }
}