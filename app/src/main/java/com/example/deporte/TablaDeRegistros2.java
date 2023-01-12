package com.example.deporte;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TablaDeRegistros2 extends AppCompatActivity {

    Button btn;
    EditText et;
    TableLayout tabla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla_de_registros2);

        tabla=(TableLayout) findViewById(R.id.tblayout);
        et=(EditText) findViewById(R.id.etborrar);
        btn =(Button)findViewById(R.id.buttonborrar);
        Consulta2();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = et.getText().toString();
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(TablaDeRegistros2.this, "pruebalower1", null, 1);
                SQLiteDatabase db = admin.getWritableDatabase();
                try {
                    int totalRows = tabla.getChildCount();
                    boolean found = false;
                    for (int i = 1; i < totalRows; i++) {
                        View view = tabla.getChildAt(i);
                        TextView idView = (TextView) view.findViewById(R.id.tvid);
                        if (idView.getText().toString().equals(id)) {
                            tabla.removeViewAt(i);
                            db.execSQL("DELETE FROM lower WHERE id = " + id);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        throw new Exception("El id no existe");
                    }
                } catch (Exception e) {
                    Toast.makeText(TablaDeRegistros2.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                } finally {
                    db.close();
                    et.setText("");
                }
            }
        });

    }
    //metodo de consulta
    public void Consulta2() {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "pruebalower1", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        Cursor cursor = db.rawQuery("select id,nombre,repes1,peso1,repes2,peso2,repes3,peso3,rm,fecha from lower", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            View layout = LayoutInflater.from(this).inflate(R.layout.item_data,null,false);
            TextView id=(TextView)layout.findViewById(R.id.tvid) ;
            TextView nombre=(TextView)layout.findViewById(R.id.tvNombre);
            TextView repes1=(TextView)layout.findViewById(R.id.tvrepes1);
            TextView peso1=(TextView)layout.findViewById(R.id.tvpeso1);
            TextView repes2=(TextView)layout.findViewById(R.id.tvrepes2);
            TextView peso2=(TextView)layout.findViewById(R.id.tvpeso2);
            TextView repes3=(TextView)layout.findViewById(R.id.tvrepes3);
            TextView peso3=(TextView)layout.findViewById(R.id.tvpeso3);
            TextView rm =(TextView)layout.findViewById(R.id.tvrm);
            TextView fecha=(TextView)layout.findViewById(R.id.tvFecha);

            id.setText(cursor.getString(0));
            nombre.setText(cursor.getString(1));
            repes1.setText(cursor.getString(2));
            peso1.setText(cursor.getString(3));
            repes2.setText(cursor.getString(4));
            peso2.setText(cursor.getString(5));
            repes3.setText(cursor.getString(6));
            peso3.setText(cursor.getString(7));
            rm.setText(cursor.getString(8));
            fecha.setText(cursor.getString(9));

            tabla.addView(layout);
            cursor.moveToNext();
        }

    }
}