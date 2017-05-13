package com.example.cuc.personabasedatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

public class listadoTabla extends AppCompatActivity {
    private TableLayout tabla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_tabla);
        tabla = (TableLayout)findViewById(R.id.tblPersonas);
    }
}
