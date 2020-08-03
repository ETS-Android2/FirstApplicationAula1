package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.recyclerview.models.Receitas;

public class DetalhesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        Intent intent = getIntent();
        Receitas receitas = (Receitas) intent.getSerializableExtra(ListagemAdapter.DETALHES_KEY);

        TextView textView = findViewById(R.id.detalher_title);
        textView.setText(receitas.getName());
    }
}