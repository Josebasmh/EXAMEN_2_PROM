package com.example.examen_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private EditText etNombre,etContasena;
    private ImageView imgError;
    private TextView tvError;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etNombre = findViewById(R.id.etNombre);
        etContasena = findViewById(R.id.etContrasena);
        imgError = findViewById(R.id.imgError);
        tvError = findViewById(R.id.tvError);
    }

    public void logear(View view) {

        if (!etNombre.getText().toString().equals("admin")){
            imgError.setImageDrawable(Drawable.createFromPath("@drawable/baseline_error_24"));
            tvError.setText("Nombre incorrecto.");
        } else if (!etContasena.getText().toString().equals("admin")) {
            imgError.setImageDrawable(Drawable.createFromPath("@drawable/baseline_error_24"));
            tvError.setText("Contraseña incorrecta.");
        }else {
            tvError.setText("");
            Intent i = new Intent(this, AdministrationActivity.class);
            startActivity(i);
            finish();
        }



    }

    public void volver(View view) {
        finish();
    }
}