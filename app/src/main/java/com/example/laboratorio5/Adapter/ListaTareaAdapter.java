package com.example.laboratorio5.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laboratorio5.Dto.TareaDto;
import com.example.laboratorio5.R;

import java.util.ArrayList;

public class ListaTareaAdapter extends RecyclerView.Adapter<ListaTareaAdapter.MyViewHolder> {

    private final ArrayList <TareaDto> list;
    private OnRecyclerViewClickListener listener;

    public interface OnRecyclerViewClickListener{
         void onItemClick(int position);

    }

    public void OnRecyclerViewClickListener(OnRecyclerViewClickListener listener){
        this.listener = listener;
    }

    public ListaTareaAdapter(ArrayList<TareaDto> list) {
        this.list = list;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_lista_item,parent,false);
        return new MyViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        TareaDto item = list.get(position);
        holder.titulo.setText(item.getTitulo());
        holder.fecha.setText(item.getFecha());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView titulo, fecha;
        public MyViewHolder(@NonNull View itemView, OnRecyclerViewClickListener listener) {
            super(itemView);
            titulo = itemView.findViewById(R.id.id_titulo);
            fecha = itemView.findViewById(R.id.id_fecha);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null && getAdapterPosition()!= RecyclerView.NO_POSITION){
                        listener.onItemClick(getAdapterPosition());
                    }
                }
            });
        }
    }
}

