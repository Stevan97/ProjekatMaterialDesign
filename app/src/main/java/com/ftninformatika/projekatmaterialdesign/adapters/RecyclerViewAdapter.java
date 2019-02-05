package com.ftninformatika.projekatmaterialdesign.adapters;



import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ftninformatika.projekatmaterialdesign.R;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private String items[];
    private OnClickListener listener;

    public interface OnClickListener {
        void onClick(String text);
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {


        TextView tvText;
        CardView container;

        public MyViewHolder(View v) {
            super(v);
            tvText = v.findViewById(R.id.tvText);
            container = (CardView) v;
        }

        public void bind(final String ime, final OnClickListener listener){
            tvText.setText(ime);
            container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(ime);
                }
            });
        }


    }

    public RecyclerViewAdapter(String items[],OnClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        CardView cv = (CardView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_item,viewGroup,false);
        MyViewHolder vh = new MyViewHolder(cv);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      // holder.tvText.setText(items[position]); // visak
       holder.bind(items[position],listener);
    }

    @Override
    public int getItemCount() {
        return items.length;
    }




}
