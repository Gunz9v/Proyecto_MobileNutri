package com.gustavo.proyecto_nutricion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;

public class Detalles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);


        // Obtener el Intent que inició esta actividad
        Intent intent = getIntent();
        startService(new Intent(this, BackgroundSoundService.class));
        // Recuperar los valores de los extras usando las claves
        String nombre = intent.getStringExtra("nombre");
        String musculo = intent.getStringExtra("musculo");
        String detail1 = intent.getStringExtra("detail1");
        String detail2 = intent.getStringExtra("detail2");
        String detail3 = intent.getStringExtra("detail3");
        String detail4 = intent.getStringExtra("detail4");
        String videoURL = intent.getStringExtra("videoURL");
        // Ahora puedes usar los valores en tu actividad Detalles
        // Por ejemplo, establecer el texto en TextViews
        TextView textView1 = findViewById(R.id.nombreDetallesTextView);
        textView1.setText("Nombre: " + nombre);

        TextView textView2 = findViewById(R.id.caloriasDetallesTextView);
        textView2.setText("Tipo de ejercicios: " + musculo);

        TextView textView3 = findViewById(R.id.detailTextView3);
        textView3.setText(detail1);
        TextView textView4 = findViewById(R.id.detailTextView4);
        textView4.setText(detail2);
        TextView textView5 = findViewById(R.id.detailTextView5);
        textView5.setText(detail3);
        TextView textView6 = findViewById(R.id.detailTextView6);
        textView6.setText(detail4);


        WebView webView=findViewById(R.id.webViewYt);
        String video = "<iframe width=\"100%\" height=\"100%\" src=\"" + videoURL + "\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
        webView.loadData(video, "text/html", "utf-8");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());

        // y así sucesivamente para los demás valores...
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Detener el servicio de reproducción de sonido cuando la actividad se destruye
        stopService(new Intent(this, BackgroundSoundService.class));
    }

}