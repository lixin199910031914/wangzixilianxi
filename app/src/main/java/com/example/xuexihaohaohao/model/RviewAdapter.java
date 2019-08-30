package com.example.xuexihaohaohao.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xuexihaohaohao.R;

import java.util.List;

public class RviewAdapter extends RecyclerView.Adapter<RviewAdapter.MyViewHolder> {
    List<Bean.BeanResult> results;
    Context context;

    public RviewAdapter(List<Bean.BeanResult> results, Context context) {
        this.results = results;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item, viewGroup, true);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        myViewHolder.name.setText(results.get(position).name);
        Glide.with(context).load(results.get(position).imageUrl).into(myViewHolder.img);
    }

    @Override
    public int getItemCount() {
        return results.size();
    }
    class  MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
        }
    }
}
