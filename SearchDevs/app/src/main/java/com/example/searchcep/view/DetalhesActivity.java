package com.example.searchcep.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.searchcep.R;
import com.example.searchcep.model.Dev;
import com.squareup.picasso.Picasso;

import static com.example.searchcep.view.ListagemAdapter.DETALHES_KEY;

public class DetalhesActivity extends AppCompatActivity {

    public ImageView imageView;
    public TextView mUserName;
    public TextView mUserBio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        Intent intent = getIntent();
        Dev dev = (Dev) intent.getSerializableExtra(DETALHES_KEY);

        imageView = findViewById(R.id.imageView);
        mUserName = findViewById(R.id.textView);
        mUserBio = findViewById(R.id.textView2);

        Picasso.with(this).load(dev.getAvatar()).into(imageView);
        mUserName.setText(dev.getName());
        mUserBio.setText(dev.getBio() == null ? "Não tem BIO" : dev.getBio() );



    }
}