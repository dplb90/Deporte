package com.example.deporte;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table upper(id integer primary key autoincrement , nombre text, repes1 text, peso1 text, repes2 text, peso2 text, repes3 text, peso3 text,rm text, fecha text)");
        db.execSQL("create table lower(id integer primary key autoincrement , nombre text, repes1 text, peso1 text, repes2 text, peso2 text, repes3 text, peso3 text,rm text, fecha text)");



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
