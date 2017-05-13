package com.example.cuc.personabasedatos;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

/**
 * Created by CUC on 12/05/2017.
 */

public class Registrar extends AppCompatActivity {
    private EditText cajaCedula;
    private EditText cajaNombre;
    private EditText cajaApellido;
    private RadioButton rdMasculino;
    private RadioButton rdFemenino;
    private CheckBox chkProgramar;
    private CheckBox chkLeer;
    private CheckBox chkBailar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registar);
        cajaCedula = (EditText)findViewById(R.id.txtCedula);
        cajaNombre = (EditText)findViewById(R.id.txtNombre);
        cajaApellido = (EditText)findViewById(R.id.txtApellido);
        rdMasculino = (RadioButton)findViewById(R.id.rdMasculino);
        rdFemenino = (RadioButton)findViewById(R.id.rdFemenino);
        chkProgramar = (CheckBox)findViewById(R.id.chkProgramar);
        chkBailar = (CheckBox)findViewById(R.id.chkBailar);
        chkLeer = (CheckBox)findViewById(R.id.chkLeer);

    }


    public boolean validarTodo(){
        if (cajaCedula.getText().toString().isEmpty()){
            cajaCedula.setError("Digite la Cedula");
            cajaCedula.requestFocus();
            return false;
        }if (cajaNombre.getText().toString().isEmpty()){
            cajaNombre.setError("Digite el Nombre");
            cajaNombre.requestFocus();
            return false;
        }if (cajaApellido.getText().toString().isEmpty()){
            cajaApellido.setError("Digite el Apellido");
            cajaApellido.requestFocus();
            return false;
        }
        if((!chkProgramar.isChecked())&&(!chkBailar.isChecked())&&(!chkLeer.isChecked())){
            new AlertDialog.Builder(this).setMessage("Seleccione por lo menos un pasa tiempos").setCancelable(true).show();
            return false;
        }
        return true;
    }

    public void guardar(View v){
        String foto, cedula, nombre, apellido, sexo, pasatiempo = "";
        Persona p;
        if (validarTodo()){
            foto = String.valueOf(fotoAleatorio());
            cedula = cajaCedula.getText().toString();
            nombre = cajaNombre.getText().toString();
            apellido = cajaApellido.getText().toString();

            if (rdMasculino.isChecked()) sexo = getResources().getString(R.string.masculino);
            else sexo = getResources().getString(R.string.femenino);

            if (chkProgramar.isChecked()){
                pasatiempo = getResources().getString(R.string.programar)+", ";
            }

            if (chkLeer.isChecked()){
                pasatiempo = pasatiempo+getResources().getString(R.string.leer)+", ";
            }

            if (chkBailar.isChecked()){
                pasatiempo = pasatiempo+getResources().getString(R.string.bailar)+", ";
            }

            pasatiempo = pasatiempo.substring(0,pasatiempo.length()-2);
            p = new Persona(foto, cedula, nombre, apellido, sexo, pasatiempo);
            p.guardar(getApplication());

            new AlertDialog.Builder(this).
                    setMessage("Persona Guardada Exitosamente").
                    setCancelable(true).show();

            limpiar();
        }
    }

    public int fotoAleatorio(){
        int fotos[] = {R.drawable.images,R.drawable.images2,R.drawable.images3};
        int numero = (int) (Math.random() * 3);
        return fotos[numero];
    }

    public boolean validarCedula(){
        if (cajaCedula.getText().toString().isEmpty()) {
            cajaCedula.setError("Digite la Cedula");
            cajaCedula.requestFocus();
            return false;
        }
        return true;
    }

    public void limpiar(){
        cajaCedula.setText("");
        cajaNombre.setText("");
        cajaApellido.setText("");
        rdMasculino.setChecked(true);
        rdFemenino.setChecked(false);
        chkProgramar.setChecked(false);
        chkLeer.setChecked(false);
        chkBailar.setChecked(false);

        cajaCedula.requestFocus();
    }

    public void limpiar(View v){
        limpiar();
    }

    public void buscar(View v){
        Persona p;
        if (validarCedula()){
            p= Datos.buscarPersona(getApplicationContext(), cajaCedula.getText().toString());
            if (p!=null){
                cajaNombre.setText(p.getNombre());
                cajaApellido.setText(p.getApellido());
                if (p.getSexo().equals(getResources().getString(R.string.masculino)))rdMasculino.setChecked(true);
                else rdFemenino.setChecked(true);
                if (p.getPasatiempo().contains(getResources().getString(R.string.programar)))chkProgramar.setChecked(true);
                if (p.getPasatiempo().contains(getResources().getString(R.string.leer)))chkLeer.setChecked(true);
                if (p.getPasatiempo().contains(getResources().getString(R.string.bailar)))chkBailar.setChecked(true);
            }
        }
    }

    


}