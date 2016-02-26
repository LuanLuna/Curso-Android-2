package com.example.luan_luna.aula3_testes;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity implements Runnable{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        Handler h = new Handler();
        h.postDelayed(this,5000);
    }

    @Override
    public void run() {
        Intent t = new Intent(this, MainActivity.class);
        startActivity(t);
        finish();
    }
}
