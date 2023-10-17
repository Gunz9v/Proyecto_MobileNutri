package com.gustavo.proyecto_nutricion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.airbnb.lottie.LottieAnimationView;
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
    boolean islikedone=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_gyms);
        LottieAnimationView likeIV= findViewById(R.id.likeIV);
        likeIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (islikedone){
                    likeIV.setSpeed(-1);
                    likeIV.playAnimation();
                    islikedone=false;
                }else {
                    likeIV.setSpeed(1);
                    likeIV.playAnimation();
                    islikedone=true;
                }
            }
        });
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