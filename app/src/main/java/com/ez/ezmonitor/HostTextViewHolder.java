package com.ez.ezmonitor;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class HostTextViewHolder extends RecyclerView.ViewHolder {

    public TextView getHostNameTextView() {
        return hostNameTextView;
    }

    public TextView getHostIpTextView() {
        return hostIpTextView;
    }

    public TextView getHostPortTextView() {
        return hostPortTextView;
    }

    public TextView getHostUsernameTextView() {
        return hostUsernameTextView;
    }

    private final TextView hostNameTextView;
    private final TextView hostIpTextView;
    private final TextView hostPortTextView;
    private final TextView hostUsernameTextView;

    public HostTextViewHolder(View v) {
        super(v);
        hostNameTextView = v.findViewById(R.id.text_host_name);
        hostIpTextView = v.findViewById(R.id.text_host_ip);
        hostPortTextView = v.findViewById(R.id.text_host_port);
        hostUsernameTextView = v.findViewById(R.id.text_host_username);
    }


}
