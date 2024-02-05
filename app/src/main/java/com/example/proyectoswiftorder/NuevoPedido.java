package com.example.proyectoswiftorder;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NuevoPedido extends AppCompatActivity {

    private Button btnGuardar, btnLimpiar;
    private EditText etCliente, etCedula, etDireccion, etFecha, etTelefono;

    // Obtén la referencia a la base de datos
    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("pedidos");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_pedido);

        btnGuardar = findViewById(R.id.btnGuardar);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        etCliente = findViewById(R.id.etCliente);
        etCedula = findViewById(R.id.editTextText8);
        etDireccion = findViewById(R.id.editTextText10);
        etFecha = findViewById(R.id.editTextText9);
        etTelefono = findViewById(R.id.editTextText11);

        // Configurar el onClickListener para el botón de guardar
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarPedido();
            }
        });

        // Configurar el onClickListener para el botón de limpiar
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpiarCampos();
            }
        });
    }

    public void Inicio(View view) {
        Intent Inicio = new Intent(this, com.example.proyectoswiftorder.Inicio.class);
        startActivity(Inicio);
    }

    public void guardarPedido() {
        // Obtén los valores de los EditText
        String cliente = etCliente.getText().toString();
        String cedula = etCedula.getText().toString();
        String direccion = etDireccion.getText().toString();
        String fecha = etFecha.getText().toString();
        String telefono = etTelefono.getText().toString();

        // Crea un nuevo nodo en la base de datos y obtén su referencia
        DatabaseReference nuevoPedidoRef = databaseReference.push();

        // Guarda los datos en el nodo recién creado
        nuevoPedidoRef.child("cliente").setValue(cliente);
        nuevoPedidoRef.child("cedula").setValue(cedula);
        nuevoPedidoRef.child("direccion").setValue(direccion);
        nuevoPedidoRef.child("fecha").setValue(fecha);
        nuevoPedidoRef.child("telefono").setValue(telefono);

        // Puedes añadir más campos según sea necesario

        // Limpiar los EditText después de guardar
        limpiarCampos();
    }

    public void limpiarCampos() {
        etCliente.setText("");
        etCedula.setText("");
        etDireccion.setText("");
        etFecha.setText("");
        etTelefono.setText("");


    }

}