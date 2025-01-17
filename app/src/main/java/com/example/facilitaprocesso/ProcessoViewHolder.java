package com.example.facilitaprocesso;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ProcessoViewHolder extends RecyclerView.ViewHolder{

    private final TextView processoItemView;

    private ProcessoViewHolder(View itemView) {
        super(itemView);
        processoItemView = itemView.findViewById(R.id.textView);
    }

    public void bind(String text) {
        processoItemView.setText(text);
    }

    static ProcessoViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new ProcessoViewHolder(view);
    }
}
