package com.gustavo.proyecto_nutricion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class CargaApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_carga_app);

        //animaciones
        Animation animacion1= AnimationUtils.loadAnimation(this,R.anim.desplazamiento_arriba);
        Animation animacion2= AnimationUtils.loadAnimation(this,R.anim.desplazamiento_abajo);

        TextView txtPara = findViewById(R.id.txtPara);
        TextView txtGymrats = findViewById(R.id.txtGymrats);
        ImageView ivLogo=findViewById(R.id.ivLogo);

        txtPara.setAnimation(animacion2);
        txtGymrats.setAnimation(animacion2);
        ivLogo.setAnimation(animacion1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(CargaApp.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 4000);

    }
}