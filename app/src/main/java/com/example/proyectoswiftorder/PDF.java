package com.example.proyectoswiftorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PDF extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

    }

        public void Regresar(View view) {
            Intent Regresar = new Intent(this, RevisarPedidos.class);
            startActivity(Regresar);
    }
}