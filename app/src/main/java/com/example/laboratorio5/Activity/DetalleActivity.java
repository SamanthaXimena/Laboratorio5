package com.example.laboratorio5.Activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.laboratorio5.MainActivity;
import com.example.laboratorio5.R;

import java.util.Calendar;

public class DetalleActivity extends AppCompatActivity {

    private TextView tv_titulo , tv_descr , tv_fecha;
    Button boton_edit;

    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_detalle);
        tv_titulo = findViewById(R.id.titulo_detalle);
        tv_descr = findViewById(R.id.desc_detalle);
        tv_fecha = findViewById(R.id.fecha_detalle);

        boton_edit = findViewById(R.id.boton_edit);

        tv_titulo.setText(getIntent().getStringExtra("tituloINTENT"));
        tv_descr.setText(getIntent().getStringExtra("descINTENT"));
        tv_fecha.setText(getIntent().getStringExtra("fechaINTENT"));

        boton_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DetalleActivity.this, NuevaTareaActivity.class);
                startActivity(intent);
            }
        });
    }





}

