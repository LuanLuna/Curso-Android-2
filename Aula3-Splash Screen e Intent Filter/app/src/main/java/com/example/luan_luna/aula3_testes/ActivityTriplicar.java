package com.example.luan_luna.aula3_testes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTriplicar extends AppCompatActivity {
    private int result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triplicar);

        TextView t = (TextView) findViewById(R.id.textView2);//captura o textview da tela
        Intent i = getIntent();//captura a intent vinda da outra tela
        if(i != null) {//verifica se a intent não veio nula
            Bundle b = i.getExtras();//recebe o bundle que está dentro da intent
            if (b != null) {//verifica se o bundle está nullo
                int num = b.getInt("NUMERO");//recebe o numero vindo da intent
                result = num * 3;//muitiplica por três
                t.setText("Número: " + num + " TRIPLO: " + result);//põe o resultado no textview
            } else {
                t.setText("Resultado: ");
            }
        }
        ((Button)findViewById(R.id.button)).setOnClickListener(new onClick());//adiciona o evento de onclick ao botão
    }
    private class onClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            finish();//destroy a activity
        }
    }
}
