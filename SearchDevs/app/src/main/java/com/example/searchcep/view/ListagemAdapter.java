package com.example.searchcep.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.searchcep.R;
import com.example.searchcep.model.Dev;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListagemAdapter extends RecyclerView.Adapter<ListagemAdapter.ReceitaHolder> {

    private Context context;
    private List<Dev> lista;
    private final LayoutInflater mInflater;

    public ListagemAdapter(Context context, List<Dev> listaDeReceitas) {
        this.context = context;
        this.lista = listaDeReceitas;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ReceitaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.list_item, parent, false);

        return new ReceitaHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ReceitaHolder holder, int position) {
        Dev dev = lista.get(position);

        Picasso.with(context).load(dev.getAvatar()).into(holder.imageView);
        holder.mUserName.setText(dev.getName());
        holder.mUserBio.setText(dev.getBio());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static final String DETALHES_KEY = "devs";

    public void setList(List<Dev> devs) {
        lista = devs;
    }

    public class ReceitaHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView imageView;
        public TextView mUserName;
        public TextView mUserBio;
        public ConstraintLayout mContainer;

        public ReceitaHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.profile_image);
            mUserName = itemView.findViewById(R.id.txt_name);
            mUserBio = itemView.findViewById(R.id.txt_bio);
            mContainer = itemView.findViewById(R.id.container);

            mContainer.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, DetalhesActivity.class);
            intent.putExtra(DETALHES_KEY, lista.get(getLayoutPosition()));
            context.startActivity(intent);
        }
    }
}
