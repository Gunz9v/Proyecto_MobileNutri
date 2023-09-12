package com.gustavo.proyecto_nutricion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Detalles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        // Obtener el Intent que inició esta actividad
        Intent intent = getIntent();

        // Recuperar los valores de los extras usando las claves
        String nombre = intent.getStringExtra("nombre");
        String calorias = intent.getStringExtra("calorias");
        String detail1 = intent.getStringExtra("detail1");
        String detail2 = intent.getStringExtra("detail2");
        String detail3 = intent.getStringExtra("detail3");
        String detail4 = intent.getStringExtra("detail4");

        // Ahora puedes usar los valores en tu actividad Detalles
        // Por ejemplo, establecer el texto en TextViews
        TextView textView1 = findViewById(R.id.nombreDetallesTextView);
        textView1.setText("Nombre: " + nombre);

        TextView textView2 = findViewById(R.id.caloriasDetallesTextView);
        textView2.setText("Calorias: " + calorias);

        TextView textView3 = findViewById(R.id.detailTextView3);
        textView3.setText(detail1);
        TextView textView4 = findViewById(R.id.detailTextView4);
        textView4.setText(detail2);
        TextView textView5 = findViewById(R.id.detailTextView5);
        textView5.setText(detail3);
        TextView textView6 = findViewById(R.id.detailTextView6);
        textView6.setText(detail4);


        // y así sucesivamente para los demás valores...
    }
}