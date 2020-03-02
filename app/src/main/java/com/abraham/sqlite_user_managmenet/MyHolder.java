package com.abraham.sqlite_user_managmenet;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyHolder extends RecyclerView.ViewHolder {
    TextView title,descriptor;

    public MyHolder(@NonNull View itemView) {
        super(itemView);

        this.title = itemView.findViewById(R.id.titleId);
        this.descriptor = itemView.findViewById(R.id.descriptorId);
    }
}
