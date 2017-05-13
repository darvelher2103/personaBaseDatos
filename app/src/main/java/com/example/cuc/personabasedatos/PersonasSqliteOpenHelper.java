package com.example.cuc.personabasedatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by CUC on 13/05/2017.
 */

public class PersonasSqliteOpenHelper extends SQLiteOpenHelper{
    private String sql = "CREATE TABLE Personas (foto text, cedula text, nombre text, apellido text, sexo text, pasatiempo text)";

    public PersonasSqliteOpenHelper(Context contexto, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(contexto, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //se ejecuta cada vez que abrimos la escritura o lectura de la bd (verifica si existe alguna version)
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE OF EXISTS Personas");
        db.execSQL(sql);
    }
}
