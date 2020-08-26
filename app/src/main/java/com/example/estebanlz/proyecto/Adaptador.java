package com.example.estebanlz.proyecto;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolderBuscador>{
    Context contexto;
    ArrayList<FrasesVo> consultaCompleta;
    ArrayList<FrasesVo> searchFull;
    ArrayList<AudiosVo> consultaAudios;
    Registros db;
    TextView frase;
    ImageView sonido;
    ImageView estrella;
    int color = 1;
    private static LayoutInflater inflater = null;

    public Adaptador(Activity activity, ArrayList<FrasesVo> frasesConsult) {
        this.consultaCompleta = frasesConsult;
        this.contexto = activity;
        this.consultaAudios = consultaAudios;
        searchFull = new ArrayList<>(consultaCompleta);
    }
    public Adaptador(Activity activity, ArrayList<FrasesVo> frasesConsult, ArrayList<AudiosVo> consultaAudios) {
        this.consultaAudios = consultaAudios;
        this.consultaCompleta = frasesConsult;
        this.contexto = activity;
        searchFull = new ArrayList<>(consultaCompleta);
    }

    public class ViewHolderBuscador extends RecyclerView.ViewHolder {
        TextView frase;
        ImageView sonido;
        ImageView estrella;
        CardView tarjeta;
        ConstraintLayout fondo;
        Resources res;
        final Drawable drawable;
        final Drawable drawabledos;
        final Drawable drawabletres;


        public ViewHolderBuscador(View itemView) {
            super(itemView);
            frase = (TextView) itemView.findViewById(R.id.fraseMedica);
            sonido = (ImageView) itemView.findViewById(R.id.audioMedico);
            estrella = (ImageView) itemView.findViewById(R.id.star);
            tarjeta = (CardView) itemView.findViewById(R.id.card);
            fondo = (ConstraintLayout) itemView.findViewById(R.id.fondobuscador);
            res = itemView.getResources();
            drawable = res.getDrawable(R.drawable.gradient_background);
            drawabledos = res.getDrawable(R.drawable.gradient_backgrounddos);
            drawabletres = res.getDrawable(R.drawable.gradient_backgroundtres);
        }
    }
    @Override
    public Adaptador.ViewHolderBuscador onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_elementos, null, false);
        return new ViewHolderBuscador(view);
    }
    static MediaPlayer mPlay;
    int anterior = 0;
    Adaptador.ViewHolderBuscador repuesto;
    @Override
    public void onBindViewHolder(final Adaptador.ViewHolderBuscador holder, final int position) {
        try {
            holder.frase.setText(consultaCompleta.get(position).getFrase());
            switch (color)
            {
                case 1:
                    holder.fondo.setBackground(holder.drawable);
                    break;
                case 2:
                    holder.fondo.setBackground(holder.drawabletres);
                    color = 0;
                    break;
            }
            color++;
        }
        catch (Exception e)
        {
            holder.frase.setText(e.getMessage());
        }
        holder.tarjeta.setTag(position);
        holder.tarjeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(mPlay == null || !mPlay.isPlaying())
                    {
                        holder.sonido.setImageResource(R.drawable.audiostop);
                        reproducir(position, holder);
                    }
                    else if(!holder.tarjeta.getTag().equals(anterior) && mPlay.isPlaying())
                    {
                        mPlay.stop();
                        repuesto.sonido.setImageResource(R.drawable.audio);
                        holder.sonido.setImageResource(R.drawable.audiostop);
                        reproducir(position, holder);
                    }
                    else
                    {
                        mPlay.stop();
                        holder.sonido.setImageResource(R.drawable.audio);
                    }
                }
                catch (Exception s){}
                anterior = position;
                repuesto = holder;
            }
        });
        if(consultaCompleta.get(position).getStatus() == 0)
        {
            holder.estrella.setImageResource(R.mipmap.btn_star_big_off_disable);
            holder.estrella.setTag(R.mipmap.btn_star_big_off_disable);
        }
        else if(consultaCompleta.get(position).getStatus() == 1)
        {
            holder.estrella.setImageResource(R.mipmap.btn_star_big_on);
            holder.estrella.setTag(R.mipmap.btn_star_big_on);
        }
        holder.estrella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpgradeStar(holder, position);
            }
        });
    }
    private void reproducir(int link, final Adaptador.ViewHolderBuscador holder)
    {
        try{ mPlay = MediaPlayer.create(contexto, Uri.parse(String.format("android.resource://com.example.estebanlz.proyecto/%d", consultaAudios.get(link).getAudio())));
        mPlay.start();
        mPlay.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                holder.sonido.setImageResource(R.drawable.audio);
            }
        });}
        catch (Exception s){
            Log.e("1",s.getMessage());
        }
    }
public void UpgradeStar(Adaptador.ViewHolderBuscador holder, int position)
    {
        if((int) holder.estrella.getTag() == R.mipmap.btn_star_big_on)
        {
            holder.estrella.setImageResource(R.mipmap.btn_star_big_off_disable);
            holder.estrella.setTag(R.mipmap.btn_star_big_off_disable);
            db = new Registros(contexto);
            SQLiteDatabase base = db.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv = new ContentValues();
            cv.put(db.STATUS, 0);
            base.update(db.TABLE, cv, db.TABLE_ID+ " = " + (consultaCompleta.get(position).getId_frase()), null);
        }
        else if((int) holder.estrella.getTag() == R.mipmap.btn_star_big_off_disable)
        {
            holder.estrella.setImageResource(R.mipmap.btn_star_big_on);
            holder.estrella.setTag(R.mipmap.btn_star_big_on);
            db = new Registros(contexto);
            SQLiteDatabase base = db.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv = new ContentValues();
            cv.put(db.STATUS, 1);
            base.update(db.TABLE, cv, db.TABLE_ID+ " = " + (consultaCompleta.get(position).getId_frase()), null);
        }
    }
    public int CambiarColor(int numero, Adaptador.ViewHolderBuscador holder)
    {
        switch (numero)
        {
            case 1:
                holder.fondo.setBackground(holder.drawable);
                break;
            case 2:
                holder.fondo.setBackground(holder.drawabletres);
                numero = 0;
                break;
        }
        return numero++;
    }

    @Override
    public int getItemCount() {
        return consultaCompleta.size();
    }
}
