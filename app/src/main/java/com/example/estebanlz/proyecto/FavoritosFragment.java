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
import android.widget.ListView;
import android.widget.TextView;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

import static com.example.estebanlz.proyecto.R.menu.buscar_menu;


public class FavoritosFragment extends Fragment implements SearchView.OnQueryTextListener, MenuItem.OnActionExpandListener{
    View rootView;
    Registros db;
    ArrayList<FrasesVo> frasesConsult;
    ArrayList<FrasesVo> searchFull;
    ArrayList<AudiosVo> audiosFav;
    RecyclerView elementos;
    ArrayList<AudiosVo> audiosConsult;
    private AdaptadorFav adapter;
    private Activity activity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        rootView = inflater.inflate(R.layout.fragment_favoritos, container, false);
        activity = getActivity();
        ((MainActivity) activity).getSupportActionBar().setTitle("Favoritos");
        frasesConsult = new ArrayList<>();
        audiosFav = new ArrayList<>();
        elementos = (RecyclerView) rootView.findViewById(R.id.lista_favoritos);
        elementos.setLayoutManager(new LinearLayoutManager(activity));
        try
        {
            int lenguaActual = IdiomaActual();
            searchFull = new ArrayList<>(llenarLista());
            audiosConsult = new ArrayList<>(llenarAudios(lenguaActual));
            adapter = new AdaptadorFav(activity, searchFull, audiosConsult);
            elementos.setAdapter(adapter);
        }
        catch (Exception e)
        {
            Log.e("Mensaje de error", e.getMessage());
        }
        return rootView;
    }
    private ArrayList<FrasesVo> llenarLista() {
        try {
            db = new Registros(getActivity().getApplicationContext());
            SQLiteDatabase base = db.getWritableDatabase();
            FrasesVo frases = null;
            Cursor c = base.rawQuery("SELECT * FROM " + db.TABLE + " WHERE " + db.STATUS + " = 1", null);
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
    private ArrayList<AudiosVo> llenarAudios(int idiomaActual) {
        try {
            db = new Registros(getActivity().getApplicationContext());
            SQLiteDatabase base = db.getWritableDatabase();
            AudiosVo audios = null;
            Cursor c = base.rawQuery("SELECT audio_frase FROM frases f, audiosfrases a WHERE f._idFrase = a.fk_tb_frases AND f.status = 1 AND a.idioma_audio = " + idiomaActual, null);
            if (c != null) {
                c.moveToFirst();
                do {
                    audios = new AudiosVo( );
                    audios.setAudio(c.getInt(0));
                    audiosFav.add(audios);
                } while (c.moveToNext());
            }
        } catch (Exception es) {
        }
        return audiosFav;
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
    public boolean onQueryTextSubmit(String query) {
        return true;
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
        adapter = new AdaptadorFav(activity, filteredValues);
        elementos.setAdapter(adapter);
        return false;
    }
    private void resetSearch() {
        adapter = new AdaptadorFav(activity, frasesConsult);
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
