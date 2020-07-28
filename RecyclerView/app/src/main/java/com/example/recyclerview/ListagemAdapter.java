package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class ListagemAdapter extends RecyclerView.Adapter<ListagemAdapter.WordViewHolder> {

    private final LinkedList<String> mWordList;
    private final LayoutInflater mInflater;

    public ListagemAdapter(Context context, LinkedList<String> wordList) {
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
        holder.wordItemView.setText(mWordList.get(position));
    }

    @Override
    public int getItemCount() {
        // Informa ao adapter
        return this.mWordList.size();
    }

    // faz a conexão dos itens do layout com o código
    class WordViewHolder extends RecyclerView.ViewHolder {
        public final TextView wordItemView;
        final ListagemAdapter mAdapter;

        public WordViewHolder(View itemView, ListagemAdapter adapter) {
            super(itemView);

            wordItemView = itemView.findViewById(R.id.itemLista);

            this.mAdapter = adapter;
        }

    }

}
