package com.example.estebanlz.proyecto;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    int contador = 0;
    public static int frag = -1;
    int mensaje = 0;
    private Toast backToast;
    Registros db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
////        fab.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
////                        .setAction("Action", null).show();
////            }
////        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        android.support.v4.app.FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.contenedor, new InicioFragment()).commit();
        //UpdateLanguage(2);
        //eliminarDatos();
        //insertDatos();
    }
    private void insertDatos(){
        try{
            db = new Registros(this);
            db.addRegistro();
            db.addRegistroCuerpo();
            db.addSintomas();
            db.addAudiosFrases();
            db.addLengua();
            db.addAudiosSintomas();
        }
        catch (Exception e){
        }
    }
    private void actualizarDatos(){
        db = new Registros(this);
        SQLiteDatabase base = db.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv = new ContentValues();
        cv.put(db.FRASE, "Buen día");
        String[] args = new String []{ "1"};
        base.update(db.TABLE, cv, db.TABLE_ID+"=?", args);
    }
    private void eliminarDatos()
    {
        db = new Registros(this);
        SQLiteDatabase base = db.getReadableDatabase();
        //base.execSQL("DELETE FROM " + db.TABLE + " WHERE " + db.TABLE_ID + " = 1");
        base.execSQL("DELETE FROM " + db.TABLE);
        base.execSQL("DELETE FROM " + db.TABLE2);
        base.execSQL("DELETE FROM " + db.TABLE3);
        base.execSQL("DELETE FROM " + db.TABLE4);
        base.execSQL("DELETE FROM " + db.TABLE5);
        base.execSQL("DELETE FROM " + db.TABLE6);
    }
    public void UpdateLanguage(int language) {
        try {
            db = new Registros(this);
            SQLiteDatabase base = db.getWritableDatabase();
            base.execSQL("UPDATE lenguas SET status_lengua=0 WHERE _idLengua=1");
            base.execSQL("UPDATE lenguas SET status_lengua=1 WHERE _idLengua=2");
            Log.i("Mensaje","Se ejecuta el método UpdateLanguage: " + language);
        } catch (Exception s) {
            Log.e("Error", s.getMessage());
        }
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

        new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                contador = 0;
            }
        }.start();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        /*int id = item.getItemId();
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        if(id == R.id.action_language){
            fragmentManager.beginTransaction().replace(R.id.contenedor, new SettingsFragment()).commit();
        }*/
        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        android.support.v4.app.FragmentManager fragmentManager=getSupportFragmentManager();

        if (id == R.id.nav_camera) {
            fragmentManager.beginTransaction().replace(R.id.contenedor, new BuscadorFragment()).commit();
            controlFragmento.frag = 0;
        } else if (id == R.id.nav_gallery) {
            fragmentManager.beginTransaction().replace(R.id.contenedor, new ModeloFragment()).commit();
            controlFragmento.frag = 0;
        } else if (id == R.id.nav_slideshow) {
            fragmentManager.beginTransaction().replace(R.id.contenedor, new FavoritosFragment()).commit();
            controlFragmento.frag = 0;
        }  else if (id == R.id.nav_share) {
            fragmentManager.beginTransaction().replace(R.id.contenedor, new InformacionFragment()).commit();
            controlFragmento.frag = 0;
        }
        else if (id == R.id.nav_developer) {
            fragmentManager.beginTransaction().replace(R.id.contenedor, new DesarrolladoresFragment()).commit();
            controlFragmento.frag = 0;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
