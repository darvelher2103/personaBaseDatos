package com.example.cuc.personabasedatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Listar extends AppCompatActivity {
    //Listado personalido

    private ListView lstPersonalizado;
    private ArrayList<Persona> personas;
    private adaptadorPersona adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        lstPersonalizado = (ListView)findViewById(R.id.lstListado);
        personas = Datos.traerPersonas(getApplicationContext());
        adapter = new adaptadorPersona(getApplicationContext(),personas);
        lstPersonalizado.setAdapter(adapter);
    }
}
