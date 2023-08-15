package com.example.vfinances;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TransactionsCustomAdapter extends RecyclerView.Adapter<TransactionsCustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList trans_id, trans_type, trans_amount, trans_tag;

    TransactionsCustomAdapter(Context context, ArrayList trans_id, ArrayList trans_type, ArrayList trans_amount, ArrayList trans_tag){
        this.context = context;
        this.trans_id = trans_id;
        this.trans_type = trans_type;
        this.trans_amount = trans_amount;
        this.trans_tag = trans_tag;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position){
        holder.trans_id_txt.setText(String.valueOf(trans_id.get(position)));
        holder.trans_type.setText(String.valueOf(trans_type.get(position)));
        holder.trans_amount.setText(String.valueOf(trans_amount.get(position)));
        holder.trans_tag.setText(String.valueOf(trans_tag.get(position)));
    }

    @Override
    public int getItemCount(){
        return trans_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView trans_id_txt, trans_type, trans_amount, trans_tag;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            trans_id_txt = itemView.findViewById(R.id.trans_id_txt);
            trans_type = itemView.findViewById(R.id.trans_type);
            trans_amount = itemView.findViewById(R.id.trans_amount);
            trans_tag = itemView.findViewById(R.id.trans_tag);
        }
    }
}
