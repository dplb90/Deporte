package com.example.deporte;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

public class TablaDeRegistros extends AppCompatActivity {

    TableLayout tabla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla_de_registros);

        tabla=(TableLayout) findViewById(R.id.tblayout);
        Consulta();
    }
    //metodo de consulta
    public void Consulta() {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "pruebaupper", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        Cursor cursor = db.rawQuery("select nombre,repes1,peso1,repes2,peso2,repes3,peso3,rm,fecha from upper", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            View layout = LayoutInflater.from(this).inflate(R.layout.item_data,null,false);
            TextView nombre=(TextView)layout.findViewById(R.id.tvNombre);
            TextView repes1=(TextView)layout.findViewById(R.id.tvrepes1);
            TextView peso1=(TextView)layout.findViewById(R.id.tvpeso1);
            TextView repes2=(TextView)layout.findViewById(R.id.tvrepes2);
            TextView peso2=(TextView)layout.findViewById(R.id.tvpeso2);
            TextView repes3=(TextView)layout.findViewById(R.id.tvrepes3);
            TextView peso3=(TextView)layout.findViewById(R.id.tvpeso3);
            TextView rm =(TextView)layout.findViewById(R.id.tvrm);
            TextView fecha=(TextView)layout.findViewById(R.id.tvFecha);

            nombre.setText(cursor.getString(0));
            repes1.setText(cursor.getString(1));
            peso1.setText(cursor.getString(2));
            repes2.setText(cursor.getString(3));
            peso2.setText(cursor.getString(4));
            repes3.setText(cursor.getString(5));
            peso3.setText(cursor.getString(6));
            rm.setText(cursor.getString(7));
            fecha.setText(cursor.getString(8));

            tabla.addView(layout);
            cursor.moveToNext();
        }

    }
}