package com.example.estebanlz.proyecto;

import android.app.Fragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import static com.example.estebanlz.proyecto.R.menu.language_menu;

public class SintomaEspecificoFragment extends android.support.v4.app.Fragment implements MenuItem.OnActionExpandListener{
    public static String Parte;
    String error = "";
    Registros db;
    ArrayList<SintomasVO> sintomasConsult;
    ArrayList<AudioSintomasVO> audioSintomasConsult;
    View rootView;
    RecyclerView sintomaEsp;
    TextView cabecera;
    Button confSintomas;
    public static int contador = 0;
    private AdaptadorSintomaEspecifico adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Sintomas");
        rootView = inflater.inflate(R.layout.lista_sintomas, container, false);
        cabecera = (TextView) rootView.findViewById(R.id.parte_del_cuerpo);
        sintomaEsp = (RecyclerView) rootView.findViewById(R.id.recyclerSintomaEspecifico);
        confSintomas = (Button) rootView.findViewById(R.id.confSintomas);
        confSintomas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador = sumar(Parte);
                if(contador != 0){
                    DiagnosticoFragment.contar++;
                    getActivity().onBackPressed();
                }
                else{
                    Toast.makeText(getActivity(), "El paciente debe presentar al menos uno de los sintomas", Toast.LENGTH_LONG).show();
                }
            }
        });
        sintomaEsp.setLayoutManager(new LinearLayoutManager(getActivity()));
        sintomasConsult = new ArrayList<SintomasVO>();
        audioSintomasConsult = new ArrayList<AudioSintomasVO>();
        llenar();
        int idioma = IdiomaActual();
        llenarAudios(idioma);
        actualizarStatusSintoma();
        controlFragmento.frag = 4;
        cabecera.setText(Parte);
        try{
            adapter = new AdaptadorSintomaEspecifico(getActivity(), sintomasConsult, audioSintomasConsult);
            sintomaEsp.setAdapter(adapter);
        }
        catch (Exception e){
            Toast.makeText(getActivity(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
        return rootView;
    }
    private int sumar(String parte){
        db = new Registros(getActivity().getApplicationContext());
        SQLiteDatabase base = db.getReadableDatabase();
        Cursor c = base.rawQuery("SELECT COUNT (*) FROM " + db.TABLE3 + " WHERE " + db.STATUS_SINTOMA + " = 1" + " AND " + db.SINTOMA_RELACION + " = '" + parte +"'", null);
        int valor = 0;
        if(null != c)
            if(c.getCount() > 0){
                c.moveToFirst();
                valor = c.getInt(0);
            }
        c.close();
        return valor;
    }
    public int IdiomaActual(){
        int idioma = 0;
        try {
            db = new Registros(getActivity().getApplicationContext());
            SQLiteDatabase base = db.getWritableDatabase();
            Cursor c = base.rawQuery("SELECT " + db.TABLE4_ID + " FROM " + db.TABLE4 + " WHERE " + db.STATUS_LENGUA + " = 1" , null);
            if (c != null) {
                c.moveToFirst();
                do {
                    idioma = c.getInt(0);
                } while (c.moveToNext());
            }
        } catch (Exception es) {
            Log.e("Error idioma",es.getMessage());
        }
        return idioma;
    }
    public void llenar(){
        try {
            db = new Registros(getActivity().getApplicationContext());
            SQLiteDatabase base = db.getWritableDatabase();
            SintomasVO sintoma = null;
            Cursor c = base.rawQuery("SELECT * FROM " + db.TABLE3 + " WHERE " + db.SINTOMA_RELACION + " = '" + Parte + "'", null);
            if (c != null) {
                c.moveToFirst();
                do {
                    sintoma = new SintomasVO();
                    sintoma.setId_sintoma(c.getInt(0));
                    sintoma.setSintoma(c.getString(1));
                    sintoma.setStatus_sintoma(c.getInt(2));
                    sintoma.setSintoma_relacion(c.getString(3));
                    sintomasConsult.add(sintoma);
                } while (c.moveToNext());
            }
        } catch (Exception es) {
        }
    }
    public void llenarAudios(int idioma){
        try {
            db = new Registros(getActivity().getApplicationContext());
            SQLiteDatabase base = db.getWritableDatabase();
            AudioSintomasVO sintoma = null;
            int count = 0;
            Cursor c = base.rawQuery("SELECT " + db.SINTOMA_AUDIO + " FROM " + db.TABLE6 + " WHERE " + db.FK_TB_CUERPO + " = '" + Parte + "' AND " + db.IDIOMA_AUDIO_SINTOMA + " = " + idioma, null);
            if (c != null) {
                c.moveToFirst();
                do {
                    count = c.getInt(0);
                    sintoma = new AudioSintomasVO();
                    sintoma.setSintoma_audio(c.getInt(0));
                    audioSintomasConsult.add(sintoma);
                } while (c.moveToNext());
            }
        } catch (Exception es) {
        }
    }
    public void actualizarStatusSintoma(){
        db = new Registros(getActivity().getApplicationContext());
        SQLiteDatabase base = db.getWritableDatabase();
        base.execSQL("UPDATE " + db.TABLE3 + " SET " + db.STATUS_SINTOMA + " = " + 0 + " WHERE " + db.SINTOMA_RELACION + " = '" + Parte + "'");
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(language_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        if(id == R.id.action_language){
            transaction.replace(R.id.contenedor, new SettingsFragment()).commit();
            transaction.addToBackStack(null);
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onMenuItemActionExpand(MenuItem item) {
        return true;
    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem item) {
        return true;
    }
}
