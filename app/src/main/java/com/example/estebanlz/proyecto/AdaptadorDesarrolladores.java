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
import android.util.Log;
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
    private int LAYOUT_UT = 1;
    private int LAYOUT_DEFAULT = 0;
    private int LAYOUT_UIET = 2;
    private String[]desarrolladores = {"","José Jesús Esteban Sánchez","José Carlos Medina Zapata","Cristian Ulises Vázquez Hernández",
            "José Ángel Martínez Aguilar","Elizabeth Damas Jimenez","Egla Gómez Álvaro","Anery Suarez Vázquez","","Dra. Emma Reyes Cruz",
            "Mtro. Ulises Contreras Castillo","Lic. Elizabeth Parcero Martínez","","Lic. Jesús García Guadalupe","Mtro. Inocente Hernández Damián",
            "Edgar Darinel García Gómez","Romeo Juárez López","Luis Daniel Martínez Hernández","Lic. Cynthia Paola de los Santos Ruiz"};

    private String[]roles = {"El equipo desarrollador del apartado técnico del desarrollo tecnológico de la App estuvo a cargo de estudiantes de la Universidad Tecnológica del Usumacinta",
            "Desarrollador","Diseñador","Diseñador","Marketing","Analista","Traductor","Asesor Académico UT Usumacinta",
            "Las traducciones a las lenguas ch’ol, variante del Noroeste; tsotsil, variante del Norte Alto; y yokot’an, variante del Centro, se realizaron en colaboración con la Universidad Intercultural del Estado de Tabasco.",
            "Directora Académica", "Jefe del Departamento de Vinculación Social y Extensión Universitaria","Coordinadora del Centro de Estudios e Investigaciones en Lenguas",
            "","Coordinador de la Licenciatura en Lengua y Cultura","Traductor de la Lengua Yokot'an","Traductor de la Lengua Tsotsil","Colaborador de audio",
            "Traductor de la Lengua Ch'ol","PTC de la Licenciatura en Lengua y Cultura"};

    private int[] imagenes = {R.drawable.logout, R.drawable.esteban, R.drawable.zapa, R.drawable.chilanguita, R.drawable.chato, R.drawable.elisa,
            R.drawable.egla, R.drawable.anery,R.drawable.uiet,R.drawable.mujer,R.drawable.hombre,R.drawable.mujer,R.drawable.mujer,R.drawable.hombre,R.drawable.docente,R.drawable.edgar,
            R.drawable.romero,R.drawable.luis,R.drawable.mujer};

    private String[] correos = {"","josejesus9811@gmail.com","josecarlos-m12@outlook.com","thecriis1999@gmail.com","angerfisthalo@gmail.com",
            "elizabethdamasjimenez@gmail.com","heylagomez@gmail.com","anerysuarez@hotmail.com","","","","","","","","","","",""};

    ArrayList<DeveloperVO> developers = new RegistrarDeveloper().Desarrollador();

    public AdaptadorDesarrolladores(Context contexto) {
        this.contexto = contexto;
    }

    @Override
    public ViewHolderSintomas onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if(viewType == LAYOUT_UT){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dev_ut, null, false);
        }
        else if(viewType == LAYOUT_UIET){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dev_uiet, null, false);
        }
        else{
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_desarrolladores, null, false);
        }
        return new ViewHolderSintomas(view);
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return 1;
        }
        else if(position == 8){
            return 2;
        }
        else{
            return 0;
        }
    }

    @Override
    public void onBindViewHolder(final ViewHolderSintomas holder, final int position) {
        /*Log.e("Error: ", ""+position);
        try{
            if(i == 0 || i == 8){
                holder.rol.setTextSize(15);
                holder.fondo.setBackgroundColor(Color.parseColor("#1976d2"));
                holder.rol.setTextColor(Color.parseColor("#ffffff"));
                if(i == 8){
                    holder.rol.setTextSize(14);
                    holder.fondo.setBackgroundColor(Color.parseColor("#2e7d32"));
                    holder.rol.setTextColor(Color.parseColor("#ffffff"));
                }
            }
            if(i == 12){
                holder.fondo.setVisibility(View.INVISIBLE);
            }
        }
        catch (Exception s){
            //Log.e("Explicación",s.getMessage());
        }
        i++;*/
        /*if(position == 0){
            holder.rol.setTextSize(15);
            holder.fondo.setBackgroundColor(Color.parseColor("#1976d2"));
            holder.rol.setTextColor(Color.parseColor("#ffffff"));
        }
        if(position == 8){
            holder.rol.setTextSize(14);
            holder.fondo.setBackgroundColor(Color.parseColor("#2e7d32"));
            holder.rol.setTextColor(Color.parseColor("#ffffff"));
        }*/
        holder.imagen.setImageResource(developers.get(position).getFoto());
        holder.rol.setText(developers.get(position).getRol());
        holder.nombre.setText(developers.get(position).getNombre());
        holder.correo.setText(developers.get(position).getCorreo());
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
        return 18;
    }

    public class ViewHolderSintomas extends RecyclerView.ViewHolder {
        TextView rol;
        TextView nombre;
        TextView correo;
        ImageView imagen;
        LinearLayout desarrollador;
        //LinearLayout fondo;
        Dialog mDialog;
        ImageView fotoDes;
        public ViewHolderSintomas(View itemView) {
            super(itemView);
            rol = (TextView) itemView.findViewById(R.id.rolDesarrollador);
            nombre = (TextView) itemView.findViewById(R.id.nombreDesarrollador);
            imagen = (ImageView) itemView.findViewById(R.id.imagenDesarrollador);
            correo = (TextView) itemView.findViewById(R.id.correo);
            desarrollador = (LinearLayout) itemView.findViewById(R.id.itemdesarrollador);
            //fondo = (LinearLayout) itemView.findViewById(R.id.itemdesarrollador2);
            fotoDes = (ImageView) itemView.findViewById(R.id.fotoDesarroladorPop);
            mDialog = new Dialog(contexto);
        }
    }
}
