package com.example.estebanlz.proyecto;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.estebanlz.proyecto.Adaptador.mPlay;

public class AdaptadorSintomaEspecifico extends RecyclerView.Adapter<AdaptadorSintomaEspecifico.ViewHolderSintomas> {
    Context contexto;
    ArrayList<SintomasVO> consultaCompletaSintomas;
    ArrayList<AudioSintomasVO> consultaAudiosSintomas;
    Registros db;
    String statusCheck;
    int valor = 0;
    int contador = 0;
    private static LayoutInflater inflater = null;
    Button confSintomas;

    public AdaptadorSintomaEspecifico(Context contexto, ArrayList<SintomasVO> consultaCompletaSintomas) {
        this.contexto = contexto;
        this.consultaCompletaSintomas = consultaCompletaSintomas;
    }
    public AdaptadorSintomaEspecifico(Context contexto, ArrayList<SintomasVO> consultaCompletaSintomas, ArrayList<AudioSintomasVO> consultaAudiosSintomas) {
        this.contexto = contexto;
        this.consultaCompletaSintomas = consultaCompletaSintomas;
        this.consultaAudiosSintomas = consultaAudiosSintomas;
    }

    @Override
    public ViewHolderSintomas onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_sintoma_especifico, null, false);
        return new ViewHolderSintomas(view);
    }
    static MediaPlayer mPlay;
    int anterior = 0;
    AdaptadorSintomaEspecifico.ViewHolderSintomas repuesto;
    @Override
    public void onBindViewHolder(final ViewHolderSintomas holder, final int position) {
        try {
            holder.sintoma.setText(consultaCompletaSintomas.get(position).getSintoma());
        }
        catch (Exception s){

        }
        try {
            holder.sintomaAudio.setTag(position);
            holder.sintomaAudio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        if (mPlay == null || !mPlay.isPlaying()) {
                            reproducir(position, holder);
                        } else if (!holder.sintomaAudio.getTag().equals(anterior) && mPlay.isPlaying()) {
                            mPlay.stop();
                            reproducir(position, holder);
                        } else {
                            mPlay.stop();
                        }
                    } catch (Exception s) {
                    }
                    anterior = position;
                    repuesto = holder;
                }
            });
            holder.validar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    statusCheck = holder.sintoma.getText().toString();
                    if (holder.validar.isChecked()) {
                        valor = 1;
                        contador++;
                        SintomaEspecificoFragment.contador++;
                    } else {
                        valor = 0;
                        contador--;
                        SintomaEspecificoFragment.contador--;
                    }
                    actualizarCheck(statusCheck, valor);
                }
            });
        }
        catch (Exception e){
            holder.sintoma.setText(e.getMessage());
        }
    }
    private void actualizarCheck(String sintoma, int valor){
        try{
            db = new Registros(contexto);
            SQLiteDatabase base = db.getWritableDatabase();
            base.execSQL("UPDATE " + db.TABLE3 + " SET " + db.STATUS_SINTOMA + " = " + valor + " WHERE " + db.SINTOMA + " = '" + sintoma + "'");
        }
        catch (Exception e){
        }
    }
    private void reproducir(int link, final AdaptadorSintomaEspecifico.ViewHolderSintomas holder)
    {
        mPlay = MediaPlayer.create(contexto, Uri.parse(String.format("android.resource://com.example.estebanlz.proyecto/%d", consultaAudiosSintomas.get(link).getSintoma_audio())));
        mPlay.start();
        mPlay.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
            }
        });
    }
    @Override
    public int getItemCount() {
        return consultaCompletaSintomas.size();
    }

    public class ViewHolderSintomas extends RecyclerView.ViewHolder {
        CheckBox validar;
        TextView sintoma;
        ImageView audio;
        RelativeLayout audios;
        CardView sintomaAudio;
        public ViewHolderSintomas(View itemView) {
            super(itemView);
            validar = (CheckBox) itemView.findViewById(R.id.chek_sin);
            sintoma = (TextView) itemView.findViewById(R.id.mostrar_sin);
            audio = (ImageView) itemView.findViewById(R.id.audio_sintoma_especifico);
            audios = (RelativeLayout) itemView.findViewById(R.id.sintomasespecficositems);
            sintomaAudio = (CardView) itemView.findViewById(R.id.cardsintomaespecifico);
        }
    }
}
