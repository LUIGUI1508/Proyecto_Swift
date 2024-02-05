package com.example.proyectoswiftorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ValidarPassword extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    private EditText etUser1, etPass1;
    private Button btnValidar;

    private ProgressDialog progressDialog;
    private static final String TAG = "ValidarPassword";

    //Llamamos al autenticador
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validar_password);

        etUser1 = (EditText) findViewById(R.id.etUser1);
        etPass1 = (EditText) findViewById(R.id.etPass1);
        btnValidar = (Button) findViewById(R.id.btnValidar);
        auth = FirebaseAuth.getInstance();

        btnValidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userE = etUser1.getText().toString();
                String passE = etPass1.getText().toString();

                if (TextUtils.isEmpty(userE)) {
                    //por si falta correo
                    Toast.makeText(ValidarPassword.this, "El usuario no ha verificado su correo electrónico", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(passE)) {
                    //por si falta password
                    Toast.makeText(ValidarPassword.this, "La autenticación ha fallado. Por favor, verifique sus credenciales.", Toast.LENGTH_SHORT).show();
                    return;
                }

                auth.signInWithEmailAndPassword(userE, passE).addOnCompleteListener(ValidarPassword.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(ValidarPassword.this, "El Usuario o la Contraseña son incorrectos", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        Toast.makeText(ValidarPassword.this, "Bienvenido", Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(ValidarPassword.this, NuevoProducto.class);
                        startActivity(i);
                    }
                });
            }
        });

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}