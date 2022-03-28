package com.ez.ezmonitor;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class HostAdapter extends ListAdapter<Host, HostTextViewHolder> {

    public HostAdapter(@NonNull DiffUtil.ItemCallback<Host> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public HostTextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return HostTextViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull HostTextViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    static class HostDiff extends DiffUtil.ItemCallback<Host> {

        @Override
        public boolean areItemsTheSame(@NonNull Host oldItem, @NonNull Host newItem) {
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Host oldItem, @NonNull Host newItem) {
            return oldItem.equals(newItem);
        }
    }
}
