package com.example.examen_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdministrationActivity extends AppCompatActivity {

    private EditText etId,etNombre,etSimbolo,etNumAtomico,etEstado;
    private DBHelper dbHelper;
    private boolean bModificar= false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administration);

        etId = findViewById(R.id.Id);
        etNombre = findViewById(R.id.Nombre);
        etSimbolo = findViewById(R.id.Simbolo);
        etNumAtomico = findViewById(R.id.NumAtomico);
        etEstado = findViewById(R.id.Estado);

        dbHelper = new DBHelper(this);
    }

    public void insertar(View view) {
        int cantidad = comprobacion();
        if (cantidad > 0){
            Toast.makeText(getApplicationContext(), "No se pudo crear (Nombre existente).", Toast.LENGTH_SHORT).show();
        }else{
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            int id = Integer.parseInt(etId.getText().toString());
            String nombre = etNombre.getText().toString();
            String simbolo = etSimbolo.getText().toString();
            Integer numAtomico = Integer.parseInt(etNumAtomico.getText().toString());
            String estado = etEstado.getText().toString();

            ContentValues valores = new ContentValues();
            valores.put("Id",id);
            valores.put("Nombre",nombre);
            valores.put("Simbolo",simbolo);
            valores.put("NumAtomico",numAtomico);
            valores.put("Estado",estado);
            db.insert("Elementos",null,valores);
            if(!bModificar){
                Toast.makeText(getApplicationContext(), nombre+" creado correctamente", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void borrar(View view) {
        int cantidad = comprobacion();
        if (cantidad > 0){
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            db.delete("Elementos","Nombre = ?",new String[]{String.valueOf(etNombre)});
            if (!bModificar){
                Toast.makeText(getApplicationContext(), etNombre.getText().toString()+" eliminado correctamente", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getApplicationContext(), "No se pudo eliminar (Nombre inexistente).", Toast.LENGTH_SHORT).show();
        }
    }

    public void modificar(View view) {
        int cantidad = comprobacion();
        if (cantidad > 0){
            bModificar = true;
            borrar(view);
            insertar(view);
            bModificar=false;
            Toast.makeText(getApplicationContext(), etNombre.getText().toString()+" eliminado correctamente", Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(getApplicationContext(), "No se pudo modificar (Nombre inexistente).", Toast.LENGTH_SHORT).show();
        }
    }

    public void volver(View view) {
        finish();
    }

    private int comprobacion() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM Elementos WHERE Nombre = '"+etNombre.getText().toString()+"';",null);
        int i=0;
        if (cursor.moveToFirst()){
            do{
                i = cursor.getInt(cursor.getColumnIndexOrThrow("COUNT(*)"));
            }while(cursor.moveToNext());
        }
        return i;
    }
}