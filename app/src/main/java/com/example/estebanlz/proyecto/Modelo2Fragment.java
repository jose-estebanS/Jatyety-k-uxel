package com.example.estebanlz.proyecto;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Modelo2Fragment extends Fragment implements View.OnClickListener{
    View rootView;
    Button cambiarModelo;
    ImageView backcabeza, backespalda, backbrazode, backbrazoiz, backantebradere, backantebraiz, backmanoder, backmanoiz, backpierder, backpieriz, backpantoder, backpantoiz, backpieder, backpieiz, backcolumna, backcuello;
    private Toast backToast;
    int contador = 0;
    Registros db;
    FloatingActionButton botondos;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Modelo");
        rootView = inflater.inflate(R.layout.fragment_modelo2, container, false);
        cambiarModelo = (Button) rootView.findViewById(R.id.changeModelo2);
        cambiarModelo.setOnClickListener(this);

        backcabeza = rootView.findViewById(R.id.cabezab);
        backespalda = rootView.findViewById(R.id.espaldab);
        backbrazode = rootView.findViewById(R.id.brazoderechob);
        backbrazoiz = rootView.findViewById(R.id.brazoizquierdob);
        backantebradere = rootView.findViewById(R.id.antebrazoderechob);
        backantebraiz = rootView.findViewById(R.id.antebrazoizquierdob);
        backmanoder = rootView.findViewById(R.id.manoderechab);
        backmanoiz = rootView.findViewById(R.id.manoizquierdab);
        backpierder = rootView.findViewById(R.id.piernaderechab);
        backpieriz = rootView.findViewById(R.id.piernaizquierdab);
        backpantoder = rootView.findViewById(R.id.pantorrilladerechab);
        backpantoiz = rootView.findViewById(R.id.pantorrillaizquierdab);
        backpieder = rootView.findViewById(R.id.piederechob);
        backpieiz = rootView.findViewById(R.id.pieizquierdob);
        backcolumna = rootView.findViewById(R.id.columnab);
        backcuello = rootView.findViewById(R.id.cuellob);
        botondos = rootView.findViewById(R.id.flotantedos);

        backcabeza.setOnClickListener(this);
        backespalda.setOnClickListener(this);
        backbrazode.setOnClickListener(this);
        backbrazoiz.setOnClickListener(this);
        backantebradere.setOnClickListener(this);
        backantebraiz.setOnClickListener(this);
        backmanoder.setOnClickListener(this);
        backmanoiz.setOnClickListener(this);
        backpierder.setOnClickListener(this);
        backpieriz.setOnClickListener(this);
        backpantoder.setOnClickListener(this);
        backpantoiz.setOnClickListener(this);
        backpieder.setOnClickListener(this);
        backpieiz.setOnClickListener(this);
        backcolumna.setOnClickListener(this);
        backcuello.setOnClickListener(this);
        botondos.setOnClickListener(this);
        limpiarRegistro();

        return rootView;
    }

    @Override
    public void onClick(View v) {
        if(contador > 0)
        {
            backToast.cancel();
        }
        switch (v.getId()){
            case R.id.changeModelo2:
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.contenedor, new ModeloFragment()).commit();
                //transaction.addToBackStack(null);
                controlFragmento.frag = 3;
                break;
            case R.id.cabezab:
                if(backcabeza.getAlpha() == 0.0)
                {
                    backcabeza.setAlpha((float)1.0);
                    backToast = Toast.makeText(getContext(), "Presionaste la cabeza", Toast.LENGTH_SHORT);
                    contador++;
                    actualizarStatus("CABEZA", 1);
                    actualizarStatusSintoma("CABEZA");
                }
                else{
                    backcabeza.setAlpha((float) 0.0);
                    contador--;
                    actualizarStatus("CABEZA", 0);
                    actualizarStatusSintoma("");
                }
                break;
            case R.id.espaldab:
                if(backespalda.getAlpha() == 0.0)
                {
                    backespalda.setAlpha((float)1.0);
                    backToast = Toast.makeText(getContext(), "Presionaste la espalda", Toast.LENGTH_SHORT);
                    contador++;
                    actualizarStatus("ESPALDA", 1);
                    actualizarStatusSintoma("ESPALDA");
                }
                else{
                    backespalda.setAlpha((float) 0.0);
                    contador--;
                    actualizarStatus("ESPALDA", 0);
                    actualizarStatusSintoma("");
                }
                break;
            case R.id.brazoderechob:
                if(backbrazode.getAlpha() == 0.0)
                {
                    backbrazode.setAlpha((float)1.0);
                    backToast = Toast.makeText(getContext(), "Presionaste el brazo derecho", Toast.LENGTH_SHORT);
                    contador++;
                    actualizarStatus("BRAZOS", 1);
                    actualizarStatusSintoma("BRAZOS");
                }
                else{
                    backbrazode.setAlpha((float) 0.0);
                    contador--;
                    actualizarStatus("BRAZOS", 0);
                    actualizarStatusSintoma("");
                }
                break;
            case R.id.brazoizquierdob:
                if(backbrazoiz.getAlpha() == 0.0)
                {
                    backbrazoiz.setAlpha((float)1.0);
                    backToast = Toast.makeText(getContext(), "Presionaste el brazo izquierdo", Toast.LENGTH_SHORT);
                    contador++;
                    actualizarStatus("BRAZOS", 1);
                    actualizarStatusSintoma("BRAZOS");
                }
                else{
                    backbrazoiz.setAlpha((float) 0.0);
                    contador--;
                    actualizarStatus("BRAZOS", 0);
                    actualizarStatusSintoma("");
                }
                break;
            case R.id.antebrazoderechob:
                if(backantebradere.getAlpha() == 0.0)
                {
                    backantebradere.setAlpha((float)1.0);
                    backToast = Toast.makeText(getContext(), "Presionaste el antebrazo derecho", Toast.LENGTH_SHORT);
                    contador++;
                    actualizarStatus("ANTEBRAZOS", 1);
                    actualizarStatusSintoma("ANTEBRAZOS");
                }
                else{
                    backantebradere.setAlpha((float) 0.0);
                    contador--;
                    actualizarStatus("ANTEBRAZOS", 0);
                    actualizarStatusSintoma("");
                }
                break;
            case R.id.antebrazoizquierdob:
                if(backantebraiz.getAlpha() == 0.0)
                {
                    backantebraiz.setAlpha((float)1.0);
                    backToast = Toast.makeText(getContext(), "Presionaste el antebrazo izquierdo", Toast.LENGTH_SHORT);
                    contador++;
                    actualizarStatus("ANTEBRAZOS", 1);
                    actualizarStatusSintoma("ANTEBRAZOS");
                }
                else{
                    backantebraiz.setAlpha((float) 0.0);
                    contador--;
                    actualizarStatus("ANTEBRAZOS", 0);
                    actualizarStatusSintoma("");
                }
                break;
            case R.id.manoderechab:
                if(backmanoder.getAlpha() == 0.0)
                {
                    backmanoder.setAlpha((float)1.0);
                    backToast = Toast.makeText(getContext(), "Presionaste la mano derecha", Toast.LENGTH_SHORT);
                    contador++;
                    actualizarStatus("MANOS", 1);
                    actualizarStatusSintoma("MANOS");
                }
                else{
                    backmanoder.setAlpha((float) 0.0);
                    contador--;
                    actualizarStatus("MANOS", 0);
                    actualizarStatusSintoma("");
                }
                break;
            case R.id.manoizquierdab:
                if(backmanoiz.getAlpha() == 0.0)
                {
                    backmanoiz.setAlpha((float)1.0);
                    backToast = Toast.makeText(getContext(), "Presionaste la mano izquierda", Toast.LENGTH_SHORT);
                    contador++;
                    actualizarStatus("MANOS", 1);
                    actualizarStatusSintoma("MANOS");
                }
                else{
                    backmanoiz.setAlpha((float) 0.0);
                    contador--;
                    actualizarStatus("MANOS", 0);
                    actualizarStatusSintoma("");
                }
                break;
            case R.id.piernaderechab:
                if(backpierder.getAlpha() == 0.0)
                {
                    backpierder.setAlpha((float)1.0);
                    backToast = Toast.makeText(getContext(), "Presionaste la pierna derecha", Toast.LENGTH_SHORT);
                    contador++;
                    actualizarStatus("PIERNAS", 1);
                    actualizarStatusSintoma("PIERNAS");
                }
                else{
                    backpierder.setAlpha((float) 0.0);
                    contador--;
                    actualizarStatus("PIERNAS", 0);
                    actualizarStatusSintoma("");
                }
                break;
            case R.id.piernaizquierdab:
                if(backpieriz.getAlpha() == 0.0)
                {
                    backpieriz.setAlpha((float)1.0);
                    backToast = Toast.makeText(getContext(), "Presionaste la pierna izquierda", Toast.LENGTH_SHORT);
                    contador++;
                    actualizarStatus("PIERNAS", 1);
                    actualizarStatusSintoma("PIERNAS");
                }
                else{
                    backpieriz.setAlpha((float) 0.0);
                    contador--;
                    actualizarStatus("PIERNAS", 0);
                    actualizarStatusSintoma("");
                }
                break;
            case R.id.pantorrilladerechab:
                if(backpantoder.getAlpha() == 0.0)
                {
                    backpantoder.setAlpha((float)1.0);
                    backToast = Toast.makeText(getContext(), "Presionaste la pantorrilla derecha", Toast.LENGTH_SHORT);
                    contador++;
                    actualizarStatus("PANTORRILLAS", 1);
                    actualizarStatusSintoma("PANTORRILAS");
                }
                else{
                    backpantoder.setAlpha((float) 0.0);
                    contador--;
                    actualizarStatus("PANTORRILLAS", 0);
                    actualizarStatusSintoma("");
                }
                break;
            case R.id.pantorrillaizquierdab:
                if(backpantoiz.getAlpha() == 0.0)
                {
                    backpantoiz.setAlpha((float)1.0);
                    backToast = Toast.makeText(getContext(), "Presionaste la pantorrilla izquierda", Toast.LENGTH_SHORT);
                    contador++;
                    actualizarStatus("PANTORRILLAS", 1);
                    actualizarStatusSintoma("PANTORRILLAS");
                }
                else{
                    backpantoiz.setAlpha((float) 0.0);
                    contador--;
                    actualizarStatus("PANTORRILLAS", 0);
                    actualizarStatusSintoma("");
                }
                break;
            case R.id.piederechob:
                if(backpieder.getAlpha() == 0.0)
                {
                    backpieder.setAlpha((float)1.0);
                    backToast = Toast.makeText(getContext(), "Presionaste el pie derecho", Toast.LENGTH_SHORT);
                    contador++;
                    actualizarStatus("PIES", 1);
                    actualizarStatusSintoma("PIES");
                }
                else{
                    backpieder.setAlpha((float) 0.0);
                    contador--;
                    actualizarStatus("PIES", 0);
                    actualizarStatusSintoma("");
                }
                break;
            case R.id.pieizquierdob:
                if(backpieiz.getAlpha() == 0.0)
                {
                    backpieiz.setAlpha((float)1.0);
                    backToast = Toast.makeText(getContext(), "Presionaste el pie izquierdo", Toast.LENGTH_SHORT);
                    contador++;
                    actualizarStatus("PIES", 1);
                    actualizarStatusSintoma("PIES");
                }
                else{
                    backpieiz.setAlpha((float) 0.0);
                    contador--;
                    actualizarStatus("PIES", 0);
                    actualizarStatusSintoma("");
                }
                break;
            case R.id.columnab:
                if(backcolumna.getAlpha() == 0.0)
                {
                    backcolumna.setAlpha((float)1.0);
                    backToast = Toast.makeText(getContext(), "Presionaste la columna", Toast.LENGTH_SHORT);
                    contador++;
                    actualizarStatus("COLUMNA", 1);
                    actualizarStatusSintoma("COLUMNA");
                }
                else{
                    backcolumna.setAlpha((float) 0.0);
                    contador--;
                    actualizarStatus("COLUMNA", 0);
                    actualizarStatusSintoma("");
                }
                break;
            case R.id.cuellob:
                if(backcuello.getAlpha() == 0.0)
                {
                    backcuello.setAlpha((float)1.0);
                    backToast = Toast.makeText(getContext(), "Presionaste el cuello", Toast.LENGTH_SHORT);
                    contador++;
                    actualizarStatus("CUELLO", 1);
                    actualizarStatusSintoma("CUELLO");
                }
                else{
                    backcuello.setAlpha((float) 0.0);
                    contador--;
                    actualizarStatus("CUELLO", 0);
                    actualizarStatusSintoma("");
                }
                break;
            case R.id.flotantedos:
                if(contador!=0){
                    actualizarSintoma();
                    FragmentTransaction transactiondos = getFragmentManager().beginTransaction();
                    transactiondos.replace(R.id.contenedor, new SintomasFragment()).commit();
                    transactiondos.addToBackStack(null);
                    controlFragmento.frag = 3;
                }
                else{
                    backToast = Toast.makeText(getContext(), "Por favor presione la parte del cuerpo que le duele", Toast.LENGTH_SHORT);
                }
                break;
        }
        try{
            backToast.show();
        }
        catch(Exception ex){

        }
    }
    private void limpiarRegistro() {
        db = new Registros(getActivity().getApplicationContext());
        SQLiteDatabase base = db.getReadableDatabase();
        base.execSQL("UPDATE " + db.TABLE2 + " SET " + db.STATUS_CUERPO + " = 0");
    }
    public void actualizarStatus(String parte, int i)
    {
        try
        {
            db = new Registros(getContext());
            SQLiteDatabase base = db.getReadableDatabase();
            base.execSQL("UPDATE " + db.TABLE2 + " SET " + db.STATUS_CUERPO + " = " + i + " WHERE " + db.PARTE_CUERPO + " = '" + parte + "'");
        }
        catch (Exception e)
        {
        }
    }
    public void actualizarStatusSintoma(String parte)
    {
        int i = 0;
        switch (parte)
        {
            case "CABEZA":
                i = 1;
                break;
            case "BRAZOS":
                i = 3;
                break;
            case "ANTEBRAZOS":
                i = 4;
                break;
            case "MANOS":
                i = 5;
                break;
            case "PIERNAS":
                i = 7;
                break;
            case "PANTORRILLAS":
                i = 8;
                break;
            case "PIES":
                i = 9;
                break;
            case "COLUMNA":
                i = 13;
                break;
            case "CUELLO":
                i = 14;
                break;
            case "ESPALDA":
                i = 15;
                break;
            default:
                i = 0;
                break;
        }
        try
        {
            db = new Registros(getContext());
            SQLiteDatabase base = db.getReadableDatabase();
            base.execSQL("UPDATE " + db.TABLE3 + " SET " + db.STATUS_SINTOMA + " = " + i + " WHERE " + db.SINTOMA_RELACION + " = '" + parte + "'");
        }
        catch (Exception s)
        {

        }
    }
    public void actualizarSintoma(){
        db = new Registros(getActivity().getApplicationContext());
        SQLiteDatabase base = db.getWritableDatabase();
        base.execSQL("UPDATE " + db.TABLE3 + " SET " + db.STATUS_SINTOMA + " = " + 0);
    }
}