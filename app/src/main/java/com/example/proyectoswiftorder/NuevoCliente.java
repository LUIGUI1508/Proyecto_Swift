package com.example.proyectoswiftorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NuevoCliente extends AppCompatActivity {

    private Button btnCancelar,btnGuardarCodigo,btnInicio;
    private EditText etCedula, etPrimerNombre, etSegundoNombre, etPrimerApellido, etSegundoApellido,etCelular,etDireccion;

  /* private TextView etvNuevoCodigo;
    private int counter = 0;*/

    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("clientes");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_cliente);

        btnCancelar= (Button) findViewById(R.id.btnCancelar);
        btnGuardarCodigo=(Button) findViewById(R.id.btnGuardar);
        btnCancelar= (Button) findViewById(R.id.btnCancelar);
        etCedula = (EditText) findViewById(R.id.etCedula);
        etPrimerNombre = (EditText) findViewById(R.id.etPrimerNombre);
        etSegundoNombre = (EditText) findViewById(R.id.etSegundoNombre);
        etPrimerApellido = (EditText) findViewById(R.id.etPrimerApellido);
        etSegundoApellido = (EditText) findViewById(R.id.etSegundoApellido);
        etCelular = (EditText) findViewById(R.id.etCelular);
        etDireccion = (EditText) findViewById(R.id.etDireccion);
        /*etvNuevoCodigo = (TextView) findViewById(R.id.etvNuevoCodigo);
        btnGenerar = (Button) findViewById(R.id.btnGenerar);*/





        btnGuardarCodigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generar();
            }
        });

        // Configurar el onClickListener para el botón de limpiar
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpiarCampos();
            }
        });
    }

    public void Inicio(View view) {
        Intent Inicio = new Intent(this, Inicio.class);
        startActivity(Inicio);
    }

    public void generar() {
        // Obtén los valores de los EditText
        String cedula = etCedula.getText().toString();
        String nombre1 = etPrimerNombre.getText().toString();
        String nombre2 = etSegundoNombre.getText().toString();
        String apellido1 = etPrimerApellido.getText().toString();
        String apellido2 = etSegundoApellido.getText().toString();
        String celular = etCelular.getText().toString();
        String direccion = etDireccion.getText().toString();


        // Crea un nuevo nodo en la base de datos y obtén su referencia
        DatabaseReference nuevoClienteRef = databaseReference.push();

        // Guarda los datos en el nodo recién creado
        nuevoClienteRef.child("cedula").setValue(cedula);
        nuevoClienteRef.child("nombre1").setValue(nombre1);
        nuevoClienteRef.child("nombre2").setValue(nombre2);
        nuevoClienteRef.child("apellido1").setValue(apellido1);
        nuevoClienteRef.child("apellido2").setValue(apellido2);
        nuevoClienteRef.child("celular").setValue(celular);
        nuevoClienteRef.child("direccion").setValue(direccion);


        // Puedes añadir más campos según sea necesario

        // Limpiar los EditText después de guardar
       limpiarCampos();
    }

    public void limpiarCampos() {
        etCedula.setText("");
        etPrimerNombre.setText("");
        etSegundoNombre.setText("");
        etPrimerApellido.setText("");
        etSegundoApellido.setText("");
        etCelular.setText("");
        etDireccion.setText("");

    }

}
