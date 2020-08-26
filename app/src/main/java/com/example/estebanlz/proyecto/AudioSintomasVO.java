package com.example.estebanlz.proyecto;

import java.io.Serializable;

public class AudioSintomasVO implements Serializable {
    private Integer id_sintoma_audio;
    private Integer fk_audio_idioma;
    private String fk_tb_cuerpo;
    private Integer sintoma_audio;

    public AudioSintomasVO(Integer id_sintoma_audio, Integer fk_audio_idioma, String fk_tb_cuerpo, Integer sintoma_audio) {
        this.id_sintoma_audio = id_sintoma_audio;
        this.fk_audio_idioma = fk_audio_idioma;
        this.fk_tb_cuerpo = fk_tb_cuerpo;
        this.sintoma_audio = sintoma_audio;
    }

    public AudioSintomasVO() {

    }

    public Integer getId_sintoma_audio() {
        return id_sintoma_audio;
    }

    public void setId_sintoma_audio(Integer id_sintoma_audio) {
        this.id_sintoma_audio = id_sintoma_audio;
    }

    public Integer getFk_audio_idioma() {
        return fk_audio_idioma;
    }

    public void setFk_audio_idioma(Integer fk_audio_idioma) {
        this.fk_audio_idioma = fk_audio_idioma;
    }

    public String getFk_tb_cuerpo() {
        return fk_tb_cuerpo;
    }

    public void setFk_tb_cuerpo(String fk_tb_cuerpo) {
        this.fk_tb_cuerpo = fk_tb_cuerpo;
    }

    public Integer getSintoma_audio() {
        return sintoma_audio;
    }

    public void setSintoma_audio(Integer sintoma_audio) {
        this.sintoma_audio = sintoma_audio;
    }
}

