package com.example.searchcep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView mNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNome = findViewById(R.id.nome);

        sendRequest();
    }

    public void sendRequest() {

        Call<List<Dev>> call = new RetrofitConfig().getDevService().getAllDevs();

        call.enqueue(new Callback<List<Dev>>() {
            @Override
            public void onResponse(Call<List<Dev>> call, Response<List<Dev>> response) {
                //voz
                List<Dev> dev = response.body();

                int code = response.code();

                if (code == 503) {
                    Toast.makeText(MainActivity.this, "O servidor não respondeu!", Toast.LENGTH_LONG).show();
                } else {
                    mNome.setText(dev.get(0).getName());
                }
            }

            @Override
            public void onFailure(Call<List<Dev>> call, Throwable t) {
                // caixa de mensagem
                Toast.makeText(MainActivity.this, "Request failure", Toast.LENGTH_LONG).show();
            }
        });

    }
}