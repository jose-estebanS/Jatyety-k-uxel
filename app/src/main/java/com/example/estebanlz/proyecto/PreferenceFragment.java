package com.example.estebanlz.proyecto;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.Preference.OnPreferenceChangeListener;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceManager;
import android.util.Log;

import static android.support.constraint.Constraints.TAG;

public class PreferenceFragment extends PreferenceFragmentCompat{
    Registros db;
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        /*ListPreference listPreference = (ListPreference) findPreference("language");
        CharSequence currText = listPreference.getEntry();
        String currValue = listPreference.getValue();*/
        controlFragmento.frag = 1;
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        OnSharedPreferenceChangeListener listener = new OnSharedPreferenceChangeListener() {
            public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
                if (key.equals("language")) {
                    //Log.i(TAG, "Preference value was updated to: " + prefs.getString(key, ""));
                    UpdateLanguage(prefs.getString(key,""));
                }
            }
        };
        prefs.registerOnSharedPreferenceChangeListener(listener);
        setPreferencesFromResource(R.xml.preferencias, rootKey);
    }
    public void UpdateLanguage(String language){
        try{
            db = new Registros(getActivity());
            SQLiteDatabase base = db.getWritableDatabase();
            base.execSQL("UPDATE " + db.TABLE4 + " SET " + db.STATUS_LENGUA + " = 0 WHERE " + db.TABLE4_ID + " != " + language);
            base.execSQL("UPDATE " + db.TABLE4 + " SET " + db.STATUS_LENGUA + " = 1 WHERE " + db.TABLE4_ID + " = " + language);
            Log.i("Mensaje","Se ejecuta el método UpdateLanguage: " + language);
        }
        catch (Exception s){
            Log.e("Error", s.getMessage());
        }
    }
}
