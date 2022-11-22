package com.example.app_multiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView frequencia = findViewById(R.id.txtFreq);
        frequencia.setFilters(new InputFilter[]{new MinMax("0.0","100.0")});
    }

    public void onClick (View view) {

        TextView nome = findViewById(R.id.txtNome);
        TextView nota1 = findViewById(R.id.txtNota1);
        TextView nota2 = findViewById(R.id.txtNota2);
        TextView frequencia = findViewById(R.id.txtFreq);

        Intent it = new Intent(this, Tela2.class);
        Bundle params = new Bundle();

        double nota1_calc, nota2_calc, media;
        int frequencia_calc;
        String nome_envio = nome.getText().toString();
        String situacao = "";

        nota1_calc = Double.parseDouble(nota1.getText().toString());
        nota2_calc = Double.parseDouble(nota2.getText().toString());

        if(nota1_calc < 0 || nota1_calc > 10 || nota2_calc < 0 || nota2_calc > 10) {
            Toast.makeText(this, "A nota deve ser um número entre 0 e 10", Toast.LENGTH_SHORT).show();
        }else {
            frequencia_calc = Integer.parseInt(frequencia.getText().toString());

            media = (nota1_calc + nota2_calc) / 2;

            if (frequencia_calc > 75) {

                if (media < 4) {
                    // reprovado por nota

                    situacao = "Reprovado por Nota";
                    String media_envia = String.valueOf(media);
                    params.putString("nomeAluno", nome_envio);
                    params.putString("situacao", situacao);
                    params.putString("media", media_envia);


                } else if (media >= 7) {
                    // aprovado

                    situacao = "Aprovado";
                    String media_envia = String.valueOf(media);
                    params.putString("nomeAluno", nome_envio);
                    params.putString("situacao", situacao);
                    params.putString("media", media_envia);


                } else {
                    //final
                    situacao = "Final";
                    String media_envia = String.valueOf(media);
                    params.putString("nomeAluno", nome_envio);
                    params.putString("situacao", situacao);
                    params.putString("media", media_envia);

                }
            } else {
                // reprovado por falta

                situacao = "Reprovado por Falta";
                String media_envia = String.valueOf(media);
                params.putString("nomeAluno", nome_envio);
                params.putString("situacao", situacao);
                params.putString("media", media_envia);
            }

            it.putExtras(params);
            startActivity(it);
        }
    }
}