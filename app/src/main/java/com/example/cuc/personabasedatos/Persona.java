package com.example.cuc.personabasedatos;

/**
 * Created by CUC on 12/05/2017.
 */

public class Persona {
    private String foto;
    private String Cedula;
    private String apellido;
    private String sexo;
    private String pasatiempo;

    public Persona(String foto, String cedula, String apellido, String sexo, String pasatiempo) {
        this.foto = foto;
        Cedula = cedula;
        this.apellido = apellido;
        this.sexo = sexo;
        this.pasatiempo = pasatiempo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPasatiempo() {
        return pasatiempo;
    }

    public void setPasatiempo(String pasatiempo) {
        this.pasatiempo = pasatiempo;
    }
}
