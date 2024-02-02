package com.example.examen_2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Elementos.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Elementos (Id INTEGER PRIMARY KEY, Nombre TEXT, Simbolo TEXT,NumAtomico INTEGER,Estado TEXT)");
        db.execSQL("INSERT INTO Elementos VALUES(1,'HELIO','He',2,'GAS')");
        db.execSQL("INSERT INTO Elementos VALUES(2,'HIERRO','Fe',26,'SOLIDO')");
        db.execSQL("INSERT INTO Elementos VALUES(3,'MERCURIO','Hg',80,'LIQUIDO')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Elemento");
    }
}
