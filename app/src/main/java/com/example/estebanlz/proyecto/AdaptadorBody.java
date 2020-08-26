package com.example.estebanlz.proyecto;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AdaptadorBody extends RecyclerView.Adapter<AdaptadorBody.ViewHolderFavoritos> implements View.OnClickListener{
    Context contexto;
    ArrayList<CuerpoVo> consultaCompleta;
    ArrayList<SintomasVO> consultaCompletaSintomas;
    ArrayList<SintomasVO> sintomasConsult;
    RecyclerView cuerpo_lista_contenedor;
    Registros db;
    String error = "";
    int contador = 0;
    private AdaptadorSintoma adapter;
    private static LayoutInflater inflater = null;
    private View.OnClickListener listener;

    public AdaptadorBody(Activity activity, ArrayList<CuerpoVo> cuerpoConsult) {
        this.consultaCompleta = cuerpoConsult;
        this.contexto = activity;
    }

    @Override
    public void onClick(View v) {
        if(listener != null){
            listener.onClick(v);
        }
    }

    public class ViewHolderFavoritos extends RecyclerView.ViewHolder {
        TextView cuerpo;
        ImageView imagen;
        ImageView imagen2;
        public ViewHolderFavoritos(View itemView) {
            super(itemView);
            try
            {
                cuerpo = (TextView) itemView.findViewById(R.id.nombre_parte);
                cuerpo_lista_contenedor = (RecyclerView) itemView.findViewById(R.id.sintomas_lista);
                imagen = (ImageView) itemView.findViewById(R.id.imagen_parte);
                imagen2 = (ImageView) itemView.findViewById(R.id.imagenValidar);
                sintomasConsult = new ArrayList<>();
            }
            catch (Exception s)
            {
                cuerpo.setText(s.getMessage());
            }
        }
    }
    private int sumar(String parte){
        db = new Registros(contexto.getApplicationContext());
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
    @Override
    public AdaptadorBody.ViewHolderFavoritos onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_sintomas2_item, null, false);
        view.setOnClickListener(this);
        return new ViewHolderFavoritos(view);
    }
    @Override
    public void onBindViewHolder(final AdaptadorBody.ViewHolderFavoritos holder, final int position) {
        try {
            holder.cuerpo.setText("Sintomas " + consultaCompleta.get(position).getCuerpo().toLowerCase());
            holder.imagen.setImageResource(consultaCompleta.get(position).getImg_cuerpo());
            int validar = sumar(consultaCompleta.get(position).getCuerpo());
            if(validar > 0){
                holder.imagen2.setImageResource(R.drawable.check);
            }
            else{
                holder.imagen2.setImageResource(0);
            }
        }
        catch (Exception e)
        {
            holder.cuerpo.setText(e.getMessage());
        }
    }
    @Override
    public int getItemCount() {
        return consultaCompleta.size();
    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }
    private void llenarListaSintomas(String filtro)
    {
        try {
            db = new Registros(contexto.getApplicationContext());
            SQLiteDatabase base = db.getWritableDatabase();
            SintomasVO sintomas = null;
            Cursor c = base.rawQuery("SELECT * FROM " + db.TABLE3 + " WHERE " + db.SINTOMA_RELACION + " = '" + filtro + "'", null);
            if (c != null) {
                c.moveToFirst();
                do {
                    sintomas = new SintomasVO();
                    sintomas.setId_sintoma(c.getInt(0));
                    sintomas.setSintoma(c.getString(1));
                    sintomas.setStatus_sintoma(c.getInt(2));
                    sintomas.setSintoma_relacion(c.getString(3));
                    sintomasConsult.add(sintomas);
                } while (c.moveToNext());
            }
        } catch (Exception es) {
            error = es.getMessage();
        }
    }
}
