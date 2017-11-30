package local.tp2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Antoine Mascolo on 2017-11-30.
 */

public class Note {
    private String titre;
    private String date;
    private String contenu;



    public Note() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy, HH:mm");
        String date = df.format(Calendar.getInstance().getTime());

        this.titre = "";
        this.date = date;
        this.contenu = "";
    }

    public Note(String titre, String ligne1) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy, HH:mm");
        String date = df.format(Calendar.getInstance().getTime());

        this.titre = titre;
        this.date = date;
        this.contenu = ligne1;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy, HH:mm");
        String date = df.format(Calendar.getInstance().getTime());
        this.date = date;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(NoteActivity currentNote){

        /////////////COMMENT TROUVER LA PREMIERE LIGNE??? YÉ RENDU MINUIT PI CA ME TENTE PAS D'ESSAYER DE TROUVER//////////////


        //currentNote.

        this.contenu = contenu;
    }
}
