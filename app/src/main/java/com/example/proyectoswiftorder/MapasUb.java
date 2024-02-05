package com.example.proyectoswiftorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapasUb extends AppCompatActivity implements OnMapReadyCallback {

    private Button btnCambiar,btnAnimar,btnCliente1,btnCliente2,btnCliente3,btnCliente4;
    private Spinner mapTypeSpinner;
    private GoogleMap mMap;
    private RadioButton rbtn;
    private RadioButton rbtn1;
    private RadioButton rbtn2;

    private RadioGroup rbtnG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapas_ub);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mapTypeSpinner = findViewById(R.id.mapTypeSpinner);
        btnCambiar = findViewById(R.id.btnCambiar);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.map_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mapTypeSpinner.setAdapter(adapter);

        btnCambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mapTypeIndex = mapTypeSpinner.getSelectedItemPosition();
                int mapType = getResources().getIntArray(R.array.map_type_values)[mapTypeIndex];
                mMap.setMapType(mapType);
            }
        });

        rbtn =findViewById(R.id.rbtn);
        rbtn1 = findViewById(R.id.rbtn1);
        rbtn2 = findViewById(R.id.rbtn2);
        rbtnG = findViewById(R.id.rbtnG);

        rbtnG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rbtn1) {
                    mMap.setMapStyle(
                            MapStyleOptions.loadRawResourceStyle(MapasUb.this, R.raw.style1));
                } if (checkedId == R.id.rbtn2) {
                    mMap.setMapStyle(
                            MapStyleOptions.loadRawResourceStyle(MapasUb.this, R.raw.style2));
                } if (checkedId == R.id.rbtn) {
                    mMap.setMapStyle(
                            MapStyleOptions.loadRawResourceStyle(MapasUb.this, R.raw.formato_mapa));
                }
            }
        });

        btnAnimar = (Button)findViewById(R.id.btnAnimar);
        btnAnimar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Confryval();
            }
        });

        btnCliente1 = (Button)findViewById(R.id.btnCliente1);
        btnCliente1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cliente1();
            }
        });

        btnCliente2 = (Button)findViewById(R.id.btnCliente2);
        btnCliente2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cliente2();
            }
        });

        btnCliente3 = (Button)findViewById(R.id.btnCliente3);
        btnCliente3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { CLiente3();
            }
        });

        btnCliente4 = (Button)findViewById(R.id.btnCliente4);
        btnCliente4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Cliente4();
            }
        });


    }

    private void loadStyle(String s) {
    }




    private void Confryval()
    {
        LatLng confryval = new LatLng(0.016484800117894195, -78.15052361831923);

        CameraPosition camPos = new CameraPosition.Builder()
                .target(confryval)   //Centramos el mapa en Egypto
                .zoom(20)         //Establecemos el zoom en 15
                .bearing(50)      //Establecemos la orientación con el noreste arriba
                .tilt(65)         //Bajamos el punto de vista de la cámara 65 grados
                .build();

        CameraUpdate camUpd3 =
                CameraUpdateFactory.newCameraPosition(camPos);




        mMap.animateCamera(camUpd3);
    }



    private void Cliente1() {
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(0.045939953373271, -78.13512772903043))
                .title("Cliente1: Abigail Cabezas"));

    }

    private void Cliente2() {
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(0.050372, -78.217394))
                .title("Cliente2: David Rojas"));
    }

    private void CLiente3() {
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(0.048428, -78.145314))
                .title("Cliente3: Giovanny Llumiquinga"));
    }

    private void Cliente4() {
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(0.036439, -78.125012))
                .title("Cliente4: Tatiana Estevez"));
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng quito = new LatLng(-0.22985, -78.52);
        mMap.addMarker(new MarkerOptions().position(quito).title("Marker in Quito"));
        LatLng cayambe = new LatLng(0.027936, -78.137192);
        mMap.addMarker(new MarkerOptions().position(cayambe).title("Marker in Cayambe"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(quito));

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            public void onMapClick(LatLng point) {
                Projection proj = mMap.getProjection();
                Point coord = proj.toScreenLocation(point);

                Toast.makeText(
                        MapasUb.this,
                        "Click\n" +
                                "Lat: " + point.latitude + "\n" +
                                "Lng: " + point.longitude + "\n" +
                                "X: " + coord.x + " - Y: " + coord.y,
                        Toast.LENGTH_LONG).show();
            }
        });

        mMap.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener() {
            public void onCameraChange(CameraPosition position) {
                Toast.makeText(
                        MapasUb.this,
                        "Cambio Cámara\n" +
                                "Lat: " + position.target.latitude + "\n" +
                                "Lng: " + position.target.longitude + "\n" +
                                "Zoom: " + position.zoom + "\n" +
                                "Orientación: " + position.bearing + "\n" +
                                "Ángulo: " + position.tilt,
                        Toast.LENGTH_SHORT).show();
            }
        });

        //Aplicamos el estilo personalizado de mapa
        mMap.setMapStyle(
                MapStyleOptions.loadRawResourceStyle(
                        this, R.raw.formato_mapa));


    }
}