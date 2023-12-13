package com.jpml.examen_recuperacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed_cedula, ed_nombre, ed_placa, ed_anioF, ed_marca, ed_color, ed_tipoVh, ed_valorVh, ed_opcMultas;
    Button btn_calcula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_cedula = findViewById(R.id.edt_cedula);
        ed_nombre = findViewById(R.id.edt_Propietario);
        ed_placa = findViewById(R.id.edt_Placa);
        ed_anioF = findViewById(R.id.edt_anioFAv);
        ed_marca = findViewById(R.id.edt_Marca);
        ed_color = findViewById(R.id.edt_Color);
        ed_tipoVh = findViewById(R.id.edt_Tvehiculo);
        ed_valorVh = findViewById(R.id.edt_Valorvehiculo);
        ed_opcMultas = findViewById(R.id.edt_TieneMultas);
        btn_calcula = findViewById(R.id.btn_generar);

    }
    public void ingresar(View view) {

        int cedula = Integer.parseInt(ed_cedula.getText().toString());
        String nombre = ed_nombre.getText().toString();
        String placa = ed_placa.getText().toString();
        int anio_fabricacion = Integer.parseInt(ed_anioF.getText().toString());
        String marca = ed_marca.getText().toString();
        String color = ed_color.getText().toString();
        String tipoVehiculo = ed_tipoVh.getText().toString();
        int valor = Integer.parseInt( ed_valorVh.getText().toString());
        int opcMulta= Integer.parseInt(ed_opcMultas.getText().toString());
                Bundle datos = new Bundle();
                datos.putInt("cedulas", cedula);
                datos.putString("nombres", nombre);
                datos.putString("placas", placa);
                datos.putInt("anios_fab", anio_fabricacion);
                datos.putString("marcas", marca);
                datos.putString("colores", color);
                datos.putString("tipoV", tipoVehiculo);
                datos.putInt("valores", valor);
                datos.putInt("multass", opcMulta);
                Intent in = new Intent(MainActivity.this, Resultado.class);
                in.putExtras(datos);
                startActivity(in);

    }
}
