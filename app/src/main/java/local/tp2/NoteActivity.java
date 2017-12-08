package local.tp2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by anthonymartin on 17-11-27.
 */

public class NoteActivity extends AppCompatActivity {
    private Note note;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note);
        ActionBar actionBar= getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                EditText titre = (EditText) findViewById(R.id.titreNote);
                EditText contenu = (EditText)findViewById(R.id.contenuNote);

                Intent intent = new Intent(NoteActivity.this, MainActivity.class);
                intent.putExtra("TITRE", titre.getText().toString());
                intent.putExtra("CONTENU", contenu.getText().toString());
                intent.putExtra("CHEMIN", titre.getText().toString() + ".txt");

                /*
                EditText titre = (EditText)findViewById(R.id.titreNote);
                EditText contenu = (EditText)findViewById(R.id.contenuNote);
                String filename = ("fileOut_test1.txt");
                //String filename = ("fileOut_" + titre.getText().toString() + ".txt");
                File file = new File(getApplicationContext().getFilesDir(), filename);
                Log.e("allo", getApplicationContext().getFilesDir().toString());
                FileOutputStream outputStream;

                try {
                    outputStream = openFileOutput(filename , getApplicationContext().MODE_PRIVATE);
                    outputStream.write("allo".getBytes());
                    //outputStream.write(contenu.getText().toString().getBytes());
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                /*FileInputStream fis = getApplicationContext().openFileInput(filename, Context.MODE_PRIVATE);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader bufferedReader = new BufferedReader(isr);
                StringBuilder sb = new StringBuilder();
                String line;
                try {
                    while ((line = bufferedReader.readLine()) != null) {
                        sb.append(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Log.e("allo", sb.toString());*/
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
