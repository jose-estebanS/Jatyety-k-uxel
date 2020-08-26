package com.example.estebanlz.proyecto;

import java.io.Serializable;

public class VoSintomas implements Serializable{
    private Integer id_sintoma;
    private String sintoma;
    private Integer status_sintoma;
    private String relacion_sintoma;

    public VoSintomas(Integer id_sintoma, String sintoma, Integer status_sintoma, String relacion_sintoma)
    {
        this.id_sintoma = id_sintoma;
        this.sintoma = sintoma;
        this.status_sintoma = status_sintoma;
        this.relacion_sintoma = relacion_sintoma;
    }
    public VoSintomas()
    {

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

    public String getRelacion_sintoma() {
        return relacion_sintoma;
    }

    public void setRelacion_sintoma(String relacion_sintoma) {
        this.relacion_sintoma = relacion_sintoma;
    }
}
