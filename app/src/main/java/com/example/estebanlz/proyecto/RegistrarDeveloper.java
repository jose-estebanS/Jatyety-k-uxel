package com.example.estebanlz.proyecto;

import java.util.ArrayList;
import java.util.List;

public class RegistrarDeveloper {
    ArrayList<DeveloperVO> desarrolladores;
    DeveloperVO developerInfo;

    public ArrayList<DeveloperVO> Desarrollador(){
        desarrolladores = new ArrayList<>();
        TomarDatos();
        return desarrolladores;
    }

    private void TomarDatos(){
        Registrar("","El equipo desarrollador del apartado técnico del desarrollo tecnológico de la App " +
                "estuvo a cargo de estudiantes de la Universidad Tecnológica del Usumacinta","", R.drawable.logout);
        Registrar("José Jesús Esteban Sánchez","Desarrollador", "josejesus9811@gmail.com",R.drawable.esteban);
        Registrar("José Carlos Medina Zapata","Diseñador","josecarlos-m12@outlook.com",R.drawable.zapa);
        Registrar("Cristian Ulises Vázquez Hernández","Diseñador","thecriis1999@gmail.com",R.drawable.chilanguita);
        Registrar("José Ángel Martínez Aguilar","Marketing","angerfisthalo@gmail.com",R.drawable.chato);
        Registrar("Elizabeth Damas Jimenez","Analista","elizabethdamasjimenez@gmail.com",R.drawable.elisa);
        Registrar("Egla Gómez Álcaro","Traductor","heylagomez@gmail.com",R.drawable.egla);
        Registrar("Anery Suarez Vázquez","Asesor Académico UT Usumacinta", "anerysuarez@hotmail.com",R.drawable.anery);
        Registrar("","Las traducciones a las lenguas ch’ol, variante del Noroeste; tsotsil, variante del Norte Alto; " +
                "y yokot’an, variante del Centro, se realizaron en colaboración con la Universidad Intercultural del " +
                "Estado de Tabasco.","",R.drawable.uiet);
        Registrar("Dra. Emma Reyes Cruz","Directora Académica","", R.drawable.mujer);
        Registrar("Mtro. Ulises Contreras Castillo","Jefe del Departamento de Vinculación Social y Extensión Universitaria",
                "", R.drawable.hombre);
        Registrar("Lic. Elizabeth Parcero Martínez", "Coordinadora del Centro de Estudios e Investigaciones en Lenguas",
                "",R.drawable.mujer);
        Registrar("Lic. Jesús García Guadalupe","Coordinador de la Licenciatura en Lengua y Cultura","",R.drawable.hombre);
        Registrar("Mtro. Inocente Hernández Damián","Traductor de la Lengua Yokot'an","",R.drawable.docente);
        Registrar("Edgar Daniel García Gómez","Traductor de la Lengua Tsotsil","",R.drawable.edgar);
        Registrar("Romeo Juaréz López","Colaborador de audio","",R.drawable.romero);
        Registrar("Luis Daniel Martínez Hernández","Traductor de la Lengua Ch'ol","",R.drawable.luis);
        Registrar("Lic. Cynthia Paola de los Santos Ruiz", "PTC de la Licenciatura en Lengua y Cultura","",R.drawable.mujer);
    }
    private void Registrar(String nombre, String rol, String correo, int foto){
        developerInfo = new DeveloperVO();
        developerInfo.setNombre(nombre);
        developerInfo.setRol(rol);
        developerInfo.setCorreo(correo);
        developerInfo.setFoto(foto);
        desarrolladores.add(developerInfo);
    }
}
