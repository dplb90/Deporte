package com.example.deporte;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class mostrarLegs extends AppCompatActivity {

    public EditText tvnombre, etrepe1, etpeso1, etrepe2, etpeso2, etrepe3, etpeso3;
    public TextView tvfechas;

    String[] EjerLegs = {"Curl Femoral", "SENTADILLA", "Hipthrust", "Landmine Hack", "Búlgara", "Extensión Cuádriceps", "Curl Femoral", "Gemelos Unilateral"};
    int i = 0;

    String[] RepesLegs1 = {"25","8", "20", "20", "12", "20", "15", "20"};
    int j = 0;

    String[] RepesLegs2 = {"20", "5", "15", "20", "10", "15", "12", "15"};
    int k = 0;

    String[] RepesLegs3 = {"15", "3", "12", "15", "10", "15", "10", "12"};
    int l = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_legs);


        if (savedInstanceState != null) {
            // restore the values of the variables
            i = savedInstanceState.getInt("indexEjerLegs");
            j = savedInstanceState.getInt("indexRepesLegs1");
            k = savedInstanceState.getInt("indexRepesLegs2");
            l = savedInstanceState.getInt("indexRepesLegs3");
            EjerLegs = savedInstanceState.getStringArray("EjerLegs");
            RepesLegs1 = savedInstanceState.getStringArray("RepesLegs1");
            RepesLegs2 = savedInstanceState.getStringArray("RepesLegs2");
            RepesLegs3 = savedInstanceState.getStringArray("RepesLegs3");
        }

        Date date = new Date();
        tvfechas = findViewById(R.id.textView);
        SimpleDateFormat fecha = new SimpleDateFormat("yyyy / MM / dd");
        String Fecha = fecha.format(date);
        tvfechas.setText(Fecha);

        etrepe1 = (EditText) findViewById(R.id.et1);
        etrepe2 = (EditText) findViewById(R.id.et2);
        etrepe3 = (EditText) findViewById(R.id.et3);
        etrepe1.setText(RepesLegs1[j]);
        etrepe2.setText(RepesLegs2[k]);
        etrepe3.setText(RepesLegs3[l]);
        etpeso1 = (EditText) findViewById(R.id.et1_1);
        etpeso2 = (EditText) findViewById(R.id.et2_2);
        etpeso3 = (EditText) findViewById(R.id.et3_3);
        tvnombre = (EditText) findViewById(R.id.textNombre);
        tvnombre.setText(EjerLegs[i]);
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
            try {
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
                Toast.makeText(this, "ejercicio grabado", Toast.LENGTH_SHORT).show();
            }catch(NumberFormatException e){
                Toast.makeText(this,"Ups! Dato inválido, no guardado",Toast.LENGTH_SHORT).show();
            }
                etpeso1.setText("");
                etpeso2.setText("");
                etpeso3.setText("");



        }else if(!peso1.isEmpty() && !peso2.isEmpty() && peso3.isEmpty()) {

            try {
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
                Toast.makeText(this, "ejercicio grabado", Toast.LENGTH_SHORT).show();
            }catch (NumberFormatException e){
                Toast.makeText(this,"Ups! Dato inválido, no guardado",Toast.LENGTH_SHORT).show();
            }
            etpeso1.setText("");
            etpeso2.setText("");
            etpeso3.setText("");


        }else if(!peso1.isEmpty() && peso2.isEmpty() && peso3.isEmpty()){
            try {
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
                Toast.makeText(this, "ejercicio grabado", Toast.LENGTH_SHORT).show();
            }catch (NumberFormatException e){
                Toast.makeText(this,"Ups! Dato inválido, no guardado",Toast.LENGTH_SHORT).show();
            }
            etpeso1.setText("");
            etpeso2.setText("");
            etpeso3.setText("");


        } else {

            etpeso1.setText("");
            etpeso2.setText("");
            etpeso3.setText("");

            Toast.makeText(this, "EJERCICIO NULO, NO GUARDADO", Toast.LENGTH_SHORT).show();

        }


        if (i < 7 && j < 7 && k < 7 && l < 7 ) {
            i++;
            j++;
            k++;
            l++;
            tvnombre.setText(EjerLegs[i]);
            etrepe1.setText(RepesLegs1[j]);
            etrepe2.setText(RepesLegs2[k]);
            etrepe3.setText(RepesLegs3[l]);

        } else {
            tvnombre.setText("Finalizado!!!");
            etrepe1.setText("Fin");
            etrepe2.setText("Fin");
            etrepe3.setText("Fin");
        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("indexEjerLegs", i);
        outState.putInt("indexRepesLegs1", j);
        outState.putInt("indexRepesLegs2", k);
        outState.putInt("indexRepesLegs3", l);
        outState.putStringArray("EjerLegs", EjerLegs);
        outState.putStringArray("RepesLegs1", RepesLegs1);
        outState.putStringArray("RepesLegs2", RepesLegs2);
        outState.putStringArray("RepesLegs3", RepesLegs3);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        i = savedInstanceState.getInt("indexEjerLegs");
        j = savedInstanceState.getInt("indexRepesLegs1");
        k = savedInstanceState.getInt("indexRepesLegs2");
        l = savedInstanceState.getInt("indexRepesLegs3");
        EjerLegs = savedInstanceState.getStringArray("EjerLegs");
        RepesLegs1 = savedInstanceState.getStringArray("RepesLegs1");
        RepesLegs2 = savedInstanceState.getStringArray("RepesLegs2");
        RepesLegs3 = savedInstanceState.getStringArray("RepesLegs3");
    }
}