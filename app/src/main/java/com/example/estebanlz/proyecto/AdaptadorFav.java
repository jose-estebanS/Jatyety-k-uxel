package com.example.estebanlz.proyecto;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.estebanlz.proyecto.Adaptador.mPlay;

public class AdaptadorFav extends RecyclerView.Adapter<AdaptadorFav.ViewHolderFavoritos>{
    Context contexto;
    ArrayList<FrasesVo> consultaCompleta;
    ArrayList<AudiosVo> consultaAudios;
    Registros db;
    int color = 1;
    private static LayoutInflater inflater = null;

    public AdaptadorFav(Activity activity, ArrayList<FrasesVo> frasesConsult) {
        this.consultaCompleta = frasesConsult;
        this.contexto = activity;
    }
    public AdaptadorFav(Activity activity, ArrayList<FrasesVo> frasesConsult, ArrayList<AudiosVo> consultaAudios) {
        this.consultaCompleta = frasesConsult;
        this.contexto = activity;
        this.consultaAudios = consultaAudios;
    }
    public class ViewHolderFavoritos extends RecyclerView.ViewHolder {
        TextView frase;
        ImageView sonido;
        ImageView estrella;
        RecyclerView fragmento;
        CardView tarjeta;
        ConstraintLayout fondo;
        Resources res;
        final Drawable drawable;
        final Drawable drawabledos;
        final Drawable drawabletres;

        public ViewHolderFavoritos(View itemView) {
            super(itemView);
            frase = (TextView) itemView.findViewById(R.id.fraseMedica);
            sonido = (ImageView) itemView.findViewById(R.id.audioMedico);
            estrella = (ImageView) itemView.findViewById(R.id.star);
            fragmento = (RecyclerView) itemView.findViewById(R.id.lista_favoritos);
            tarjeta = (CardView) itemView.findViewById(R.id.card);
            fondo = (ConstraintLayout) itemView.findViewById(R.id.fondobuscador);
            res = itemView.getResources();
            drawable = res.getDrawable(R.drawable.gradient_background);
            drawabledos = res.getDrawable(R.drawable.gradient_backgrounddos);
            drawabletres = res.getDrawable(R.drawable.gradient_backgroundtres);
        }
    }
    @Override
    public AdaptadorFav.ViewHolderFavoritos onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_elementos, null, false);
        return new ViewHolderFavoritos(view);
    }
    static MediaPlayer mPlay;
    int anterior = 0;
    AdaptadorFav.ViewHolderFavoritos repuesto;
    @Override
    public void onBindViewHolder(final AdaptadorFav.ViewHolderFavoritos holder, final int position) {
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
            holder.estrella.setImageResource(R.mipmap.btn_star_big_on);
            holder.estrella.setTag(R.mipmap.btn_star_big_on);
        holder.estrella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpgradeStar(holder, position);
            }
        });
    }
    private void reproducir(int link, final AdaptadorFav.ViewHolderFavoritos holder)
    {
        mPlay = MediaPlayer.create(contexto, Uri.parse(String.format("android.resource://com.example.estebanlz.proyecto/%d", consultaAudios.get(link).getAudio())));
        mPlay.start();
        mPlay.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                holder.sonido.setImageResource(R.drawable.audio);
            }
        });
    }
    public void UpgradeStar(AdaptadorFav.ViewHolderFavoritos holder, int position)
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

    @Override
    public int getItemCount() {
        return consultaCompleta.size();
    }
}
