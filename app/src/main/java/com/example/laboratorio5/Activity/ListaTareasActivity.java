package com.example.laboratorio5.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laboratorio5.Adapter.ListaTareaAdapter;
import com.example.laboratorio5.Dto.TareaDto;
import com.example.laboratorio5.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ListaTareasActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private ArrayList<TareaDto> list ;
    FloatingActionButton fab;
     ListaTareaAdapter adapter;

    protected  void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);

        setContentView(R.layout.activity_lista_tarea);

        list = new ArrayList<>();

        list.add(new TareaDto("Recordatorio 1" , "24/05/2024"));
        list.add(new TareaDto("Recordatorio 2" , "24/05/2024"));
        list.add(new TareaDto("Recordatorio 3" , "24/05/2024"));
        list.add(new TareaDto("Recordatorio 4" , "24/05/2024"));

        recyclerView = findViewById(R.id.recyclerView_lit);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        ListaTareaAdapter adapter = new ListaTareaAdapter(list);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);









        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaTareasActivity.this, NuevaTareaActivity.class);
                startActivity(intent);
            }
        });

    }


}
