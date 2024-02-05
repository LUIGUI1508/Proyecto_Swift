package com.example.proyectoswiftorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NuevoProducto extends AppCompatActivity {

    private EditText etNombreProducto, etPresentacion, etPrecio, etDescripcion;
    private Button btnGuardar, btnCancelar,btnInicio;

    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_producto);

        // Inicializar Firebase
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("productos"); // "productos" es el nombre del nodo en la base de datos

        // Obtener referencias de los elementos de la interfaz de usuario
        etNombreProducto = findViewById(R.id.etNombreProducto);
        etPresentacion = findViewById(R.id.etPrimerNombre);
        etPrecio = findViewById(R.id.etSegundoNombre);
        etDescripcion = findViewById(R.id.etPrimerApellido);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnCancelar = findViewById(R.id.btnCancelar);
        btnInicio = findViewById(R.id.btnInicio);

        // Configurar el evento de clic para el botón de guardar
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarInformacion();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpiar();
            }
        });
    }

    private void limpiar() {
        etNombreProducto.setText("");
        etPresentacion.setText("");
        etPrecio.setText("");
        etDescripcion.setText("");
    }

    public void Inicio(View view) {
        Intent Inicio = new Intent(this, Inicio.class);
        startActivity(Inicio);
    }

    // Método para guardar la información en Firebase
    private void guardarInformacion() {
        String nombreProducto = etNombreProducto.getText().toString().trim();
        String presentacion = etPresentacion.getText().toString().trim();
        String precio = etPrecio.getText().toString().trim();
        String descripcion = etDescripcion.getText().toString().trim();

        // Verificar que los campos no estén vacíos antes de guardar
        if (!nombreProducto.isEmpty() && !presentacion.isEmpty() && !precio.isEmpty() && !descripcion.isEmpty()) {
            // Crear un nuevo objeto Producto
            Producto nuevoProducto = new Producto(nombreProducto, presentacion, precio, descripcion);

            // Generar una clave única para el nuevo producto
            String productoId = databaseReference.push().getKey();

            // Guardar el nuevo producto en la base de datos
            databaseReference.child(productoId).setValue(nuevoProducto);

            // Limpiar los campos después de guardar
            etNombreProducto.setText("");
            etPresentacion.setText("");
            etPrecio.setText("");
            etDescripcion.setText("");

            // Notificar al usuario que la información se guardó exitosamente (puedes agregar un Toast u otro tipo de mensaje)
        } else {
            // Mostrar un mensaje de error indicando que todos los campos son obligatorios
            // (puedes agregar un Toast u otro tipo de mensaje)
        }
    }


}