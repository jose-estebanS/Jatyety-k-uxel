package com.example.estebanlz.proyecto;

import java.io.Serializable;

public class DeveloperVO implements Serializable{
    private String nombre;
    private String rol;
    private String correo;
    private Integer foto;

    public void DeveloperVO(String nombre, String rol, String correo, Integer foto){
        this.nombre = nombre;
        this.rol = rol;
        this.correo = correo;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getFoto() {
        return foto;
    }

    public void setFoto(Integer foto) {
        this.foto = foto;
    }
}
