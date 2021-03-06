package com.example.cuc.personabasedatos;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Principal extends AppCompatActivity {
    private ListView opciones;
    private String[] opc;
    private ArrayAdapter adapter;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        opciones = (ListView)findViewById(R.id.lstOpciones);
        opc = getResources().getStringArray(R.array.opciones);
        adapter = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,opc);
        opciones.setAdapter(adapter);

        opciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        i = new Intent(Principal.this,Registrar.class);
                        startActivity(i);
                        break;
                    case 1:
                        i = new Intent(Principal.this,listadoTabla.class);
                        startActivity(i);
                        break;
                    case 2:
                        i = new Intent(Principal.this,Listar.class);
                        startActivity(i);
                        break;
                }
            }
        });
    }

}
