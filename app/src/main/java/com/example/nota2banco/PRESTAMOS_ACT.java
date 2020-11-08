package com.example.nota2banco;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;

public class PRESTAMOS_ACT extends AppCompatActivity {
    private Spinner spinClientes, spinCredito;
    private String RRR;
    private HashMap<String,Integer> hashclientes;
    private TextView edResultado;
    private int Ch=12,Chaxel=1750000, Chroxana=1900000;
    private int Ca=8, Caaxel=1250000, Caroxana=1400000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_r_e_s_t_a_m_o_s__a_c_t);
        edResultado = (TextView) findViewById(R.id.tvResultado);
        spinClientes = (Spinner)findViewById(R.id.spnClientes);
        spinCredito = (Spinner)findViewById(R.id.spnCredito);
        hashclientes = (HashMap<String, Integer>) getIntent().getSerializableExtra("Clientes");
        String [] listadoClientes = {"(Seleccione Cliente)","Axel","Roxana","danilo","chamelfo"};
        String [] listadoCreditos = {"(Seleccione Credito)","Credito Hipotecario","Credito Automotriz"};
        ArrayAdapter<String> adaptClientes = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listadoClientes);
        spinClientes.setAdapter(adaptClientes);
        ArrayAdapter<String> adaptCreditos = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listadoCreditos);
        spinCredito.setAdapter(adaptCreditos);
    }
    public void CalcularPrestamo(View view){
            if (spinCredito.getSelectedItemPosition() == 1 && (spinClientes.getSelectedItemPosition() == 1)) {
                RRR = "su prestamo es de 1750000";
                edResultado.setText(RRR);
            }
            else if (spinCredito.getSelectedItemPosition() == 1 && (spinClientes.getSelectedItemPosition() == 2)) {
                RRR = "su prestamo es de 1250000";
                edResultado.setText(RRR);
            }
            else if (spinCredito.getSelectedItemPosition() == 2 && (spinClientes.getSelectedItemPosition() == 1)) {
                RRR = "Su prestamo es de 1900000";
                edResultado.setText(RRR);
            }
            else if (spinCredito.getSelectedItemPosition() == 2 && (spinClientes.getSelectedItemPosition() == 2)) {
                RRR = "Su prestamo es de 1400000";
                edResultado.setText(RRR);
            }
    }
            public void CalcularDeuda(View view){

            if (spinCredito.getSelectedItemPosition() == 1 && (spinClientes.getSelectedItemPosition() == 1  )){
                RRR ="Su deuda por credito hipotecario es de  "+ Chaxel/Ch +"en 12 cuotas";
                edResultado.setText(RRR);
            }
            else if (spinCredito.getSelectedItemPosition() == 1 && (spinClientes.getSelectedItemPosition() == 2  )) {
                RRR = "Su deuda por credito Automotriz es de  " + Chaxel/Ca +"en 8 cuotas";
                edResultado.setText(RRR);
                }
            else if (spinCredito.getSelectedItemPosition() == 2 && (spinClientes.getSelectedItemPosition() == 1  )) {
                RRR = "Su deuda por credito hipotecario es de  " + Caroxana/Ch +"en 12 cuotas";
                edResultado.setText(RRR);
            }
            else if (spinCredito.getSelectedItemPosition() == 2 && (spinClientes.getSelectedItemPosition() == 2  )) {
                RRR = "Su deuda por credito Automotriz es de  " + Caroxana/Ca +"en 8 cuotas";
                edResultado.setText(RRR);
            }
        }
    }

