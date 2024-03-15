package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewViewHolder> {
    List<Fruits> fruitList;

    public RecyclerViewAdapter(List<Fruits> fruits) {
        this.fruitList = fruits;
    }

    @NonNull
    @Override
    public RecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recyclerview_item, parent, false);
        return new RecyclerViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewViewHolder holder, int position) {
        Fruits fruit = fruitList.get(position);
        holder.textView_fruitName.setText(fruit.getFruit_name());
        holder.textView_description.setText(fruit.getDescription());
        Picasso.get().load(fruit.getImage_url()).into(holder.imageView);
    }


    @Override
    public int getItemCount() {
        return 10;
    }

    public void setFruitList(List<Fruits> fruitList) {
        this.fruitList = fruitList;
        notifyDataSetChanged();
    }
}
