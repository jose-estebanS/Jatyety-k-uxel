package com.example.estebanlz.proyecto;

import android.widget.ImageView;

import java.io.Serializable;

public class FrasesVo implements Serializable{
    private Integer id_frase;
    private String frase;
    private Integer status;

    public FrasesVo(Integer id_frase, String frase, Integer status)
    {
        this.id_frase = id_frase;
        this.frase = frase;
        this.status = status;
    }
    public FrasesVo()
    {

    }
    public Integer getId_frase() {
        return id_frase;
    }

    public void setId_frase(Integer id_frase) {
        this.id_frase = id_frase;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
