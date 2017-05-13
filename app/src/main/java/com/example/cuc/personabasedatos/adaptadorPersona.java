package com.example.cuc.personabasedatos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by CUC on 13/05/2017.
 */

public class adaptadorPersona extends BaseAdapter {
    private Context contexto;
    private ArrayList<Persona> personas;

    public adaptadorPersona(Context contexto, ArrayList<Persona> personas){
        this.contexto = contexto;
        this.personas = personas;
    }

    @Override
    public int getCount() {
        return personas.size();
    }

    @Override
    public Object getItem(int position) {
        return personas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Long.parseLong(personas.get(position).getCedula());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Declarar Variables
        TextView cajaCedula, cajaNombre, cajaApellido;
        ImageView foto;
        LayoutInflater inflater;
        View itemView;


        //  Uso del Inflater
        inflater = (LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        itemView = inflater.inflate(R.layout.item_personalizado, null);

        // Capturar los objetos

        cajaCedula = (TextView)itemView.findViewById(R.id.txtCedulaP);
        cajaNombre = (TextView)itemView.findViewById(R.id.txtCedula);
        cajaApellido = (TextView)itemView.findViewById(R.id.txtApellidoP);
        foto = (ImageView)itemView.findViewById(R.id.imgFoto);

        // Pasar la informacion
        foto.setImageResource(Integer.parseInt(personas.get(position).getFoto()));
        cajaCedula.setText(personas.get(position).getCedula());
        cajaNombre.setText(personas.get(position).getNombre());
        cajaApellido.setText(personas.get(position).getApellido());

        //Retornar el itemView

        return itemView;
    }
}
