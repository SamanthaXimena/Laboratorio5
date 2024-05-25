package com.example.laboratorio5.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laboratorio5.Activity.NuevaTareaActivity;
import com.example.laboratorio5.Dto.TareaDto;
import com.example.laboratorio5.R;
import com.orhanobut.dialogplus.DialogPlus;

import java.util.ArrayList;

public class ListaTareaAdapter extends RecyclerView.Adapter<ListaTareaAdapter.MyViewHolder> {

    private final ArrayList <TareaDto> list;
    private OnRecyclerViewClickListener listener;
    Context context;

    public interface OnRecyclerViewClickListener{
         void onItemClick(int position);
         void onEditClick(int position);

    }

    public void OnRecyclerViewClickListener(OnRecyclerViewClickListener listener){
        this.listener = listener;
    }

    public ListaTareaAdapter( ArrayList<TareaDto> list) {
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

        TareaDto item_1 = list.get(position);
        holder.titulo.setText(item_1.getTitulo());
        holder.fecha.setText(item_1.getFecha());

        holder.btnEdit.setOnClickListener(v -> {
            Intent intent = new Intent(context, NuevaTareaActivity.class);
            intent.putExtra("taskPosition", position);
            intent.putExtra("titulo", item_1.getTitulo());
            intent.putExtra("desc", item_1.getDesc());
            intent.putExtra("fecha", item_1.getFecha());
            context.startActivity(intent);
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView titulo, fecha;
        public ImageButton btnEdit, btnDelete;


        public MyViewHolder(@NonNull View itemView, OnRecyclerViewClickListener listener) {
            super(itemView);
            titulo = itemView.findViewById(R.id.id_titulo);
            fecha = itemView.findViewById(R.id.id_fecha);

            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnDelete = itemView.findViewById(R.id.btnDelete);





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

