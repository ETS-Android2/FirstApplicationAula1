package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class ListagemAdapter extends RecyclerView.Adapter<ListagemAdapter.WordViewHolder> {

    private final LinkedList<String> mWordList;
    private final LayoutInflater mInflater;
    public Context ctx;

    public ListagemAdapter(Context context, LinkedList<String> wordList) {
        ctx = context;
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Finciona como o metodo Main e tem a responsabilidade
        // de informar ao adapter qual é o layout dos itens da lista.

        View mItemView = mInflater.inflate(
                R.layout.item_list, parent, false);

        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        // Diz pro layout qual o conteúdo que os itens dele vão ter
        holder.wordItemView.setText(mWordList.get(position));
    }

    @Override
    public int getItemCount() {
        // Informa ao adapter
        return this.mWordList.size();
    }

    // faz a conexão dos itens do layout com o código
    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView wordItemView;
        final ListagemAdapter mAdapter;

        public WordViewHolder(View itemView, ListagemAdapter adapter) {
            super(itemView);

            wordItemView = itemView.findViewById(R.id.itemLista);
            ConstraintLayout container = itemView.findViewById(R.id.paiDeTodos);

            wordItemView.setOnClickListener(this);

            this.mAdapter = adapter;
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.itemLista) {
                Toast.makeText(ctx, "Item foi clicado", Toast.LENGTH_LONG).show();
            } else if(v.getId() == R.id.paiDeTodos) {
                // Executar alguma coisa
            }
        }
    }

}
