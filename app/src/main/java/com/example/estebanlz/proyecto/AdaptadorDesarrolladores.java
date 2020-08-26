package com.example.estebanlz.proyecto;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AdaptadorDesarrolladores extends RecyclerView.Adapter<AdaptadorDesarrolladores.ViewHolderSintomas> {
    Context contexto;
    Intent emailIntent;
    private static LayoutInflater inflater = null;
    private String[]desarrolladores = {"José Jesús Esteban Sánchez","José Carlos Medina Zapata","Cristian Ulises Vázquez Hernández","José Ángel Martínez Aguilar","Elizabeth Damas Jimenez","Egla Gómez Álvaro","Anery Suarez Vázquez","Dra. Emma Reyes Cruz","Mtro. Ulises Contreras Castillo","Lic. Elizabeth Parcero Martínez","Lic.Jesús García Guadalupe","Mtro. Inocente Hernández Damián","Edgar Darinel García Gómez","Romeo Juárez López","Luis Daniel Martínez Hernández"};
    private String[]roles = {"Desarrollador","Diseñador","Diseñador","Marketing","Analista","Traductor","Asesor Académico UT Usumacinta","Directora Académica","Jefe del Departamento de Vinculación Social y Extensión Universitaria","Coordinadora del Centro de Estudios e Investigaciones en Lenguas","Coordinador de la Licenciatura en Lengua y Cultura","Traductor de la Lengua Yokot'an","Traductor de la Lengua Tsotsil","Colaborador de audio","Traductor de la Lengua Ch'ol"};
    private int[] imagenes = {R.drawable.esteban, R.drawable.zapa, R.drawable.chilanguita, R.drawable.chato, R.drawable.elisa, R.drawable.egla, R.drawable.anery,R.drawable.mujer,R.drawable.hombre,R.drawable.mujer,R.drawable.hombre,R.drawable.docente,R.drawable.edgar,R.drawable.romero,R.drawable.luis};
    private String[] correos = {"josejesus9811@gmail.com","josecarlos-m12@outlook.com","thecriis1999@gmail.com","angerfisthalo@gmail.com","elizabethdamasjimenez@gmail.com","heylagomez@gmail.com","anerysuarez@hotmail.com","","","","","","","","","","",""};
    public AdaptadorDesarrolladores(Context contexto) {
        this.contexto = contexto;
    }

    @Override
    public ViewHolderSintomas onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_desarrolladores, null, false);
        return new ViewHolderSintomas(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolderSintomas holder, final int position) {
        if(position == 0){
            holder.encabezadoUT.setHeight(200);
        }else{
            holder.encabezadoUT.setHeight(1);
        }
        if(position == 6){
            holder.encabezadoUIET.setHeight(200);
        }else{
            holder.encabezadoUIET.setHeight(1);
        }
        holder.imagen.setImageResource(imagenes[position]);
        holder.rol.setText(roles[position]);
        holder.nombre.setText(desarrolladores[position]);
        holder.correo.setText(correos[position]);
        holder.desarrollador.setTag(position);
        holder.desarrollador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", correos[position], null));
                    contexto.startActivity(Intent.createChooser(emailIntent, null));
                }
                catch (Exception e)
                {
                    Toast.makeText(contexto,"No cuentas con una aplicación para enviar correos", Toast.LENGTH_LONG).show();
                }
            }
        });
        holder.imagen.setTag(position);
        holder.imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    //holder.fotoDes.setImageResource(imagenes[position]);
                    //holder.mDialog.setContentView(R.layout.foto_popup);
                    //holder.mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    //holder.mDialog.show();
                    onCreateDialog(0, imagenes[position]).show();
                }
                catch (Exception E){
                    Toast.makeText(contexto, E.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    protected Dialog onCreateDialog(int id, int foto){
        ImageView image = new ImageView(contexto);
        image.setImageResource(foto);
        Dialog dialog = null;
        AlertDialog.Builder builder =  new AlertDialog.Builder(contexto);
        builder = builder.setView(image);
        dialog = builder.create();
        return dialog;
    }
    @Override
    public int getItemCount() {
        return imagenes.length;
    }

    public class ViewHolderSintomas extends RecyclerView.ViewHolder {
        TextView rol;
        TextView nombre;
        TextView correo;
        TextView encabezadoUT;
        TextView encabezadoUIET;
        ImageView imagen;
        LinearLayout desarrollador;
        Dialog mDialog;
        ImageView fotoDes;
        public ViewHolderSintomas(View itemView) {
            super(itemView);
            rol = (TextView) itemView.findViewById(R.id.rolDesarrollador);
            nombre = (TextView) itemView.findViewById(R.id.nombreDesarrollador);
            imagen = (ImageView) itemView.findViewById(R.id.imagenDesarrollador);
            encabezadoUT = (TextView) itemView.findViewById(R.id.encabezadoUT);
            encabezadoUIET = (TextView) itemView.findViewById(R.id.encabezadoUIET);
            correo = (TextView) itemView.findViewById(R.id.correo);
            desarrollador = (LinearLayout) itemView.findViewById(R.id.itemdesarrollador);
            fotoDes = (ImageView) itemView.findViewById(R.id.fotoDesarroladorPop);
            mDialog = new Dialog(contexto);
        }
    }
}
