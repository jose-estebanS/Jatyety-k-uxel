package com.example.estebanlz.proyecto;

import android.animation.Animator;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Interpolator;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.ImageViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ModeloFragment extends Fragment implements
        View.OnClickListener{
    View rootView;
    ImageView head;
    ImageView chest;
    ImageView stomach;
    ImageView right_food;
    ImageView left_food;
    ImageView right_hand;
    ImageView left_hand;
    ImageView brazoderecho;
    ImageView brazoizquierdo;
    ImageView antebrazoderecho;
    ImageView antebrazoizquierdo;
    ImageView piernaderecha;
    ImageView piernaizquierda;
    ImageView pantorrilladerecha;
    ImageView pantorrillaizquierda;
    ImageView pene, garganta, rodillauno, rodillados;
    FloatingActionButton botón;
    Button changeModeloOne;
    Registros db;
    private Toast backToast;
    private ExpandableListView expLV;
    private ArrayList<String> listCategorias;
    private Map<String, ArrayList<String>> mapChild;
    int contador = 0;

    public ModeloFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_modelo3, container, false);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Modelo");
        controlFragmento.frag = 1;
        limpiarRegistro();
        head = (ImageView) rootView.findViewById(R.id.head2);
        chest = (ImageView) rootView.findViewById(R.id.pecho2);
        stomach = (ImageView) rootView.findViewById(R.id.estomago2);
        right_food = (ImageView) rootView.findViewById(R.id.piederecho2);
        left_food = (ImageView) rootView.findViewById(R.id.pieizquierdo2);
        right_hand = (ImageView) rootView.findViewById(R.id.manoderecha);
        left_hand = (ImageView) rootView.findViewById(R.id.manoizquierda);
        brazoderecho = (ImageView) rootView.findViewById(R.id.brazoderecho2);
        brazoizquierdo = (ImageView) rootView.findViewById(R.id.brazoizquierdo2);
        antebrazoderecho = (ImageView) rootView.findViewById(R.id.antebrazoderecho2);
        antebrazoizquierdo = (ImageView) rootView.findViewById(R.id.antebrazoizquierdo2);
        piernaderecha = (ImageView) rootView.findViewById(R.id.piernaderecha2);
        piernaizquierda = (ImageView) rootView.findViewById(R.id.piernaizquierda2);
        pantorrilladerecha = (ImageView) rootView.findViewById(R.id.pantorrilladerecha2);
        pantorrillaizquierda = (ImageView) rootView.findViewById(R.id.pantorrillaizquierda2);
        pene = (ImageView) rootView.findViewById(R.id.pene);
        garganta = (ImageView) rootView.findViewById(R.id.garganta);
        rodillauno = (ImageView) rootView.findViewById(R.id.rodillaizquierda);
        rodillados = (ImageView) rootView.findViewById(R.id.rodilladerecha);
        botón = (FloatingActionButton) rootView.findViewById(R.id.flotante);
        changeModeloOne = (Button) rootView.findViewById(R.id.changeModeloUno);

        head.setOnClickListener(this);
        chest.setOnClickListener(this);
        stomach.setOnClickListener(this);
        right_food.setOnClickListener(this);
        left_food.setOnClickListener(this);
        right_hand.setOnClickListener(this);
        left_hand.setOnClickListener(this);
        brazoderecho.setOnClickListener(this);
        brazoizquierdo.setOnClickListener(this);
        antebrazoderecho.setOnClickListener(this);
        antebrazoizquierdo.setOnClickListener(this);
        piernaderecha.setOnClickListener(this);
        piernaizquierda.setOnClickListener(this);
        pantorrilladerecha.setOnClickListener(this);
        pantorrillaizquierda.setOnClickListener(this);
        pene.setOnClickListener(this);
        garganta.setOnClickListener(this);
        rodillauno.setOnClickListener(this);
        rodillados.setOnClickListener(this);
        botón.setOnClickListener(this);
        changeModeloOne.setOnClickListener(this);
        //consultaStatusCuerpo();
        //botón.setVisibility(View.INVISIBLE);
        return rootView;
    }
    public void actualizarSintoma(){
        db = new Registros(getActivity().getApplicationContext());
        SQLiteDatabase base = db.getWritableDatabase();
        base.execSQL("UPDATE " + db.TABLE3 + " SET " + db.STATUS_SINTOMA + " = " + 0);
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
            case "PECHO":
                i = 2;
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
            case "ESTOMAGO":
                i = 6;
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
            case "GARGANTA":
                i = 10;
                break;
            case "PENE":
                i = 12;
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
    @Override
    public void onClick(View v) {
        if(contador > 0)
        {
            backToast.cancel();
        }
        switch (v.getId())
        {
            case R.id.head2:
                if(head.getAlpha() == 0.0)
                {
                    actualizarStatus("CABEZA", 1);
                    actualizarStatusSintoma("CABEZA");
                    head.setAlpha((float)1.0);
                    backToast = Toast.makeText(getContext(), "Presionaste la cabeza", Toast.LENGTH_SHORT);
                    contador++;
                }
                else{
                    head.setAlpha((float) 0.0);
                    contador--;
                    actualizarStatus("CABEZA", 0);
                    actualizarStatusSintoma("");
                }
                break;
            case R.id.pecho2:
                if(chest.getAlpha() == 0.0)
                {
                    chest.setAlpha((float)1.0);
                    backToast = Toast.makeText(getContext(), "Presionaste el pecho", Toast.LENGTH_SHORT);
                    contador++;
                    actualizarStatus("PECHO", 1);
                    actualizarStatusSintoma("PECHO");
                }
                else{
                    chest.setAlpha((float)0.0);
                    contador--;
                    actualizarStatus("PECHO", 0);
                    actualizarStatusSintoma("");
                }
                break;
            case R.id.estomago2:
                if(stomach.getAlpha() == 0.0)
                {
                    stomach.setAlpha((float)1.0);
                    backToast = Toast.makeText(getContext(), "Presionaste el abdomen", Toast.LENGTH_SHORT);
                    contador++;
                    actualizarStatus("ESTOMAGO", 1);
                    actualizarStatusSintoma("ESTOMAGO");
                }
                else{
                    stomach.setAlpha((float)0.0);
                    contador--;
                    actualizarStatus("ESTOMAGO", 0);
                    actualizarStatusSintoma("");
                }
            break;
            case R.id.piederecho2:
                if(right_food.getAlpha() == 0.0)
                {
                    right_food.setAlpha((float)1.0);
                    backToast = Toast.makeText(getContext(), "Presionaste el pie derecho", Toast.LENGTH_SHORT);
                    contador++;
                    actualizarStatus("PIES", 1);
                    actualizarStatusSintoma("PIES");
                }
                else{
                    right_food.setAlpha((float)0.0);
                    contador--;
                    actualizarStatus("PIES", 0);
                    actualizarStatusSintoma("");
                }
            break;
            case R.id.pieizquierdo2:
                if(left_food.getAlpha() == 0.0)
                {
                    left_food.setAlpha((float)1.0);
                    backToast = Toast.makeText(getContext(), "Presionaste el pie izquierdo", Toast.LENGTH_SHORT);
                    contador++;
                    actualizarStatus("PIES", 1);
                    actualizarStatusSintoma("PIES");
                }
                else{
                    left_food.setAlpha((float)0.0);
                    contador--;
                    actualizarStatus("PIES", 0);
                    actualizarStatusSintoma("");
                }
            break;
            case R.id.manoderecha:
                if(right_hand.getAlpha() == 0.0)
            {
                right_hand.setAlpha((float)1.0);
                backToast = Toast.makeText(getContext(), "Presionaste la mano derecha", Toast.LENGTH_SHORT);
                contador++;
                actualizarStatus("MANOS", 1);
                actualizarStatusSintoma("MANOS");
            }
                else{
                    right_hand.setAlpha((float)0.0);
                    contador--;
                    actualizarStatus("MANOS", 0);
                    actualizarStatusSintoma("");
            }
            break;
            case R.id.manoizquierda:
                if(left_hand.getAlpha() == 0.0)
            {
                left_hand.setAlpha((float)1.0);
                backToast = Toast.makeText(getContext(), "Presionaste la mano izquierda", Toast.LENGTH_SHORT);
                contador++;
                actualizarStatus("MANOS", 1);
                actualizarStatusSintoma("MANOS");
            }
                else{
                    left_hand.setAlpha((float)0.0);
                    contador--;
                    actualizarStatus("MANOS", 0);
                    actualizarStatusSintoma("");
            }
            break;
            case R.id.brazoderecho2:
                if(brazoderecho.getAlpha() == 0.0)
                {
                    brazoderecho.setAlpha((float)1.0);
                    backToast = Toast.makeText(getContext(), "Presionaste el brazo derecho", Toast.LENGTH_SHORT);
                    contador++;
                    actualizarStatus("BRAZOS", 1);
                    actualizarStatusSintoma("BRAZOS");
                }
                else{
                    brazoderecho.setAlpha((float)0.0);
                    contador--;
                    actualizarStatus("BRAZOS", 0);
                    actualizarStatusSintoma("");
                }
                break;
            case R.id.brazoizquierdo2:
                if(brazoizquierdo.getAlpha() == 0.0)
            {
                    brazoizquierdo.setAlpha((float)1.0);
                backToast = Toast.makeText(getContext(), "Presionaste el brazo izquierdo", Toast.LENGTH_SHORT);
                contador++;
                actualizarStatus("BRAZOS", 1);
                actualizarStatusSintoma("BRAZOS");
            }
                else{
                    brazoizquierdo.setAlpha((float)0.0);
                    contador--;
                    actualizarStatus("BRAZOS", 0);
                    actualizarStatusSintoma("");
            }
            break;
            case R.id.antebrazoderecho2:
                if(antebrazoderecho.getAlpha() == 0.0)
            {
                antebrazoderecho.setAlpha((float)1.0);
                backToast = Toast.makeText(getContext(), "Presionaste el antebrazo derecho", Toast.LENGTH_SHORT);
                contador++;
                actualizarStatus("ANTEBRAZO", 1);
                actualizarStatusSintoma("ANTEBRAZO");
            }
                else{
                    antebrazoderecho.setAlpha((float)0.0);
                    contador--;
                    actualizarStatus("ANTEBRAZO", 0);
                    actualizarStatusSintoma("");
            }
            break;
            case R.id.antebrazoizquierdo2:
                if(antebrazoizquierdo.getAlpha() == 0.0)
            {
                antebrazoizquierdo.setAlpha((float)1.0);
                backToast = Toast.makeText(getContext(), "Presionaste el antebrazo izquierdo", Toast.LENGTH_SHORT);
                contador++;
                actualizarStatus("ANTEBRAZO", 1);
                actualizarStatusSintoma("ANTEBRAZO");
            }
                else{
                    antebrazoizquierdo.setAlpha((float)0.0);
                    contador--;
                    actualizarStatus("ANTEBRAZO", 0);
                    actualizarStatusSintoma("");
            }
            break;
            case R.id.piernaderecha2:
                if(piernaderecha.getAlpha() == 0.0)
            {
                piernaderecha.setAlpha((float)1.0);
                backToast = Toast.makeText(getContext(), "Presionaste la pierna derecha", Toast.LENGTH_SHORT);
                contador++;
                actualizarStatus("PIERNAS", 1);
                actualizarStatusSintoma("PIERNAS");
            }
                else{
                    piernaderecha.setAlpha((float)0.0);
                    contador--;
                    actualizarStatus("PIERNAS", 0);
                    actualizarStatusSintoma("");
            }
            break;
            case R.id.piernaizquierda2:
                if(piernaizquierda.getAlpha() == 0.0)
            {
                    piernaizquierda.setAlpha((float)1.0);
                backToast = Toast.makeText(getContext(), "Presionaste la pierna izquierda", Toast.LENGTH_SHORT);
                contador++;
                actualizarStatus("PIERNAS", 1);
                actualizarStatusSintoma("PIERNAS");
            }
                else{
                    piernaizquierda.setAlpha((float)0.0);
                    contador--;
                    actualizarStatus("PIERNAS", 0);
                    actualizarStatusSintoma("");
            }
            break;
            case R.id.pantorrilladerecha2:
                if(pantorrilladerecha.getAlpha() == 0.0)
            {
                    pantorrilladerecha.setAlpha((float)1.0);
                backToast = Toast.makeText(getContext(), "Presionaste la pantorrilla derecha", Toast.LENGTH_SHORT);
                contador++;
                actualizarStatus("PANTORRILLAS", 1);
                actualizarStatusSintoma("PANTORRILLAS");
            }
                else{
                    pantorrilladerecha.setAlpha((float)0.0);
                    contador--;
                    actualizarStatus("PANTORRILLAS", 0);
                    actualizarStatusSintoma("");
            }
            break;
            case R.id.pantorrillaizquierda2:
                if(pantorrillaizquierda.getAlpha() == 0.0)
            {
                    pantorrillaizquierda.setAlpha((float)1.0);
                backToast = Toast.makeText(getContext(), "Presionaste la pantorrilla izquierda", Toast.LENGTH_SHORT);
                contador++;
                actualizarStatus("PANTORRILLA", 1);
                actualizarStatusSintoma("PANTORRILLA");
            }
                else{
                    pantorrillaizquierda.setAlpha((float)0.0);
                    contador--;
                    actualizarStatus("PANTORRILLA", 0);
                    actualizarStatusSintoma("");
            }
            break;
            case R.id.pene:
                if(pene.getAlpha() == 0.0)
                {
                    pene.setAlpha((float)1.0);
                    backToast = Toast.makeText(getContext(), "Presionaste el pene", Toast.LENGTH_SHORT);
                    contador++;
                    actualizarStatus("PENE", 1);
                    actualizarStatusSintoma("PENE");
                }
                else{
                    pene.setAlpha((float)0.0);
                    contador--;
                    actualizarStatus("PENE", 0);
                    actualizarStatusSintoma("");
                }
                break;
            case R.id.changeModeloUno:
                FragmentTransaction transactionDos = getFragmentManager().beginTransaction();
                transactionDos.replace(R.id.contenedor, new Modelo2Fragment()).commit();
                controlFragmento.frag = 3;
                break;
            case R.id.garganta:
                if(garganta.getAlpha() == 0.0)
                {
                    garganta.setAlpha((float)1.0);
                    backToast = Toast.makeText(getContext(), "Presionaste la garganta", Toast.LENGTH_SHORT);
                    contador++;
                    actualizarStatus("GARGANTA", 1);
                    actualizarStatusSintoma("GARGANTA");
                }
                else{
                    garganta.setAlpha((float)0.0);
                    contador--;
                    actualizarStatus("GARGANTA", 0);
                    actualizarStatusSintoma("");
                }
                break;
            case R.id.rodilladerecha:
                if(rodillauno.getAlpha() == 0.0)
                {
                    rodillauno.setAlpha((float)1.0);
                    backToast = Toast.makeText(getContext(), "Presionaste la rodilla derecha", Toast.LENGTH_SHORT);
                    contador++;
                    actualizarStatus("RODILLAS", 1);
                    actualizarStatusSintoma("RODILLAS");
                }
                else{
                    rodillauno.setAlpha((float)0.0);
                    contador--;
                    actualizarStatus("RODILLAS", 0);
                    actualizarStatusSintoma("");
                }
                break;
            case R.id.rodillaizquierda:
                if(rodillados.getAlpha() == 0.0)
                {
                    rodillados.setAlpha((float)1.0);
                    backToast = Toast.makeText(getContext(), "Presionaste la rodilla izquierda", Toast.LENGTH_SHORT);
                    contador++;
                    actualizarStatus("RODILLAS", 1);
                    actualizarStatusSintoma("RODILLAS");
                }
                else{
                    rodillados.setAlpha((float)0.0);
                    contador--;
                    actualizarStatus("RODILLAS", 0);
                    actualizarStatusSintoma("");
                }
                break;
            case R.id.flotante:
                if(contador!=0){
                    actualizarSintoma();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.contenedor, new SintomasFragment()).commit();
                    transaction.addToBackStack(null);
                    //controlFragmento.frag = 3;
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
}
