package com.example.estebanlz.proyecto;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ConsultarDatos {
    private Registros db;
    private ArrayList<FrasesVo> frasesConsult;
    private ArrayList<AudiosVo> audiosFrases;

    public ConsultarDatos(){
    }

    public ArrayList<FrasesVo>ConsultarFrases(Activity activity){
        try {
            db = new Registros(activity.getApplicationContext());
            SQLiteDatabase base = db.getWritableDatabase();
            FrasesVo frases = null;
            Cursor c = base.rawQuery("SELECT * FROM " + db.TABLE, null);
            if (c != null) {
                c.moveToFirst();
                do {
                    frases = new FrasesVo( );
                    frases.setId_frase(c.getInt(0));
                    frases.setFrase(c.getString(1));
                    frases.setStatus(c.getInt(2));
                    frasesConsult.add(frases);
                } while (c.moveToNext());
            }
        } catch (Exception es) {
        }
        return frasesConsult;
    }

    public int IdiomaActual(Activity activity){
        int idioma = 0;
        try {
            db = new Registros(activity);
            SQLiteDatabase base = db.getWritableDatabase();
            Cursor c = base.rawQuery("SELECT " + db.TABLE4_ID + " FROM " + db.TABLE4 + " WHERE " + db.STATUS_LENGUA + " = 1" , null);
            if (c != null) {
                c.moveToFirst();
                do {
                    idioma = c.getInt(0);
                } while (c.moveToNext());
            }
        } catch (Exception es) {
        }
        return idioma;
    }

    public ArrayList<AudiosVo> ConsultarAudiosFrases(Activity activity, int lengua){
        try {
            db = new Registros(activity.getApplicationContext());
            SQLiteDatabase base = db.getWritableDatabase();
            AudiosVo audios = null;
            Cursor c = base.rawQuery("SELECT * FROM audiosfrases WHERE " + db.IDIOMA_AUDIO + " = " + lengua, null);
            if (c != null) {
                c.moveToFirst();
                do {
                    audios = new AudiosVo( );
                    audios.setId_audio(c.getInt(0));
                    audios.setAudio(c.getInt(1));
                    audios.setFk_frases(c.getInt(2));
                    audios.setIdioma_audio(c.getInt(3));
                    audiosFrases.add(audios);
                } while (c.moveToNext());
            }
        } catch (Exception es) {
        }
        return audiosFrases;
    }
}