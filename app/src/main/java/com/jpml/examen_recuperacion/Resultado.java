package com.jpml.examen_recuperacion;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {
    TextView total_pagar, txt_cedula, txt_nombre, txtVehiculo, txtplaca, txtpagar_placa, txtpagar_año, pagar_marca, pagar_multas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        total_pagar = findViewById(R.id.TOTALpAGAR);
        txt_cedula = findViewById(R.id.res_cedula);
        txt_nombre = findViewById(R.id.res_nombre);
        txtVehiculo = findViewById(R.id.res_vehiculo);
        txtplaca = findViewById(R.id.res_placa);
        txtpagar_placa = findViewById(R.id.res_VALORpLACA);
        txtpagar_año = findViewById(R.id.res_AÑO);
        pagar_marca = findViewById(R.id.res_MARCA);
        pagar_multas = findViewById(R.id.res_MULTAS);

        Bundle datos = getIntent().getExtras();
        if (datos != null) {
            int cedula = datos.getInt("cedulas");
            String nomb = datos.getString("nombres");
            String pla = datos.getString("placas");
            int aniosfab = datos.getInt("anios_fab");
            String marc = datos.getString("marcas");
            String color = datos.getString("colores");
            String tipoVeh = datos.getString("tipoV");
            int val = datos.getInt("valores");
            int mult = datos.getInt("multass");

            // Mostrar los datos en los TextView
            txt_cedula.setText(String.valueOf(cedula));
            txt_nombre.setText(nomb);
            txtVehiculo.setText(tipoVeh);
            txtplaca.setText(pla);
            double valorPlaca = calcularValorRenovacionPlacas(cedula, pla);
            txtpagar_placa.setText(String.valueOf(valorPlaca));
            double valorContaminacion = calcularMultaContaminacion((aniosfab));

            double valorMatriculacion = calcularValorMatriculacion(marc, tipoVeh, val);
            double valorMultas = calcularMultaPorMultas(mult);

            // Mostrar los valores calculados en los TextView correspondientes
            txtpagar_placa.setText(String.valueOf(valorPlaca));
            txtpagar_año.setText(String.valueOf(valorContaminacion));
            pagar_marca.setText(String.valueOf(valorMatriculacion));
            pagar_multas.setText(String.valueOf(valorMultas));



        }
    }


    public double calcularValorRenovacionPlacas(int cedula, String placa) {
        int sueldoBasico = 435;
        String cedulaString = String.valueOf(cedula);

        if (cedulaString.startsWith("1") && placa.contains("I")) {
            // Calcula el 5% del sueldo básico para renovación de placas
            double porcentajeRenovacion = 0.05;
            double valorPlaca = sueldoBasico * porcentajeRenovacion;
            return valorPlaca;
        }
        return 0;
    }


    public double calcularMultaContaminacion(int anioFabricacion) {
        if (anioFabricacion < 2010) {
            double porcentajeMulta = 0.02;
            int aniosDeContaminacion = 2010 - anioFabricacion;
            double valorAnio = aniosDeContaminacion * porcentajeMulta;
            return valorAnio;
        }
        return 0;
    }

    public double calcularValorMatriculacion(String marca, String tipo, int valorVehiculo) {
        double porcentajeMatriculacion = 0.0;

        if (marca.equals("TOYOTA") && tipo.equals("JEEP")) {
            porcentajeMatriculacion = 0.08;
        } else if (marca.equals("TOYOTA") && tipo.equals("CAMIONETA")) {
            porcentajeMatriculacion = 0.12;
        } else if (marca.equals("SUSUKI") && tipo.equals("VITARA")) {
            porcentajeMatriculacion = 0.10;
        } else if (marca.equals("SUSUKI") && tipo.equals("AUTOMOVIL")) {
            porcentajeMatriculacion = 0.09;
        }

        return valorVehiculo * porcentajeMatriculacion;
    }

    public double calcularMultaPorMultas(int cantidadMultas) {
        int sueldoBasico = 435;

        if (cantidadMultas > 0) {
            double porcentajeMulta = 0.25;
            return sueldoBasico * porcentajeMulta;
        }

        return 0;
    }
}
