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

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener{

    private EditText etUser, etPass;
    private Button btnIngresar,btnRegistrar;

    private ProgressDialog progressDialog;
    private static final String TAG = "MainActivity";

    //Llamamos al autenticador
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);etUser = (EditText) findViewById(R.id.etUser);

        auth=FirebaseAuth.getInstance();

        etUser= (EditText) findViewById(R.id.etUser);
        etPass = (EditText) findViewById(R.id.etPass);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            String userE = etUser.getText().toString();
            String passE = etPass.getText().toString();
            //Ahora validamos por si uno de los campos esta vacío
            if (TextUtils.isEmpty(userE)) {
                //por si falta correo
                Toast.makeText(MainActivity.this, "Inserte correo", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(passE)) {
                //por si falta password
                Toast.makeText(MainActivity.this, "Inserte contraseña", Toast.LENGTH_SHORT).show();
                return;
            }

            //Ahora usamos el Auth para que se logee una vez registrado
            auth.signInWithEmailAndPassword(userE, passE).
                    //Le pasamos la clase registro
                            addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (!task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "El Usuario o la Contraseña son incorrectos", Toast.LENGTH_SHORT).show();
                                return;
                            }

                            Toast.makeText(MainActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();

                            Intent i = new Intent(MainActivity.this, Inicio.class);
                            startActivity(i);
                        }


                    });
        }

        ;
    });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(MainActivity.this, RegistroUS.class);
            startActivity(i);
        }
    });

}

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}