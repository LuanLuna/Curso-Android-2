package com.example.luan_luna.aula3_testes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int numero = 0;//VARIÁVEL QUE IRÁ RECEBER O NÚMERO QUE O USUÁRIO DIGITAR
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ATRIBUI OS EVENTOS DE CLICK AOS BOTÕES NA TELA
        ((Button)findViewById(R.id.button2)).setOnClickListener(new Multiplicar("MULTIPLICAR", null));//NULL POIS QUEREMOS A INTENT SEM CATEGORIA
        ((Button)findViewById(R.id.button4)).setOnClickListener(new Multiplicar("MULTIPLICAR", "DUPLICAR"));
        ((Button)findViewById(R.id.button5)).setOnClickListener(new Multiplicar("MULTIPLICAR", "TRIPLICAR"));
    }
    //CAPTURA O NUMERO DIGITADO PELO USUÁRIO
    private void capturarNumero() throws NumberFormatException{
        String s = ((EditText)findViewById(R.id.editText)).getText().toString();//CAPTURA O VALOR
        numero = Integer.parseInt(s);//FAZ UM CAST DO VALOR PARA INTEIRO
    }
    //CLASSE QUE REPRESENTA O CLICK NO BOTÃO DE MULTIPLICAR
    private class Multiplicar implements View.OnClickListener {
        private String action;
        private String category;

        Multiplicar(String action, String category){//construtor da classe de evento
            this.action = action;//ação da intent
            this.category = category;//categoria da intent
        }

        @Override
        public void onClick(View v) {
            try {
                capturarNumero();
                Intent i = new Intent(this.action);//CRIA A INTENT COM A ACTION MULTIPLICAR
                if (this.category != null)//caso a categoria não seja nula
                    i.addCategory(this.category);//ADICIONA A CATEGORY DORBRO A INTENT
                Bundle b = new Bundle();//CRIA O BUNDLE PARA LEVAR OS DADOS ATÉ A OUTRA TELA
                b.putInt("NUMERO", numero);//COLOCA O NUMERO DIGITADO NO BUNDLE
                i.putExtras(b);//COLOCA O BUNDLE NA INTENT
                startActivity(i);//CHAMA A ACTIVITY
            }catch (NumberFormatException ne){
                Toast.makeText(v.getContext(),"Valor inválido",Toast.LENGTH_LONG).show();//MOSTRA UMA MENSAGEM DE ERRO CASO OCORRA
            }
        }
    }
}
