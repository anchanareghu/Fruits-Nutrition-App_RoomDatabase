package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView textView_fruitName, textView_description;

    public RecyclerViewViewHolder(@NonNull View itemView) {
        super(itemView);
        this.imageView = itemView.findViewById(R.id.imageView);
        this.textView_fruitName = itemView.findViewById(R.id.textView_fruitName);
        this.textView_description = itemView.findViewById(R.id.textView_description);
    }
}
