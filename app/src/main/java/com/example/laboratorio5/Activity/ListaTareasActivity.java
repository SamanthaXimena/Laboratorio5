package com.example.laboratorio5.Activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laboratorio5.Adapter.ListaTareaAdapter;
import com.example.laboratorio5.Dto.TareaDto;
import com.example.laboratorio5.R;

import java.util.ArrayList;

public class ListaTareasActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<TareaDto> list ;

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

        adapter.OnRecyclerViewClickListener(new ListaTareaAdapter.OnRecyclerViewClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(ListaTareasActivity.this, "Posicion:" + position, Toast.LENGTH_SHORT).show();
            }
        });

    }


}
