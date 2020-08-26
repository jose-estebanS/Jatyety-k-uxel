package com.example.estebanlz.proyecto;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.example.estebanlz.proyecto.R.drawable.cabezaimg;
import static com.example.estebanlz.proyecto.R.drawable.pierna;

public class Registros extends SQLiteOpenHelper{
    //Campos de la tabla frases
    public static final String TABLE_ID = "_idFrase";
    public static final String FRASE = "frase";
    public static final String STATUS = "status";
    //Campos de la tabla cuerpo
    public static final String TABLE2_ID = "_idCuerpo";
    public static final String PARTE_CUERPO = "parte_cuerpo";
    public static final String STATUS_CUERPO = "status_cuerpo";
    public static final String IMAGEN_CUERPO = "imagen_cuerpo";
    //Campos de la tabla sintomas
    public static final String TABLE3_ID = "_idSintoma";
    public static final String SINTOMA = "sintoma";
    public static final String STATUS_SINTOMA = "status_sintoma";
    public static final String SINTOMA_RELACION = "sintoma_relacion";
    //Campos de la tabla lenguas
    public static final String TABLE4_ID = "_idLengua";
    public static final String LENGUA = "lengua";
    public static final String STATUS_LENGUA = "status_lengua";
    //Campos de la tabla audios_frases
    public static final String TABLE5_ID = "_idAudioFrase";
    public static final String AUDIO_FRASE = "audio_frase";
    public static final String FK_TB_FRASES = "fk_tb_frases";
    public static final String IDIOMA_AUDIO = "idioma_audio";
    //Campos de la tabla audios_sintomas
    public static final String TABLE6_ID = "_idAudioSintomas";
    public static final String IDIOMA_AUDIO_SINTOMA = "idioma_audio_sintoma";
    public static final String FK_TB_CUERPO = "fk_tb_cuerpo";
    public static final String SINTOMA_AUDIO = "sintoma_audio";
    //Nombre de la bd y las tablas
    public static final String DATABASE = "Traduccion.db";
    public static final String TABLE = "frases";
    public static final String TABLE2 = "cuerpo";
    public static final String TABLE3 = "sintomas";
    public static final String TABLE4 = "lenguas";
    public static final String TABLE5 = "audiosfrases";
    public static final String TABLE6 = "audiossintomas";
    private Context context;
    SQLiteDatabase base;
    public Registros(Context context) {
        super(context, DATABASE, null, 10);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.execSQL("CREATE TABLE " + TABLE + " (" + TABLE_ID +" INTEGER PRIMARY KEY, "+ FRASE + " TEXT," + STATUS + " INTEGER)");
            db.execSQL("CREATE TABLE " + TABLE2 + " (" + TABLE2_ID +" INTEGER PRIMARY KEY, "+ PARTE_CUERPO + " TEXT," + STATUS_CUERPO + " INTEGER," + IMAGEN_CUERPO + " INTEGER)");
            db.execSQL("CREATE TABLE " + TABLE3 + " (" + TABLE3_ID +" INTEGER PRIMARY KEY, "+ SINTOMA + " TEXT," + STATUS_SINTOMA + " INTEGER," + SINTOMA_RELACION + " TEXT)");
            db.execSQL("CREATE TABLE " + TABLE4 + " (" + TABLE4_ID +" INTEGER PRIMARY KEY, "+ LENGUA + " TEXT," + STATUS_LENGUA + " INTEGER)");
            db.execSQL("CREATE TABLE " + TABLE5 + " (" + TABLE5_ID +" INTEGER PRIMARY KEY, "+ AUDIO_FRASE + " INTEGER," + FK_TB_FRASES + " INTEGER," + IDIOMA_AUDIO + " INTEGER)");
            db.execSQL("CREATE TABLE " + TABLE6 + " (" + TABLE6_ID +" INTEGER PRIMARY KEY, "+ IDIOMA_AUDIO_SINTOMA + " INTEGER," + FK_TB_CUERPO + " INTEGER," + SINTOMA_AUDIO + " INTEGER)");
            this.base = db;
        }
        catch (Exception e){
            Log.e("No", e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE2);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE3);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE4);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE5);
        onCreate(db);
    }
    public void close(){
        this.close();
    }
    public void addRegistro(){
        ContentValues valores = new ContentValues();

        valores.put(TABLE_ID, 1);
        valores.put(FRASE, "Buenos días");
        valores.put(STATUS, 0);
        this.getWritableDatabase().insert(TABLE,null,valores);

        valores.put(TABLE_ID, 2);
        valores.put(FRASE, "¿Cómo se siente?");
        valores.put(STATUS, 0);
        this.getWritableDatabase().insert(TABLE,null,valores);

        valores.put(TABLE_ID, 3);
        valores.put(FRASE, "¿Cuándo empezaron los síntomas?");
        valores.put(STATUS, 0);
        this.getWritableDatabase().insert(TABLE,null,valores);

        valores.put(TABLE_ID, 4);
        valores.put(FRASE, "¿Cuál es su nombre?");
        valores.put(STATUS, 0);
        this.getWritableDatabase().insert(TABLE,null,valores);

        valores.put(TABLE_ID, 5);
        valores.put(FRASE, "¿Cuántos años tiene?");
        valores.put(STATUS, 0);
        this.getWritableDatabase().insert(TABLE,null,valores);

        valores.put(TABLE_ID, 6);
        valores.put(FRASE, "¿Es alérgico a algún medicamento?");
        valores.put(STATUS, 0);
        this.getWritableDatabase().insert(TABLE,null,valores);

        valores.put(TABLE_ID, 7);
        valores.put(FRASE, "Pase a la farmacia a comprar este medicamento");
        valores.put(STATUS, 0);
        this.getWritableDatabase().insert(TABLE,null,valores);

        valores.put(TABLE_ID, 8);
        valores.put(FRASE, "Señáleme donde le duele");
        valores.put(STATUS, 0);
        this.getWritableDatabase().insert(TABLE,null,valores);

        valores.put(TABLE_ID, 9);
        valores.put(FRASE, "Coma frutas y verduras");
        valores.put(STATUS, 0);
        this.getWritableDatabase().insert(TABLE,null,valores);

        valores.put(TABLE_ID, 10);
        valores.put(FRASE, "Tome más líquidos");
        valores.put(STATUS, 0);
        this.getWritableDatabase().insert(TABLE,null,valores);

        valores.put(TABLE_ID, 11);
        valores.put(FRASE, "¿Dónde ha estado?");
        valores.put(STATUS, 0);
        this.getWritableDatabase().insert(TABLE,null,valores);

        valores.put(TABLE_ID, 12);
        valores.put(FRASE, "¿Ha tomado algún medicamento antes de venir?");
        valores.put(STATUS, 0);
        this.getWritableDatabase().insert(TABLE,null,valores);

        valores.put(TABLE_ID, 13);
        valores.put(FRASE, "¿Hace cuánto le duele?");
        valores.put(STATUS, 0);
        this.getWritableDatabase().insert(TABLE,null,valores);

        valores.put(TABLE_ID, 14);
        valores.put(FRASE, "¿Hace cuánto lo siente?");
        valores.put(STATUS, 0);
        this.getWritableDatabase().insert(TABLE,null,valores);

        valores.put(TABLE_ID, 15);
        valores.put(FRASE, "¿Está embarazada?");
        valores.put(STATUS, 0);
        this.getWritableDatabase().insert(TABLE,null,valores);

        valores.put(TABLE_ID, 16);
        valores.put(FRASE, "¿Está tomando antibióticos?");
        valores.put(STATUS, 0);
        this.getWritableDatabase().insert(TABLE,null,valores);

        valores.put(TABLE_ID, 17);
        valores.put(FRASE, "Tome asiento");
        valores.put(STATUS, 0);
        this.getWritableDatabase().insert(TABLE,null,valores);

        valores.put(TABLE_ID, 18);
        valores.put(FRASE, "Levante el brazo");
        valores.put(STATUS, 0);
        this.getWritableDatabase().insert(TABLE,null,valores);

        valores.put(TABLE_ID, 19);
        valores.put(FRASE, "Párese");
        valores.put(STATUS, 0);
        this.getWritableDatabase().insert(TABLE,null,valores);

        valores.put(TABLE_ID, 20);
        valores.put(FRASE, "¿Cómo se ha sentido después del tratamiento?");
        valores.put(STATUS, 0);
        this.getWritableDatabase().insert(TABLE,null,valores);

        valores.put(TABLE_ID, 21);
        valores.put(FRASE, "¿Algo más que sienta?");
        valores.put(STATUS, 0);
        this.getWritableDatabase().insert(TABLE,null,valores);
    }
    public void addRegistroCuerpo()
    {
        ContentValues parte = new ContentValues();

        parte.put(TABLE2_ID, 1);
        parte.put(PARTE_CUERPO, "CABEZA");
        parte.put(STATUS_CUERPO, 0);
        parte.put(IMAGEN_CUERPO, cabezaimg);
        this.getWritableDatabase().insert(TABLE2,null,parte);

        parte.put(TABLE2_ID, 2);
        parte.put(PARTE_CUERPO, "PECHO");
        parte.put(STATUS_CUERPO, 0);
        parte.put(IMAGEN_CUERPO, R.drawable.pechoimg);
        this.getWritableDatabase().insert(TABLE2,null,parte);

        parte.put(TABLE2_ID, 3);
        parte.put(PARTE_CUERPO, "BRAZOS");
        parte.put(STATUS_CUERPO, 0);
        parte.put(IMAGEN_CUERPO, R.drawable.brazo);
        this.getWritableDatabase().insert(TABLE2,null,parte);

        parte.put(TABLE2_ID, 4);
        parte.put(PARTE_CUERPO, "ANTEBRAZOS");
        parte.put(STATUS_CUERPO, 0);
        parte.put(IMAGEN_CUERPO, R.drawable.brazo);
        this.getWritableDatabase().insert(TABLE2,null,parte);

        parte.put(TABLE2_ID, 5);
        parte.put(PARTE_CUERPO, "MANOS");
        parte.put(STATUS_CUERPO, 0);
        parte.put(IMAGEN_CUERPO, R.drawable.mano);
        this.getWritableDatabase().insert(TABLE2,null,parte);

        parte.put(TABLE2_ID, 6);
        parte.put(PARTE_CUERPO, "ESTOMAGO");
        parte.put(STATUS_CUERPO, 0);
        parte.put(IMAGEN_CUERPO, R.drawable.imgadomen);
        this.getWritableDatabase().insert(TABLE2,null,parte);

        parte.put(TABLE2_ID, 7);
        parte.put(PARTE_CUERPO, "PIERNAS");
        parte.put(STATUS_CUERPO, 0);
        parte.put(IMAGEN_CUERPO, pierna);
        this.getWritableDatabase().insert(TABLE2,null,parte);

        parte.put(TABLE2_ID, 8);
        parte.put(PARTE_CUERPO, "PANTORRILLAS");
        parte.put(STATUS_CUERPO, 0);
        parte.put(IMAGEN_CUERPO, R.drawable.pantorrilla);
        this.getWritableDatabase().insert(TABLE2,null,parte);

        parte.put(TABLE2_ID, 9);
        parte.put(PARTE_CUERPO, "PIES");
        parte.put(STATUS_CUERPO, 0);
        parte.put(IMAGEN_CUERPO, R.drawable.pie);
        this.getWritableDatabase().insert(TABLE2,null,parte);

        parte.put(TABLE2_ID, 10);
        parte.put(PARTE_CUERPO, "GARGANTA");
        parte.put(STATUS_CUERPO, 0);
        parte.put(IMAGEN_CUERPO, R.drawable.garganta);
        this.getWritableDatabase().insert(TABLE2,null,parte);

        parte.put(TABLE2_ID, 11);
        parte.put(PARTE_CUERPO, "RODILLAS");
        parte.put(STATUS_CUERPO, 0);
        parte.put(IMAGEN_CUERPO, R.drawable.rodilla);
        this.getWritableDatabase().insert(TABLE2,null,parte);

        parte.put(TABLE2_ID, 12);
        parte.put(PARTE_CUERPO, "PENE");
        parte.put(STATUS_CUERPO, 0);
        parte.put(IMAGEN_CUERPO, R.drawable.pene);
        this.getWritableDatabase().insert(TABLE2,null,parte);

        parte.put(TABLE2_ID, 13);
        parte.put(PARTE_CUERPO, "COLUMNA");
        parte.put(STATUS_CUERPO, 0);
        parte.put(IMAGEN_CUERPO, R.drawable.espalda);
        this.getWritableDatabase().insert(TABLE2,null,parte);

        parte.put(TABLE2_ID, 14);
        parte.put(PARTE_CUERPO, "CUELLO");
        parte.put(STATUS_CUERPO, 0);
        parte.put(IMAGEN_CUERPO, R.drawable.espalda);
        this.getWritableDatabase().insert(TABLE2,null,parte);

        parte.put(TABLE2_ID, 15);
        parte.put(PARTE_CUERPO, "ESPALDA");
        parte.put(STATUS_CUERPO, 0);
        parte.put(IMAGEN_CUERPO, R.drawable.espalda);
        this.getWritableDatabase().insert(TABLE2,null,parte);
    }
    public void addSintomas()
    {
        ContentValues sintoma = new ContentValues();

        sintoma.put(TABLE3_ID, 1);
        sintoma.put(SINTOMA, "Dolor de cabeza leve, molesto y continuo");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "CABEZA");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 2);
        sintoma.put(SINTOMA, "Sensación de tensión en la frente o laterales y la parte trasera de la cabeza");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "CABEZA");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 3);
        sintoma.put(SINTOMA, "Dolor con la palpación en los músculos del cuero cabelludo, el cuello y los hombros");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "CABEZA");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 4);
        sintoma.put(SINTOMA, "Mareos");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "CABEZA");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 5);
        sintoma.put(SINTOMA, "Náuseas");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "CABEZA");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 6);
        sintoma.put(SINTOMA, "Dolor de tímpano");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "CABEZA");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 7);
        sintoma.put(SINTOMA, "Sangrado nasal");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "CABEZA");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 8);
        sintoma.put(SINTOMA, "Dolor nasal");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "CABEZA");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 9);
        sintoma.put(SINTOMA, "Dolor de muelas");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "CABEZA");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 10);
        sintoma.put(SINTOMA, "Ardor ocular");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "CABEZA");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 11);
        sintoma.put(SINTOMA, "Estornudo frecuente");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "CABEZA");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 12);
        sintoma.put(SINTOMA, "Flujo nasal");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "CABEZA");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 14);
        sintoma.put(SINTOMA, "Inflamación");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "PECHO");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 15);
        sintoma.put(SINTOMA, "Falta de aire");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "PECHO");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 16);
        sintoma.put(SINTOMA, "Dolor de seno");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "PECHO");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 17);
        sintoma.put(SINTOMA, "Dolor o molestia en el pecho");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "PECHO");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 19);
        sintoma.put(SINTOMA, "Presión, compresión, ardor");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "PECHO");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 20);
        sintoma.put(SINTOMA, "Hinchazón de todo o parte del brazo");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "BRAZOS");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 21);
        sintoma.put(SINTOMA, "Sensación de pesadez o rigidez");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "BRAZOS");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 22);
        sintoma.put(SINTOMA, "Amplitud de movimiento limitada");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "BRAZOS");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 23);
        sintoma.put(SINTOMA, "Dolor o molestia");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "BRAZOS");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 24);
        sintoma.put(SINTOMA, "Infecciones recurrentes");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "BRAZOS");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 25);
        sintoma.put(SINTOMA, "Endurecimiento y engrosamiento de la piel");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "BRAZOS");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 26);
        sintoma.put(SINTOMA, "Torcedura");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "BRAZOS");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 27);
        sintoma.put(SINTOMA, "Fractura");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "BRAZOS");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 28);
        sintoma.put(SINTOMA, "Hormigueo");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "BRAZOS");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 29);
        sintoma.put(SINTOMA, "Torpeza de la mano al agarrar objetos");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "MANOS");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 30);
        sintoma.put(SINTOMA, "Entumecimiento u hormigueo en los dedos");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "MANOS");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 31);
        sintoma.put(SINTOMA, "Entumecimiento u hormigueo en la palma de la mano");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "MANOS");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 32);
        sintoma.put(SINTOMA, "Dolor en la mano o la muñeca");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "MANOS");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 33);
        sintoma.put(SINTOMA, "Problemas con los movimientos finos de los dedos (coordinación) en las manos");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "MANOS");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 34);
        sintoma.put(SINTOMA, "Tensión de ligamentos");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "MANOS");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 35);
        sintoma.put(SINTOMA, "Fractura");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "MANOS");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 36);
        sintoma.put(SINTOMA, "Dolor abdominal");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "ESTOMAGO");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 37);
        sintoma.put(SINTOMA, "Dolor vientre bajo");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "ESTOMAGO");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 38);
        sintoma.put(SINTOMA, "Estreñimiento");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "ESTOMAGO");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 39);
        sintoma.put(SINTOMA, "Ardor");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "ESTOMAGO");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 40);
        sintoma.put(SINTOMA, "Esponjamiento");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "ESTOMAGO");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 41);
        sintoma.put(SINTOMA, "Pérdida de apetito");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "ESTOMAGO");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 42);
        sintoma.put(SINTOMA, "Diarrea");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "ESTOMAGO");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 43);
        sintoma.put(SINTOMA, "Vómito");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "ESTOMAGO");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 44);
        sintoma.put(SINTOMA, "Hormigueo");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "PIERNAS");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 45);
        sintoma.put(SINTOMA, "Tirones");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "PIERNAS");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 46);
        sintoma.put(SINTOMA, "Sensación pulsátil");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "PIERNAS");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 47);
        sintoma.put(SINTOMA, "Dolor");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "PIERNAS");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 48);
        sintoma.put(SINTOMA, "Picazón");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "PIERNAS");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 49);
        sintoma.put(SINTOMA, "Fractura");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "PIERNAS");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 50);
        sintoma.put(SINTOMA, "Hinchazón");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "PIERNAS");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 51);
        sintoma.put(SINTOMA, "Calambres");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "PIERNAS");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 52);
        sintoma.put(SINTOMA, "Dolor en los dedos");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "PIES");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 53);
        sintoma.put(SINTOMA, "Dolor en la planta del pie");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "PIES");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 54);
        sintoma.put(SINTOMA, "Hormigueo");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "PIES");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 55);
        sintoma.put(SINTOMA, "Hinchazón");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "PIES");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 56);
        sintoma.put(SINTOMA, "Mal olor");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "PIES");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 57);
        sintoma.put(SINTOMA, "Picazón");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "PIES");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 58);
        sintoma.put(SINTOMA, "Uñas encarnadas");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "PIES");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 59);
        sintoma.put(SINTOMA, "Calambres");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "PIES");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 60);
        sintoma.put(SINTOMA, "Dolor");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "PANTORRILLAS");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 61);
        sintoma.put(SINTOMA, "Debilidad");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "PANTORRILLAS");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 62);
        sintoma.put(SINTOMA, "Sensación de ardor");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "PANTORRILLAS");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 63);
        sintoma.put(SINTOMA, "Dolor o molestia al tragar");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "GARGANTA");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 64);
        sintoma.put(SINTOMA, "Cambio de voz");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "GARGANTA");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 65);
        sintoma.put(SINTOMA, "Dolor de oído");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "GARGANTA");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 66);
        sintoma.put(SINTOMA, "Dolor de garganta");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "GARGANTA");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 67);
        sintoma.put(SINTOMA, "Orina con dolor");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "PENE");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 68);
        sintoma.put(SINTOMA, "Dolor en la parte baja de abdomen");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "PENE");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 69);
        sintoma.put(SINTOMA, "Secreción en el pene");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "PENE");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 70);
        sintoma.put(SINTOMA, "Dolor testicular");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "PENE");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 71);
        sintoma.put(SINTOMA, "Dolor en la relación sexual");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "PENE");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 72);
        sintoma.put(SINTOMA, "Dolor de espalda que baja hacia las piernas");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "CUELLO");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 73);
        sintoma.put(SINTOMA, "Debilidad o cansancio");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "CUELLO");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 74);
        sintoma.put(SINTOMA, "Dolor en el cuello");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "CUELLO");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 75);
        sintoma.put(SINTOMA, "Dolor de espalda que baja hacia las piernas");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "COLUMNA");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 76);
        sintoma.put(SINTOMA, "Debilidad o cansancio");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "COLUMNA");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 77);
        sintoma.put(SINTOMA, "Dolor en el cuello");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "COLUMNA");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 78);
        sintoma.put(SINTOMA, "Dolor de espalda que baja hacia las piernas");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "ESPALDA");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 79);
        sintoma.put(SINTOMA, "Debilidad o cansancio");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "ESPALDA");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);

        sintoma.put(TABLE3_ID, 80);
        sintoma.put(SINTOMA, "Dolor en el cuello");
        sintoma.put(STATUS_SINTOMA, 0);
        sintoma.put(SINTOMA_RELACION, "ESPALDA");
        this.getWritableDatabase().insert(TABLE3,null,sintoma);
    }
    public void addLengua(){
        ContentValues lengua = new ContentValues();

        lengua.put(TABLE4_ID, 1);
        lengua.put(LENGUA, "CH'OL DEL NORESTE");
        lengua.put(STATUS_LENGUA, 1);
        this.getWritableDatabase().insert(TABLE4,null,lengua);

        lengua.put(TABLE4_ID, 2);
        lengua.put(LENGUA, "TSOTSIL");
        lengua.put(STATUS_LENGUA, 0);
        this.getWritableDatabase().insert(TABLE4,null,lengua);

        lengua.put(TABLE4_ID, 3);
        lengua.put(LENGUA, "YOKOT`AN");
        lengua.put(STATUS_LENGUA, 0);
        this.getWritableDatabase().insert(TABLE4,null,lengua);

    }
    public void addAudiosFrases(){
        ContentValues alores = new ContentValues();

        alores.put(TABLE5_ID, 22);
        alores.put(AUDIO_FRASE, R.raw.f21);
        alores.put(FK_TB_FRASES, 1);
        alores.put(IDIOMA_AUDIO, 2);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 23);
        alores.put(AUDIO_FRASE, R.raw.f22);
        alores.put(FK_TB_FRASES, 2);
        alores.put(IDIOMA_AUDIO, 2);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 24);
        alores.put(AUDIO_FRASE, R.raw.f23);
        alores.put(FK_TB_FRASES, 3);
        alores.put(IDIOMA_AUDIO, 2);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 25);
        alores.put(AUDIO_FRASE, R.raw.f24);
        alores.put(FK_TB_FRASES, 4);
        alores.put(IDIOMA_AUDIO, 2);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 26);
        alores.put(AUDIO_FRASE, R.raw.f25);
        alores.put(FK_TB_FRASES, 5);
        alores.put(IDIOMA_AUDIO, 2);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 27);
        alores.put(AUDIO_FRASE, R.raw.f26);
        alores.put(FK_TB_FRASES, 6);
        alores.put(IDIOMA_AUDIO, 2);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 28);
        alores.put(AUDIO_FRASE, R.raw.f27);
        alores.put(FK_TB_FRASES, 7);
        alores.put(IDIOMA_AUDIO, 2);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 29);
        alores.put(AUDIO_FRASE, R.raw.f28);
        alores.put(FK_TB_FRASES, 8);
        alores.put(IDIOMA_AUDIO, 2);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 30);
        alores.put(AUDIO_FRASE, R.raw.f29);
        alores.put(FK_TB_FRASES, 9);
        alores.put(IDIOMA_AUDIO, 2);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 31);
        alores.put(AUDIO_FRASE, R.raw.f210);
        alores.put(FK_TB_FRASES, 10);
        alores.put(IDIOMA_AUDIO, 2);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 32);
        alores.put(AUDIO_FRASE, R.raw.f211);
        alores.put(FK_TB_FRASES, 11);
        alores.put(IDIOMA_AUDIO, 2);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 33);
        alores.put(AUDIO_FRASE, R.raw.f212);
        alores.put(FK_TB_FRASES, 12);
        alores.put(IDIOMA_AUDIO, 2);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 34);
        alores.put(AUDIO_FRASE, R.raw.f213);
        alores.put(FK_TB_FRASES, 13);
        alores.put(IDIOMA_AUDIO, 2);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 35);
        alores.put(AUDIO_FRASE, R.raw.f214);
        alores.put(FK_TB_FRASES, 14);
        alores.put(IDIOMA_AUDIO, 2);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 36);
        alores.put(AUDIO_FRASE, R.raw.f215);
        alores.put(FK_TB_FRASES, 15);
        alores.put(IDIOMA_AUDIO, 2);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 37);
        alores.put(AUDIO_FRASE, R.raw.f216);
        alores.put(FK_TB_FRASES, 16);
        alores.put(IDIOMA_AUDIO, 2);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 38);
        alores.put(AUDIO_FRASE, R.raw.f217);
        alores.put(FK_TB_FRASES, 17);
        alores.put(IDIOMA_AUDIO, 2);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 39);
        alores.put(AUDIO_FRASE, R.raw.f218);
        alores.put(FK_TB_FRASES, 18);
        alores.put(IDIOMA_AUDIO, 2);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 40);
        alores.put(AUDIO_FRASE, R.raw.f219);
        alores.put(FK_TB_FRASES, 19);
        alores.put(IDIOMA_AUDIO, 2);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 41);
        alores.put(AUDIO_FRASE, R.raw.f220);
        alores.put(FK_TB_FRASES, 20);
        alores.put(IDIOMA_AUDIO, 2);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 42);
        alores.put(AUDIO_FRASE, R.raw.f31);
        alores.put(FK_TB_FRASES, 1);
        alores.put(IDIOMA_AUDIO, 3);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 43);
        alores.put(AUDIO_FRASE, R.raw.f32);
        alores.put(FK_TB_FRASES, 2);
        alores.put(IDIOMA_AUDIO, 3);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 44);
        alores.put(AUDIO_FRASE, R.raw.f33);
        alores.put(FK_TB_FRASES, 3);
        alores.put(IDIOMA_AUDIO, 3);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 45);
        alores.put(AUDIO_FRASE, R.raw.f34);
        alores.put(FK_TB_FRASES, 4);
        alores.put(IDIOMA_AUDIO, 3);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 46);
        alores.put(AUDIO_FRASE, R.raw.f35);
        alores.put(FK_TB_FRASES, 5);
        alores.put(IDIOMA_AUDIO, 3);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 47);
        alores.put(AUDIO_FRASE, R.raw.f36);
        alores.put(FK_TB_FRASES, 6);
        alores.put(IDIOMA_AUDIO, 3);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 48);
        alores.put(AUDIO_FRASE, R.raw.f37);
        alores.put(FK_TB_FRASES, 7);
        alores.put(IDIOMA_AUDIO, 3);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 49);
        alores.put(AUDIO_FRASE, R.raw.f38);
        alores.put(FK_TB_FRASES, 8);
        alores.put(IDIOMA_AUDIO, 3);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 50);
        alores.put(AUDIO_FRASE, R.raw.f39);
        alores.put(FK_TB_FRASES, 9);
        alores.put(IDIOMA_AUDIO, 3);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 51);
        alores.put(AUDIO_FRASE, R.raw.f310);
        alores.put(FK_TB_FRASES, 10);
        alores.put(IDIOMA_AUDIO, 3);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 52);
        alores.put(AUDIO_FRASE, R.raw.f311);
        alores.put(FK_TB_FRASES, 11);
        alores.put(IDIOMA_AUDIO, 3);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 53);
        alores.put(AUDIO_FRASE, R.raw.f312);
        alores.put(FK_TB_FRASES, 12);
        alores.put(IDIOMA_AUDIO, 3);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 54);
        alores.put(AUDIO_FRASE, R.raw.f313);
        alores.put(FK_TB_FRASES, 13);
        alores.put(IDIOMA_AUDIO, 3);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 55);
        alores.put(AUDIO_FRASE, R.raw.f314);
        alores.put(FK_TB_FRASES, 14);
        alores.put(IDIOMA_AUDIO, 3);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 56);
        alores.put(AUDIO_FRASE, R.raw.f315);
        alores.put(FK_TB_FRASES, 15);
        alores.put(IDIOMA_AUDIO, 3);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 57);
        alores.put(AUDIO_FRASE, R.raw.f316);
        alores.put(FK_TB_FRASES, 16);
        alores.put(IDIOMA_AUDIO, 3);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 58);
        alores.put(AUDIO_FRASE, R.raw.f317);
        alores.put(FK_TB_FRASES, 17);
        alores.put(IDIOMA_AUDIO, 3);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 59);
        alores.put(AUDIO_FRASE, R.raw.f318);
        alores.put(FK_TB_FRASES, 18);
        alores.put(IDIOMA_AUDIO, 3);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 60);
        alores.put(AUDIO_FRASE, R.raw.f319);
        alores.put(FK_TB_FRASES, 19);
        alores.put(IDIOMA_AUDIO, 3);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 61);
        alores.put(AUDIO_FRASE, R.raw.f320);
        alores.put(FK_TB_FRASES, 20);
        alores.put(IDIOMA_AUDIO, 3);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 62);
        alores.put(AUDIO_FRASE, R.raw.f41);
        alores.put(FK_TB_FRASES, 1);
        alores.put(IDIOMA_AUDIO, 1);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 63);
        alores.put(AUDIO_FRASE, R.raw.f42);
        alores.put(FK_TB_FRASES, 2);
        alores.put(IDIOMA_AUDIO, 1);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 64);
        alores.put(AUDIO_FRASE, R.raw.f43);
        alores.put(FK_TB_FRASES, 3);
        alores.put(IDIOMA_AUDIO, 1);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 65);
        alores.put(AUDIO_FRASE, R.raw.f44);
        alores.put(FK_TB_FRASES, 4);
        alores.put(IDIOMA_AUDIO, 1);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 66);
        alores.put(AUDIO_FRASE, R.raw.f45);
        alores.put(FK_TB_FRASES, 5);
        alores.put(IDIOMA_AUDIO, 1);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 67);
        alores.put(AUDIO_FRASE, R.raw.f46);
        alores.put(FK_TB_FRASES, 6);
        alores.put(IDIOMA_AUDIO, 1);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 68);
        alores.put(AUDIO_FRASE, R.raw.f47);
        alores.put(FK_TB_FRASES, 7);
        alores.put(IDIOMA_AUDIO, 1);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 69);
        alores.put(AUDIO_FRASE, R.raw.f48);
        alores.put(FK_TB_FRASES, 8);
        alores.put(IDIOMA_AUDIO, 1);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 70);
        alores.put(AUDIO_FRASE, R.raw.f49);
        alores.put(FK_TB_FRASES, 9);
        alores.put(IDIOMA_AUDIO, 1);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 71);
        alores.put(AUDIO_FRASE, R.raw.f410);
        alores.put(FK_TB_FRASES, 10);
        alores.put(IDIOMA_AUDIO, 1);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 72);
        alores.put(AUDIO_FRASE, R.raw.f411);
        alores.put(FK_TB_FRASES, 11);
        alores.put(IDIOMA_AUDIO, 1);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 73);
        alores.put(AUDIO_FRASE, R.raw.f412);
        alores.put(FK_TB_FRASES, 12);
        alores.put(IDIOMA_AUDIO, 1);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 74);
        alores.put(AUDIO_FRASE, R.raw.f413);
        alores.put(FK_TB_FRASES, 13);
        alores.put(IDIOMA_AUDIO, 1);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 75);
        alores.put(AUDIO_FRASE, R.raw.f414);
        alores.put(FK_TB_FRASES, 14);
        alores.put(IDIOMA_AUDIO, 1);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 76);
        alores.put(AUDIO_FRASE, R.raw.f415);
        alores.put(FK_TB_FRASES, 15);
        alores.put(IDIOMA_AUDIO, 1);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 77);
        alores.put(AUDIO_FRASE, R.raw.f416);
        alores.put(FK_TB_FRASES, 16);
        alores.put(IDIOMA_AUDIO, 1);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 78);
        alores.put(AUDIO_FRASE, R.raw.f417);
        alores.put(FK_TB_FRASES, 17);
        alores.put(IDIOMA_AUDIO, 1);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 79);
        alores.put(AUDIO_FRASE, R.raw.f418);
        alores.put(FK_TB_FRASES, 18);
        alores.put(IDIOMA_AUDIO, 1);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 80);
        alores.put(AUDIO_FRASE, R.raw.f419);
        alores.put(FK_TB_FRASES, 19);
        alores.put(IDIOMA_AUDIO, 1);
        this.getWritableDatabase().insert(TABLE5,null,alores);

        alores.put(TABLE5_ID, 81);
        alores.put(AUDIO_FRASE, R.raw.f420);
        alores.put(FK_TB_FRASES, 20);
        alores.put(IDIOMA_AUDIO, 1);
        this.getWritableDatabase().insert(TABLE5,null,alores);
    }
    public void addAudiosSintomas(){
        ContentValues audio = new ContentValues();

        audio.put(TABLE6_ID, 81);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "CABEZA");
        audio.put(SINTOMA_AUDIO, R.raw.c211);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 82);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "CABEZA");
        audio.put(SINTOMA_AUDIO, R.raw.c212);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 83);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "CABEZA");
        audio.put(SINTOMA_AUDIO, R.raw.c213);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 84);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "CABEZA");
        audio.put(SINTOMA_AUDIO, R.raw.c214);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 85);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "CABEZA");
        audio.put(SINTOMA_AUDIO, R.raw.c215);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 86);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "CABEZA");
        audio.put(SINTOMA_AUDIO, R.raw.c216);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 87);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "CABEZA");
        audio.put(SINTOMA_AUDIO, R.raw.c217);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 88);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "CABEZA");
        audio.put(SINTOMA_AUDIO, R.raw.c218);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 89);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "CABEZA");
        audio.put(SINTOMA_AUDIO, R.raw.c219);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 90);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "CABEZA");
        audio.put(SINTOMA_AUDIO, R.raw.c2110);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 91);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "CABEZA");
        audio.put(SINTOMA_AUDIO, R.raw.c2111);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 92);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "CABEZA");
        audio.put(SINTOMA_AUDIO, R.raw.c2112);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 93);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "PECHO");
        audio.put(SINTOMA_AUDIO, R.raw.p221);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 94);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "PECHO");
        audio.put(SINTOMA_AUDIO, R.raw.p222);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 95);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "PECHO");
        audio.put(SINTOMA_AUDIO, R.raw.p223);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 96);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "PECHO");
        audio.put(SINTOMA_AUDIO, R.raw.p224);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 97);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "PECHO");
        audio.put(SINTOMA_AUDIO, R.raw.p225);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 98);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "BRAZOS");
        audio.put(SINTOMA_AUDIO, R.raw.b231);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 99);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "BRAZOS");
        audio.put(SINTOMA_AUDIO, R.raw.b232);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 100);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "BRAZOS");
        audio.put(SINTOMA_AUDIO, R.raw.b233);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 101);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "BRAZOS");
        audio.put(SINTOMA_AUDIO, R.raw.b234);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 102);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "BRAZOS");
        audio.put(SINTOMA_AUDIO, R.raw.b235);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 103);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "BRAZOS");
        audio.put(SINTOMA_AUDIO, R.raw.b236);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 104);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "BRAZOS");
        audio.put(SINTOMA_AUDIO, R.raw.b237);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 105);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "BRAZOS");
        audio.put(SINTOMA_AUDIO, R.raw.b238);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 106);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "BRAZOS");
        audio.put(SINTOMA_AUDIO, R.raw.b239);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 107);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "MANOS");
        audio.put(SINTOMA_AUDIO, R.raw.m241);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 108);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "MANOS");
        audio.put(SINTOMA_AUDIO, R.raw.m242);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 109);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "MANOS");
        audio.put(SINTOMA_AUDIO, R.raw.m243);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 110);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "MANOS");
        audio.put(SINTOMA_AUDIO, R.raw.m244);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 111);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "MANOS");
        audio.put(SINTOMA_AUDIO, R.raw.m245);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 112);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "MANOS");
        audio.put(SINTOMA_AUDIO, R.raw.m246);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 113);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "MANOS");
        audio.put(SINTOMA_AUDIO, R.raw.m247);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 114);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "ESTOMAGO");
        audio.put(SINTOMA_AUDIO, R.raw.e251);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 115);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "ESTOMAGO");
        audio.put(SINTOMA_AUDIO, R.raw.e252);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 116);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "ESTOMAGO");
        audio.put(SINTOMA_AUDIO, R.raw.e253);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 117);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "ESTOMAGO");
        audio.put(SINTOMA_AUDIO, R.raw.e254);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 118);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "ESTOMAGO");
        audio.put(SINTOMA_AUDIO, R.raw.e255);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 119);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "ESTOMAGO");
        audio.put(SINTOMA_AUDIO, R.raw.e256);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 120);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "ESTOMAGO");
        audio.put(SINTOMA_AUDIO, R.raw.e257);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 121);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "ESTOMAGO");
        audio.put(SINTOMA_AUDIO, R.raw.e258);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 122);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "PIERNAS");
        audio.put(SINTOMA_AUDIO, R.raw.pier261);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 123);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "PIERNAS");
        audio.put(SINTOMA_AUDIO, R.raw.pier262);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 124);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "PIERNAS");
        audio.put(SINTOMA_AUDIO, R.raw.pier263);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 125);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "PIERNAS");
        audio.put(SINTOMA_AUDIO, R.raw.pier264);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID,126);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "PIERNAS");
        audio.put(SINTOMA_AUDIO, R.raw.pier265);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 127);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "PIERNAS");
        audio.put(SINTOMA_AUDIO, R.raw.pier266);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 128);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "PIERNAS");
        audio.put(SINTOMA_AUDIO, R.raw.pier267);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 129);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "PIERNAS");
        audio.put(SINTOMA_AUDIO, R.raw.pier268);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 130);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "PIES");
        audio.put(SINTOMA_AUDIO, R.raw.pie271);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 131);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "PIES");
        audio.put(SINTOMA_AUDIO, R.raw.pie272);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 132);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "PIES");
        audio.put(SINTOMA_AUDIO, R.raw.pie273);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 133);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "PIES");
        audio.put(SINTOMA_AUDIO, R.raw.pie274);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 134);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "PIES");
        audio.put(SINTOMA_AUDIO, R.raw.pie275);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 135);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "PIES");
        audio.put(SINTOMA_AUDIO, R.raw.pie276);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 136);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "PIES");
        audio.put(SINTOMA_AUDIO, R.raw.pie277);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 137);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "PIES");
        audio.put(SINTOMA_AUDIO, R.raw.pie278);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 138);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "PANTORRILLAS");
        audio.put(SINTOMA_AUDIO, R.raw.pan281);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 139);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "PANTORRILLAS");
        audio.put(SINTOMA_AUDIO, R.raw.pan282);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 140);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "PANTORRILLAS");
        audio.put(SINTOMA_AUDIO, R.raw.pan283);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 141);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "GARGANTA");
        audio.put(SINTOMA_AUDIO, R.raw.g291);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 142);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "GARGANTA");
        audio.put(SINTOMA_AUDIO, R.raw.g292);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 143);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "GARGANTA");
        audio.put(SINTOMA_AUDIO, R.raw.g293);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 144);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "GARGANTA");
        audio.put(SINTOMA_AUDIO, R.raw.g294);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 145);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "PENE");
        audio.put(SINTOMA_AUDIO, R.raw.pen2101);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 146);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "PENE");
        audio.put(SINTOMA_AUDIO, R.raw.pen2102);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 147);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "PENE");
        audio.put(SINTOMA_AUDIO, R.raw.pen2103);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 148);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "PENE");
        audio.put(SINTOMA_AUDIO, R.raw.pen2104);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 149);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "PENE");
        audio.put(SINTOMA_AUDIO, R.raw.pen2105);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 150);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "CUELLO");
        audio.put(SINTOMA_AUDIO, R.raw.cue2111);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 151);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "CUELLO");
        audio.put(SINTOMA_AUDIO, R.raw.cue2112);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 152);
        audio.put(IDIOMA_AUDIO_SINTOMA, 2);
        audio.put(FK_TB_CUERPO, "CUELLO");
        audio.put(SINTOMA_AUDIO, R.raw.cue2113);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 153);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "CABEZA");
        audio.put(SINTOMA_AUDIO, R.raw.c311);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 154);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "CABEZA");
        audio.put(SINTOMA_AUDIO, R.raw.c312);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 155);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "CABEZA");
        audio.put(SINTOMA_AUDIO, R.raw.c313);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 156);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "CABEZA");
        audio.put(SINTOMA_AUDIO, R.raw.c314);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 157);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "CABEZA");
        audio.put(SINTOMA_AUDIO, R.raw.c315);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 158);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "CABEZA");
        audio.put(SINTOMA_AUDIO, R.raw.c316);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 159);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "CABEZA");
        audio.put(SINTOMA_AUDIO, R.raw.c317);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 160);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "CABEZA");
        audio.put(SINTOMA_AUDIO, R.raw.c318);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 161);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "CABEZA");
        audio.put(SINTOMA_AUDIO, R.raw.c319);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 162);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "CABEZA");
        audio.put(SINTOMA_AUDIO, R.raw.c3110);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 163);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "CABEZA");
        audio.put(SINTOMA_AUDIO, R.raw.c3111);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 164);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "CABEZA");
        audio.put(SINTOMA_AUDIO, R.raw.c3112);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 165);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "PECHO");
        audio.put(SINTOMA_AUDIO, R.raw.p321);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 166);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "PECHO");
        audio.put(SINTOMA_AUDIO, R.raw.p322);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 167);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "PECHO");
        audio.put(SINTOMA_AUDIO, R.raw.p323);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 168);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "PECHO");
        audio.put(SINTOMA_AUDIO, R.raw.p324);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 169);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "PECHO");
        audio.put(SINTOMA_AUDIO, R.raw.p325);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 170);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "BRAZOS");
        audio.put(SINTOMA_AUDIO, R.raw.b331);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 171);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "BRAZOS");
        audio.put(SINTOMA_AUDIO, R.raw.b332);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 172);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "BRAZOS");
        audio.put(SINTOMA_AUDIO, R.raw.b333);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 173);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "BRAZOS");
        audio.put(SINTOMA_AUDIO, R.raw.b334);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 174);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "BRAZOS");
        audio.put(SINTOMA_AUDIO, R.raw.b335);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 175);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "BRAZOS");
        audio.put(SINTOMA_AUDIO, R.raw.b336);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 176);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "BRAZOS");
        audio.put(SINTOMA_AUDIO, R.raw.b337);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 177);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "BRAZOS");
        audio.put(SINTOMA_AUDIO, R.raw.b338);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 178);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "BRAZOS");
        audio.put(SINTOMA_AUDIO, R.raw.b339);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 179);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "MANOS");
        audio.put(SINTOMA_AUDIO, R.raw.m341);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 180);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "MANOS");
        audio.put(SINTOMA_AUDIO, R.raw.m342);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 181);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "MANOS");
        audio.put(SINTOMA_AUDIO, R.raw.m343);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 182);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "MANOS");
        audio.put(SINTOMA_AUDIO, R.raw.m344);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 183);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "MANOS");
        audio.put(SINTOMA_AUDIO, R.raw.m345);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 184);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "MANOS");
        audio.put(SINTOMA_AUDIO, R.raw.m346);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 185);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "MANOS");
        audio.put(SINTOMA_AUDIO, R.raw.m347);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 186);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "ESTOMAGO");
        audio.put(SINTOMA_AUDIO, R.raw.e351);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 187);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "ESTOMAGO");
        audio.put(SINTOMA_AUDIO, R.raw.e352);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 188);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "ESTOMAGO");
        audio.put(SINTOMA_AUDIO, R.raw.e353);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 189);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "ESTOMAGO");
        audio.put(SINTOMA_AUDIO, R.raw.e354);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 190);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "ESTOMAGO");
        audio.put(SINTOMA_AUDIO, R.raw.e355);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 191);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "ESTOMAGO");
        audio.put(SINTOMA_AUDIO, R.raw.e356);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 192);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "ESTOMAGO");
        audio.put(SINTOMA_AUDIO, R.raw.e357);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 193);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "ESTOMAGO");
        audio.put(SINTOMA_AUDIO, R.raw.e358);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 194);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "PIERNAS");
        audio.put(SINTOMA_AUDIO, R.raw.pier361);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 195);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "PIERNAS");
        audio.put(SINTOMA_AUDIO, R.raw.pier362);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 196);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "PIERNAS");
        audio.put(SINTOMA_AUDIO, R.raw.pier363);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 197);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "PIERNAS");
        audio.put(SINTOMA_AUDIO, R.raw.pier364);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID,198);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "PIERNAS");
        audio.put(SINTOMA_AUDIO, R.raw.pier365);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 199);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "PIERNAS");
        audio.put(SINTOMA_AUDIO, R.raw.pier366);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 200);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "PIERNAS");
        audio.put(SINTOMA_AUDIO, R.raw.pier367);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 201);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "PIERNAS");
        audio.put(SINTOMA_AUDIO, R.raw.pier368);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 202);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "PIES");
        audio.put(SINTOMA_AUDIO, R.raw.pie371);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 203);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "PIES");
        audio.put(SINTOMA_AUDIO, R.raw.pie372);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 204);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "PIES");
        audio.put(SINTOMA_AUDIO, R.raw.pie373);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 205);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "PIES");
        audio.put(SINTOMA_AUDIO, R.raw.pie374);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 206);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "PIES");
        audio.put(SINTOMA_AUDIO, R.raw.pie375);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 207);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "PIES");
        audio.put(SINTOMA_AUDIO, R.raw.pie376);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 208);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "PIES");
        audio.put(SINTOMA_AUDIO, R.raw.pie377);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 209);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "PIES");
        audio.put(SINTOMA_AUDIO, R.raw.pie378);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 210);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "PANTORRILLAS");
        audio.put(SINTOMA_AUDIO, R.raw.pan381);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 211);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "PANTORRILLAS");
        audio.put(SINTOMA_AUDIO, R.raw.pan382);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 212);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "PANTORRILLAS");
        audio.put(SINTOMA_AUDIO, R.raw.pan383);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 213);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "GARGANTA");
        audio.put(SINTOMA_AUDIO, R.raw.g391);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 214);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "GARGANTA");
        audio.put(SINTOMA_AUDIO, R.raw.g392);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 215);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "GARGANTA");
        audio.put(SINTOMA_AUDIO, R.raw.g393);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 216);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "GARGANTA");
        audio.put(SINTOMA_AUDIO, R.raw.g394);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 217);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "PENE");
        audio.put(SINTOMA_AUDIO, R.raw.pen3101);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 218);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "PENE");
        audio.put(SINTOMA_AUDIO, R.raw.pen3102);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 219);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "PENE");
        audio.put(SINTOMA_AUDIO, R.raw.pen3103);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 220);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "PENE");
        audio.put(SINTOMA_AUDIO, R.raw.pen3104);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 221);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "PENE");
        audio.put(SINTOMA_AUDIO, R.raw.pen3105);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 222);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "CUELLO");
        audio.put(SINTOMA_AUDIO, R.raw.cue3111);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 223);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "CUELLO");
        audio.put(SINTOMA_AUDIO, R.raw.cue3112);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 224);
        audio.put(IDIOMA_AUDIO_SINTOMA, 3);
        audio.put(FK_TB_CUERPO, "CUELLO");
        audio.put(SINTOMA_AUDIO, R.raw.cue3113);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 225);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "CABEZA");
        audio.put(SINTOMA_AUDIO, R.raw.c411);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 226);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "CABEZA");
        audio.put(SINTOMA_AUDIO, R.raw.c412);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 227);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "CABEZA");
        audio.put(SINTOMA_AUDIO, R.raw.c413);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 228);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "CABEZA");
        audio.put(SINTOMA_AUDIO, R.raw.c414);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 229);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "CABEZA");
        audio.put(SINTOMA_AUDIO, R.raw.c415);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 230);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "CABEZA");
        audio.put(SINTOMA_AUDIO, R.raw.c416);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 231);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "CABEZA");
        audio.put(SINTOMA_AUDIO, R.raw.c417);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 232);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "CABEZA");
        audio.put(SINTOMA_AUDIO, R.raw.c418);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 233);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "CABEZA");
        audio.put(SINTOMA_AUDIO, R.raw.c419);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 234);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "CABEZA");
        audio.put(SINTOMA_AUDIO, R.raw.c4110);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 235);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "CABEZA");
        audio.put(SINTOMA_AUDIO, R.raw.c4111);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 236);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "CABEZA");
        audio.put(SINTOMA_AUDIO, R.raw.c4112);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 237);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "PECHO");
        audio.put(SINTOMA_AUDIO, R.raw.p421);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 238);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "PECHO");
        audio.put(SINTOMA_AUDIO, R.raw.p422);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 239);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "PECHO");
        audio.put(SINTOMA_AUDIO, R.raw.p423);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 240);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "PECHO");
        audio.put(SINTOMA_AUDIO, R.raw.p424);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 241);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "PECHO");
        audio.put(SINTOMA_AUDIO, R.raw.p425);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 242);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "BRAZOS");
        audio.put(SINTOMA_AUDIO, R.raw.b431);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 243);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "BRAZOS");
        audio.put(SINTOMA_AUDIO, R.raw.b432);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 244);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "BRAZOS");
        audio.put(SINTOMA_AUDIO, R.raw.b433);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 245);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "BRAZOS");
        audio.put(SINTOMA_AUDIO, R.raw.b434);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 246);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "BRAZOS");
        audio.put(SINTOMA_AUDIO, R.raw.b435);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 247);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "BRAZOS");
        audio.put(SINTOMA_AUDIO, R.raw.b436);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 248);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "BRAZOS");
        audio.put(SINTOMA_AUDIO, R.raw.b437);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 249);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "BRAZOS");
        audio.put(SINTOMA_AUDIO, R.raw.b438);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 250);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "BRAZOS");
        audio.put(SINTOMA_AUDIO, R.raw.b439);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 251);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "MANOS");
        audio.put(SINTOMA_AUDIO, R.raw.m441);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 252);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "MANOS");
        audio.put(SINTOMA_AUDIO, R.raw.m442);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 253);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "MANOS");
        audio.put(SINTOMA_AUDIO, R.raw.m443);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 254);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "MANOS");
        audio.put(SINTOMA_AUDIO, R.raw.m444);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 255);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "MANOS");
        audio.put(SINTOMA_AUDIO, R.raw.m445);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 256);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "MANOS");
        audio.put(SINTOMA_AUDIO, R.raw.m446);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 257);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "MANOS");
        audio.put(SINTOMA_AUDIO, R.raw.m447);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 258);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "ESTOMAGO");
        audio.put(SINTOMA_AUDIO, R.raw.e451);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 259);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "ESTOMAGO");
        audio.put(SINTOMA_AUDIO, R.raw.e452);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 260);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "ESTOMAGO");
        audio.put(SINTOMA_AUDIO, R.raw.e453);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 261);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "ESTOMAGO");
        audio.put(SINTOMA_AUDIO, R.raw.e454);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 262);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "ESTOMAGO");
        audio.put(SINTOMA_AUDIO, R.raw.e455);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 263);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "ESTOMAGO");
        audio.put(SINTOMA_AUDIO, R.raw.e456);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 264);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "ESTOMAGO");
        audio.put(SINTOMA_AUDIO, R.raw.e457);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 265);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "ESTOMAGO");
        audio.put(SINTOMA_AUDIO, R.raw.e458);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 266);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "PIERNAS");
        audio.put(SINTOMA_AUDIO, R.raw.pier461);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 267);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "PIERNAS");
        audio.put(SINTOMA_AUDIO, R.raw.pier462);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 268);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "PIERNAS");
        audio.put(SINTOMA_AUDIO, R.raw.pier463);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 269);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "PIERNAS");
        audio.put(SINTOMA_AUDIO, R.raw.pier464);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 270);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "PIERNAS");
        audio.put(SINTOMA_AUDIO, R.raw.pier465);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 271);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "PIERNAS");
        audio.put(SINTOMA_AUDIO, R.raw.pier466);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 272);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "PIERNAS");
        audio.put(SINTOMA_AUDIO, R.raw.pier467);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 273);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "PIERNAS");
        audio.put(SINTOMA_AUDIO, R.raw.pier468);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 274);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "PIES");
        audio.put(SINTOMA_AUDIO, R.raw.pie471);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 275);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "PIES");
        audio.put(SINTOMA_AUDIO, R.raw.pie472);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 276);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "PIES");
        audio.put(SINTOMA_AUDIO, R.raw.pie473);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 277);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "PIES");
        audio.put(SINTOMA_AUDIO, R.raw.pie474);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 278);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "PIES");
        audio.put(SINTOMA_AUDIO, R.raw.pie475);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 279);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "PIES");
        audio.put(SINTOMA_AUDIO, R.raw.pie476);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 280);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "PIES");
        audio.put(SINTOMA_AUDIO, R.raw.pie477);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 281);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "PIES");
        audio.put(SINTOMA_AUDIO, R.raw.pie478);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 282);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "PANTORRILLAS");
        audio.put(SINTOMA_AUDIO, R.raw.pan481);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 283);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "PANTORRILLAS");
        audio.put(SINTOMA_AUDIO, R.raw.pan482);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 284);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "PANTORRILLAS");
        audio.put(SINTOMA_AUDIO, R.raw.pan483);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 285);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "GARGANTA");
        audio.put(SINTOMA_AUDIO, R.raw.g491);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 286);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "GARGANTA");
        audio.put(SINTOMA_AUDIO, R.raw.g492);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 287);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "GARGANTA");
        audio.put(SINTOMA_AUDIO, R.raw.g493);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 288);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "GARGANTA");
        audio.put(SINTOMA_AUDIO, R.raw.g494);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 289);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "PENE");
        audio.put(SINTOMA_AUDIO, R.raw.pen4101);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 290);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "PENE");
        audio.put(SINTOMA_AUDIO, R.raw.pen4102);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 291);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "PENE");
        audio.put(SINTOMA_AUDIO, R.raw.pen4103);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 292);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "PENE");
        audio.put(SINTOMA_AUDIO, R.raw.pen4104);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 293);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "PENE");
        audio.put(SINTOMA_AUDIO, R.raw.pen4105);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 294);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "CUELLO");
        audio.put(SINTOMA_AUDIO, R.raw.cue4111);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 295);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "CUELLO");
        audio.put(SINTOMA_AUDIO, R.raw.cue4112);
        this.getWritableDatabase().insert(TABLE6,null,audio);

        audio.put(TABLE6_ID, 296);
        audio.put(IDIOMA_AUDIO_SINTOMA, 1);
        audio.put(FK_TB_CUERPO, "CUELLO");
        audio.put(SINTOMA_AUDIO, R.raw.cue4113);
        this.getWritableDatabase().insert(TABLE6,null,audio);
    }
}
