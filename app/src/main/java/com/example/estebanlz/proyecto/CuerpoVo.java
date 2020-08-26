package com.example.estebanlz.proyecto;


import java.io.Serializable;

public class CuerpoVo implements Serializable{
    private Integer id_cuerpo;
    private String cuerpo;
    private Integer status_cuerpo;
    private Integer img_cuerpo;
    private Integer validar_cuerpo;

    public CuerpoVo(Integer id_cuerpo, String cuerpo, Integer status_cuerpo, Integer img_cuerpo, Integer validar_cuerpo)
    {
        this.id_cuerpo = id_cuerpo;
        this.cuerpo = cuerpo;
        this.status_cuerpo = status_cuerpo;
        this.img_cuerpo = img_cuerpo;
        this.validar_cuerpo = validar_cuerpo;
    }
    public CuerpoVo()
    {

    }

    public Integer getValidar_cuerpo() {
        return validar_cuerpo;
    }

    public void setValidar_cuerpo(Integer validar_cuerpo) {
        this.validar_cuerpo = validar_cuerpo;
    }

    public Integer getStatus_cuerpo() {
        return status_cuerpo;
    }

    public void setStatus_cuerpo(Integer status_cuerpo) {
        this.status_cuerpo = status_cuerpo;
    }

    public Integer getImg_cuerpo() {
        return img_cuerpo;
    }

    public void setImg_cuerpo(Integer img_cuerpo) {
        this.img_cuerpo = img_cuerpo;
    }

    public Integer getId_cuerpo() {
        return id_cuerpo;
    }

    public void setId_cuerpo(Integer id_cuerpo) {
        this.id_cuerpo = id_cuerpo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    }

