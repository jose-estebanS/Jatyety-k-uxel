package com.example.estebanlz.proyecto;

import android.widget.ImageView;

import java.io.Serializable;

public class SintomasVO implements Serializable {
    private Integer id_sintoma;
    private String sintoma;
    private Integer status_sintoma;
    private String sintoma_relacion;

    public String getSintoma_relacion() {
        return sintoma_relacion;
    }

    public void setSintoma_relacion(String sintoma_relacion) {
        this.sintoma_relacion = sintoma_relacion;
    }

    public SintomasVO(Integer id_sintoma, String sintoma, Integer status_sintoma, String sintoma_relacion) {
        this.id_sintoma = id_sintoma;
        this.sintoma = sintoma;
        this.status_sintoma = status_sintoma;
        this.sintoma_relacion = sintoma_relacion;
    }
    public SintomasVO() {

    }

    public Integer getId_sintoma() {
        return id_sintoma;
    }

    public void setId_sintoma(Integer id_sintoma) {
        this.id_sintoma = id_sintoma;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    public Integer getStatus_sintoma() {
        return status_sintoma;
    }

    public void setStatus_sintoma(Integer status_sintoma) {
        this.status_sintoma = status_sintoma;
    }
}

