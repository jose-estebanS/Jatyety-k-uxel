package com.example.estebanlz.proyecto;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorSintoma extends RecyclerView.Adapter<AdaptadorSintoma.ViewHolderSintomas> {
    Context contexto;
    ArrayList<CuerpoVo> consultaCompleta;
    ArrayList<SintomasVO> consultaCompletaSintomas;
    Registros db;
    int pos = 0;
    private static LayoutInflater inflater = null;

    public AdaptadorSintoma(Context contexto, ArrayList<SintomasVO> consultaCompletaSintomas, int pos) {
        this.contexto = contexto;
        this.consultaCompleta = consultaCompleta;
        this.consultaCompletaSintomas = consultaCompletaSintomas;
        this.pos = pos;
    }

    @Override
    public ViewHolderSintomas onCreateViewHolder(ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolderSintomas holder, int position) {
        try {
        }
        catch (Exception s){
            holder.sintoma.setText(s.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return consultaCompletaSintomas.size();
    }

    public class ViewHolderSintomas extends RecyclerView.ViewHolder {
        TextView sintoma;
        public ViewHolderSintomas(View itemView) {
            super(itemView);
        }
    }
}
