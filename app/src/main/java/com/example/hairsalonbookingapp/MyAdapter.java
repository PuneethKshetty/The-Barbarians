package com.example.hairsalonbookingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

   /* ArrayList<Booking> mList;
    Context context;*/
    private Notification activity;
    private List<Booking> mList;

    public MyAdapter(Notification activity,List<Booking> mList){
        this.mList = mList;
        this.activity = activity;
       /* this.context = context;*/
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
      /* Booking book = mList.get(position);
       holder.date.setText(book.getDate());
       holder.time.setText(book.getTime());
       holder.barber.setText(book.getBarber());*/
        holder.date.setText(mList.get(position).getDate());
        holder.time.setText(mList.get(position).getTime());
        holder.barber.setText(mList.get(position).getBarber());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
       TextView date,time,barber;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.date_text);
            time = itemView.findViewById(R.id.time_text);
            barber = itemView.findViewById(R.id.barber_text);
        }
    }
}
