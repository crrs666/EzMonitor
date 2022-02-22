package com.ez.ezmonitor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HostAdapter extends RecyclerView.Adapter<HostTextViewHolder> {

    private List<Host> inputHosts;

    public HostAdapter(List<Host> hosts) {
        inputHosts = hosts;
    }

    @NonNull
    @Override
    public HostTextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.host_text_view, parent, false);
        return new HostTextViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HostTextViewHolder holder, int position) {
        holder.getHostNameTextView().setText(inputHosts.get(position).getName());
        holder.getHostIpTextView().setText(inputHosts.get(position).getIp());
        holder.getHostPortTextView().setText(String.valueOf(inputHosts.get(position).getPort()));
        holder.getHostUsernameTextView().setText(inputHosts.get(position).getUsername());
    }

    @Override
    public int getItemCount() {
        return inputHosts.size();
    }
}
