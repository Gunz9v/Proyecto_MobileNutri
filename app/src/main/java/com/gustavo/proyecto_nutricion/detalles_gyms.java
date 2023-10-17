package com.gustavo.proyecto_nutricion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class detalles_gyms extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {
    EditText txtLatitud,txtLongitud;
    GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_gyms);

        txtLatitud=findViewById(R.id.txtLatitud);
        txtLongitud=findViewById(R.id.txtLongitud);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap=googleMap;
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnMapLongClickListener(this);

        LatLng peru=new LatLng(-11.9695698,-76.9947029);
        mMap.addMarker(new MarkerOptions().position(peru).title("Gym Mega Force"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(peru));

        LatLng megaForce=new LatLng(-11.9696779,-76.9944457);
        mMap.addMarker(new MarkerOptions().position(megaForce).title("Gym Hard Fit"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(megaForce));

        LatLng ramses=new LatLng(-11.9695549,-76.9937615);
        mMap.addMarker(new MarkerOptions().position(ramses).title("Gym Ramses"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ramses));
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        txtLatitud.setText(""+latLng.latitude);
        txtLongitud.setText(""+latLng.longitude);

    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        txtLatitud.setText(""+latLng.latitude);
        txtLongitud.setText(""+latLng.longitude);
    }
}