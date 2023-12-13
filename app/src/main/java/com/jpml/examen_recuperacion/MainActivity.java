package com.jpml.examen_recuperacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText ed_cedula,ed_nombre,ed_placa,ed_anioF,ed_marca,ed_color,ed_tipoVh,ed_valorVh,ed_opcMultas;
    Button btn_calcula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_cedula=findViewById(R.id.edt_cedula);
        ed_nombre=findViewById(R.id.edt_Propietario);
        ed_placa=findViewById(R.id.edt_Placa);
        ed_anioF=findViewById(R.id.edt_anioFAv);
        ed_marca=findViewById(R.id.edt_Marca);
        ed_color=findViewById(R.id.edt_Color);
        ed_tipoVh=findViewById(R.id.edt_Tvehiculo);
        ed_valorVh=findViewById(R.id.edt_Valorvehiculo);
        ed_opcMultas=findViewById(R.id.edt_TieneMultas);
        btn_calcula=findViewById(R.id.btn_generar);
        btn_calcula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in= new Intent(MainActivity.this,Resultado.class);
                startActivity(in);



            }
        });












    }
}