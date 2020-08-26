package com.example.estebanlz.proyecto;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.estebanlz.proyecto.MainActivity.*;


public class SintomasFragment extends Fragment{
    View rootView;
    Registros db;
    RecyclerView cuerpo_elementos;
    ArrayList<CuerpoVo> cuerpoConsult;
    ArrayList<SintomasVO> sintomasConsult;
    CardView sintoma;
    private AdaptadorBody adapter;
    Button diagnosticar;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Sintomas");
        rootView = inflater.inflate(R.layout.fragment_sintomas, container, false);
        cuerpoConsult = new ArrayList<>();
        cuerpo_elementos = (RecyclerView) rootView.findViewById(R.id.sintomas_lista);
        cuerpo_elementos.setLayoutManager(new LinearLayoutManager(getActivity()));
        sintoma = (CardView) rootView.findViewById(R.id.cardSintoma);
        controlFragmento.frag = 3;
        diagnosticar = (Button) rootView.findViewById(R.id.btnDiagnosticar);
        diagnosticar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               try{
                    if(DiagnosticoFragment.contar >= contador() && contador() != 0){
                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        transaction.replace(R.id.contenedor, new DiagnosticoFragment()).commit();
                        transaction.addToBackStack(null);

                    }
                    else if(DiagnosticoFragment.contar == 0){
                        Toast.makeText(getActivity(), "Por favor evalua los sintomas para continuar", Toast.LENGTH_LONG).show();
                    }
                    else{
                        mostrarAlertDialog();
                    }
                }
                catch (Exception e){

                }

            }
        });
        try
        {
            llenarLista();
            //llenarListaSintomas();
            adapter = new AdaptadorBody(getActivity(), cuerpoConsult);

            adapter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(getActivity().getApplicationContext(),cuerpoConsult.get(cuerpo_elementos.getChildAdapterPosition(v)).getCuerpo(), Toast.LENGTH_SHORT).show();
                    SintomaEspecificoFragment.Parte = cuerpoConsult.get(cuerpo_elementos.getChildAdapterPosition(v)).getCuerpo();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.contenedor, new SintomaEspecificoFragment()).commit();
                    transaction.addToBackStack(null);
                }
            });

            cuerpo_elementos.setAdapter(adapter);
        }
        catch (Exception e)
        {
            Toast.makeText(getActivity(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
        //limpiarRegistro();
        //limpiarRegistroSintoma();
        return rootView;
    }
    private void mostrarAlertDialog(){
        AlertDialog.Builder mensaje = new AlertDialog.Builder(getActivity());
        mensaje.setTitle("Alerta");
        mensaje.setMessage("Faltan partes del cuerpo por diagnosticar, ¿Desea continuar?")
                .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        transaction.replace(R.id.contenedor, new DiagnosticoFragment()).commit();
                        transaction.addToBackStack(null);
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setCancelable(false).show();
    }
    private int contador(){
        db = new Registros(getActivity().getApplicationContext());
        SQLiteDatabase base = db.getReadableDatabase();
        Cursor c = base.rawQuery("SELECT COUNT (*) FROM " + db.TABLE2 + " WHERE " + db.STATUS_CUERPO + " = 1", null);
        int valor = 0;
        if(null != c)
            if(c.getCount() > 0){
                c.moveToFirst();
                valor = c.getInt(0);
            }
        c.close();
        return valor;
    }
    private void limpiarRegistro() {
        db = new Registros(getActivity().getApplicationContext());
        SQLiteDatabase base = db.getReadableDatabase();
        base.execSQL("UPDATE " + db.TABLE2 + " SET " + db.STATUS_CUERPO + " = 0");
    }

    private void limpiarRegistroSintoma()
    {
        db = new Registros(getActivity().getApplicationContext());
        SQLiteDatabase base = db.getReadableDatabase();
        base.execSQL("UPDATE " + db.TABLE3 + " SET " + db.STATUS_SINTOMA + " = 0");
    }
    private void llenarLista() {
        try {
            db = new Registros(getActivity().getApplicationContext());
            SQLiteDatabase base = db.getWritableDatabase();
            CuerpoVo cuerpo = null;
            Cursor c = base.rawQuery("SELECT * FROM " + db.TABLE2 + " WHERE " + db.STATUS_CUERPO + " = 1", null);
            if (c != null) {
                c.moveToFirst();
                do {
                    cuerpo = new CuerpoVo();
                    cuerpo.setId_cuerpo(c.getInt(0));
                    cuerpo.setCuerpo(c.getString(1));
                    cuerpo.setStatus_cuerpo(c.getInt(2));
                    cuerpo.setImg_cuerpo(c.getInt(3));
                    cuerpoConsult.add(cuerpo);
                } while (c.moveToNext());
            }
        } catch (Exception es) {
        }
    }
}
