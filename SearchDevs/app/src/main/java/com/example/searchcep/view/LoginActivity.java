package com.example.searchcep.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.searchcep.R;
import com.example.searchcep.model.Dev;
import com.example.searchcep.repository.DevRepository;
import com.example.searchcep.service.RequestResult;

public class LoginActivity extends AppCompatActivity {

    private TextView mNome;
    private Button mSend;
    private DevRepository retrofitRepository = null;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences = getSharedPreferences("TestePreferences", Context.MODE_PRIVATE);

        mNome = findViewById(R.id.txt_user_name);
        mSend = findViewById(R.id.bt_enviar);

        sharedPreferences = getSharedPreferences("TestePreferences", Context.MODE_PRIVATE);

        retrofitRepository = new DevRepository(this);

        mSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                login();

                Intent intent = new Intent(LoginActivity.this, ListActivity.class);
                LoginActivity.this.startActivity(intent);
            }
        });
    }

    private void login() {
        retrofitRepository.getUserProfile(mNome.getText().toString(), new RequestResult() {

            @Override
            public <T> void returnSuccess(T requestResult) {
                Dev dev = (Dev) requestResult;

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("user_id", dev.get_id());
                editor.apply();

                Toast.makeText(LoginActivity.this, "Funfuoou!!!!!", Toast.LENGTH_LONG).show();

            }

            @Override
            public void returnError(String message) {
                Toast.makeText(LoginActivity.this, "Deu Erro!!!!!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getDevs() {
        retrofitRepository.getAll(new RequestResult() {
            @Override
            public <T> void returnSuccess(T requestResult) {



                Toast.makeText(LoginActivity.this, "Sucesso!", Toast.LENGTH_LONG).show();
            }

            @Override
            public void returnError(String message) {
                Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }


}