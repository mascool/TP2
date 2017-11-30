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


}
