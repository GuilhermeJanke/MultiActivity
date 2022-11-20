package com.example.app_multiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Tela2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        String nome = "", media = "", situacao = "";

        Intent it = getIntent();

        if (it != null){
            Bundle params = it.getExtras();
            if (params != null){
                nome = params.getString("nomeAluno");
                media = params.getString("media");
                situacao = params.getString("situacao");
            }
        }

        TextView nomeRecebe = findViewById(R.id.txtNomeRecebe);
        TextView mediaRecebe = findViewById(R.id.txtMediaRecebe);
        TextView situacaoRecebe = findViewById(R.id.txtSituacao);

        nomeRecebe.setText(nome);
        mediaRecebe.setText(media);
        situacaoRecebe.setText(situacao);

    }
}