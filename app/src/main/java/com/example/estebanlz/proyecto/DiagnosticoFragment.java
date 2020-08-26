package com.example.estebanlz.proyecto;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class DiagnosticoFragment extends Fragment {
    RecyclerView diagnostico;
    AdaptadorFinal adapter;
    View rootView;
    Registros db;
    ArrayList<SintomasVO> sintomasFinal;
    ArrayList<CuerpoVo> cuerpoFinal;
    public static int contar = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Diagnosticar");
        rootView = inflater.inflate(R.layout.fragment_diagnosticar, container, false);
        controlFragmento.frag = 4;
            sintomasFinal = new ArrayList<>();
            cuerpoFinal = new ArrayList<>();
            diagnostico = (RecyclerView) rootView.findViewById(R.id.recyclerFinal1);
            diagnostico.setLayoutManager(new LinearLayoutManager(getActivity()));
            SintomasConsulta();
            adapter = new AdaptadorFinal(getActivity(),cuerpoFinal);
        try{
            diagnostico.setAdapter(adapter);
        }
        catch (Exception e){
        }
        return rootView;
    }
    private void SintomasConsulta(){
        try {
            db = new Registros(getActivity().getApplicationContext());
            SQLiteDatabase base = db.getWritableDatabase();
            CuerpoVo parte = null;
            Cursor c = base.rawQuery("SELECT * FROM " + db.TABLE2 + " WHERE " + db.STATUS_CUERPO +  " = 1", null);
            if (c != null) {
                c.moveToFirst();
                do {
                    parte = new CuerpoVo();
                    parte.setId_cuerpo(c.getInt(0));
                    parte.setCuerpo(c.getString(1));
                    parte.setStatus_cuerpo(c.getInt(2));
                    parte.setImg_cuerpo(c.getInt(3));
                    cuerpoFinal.add(parte);
                } while (c.moveToNext());
            }
        } catch (Exception es) {
        }
    }
    private void SintomasConsulta2(String sintoma){
        try {
            db = new Registros(getActivity().getApplicationContext());
            SQLiteDatabase base = db.getWritableDatabase();
            SintomasVO sintomas = null;
            Cursor c = base.rawQuery("SELECT ( " + db.SINTOMA +") FROM " + db.TABLE3 + " WHERE " + db.SINTOMA_RELACION + " = '" + sintoma + "'", null);
            if (c != null) {
                c.moveToFirst();
                do {
                    sintomas = new SintomasVO();
                    sintomas.setSintoma(c.getString(1));
                    sintomasFinal.add(sintomas);
                } while (c.moveToNext());
            }
        } catch (Exception es) {
        }
    }
}
