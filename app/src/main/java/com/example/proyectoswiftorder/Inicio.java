package com.example.proyectoswiftorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inicio extends AppCompatActivity {

    private Button btnNuevoPedido,btnRevisarPedido,btnNuevoCliente,btnNuevoProducto,btnCatalogo,btnLocalizacion,btnMapasUb,btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        btnNuevoPedido=(Button) findViewById(R.id.btnNuevoPedido);
        btnRevisarPedido=(Button) findViewById(R.id.btnRevisarPedido);
        btnNuevoCliente=(Button) findViewById(R.id.btnNuevoCliente);
        btnNuevoProducto=(Button) findViewById(R.id.btnNuevoProducto);
        btnCatalogo=(Button) findViewById(R.id.btnCatalogo);
        btnLocalizacion=(Button) findViewById(R.id.btnLocalizacion);
        btnMapasUb=(Button) findViewById(R.id.btnMapasUb);

    }

    public void MapasUb(View view) {
        Intent mapas = new Intent(this, MapasUb.class);
        startActivity(mapas);}

    public void Localizacion(View view) {
        Intent localizacionIntent = new Intent(this, Localizacion.class);
        startActivity(localizacionIntent);}

    public void Salir(View view) {
        Intent Salir = new Intent(this, MainActivity.class);
        startActivity(Salir);}

   public void Pedido(View view) {
        Intent Pedido = new Intent(this, NuevoPedido.class);
        startActivity(Pedido);}

    public void Cliente(View view) {
        Intent Cliente = new Intent(this, NuevoCliente.class);
        startActivity(Cliente);}

    public void Producto(View view) {
        Intent Producto = new Intent(this, ValidarPassword.class);
        startActivity(Producto);}

    public void RevisarPedido(View view) {
        Intent Revisar = new Intent(this, RevisarPedidos.class);
        startActivity(Revisar);}

   /* public void Catalogo(View view) {
        Intent Revisar = new Intent(this, Catalogo.class);
        startActivity(Revisar);}*/


}