package com.example.laboratorio5.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laboratorio5.Adapter.ListaTareaAdapter;
import com.example.laboratorio5.Dto.TareaDto;
import com.example.laboratorio5.R;

import java.util.ArrayList;
import java.util.Calendar;

public class NuevaTareaActivity extends AppCompatActivity {


    private EditText Et_titulo , Et_descr , Et_fecha;
    Button boton_guardar;
    ArrayList<TareaDto> tareaDtoArrayList;
    private int taskPosition;


    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_nueva_tarea);
        Et_titulo = findViewById(R.id.titulo_new);
        Et_descr = findViewById(R.id.desc_new);
        Et_fecha = findViewById(R.id.fecha_new);
        boton_guardar = findViewById(R.id.button_new);

        boton_guardar.setOnClickListener(v-> {

            String strTitulo="" , strDesc="", strFecha="";
            if(Et_titulo.getText()!=null){
                strTitulo = Et_titulo.getText().toString();
            }
            if(strTitulo.equals("")){
                Toast.makeText(this, "Debes ingresar un Titulo", Toast.LENGTH_LONG).show();
            }

            if(Et_descr.getText()!=null){
                strDesc = Et_descr.getText().toString();
            }
            if(strDesc.equals("")){
                Toast.makeText(this, "Debes ingresar una Descripcion", Toast.LENGTH_LONG).show();
            }
            if(Et_fecha.getText()!=null){
                strFecha = Et_fecha.getText().toString();
            }
            if(strFecha.equals("")){
                Toast.makeText(this, "Debes de ingresar un titulo", Toast.LENGTH_LONG).show();
            }


        });
        tareaDtoArrayList = new ArrayList<>();


        callDialogDate();

        // Recoge los datos de la tarea a editar
        Intent intent = getIntent();
        taskPosition = intent.getIntExtra("taskPosition", -1);
        String titulo = intent.getStringExtra("titulo");
        String desc = intent.getStringExtra("desc");
        String fecha = intent.getStringExtra("fecha");

        // Rellena los campos con los datos de la tarea
        Et_titulo.setText(titulo);
        Et_descr.setText(desc);
        Et_fecha.setText(fecha);

        boton_guardar.setOnClickListener(v -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("taskPosition", taskPosition);
            resultIntent.putExtra("titulo", Et_titulo.getText().toString());
            resultIntent.putExtra("desc", Et_descr.getText().toString());
            resultIntent.putExtra("fecha", Et_fecha.getText().toString());
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }









    private void callDialogDate(){
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, day);

                Et_fecha.setText(day+"/"+month+"/"+year);

            }
        };
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                date,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }


}
