package com.example.recyclerview;

import android.os.Bundle;

import com.example.recyclerview.models.Receitas;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinkedList<Receitas> listaDeReceitas = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        listaDeReceitas.add(new Receitas("Pao", "Quentinho bla bla bla bla bla bla bla"));
        listaDeReceitas.add(new Receitas("Sonho", "Gostoso bla bla bla bla bla bla bla"));
        listaDeReceitas.add(new Receitas("Pipoca", "Quentinho bla bla bla bla bla bla bla"));
        listaDeReceitas.add(new Receitas("Ruffles", "Churrasco bla bla bla bla bla bla bla"));
        listaDeReceitas.add(new Receitas("Manteiga", "Quentinho bla bla bla bla bla bla bla"));
        listaDeReceitas.add(new Receitas("Coco", "Gelado bla bla bla bla bla bla bla"));

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        ListagemAdapter adapter = new ListagemAdapter(this, listaDeReceitas);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // Vertical

    }
}