package com.example.searchcep.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.searchcep.R;
import com.example.searchcep.model.Dev;
import com.example.searchcep.repository.DevRepository;
import com.example.searchcep.service.RequestResult;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private DevRepository retrofit = null;
    private List<Dev> devs = new ArrayList<>();
    private ListagemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        retrofit = new DevRepository(this);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        adapter = new ListagemAdapter(this, devs);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // Vertical

        getDevs();
    }

    private void getDevs() {
        retrofit.getAll(new RequestResult() {
            @Override
            public <T> void returnSuccess(T requestResult) {
                devs = (List<Dev>) requestResult;
                adapter.setList(devs);
                adapter.notifyDataSetChanged();
                Toast.makeText(ListActivity.this, "Sucesso!", Toast.LENGTH_LONG).show();
            }

            @Override
            public void returnError(String message) {
                Toast.makeText(ListActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }
}