package com.example.proyectoswiftorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class RevisarPedidos extends AppCompatActivity {

    private RadioButton rbtnCliente,rbtnTotal;
    private EditText etCodigo;
    private EditText etFecha;
    private Button btnBuscarPedido,btnInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revisar_pedidos);

        rbtnCliente = (RadioButton) findViewById(R.id.rbtnCliente);
        rbtnTotal = (RadioButton) findViewById(R.id.rbtnTotal);
        etCodigo = (EditText) findViewById(R.id.etCodigo);
        etFecha = (EditText) findViewById(R.id.etFecha);

    }

    public void Inicio(View view) {
        Intent Inicio = new Intent(this, Inicio.class);
        startActivity(Inicio);
    }

    public void PDF(View view) {

        if (etCodigo.getText().toString().equals("101") &&
                rbtnCliente.isChecked()==true) {
            Intent PDF = new Intent(this, PDF.class);
            startActivity(PDF);}

        else {
            Intent PDF2 = new Intent(this, RevisarPedidos.class);
            startActivity(PDF2);}
    }
}