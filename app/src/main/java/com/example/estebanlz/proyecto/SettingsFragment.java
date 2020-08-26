package com.example.estebanlz.proyecto;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class SettingsFragment extends Fragment {
    View rootView;
    Registros db;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Idioma");
        //UpdateLanguage(2);
        LaunchPreferenceFragment();
        controlFragmento.frag = 2;
        rootView = inflater.inflate(R.layout.fragment_setting, container, false);
        return rootView;
    }
    public void LaunchPreferenceFragment(){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.contenedor, new PreferenceFragment()).commit();
    }
    public void UpdateLanguage(int language) {
        try {
            db = new Registros(getActivity());
            SQLiteDatabase base = db.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv = new ContentValues();
            cv.put(db.STATUS_LENGUA, language);
            base.update(db.TABLE4, cv, db.TABLE4_ID + " != " + language, null);
        } catch (Exception s) {
            Log.e("Error", s.getMessage());
        }
    }
}
