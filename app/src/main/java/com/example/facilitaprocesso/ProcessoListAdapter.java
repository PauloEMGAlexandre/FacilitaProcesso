package com.example.facilitaprocesso;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class ProcessoListAdapter extends ListAdapter<Processo, ProcessoViewHolder>{

    public ProcessoListAdapter(@NonNull DiffUtil.ItemCallback<Processo> diffCallback) {
        super(diffCallback);
    }

    @Override
    public ProcessoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ProcessoViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(ProcessoViewHolder holder, int position) {
        Processo current = getItem(position);
        holder.bind(current.getNumProcesso());
    }

    static class ProcessoDiff extends DiffUtil.ItemCallback<Processo> {

        @Override
        public boolean areItemsTheSame(@NonNull Processo oldItem, @NonNull Processo newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Processo oldItem, @NonNull Processo newItem) {
            return oldItem.getNumProcesso().equals(newItem.getNumProcesso());
        }
    }

}
