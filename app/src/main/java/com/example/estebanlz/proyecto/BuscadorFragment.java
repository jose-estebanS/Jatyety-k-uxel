package com.example.estebanlz.proyecto;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import java.text.Normalizer;
import java.util.ArrayList;

import static com.example.estebanlz.proyecto.R.menu.buscar_menu;


public class BuscadorFragment extends Fragment implements SearchView.OnQueryTextListener, MenuItem.OnActionExpandListener{
    View rootView;
    View buscar;
    Registros db;
    ArrayList<FrasesVo> frasesConsult;
    ArrayList<FrasesVo> searchFull;
    ArrayList<AudiosVo> audiosConsult;
    ArrayList<AudiosVo> audiosFrases;
    RecyclerView elementos;
    private Adaptador adapter;
    private Activity activity;
    ConsultarDatos consultaFrases;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        rootView = inflater.inflate(R.layout.fragment_buscador, container, false);
        activity = getActivity();
        ((MainActivity) activity).getSupportActionBar().setTitle("Buscador");
        frasesConsult = new ArrayList<>();
        audiosConsult = new ArrayList<>();
        elementos = (RecyclerView) rootView.findViewById(R.id.lista_frases);
        elementos.setLayoutManager(new LinearLayoutManager(activity));
        controlFragmento.frag = 1;
        try
        {
            int lenguaActual = IdiomaActual();
            searchFull = new ArrayList<>(llenarLista());
            audiosFrases = new ArrayList<>(ConsultarAudiosFrases(lenguaActual));
            adapter = new Adaptador(activity, searchFull, audiosFrases);
            elementos.setAdapter(adapter);
        }
        catch (Exception e)
        {
            Log.e("Error",e.getMessage());
        }
        return rootView;
    }

    private ArrayList<FrasesVo> llenarLista() {
        try {
            db = new Registros(getActivity().getApplicationContext());
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
            Log.e("Error lista",es.getMessage());
        }
        return frasesConsult;
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

    public ArrayList<AudiosVo> ConsultarAudiosFrases(int lengua){
        try {
            Log.i("lengua", String.valueOf(lengua));
            db = new Registros(getActivity().getApplicationContext());
            SQLiteDatabase base = db.getWritableDatabase();
            AudiosVo audios = null;
            Cursor c = base.rawQuery("SELECT * FROM " + db.TABLE5 + " WHERE " + db.IDIOMA_AUDIO + " = " + lengua, null);
            if (c != null) {
                c.moveToFirst();
                do {
                    audios = new AudiosVo( );
                    audios.setId_audio(c.getInt(0));
                    audios.setAudio(c.getInt(1));
                    audios.setFk_frases(c.getInt(2));
                    audios.setIdioma_audio(c.getInt(3));
                    audiosConsult.add(audios);
                } while (c.moveToNext());
            }
        } catch (Exception es) {
            Log.e("Error consultar",es.getMessage());
        }
        return audiosConsult;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(buscar_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search_pro);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(this);
        searchView.setQueryHint("Buscar...");

        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return true;
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
    public boolean onQueryTextChange(String newText) {
        if(newText == null || newText.trim().isEmpty())
        {
            resetSearch();
            return false;
        }
        ArrayList<FrasesVo> filteredValues = new ArrayList<>(searchFull);
        for(FrasesVo value : searchFull)
        {
            String frase1 = value.getFrase().toLowerCase();
            String frase2 = newText.toLowerCase();
            String fraseLimpia1 = quitaDiacriticos(frase1);
            String fraseLimpia2 = quitaDiacriticos(frase2);
            if(!fraseLimpia1.contains(fraseLimpia2))
            {
                filteredValues.remove(value);
            }
        }
        adapter = new Adaptador(activity, filteredValues);
        elementos.setAdapter(adapter);
        return false;
    }

    private void resetSearch() {
        adapter = new Adaptador(activity, frasesConsult);
        elementos.setAdapter(adapter);
    }
    public static String quitaDiacriticos(String s) {
        s = Normalizer.normalize(s, Normalizer.Form.NFD);
        s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return s;
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

