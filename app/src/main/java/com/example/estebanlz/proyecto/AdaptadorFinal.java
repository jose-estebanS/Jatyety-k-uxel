package com.example.estebanlz.proyecto;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.security.spec.ECField;
import java.util.ArrayList;

public class AdaptadorFinal extends RecyclerView.Adapter<AdaptadorFinal.ViewHolderApadtadorFinal>{
    Context contexto;
    ArrayList<CuerpoVo> finalCuerpo;
    ArrayList<SintomasVO> sintomasFinal;
    private static LayoutInflater inflater = null;
    Registros db;
    String SintomasLista = "";
    int i = 0;
    public AdaptadorFinal(Context contexto, ArrayList<CuerpoVo> finalCuerpo) {
        this.contexto = contexto;
        this.finalCuerpo = finalCuerpo;
    }

    @Override
    public ViewHolderApadtadorFinal onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_final, null, false);
        return new AdaptadorFinal.ViewHolderApadtadorFinal(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderApadtadorFinal holder, int position) {
        try{
            holder.cabeceraSintoma.setText(finalCuerpo.get(position).getCuerpo());
            llenarLista1(finalCuerpo.get(position).getCuerpo());
            holder.hijoSintoma.setText(SintomasLista);
        }
        catch (Exception e){
            holder.cabeceraSintoma.setText(e.getMessage());

        }
    }

    @Override
    public int getItemCount() {
        return finalCuerpo.size();
    }

    public class ViewHolderApadtadorFinal extends RecyclerView.ViewHolder {
        TextView cabeceraSintoma;
        TextView hijoSintoma;
        public ViewHolderApadtadorFinal(View itemView) {
            super(itemView);
            cabeceraSintoma = (TextView) itemView.findViewById(R.id.cabeceraSintoma);
            hijoSintoma = (TextView) itemView.findViewById(R.id.hijoSintoma);
            SintomasLista = "";
        }
    }
    private void llenarLista1(String parte){
        try {
            db = new Registros(contexto.getApplicationContext());
            SQLiteDatabase base = db.getWritableDatabase();
            SintomasVO sintomaFinal = null;
            sintomasFinal = new ArrayList<>();
            Cursor c = base.rawQuery("SELECT * FROM " + db.TABLE3 + " WHERE " + db.SINTOMA_RELACION + " = '" + parte + "' AND " + db.STATUS_SINTOMA +  " = 1", null);
            if (c != null) {
                c.moveToFirst();
                do {
                    sintomaFinal = new SintomasVO();
                    sintomaFinal.setId_sintoma(c.getInt(0));
                    sintomaFinal.setSintoma(c.getString(1));
                    sintomaFinal.setStatus_sintoma(c.getInt(2));
                    sintomaFinal.setSintoma_relacion(c.getString(3));
                    sintomasFinal.add(sintomaFinal);
                } while (c.moveToNext());
                for(int i = 0; i<sintomasFinal.size(); i++){
                    SintomasLista += "➭" + sintomasFinal.get(i).getSintoma() + "\n \n";
                }
            }
        } catch (Exception es) {
        }
    }
}
