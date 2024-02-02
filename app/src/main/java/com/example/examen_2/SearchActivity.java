package com.example.examen_2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {

    private EditText etConsulta,etId,etNombre,etSimbolo,etNumAtomico,etEstado;
    private Button btnBuscar;
    private boolean bLimpiar = false;
    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        btnBuscar = findViewById(R.id.btnBuscar);
        etConsulta = findViewById(R.id.etConsulta);
        etId = findViewById(R.id.Id);
        etNombre = findViewById(R.id.Nombre);
        etSimbolo = findViewById(R.id.Simbolo);
        etNumAtomico = findViewById(R.id.NumAtomico);
        etEstado = findViewById(R.id.Estado);

        dbHelper = new DBHelper(this);
    }

    public void buscarNombre(View view) {
        if(!bLimpiar){
            Elemento c = buscarConsulta();
            etId.setText(c.getId().toString());
            etNombre.setText(c.getNombre());
            etSimbolo.setText(c.getSimbolo());
            etNumAtomico.setText(c.getNumAtomico().toString());
            etEstado.setText(c.getEstado());
            bLimpiar = true;
            btnBuscar.setText("Limpiar");
        }else{
            etId.setText("");
            etNombre.setText("");
            etSimbolo.setText("");
            etNumAtomico.setText("");
            etEstado.setText("");
            btnBuscar.setText("Buscar");
            bLimpiar=false;
        }
    }

    private Elemento buscarConsulta() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT Id,Nombre,Simbolo,NumAtomico,Estado FROM Elementos" +
                " WHERE Nombre LIKE '%"+etConsulta.getText()+"%'",null);
        Elemento e=null;
        if (cursor.moveToFirst()){
            do{
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("Id"));
                String nombre = cursor.getString(cursor.getColumnIndexOrThrow("Nombre"));
                String simbolo = cursor.getString(cursor.getColumnIndexOrThrow("Simbolo"));
                Integer numAtomico = cursor.getInt(cursor.getColumnIndexOrThrow("NumAtomico"));
                String estado = cursor.getString(cursor.getColumnIndexOrThrow("Estado"));
                e = new Elemento(id,nombre,simbolo,numAtomico,estado);
            }while(cursor.moveToNext());
        }
        cursor.close();
        MainActivity.cont++;
        return e;
    }

    public void volver(View view) {
        finish();
    }
}