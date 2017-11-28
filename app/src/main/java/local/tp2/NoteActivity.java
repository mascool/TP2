package local.tp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by anthonymartin on 17-11-27.
 */

public class NoteActivity extends AppCompatActivity {

    private String titre;
    private String date;
    private String ligne1;

    public NoteActivity(String titre, String date, String ligne1) {

        this.titre = titre;
        this.date = date;
        this.ligne1 = ligne1;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note);

        //Initialisation des Boutons cliquables
        ImageButton supprimer = (ImageButton)findViewById(R.id.supprimer);
        ImageButton reglage = (ImageButton)findViewById(R.id.reglage);
        ImageButton ajouter = (ImageButton)findViewById(R.id.ajouter);

        //Listener pour supprimer la note
        supprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //SUPPRIMER LA NOTE

            }
        });

        //Listener pour acceder aux reglages
        reglage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //ACCEDER AUX REGLAGES
            }
        });

        //Listener pour ajouter une nouvelle note
        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //AJOUTER UNE NOUVELLE NOTE
            }
        });


    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre){
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

    public String getLigne1() {
        return ligne1;
    }

    public void setLigne1(NoteActivity currentNote){

        /////////////COMMENT TROUVER LA PREMIERE LIGNE??? YÉ RENDU MINUIT PI CA ME TENTE PAS D'ESSAYER DE TROUVER//////////////

        //currentNote.

        this.ligne1 = ligne1;
    }

}
