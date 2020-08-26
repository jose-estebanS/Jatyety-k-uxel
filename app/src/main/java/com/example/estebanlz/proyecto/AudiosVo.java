package com.example.estebanlz.proyecto;

import java.io.Serializable;

public class AudiosVo implements Serializable{
    private Integer id_audio;
    private Integer audio;
    private Integer fk_frases;
    private Integer idioma_audio;

    public AudiosVo(Integer id_audio, Integer audio, Integer fk_frases, Integer idioma_audio)
    {
        this.id_audio = id_audio;
        this.audio = audio;
        this.fk_frases = fk_frases;
        this.idioma_audio = idioma_audio;
    }
    public AudiosVo()
    {

    }

    public Integer getId_audio() {
        return id_audio;
    }

    public void setId_audio(Integer id_audio) {
        this.id_audio = id_audio;
    }

    public Integer getAudio() {
        return audio;
    }

    public void setAudio(Integer audio) {
        this.audio = audio;
    }

    public Integer getFk_frases() {
        return fk_frases;
    }

    public void setFk_frases(Integer fk_frases) {
        this.fk_frases = fk_frases;
    }

    public Integer getIdioma_audio() {
        return idioma_audio;
    }

    public void setIdioma_audio(Integer idioma_audio) {
        this.idioma_audio = idioma_audio;
    }
}
