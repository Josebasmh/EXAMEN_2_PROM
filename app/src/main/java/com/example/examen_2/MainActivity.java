package com.example.examen_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvConsulta;
    static Integer cont = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvConsulta = findViewById(R.id.tvConsultas);
    }

    public void cargarConsulta(View view) {
        Intent i = new Intent(this,SearchActivity.class);
        startActivity(i);
        refrescarContador();
    }

    public void cargarQuimico(View view) {
        Intent i = new Intent(this,LoginActivity.class);
        startActivity(i);
    }

    public void salir(View view) {
        Toast.makeText(getApplicationContext(), "Adiós, vuelva pronto", Toast.LENGTH_SHORT).show();
        finish();
    }
    private void refrescarContador(){
        tvConsulta.setText(cont+"");
    }
}