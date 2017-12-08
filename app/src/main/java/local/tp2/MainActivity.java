package local.tp2;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private final String FCONFIG = "database.txt";

    private ArrayList<Note> notes;

    private RecyclerView rv;
    private FloatingActionButton nouvelleNoteB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // INITIALISATION DES NOTES
        notes = new ArrayList<Note>();


        // INITIALISATION DU FICHIER
        File fConfig = new File(getApplicationContext().getFilesDir(), FCONFIG);
        if(fConfig.exists()){
            ecrireFichier(lireFichier());
        }

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                // PASS
            } else {
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy, HH:mm");
                notes.add(new Note(extras.getString("TITRE"),df.format(Calendar.getInstance().getTime()) , extras.getString("CONTENU"), extras.getString("CHEMIN")));

            }
        } else {
            // PASS
        }


        // INITIALISATION DE TOUS LES WIDGETS
        rv = (RecyclerView) findViewById(R.id.list);
        nouvelleNoteB = (FloatingActionButton)findViewById(R.id.nouvelleNote);


        // MISE EN PLACE DU RECYCLER VIEW
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new MyAdapter(notes));

        nouvelleNoteB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NoteActivity.class);
                startActivity(intent);
            }
        });
    }


    // CRÉATION D'UN ADAPTER
    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        private ArrayList<Note> notes;
        public MyAdapter(ArrayList<Note> notes1) {this.notes = notes1;
        }

        @Override
        //Compte le numero du bouton
        public int getItemCount() {return notes.size();}

        @Override
        //Layout dans le boutons
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.case_liste, parent,false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            Note noteActivity = notes.get(position);
            //holder.display(noteActivity);
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            private NoteActivity currentNote;
            private final TextView titre;
            private final TextView date;
            private final TextView ligne1;



            public MyViewHolder(final View itemView) {
                super(itemView);

                titre = ((TextView) itemView.findViewById(R.id.titre));
                date = ((TextView) itemView.findViewById(R.id.date));
                ligne1 = ((TextView) itemView.findViewById(R.id.apercuLigne1));

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        //OUVRIR LA NOTE OU ON A CLIQUÉ





                    }
                });
            }

            //Afficher l'unité (dans le bouton)
            /*public void display(NoteActivity noteActivityy) {
                currentNote = noteActivityy;
                titre.setText(Note.getTitre());
                date.setText(Note.getDate());
                ligne1.setText(Note.contenu());
            }*/
        }


    }


    // MISE EN PLACE DU MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.aPropos:

                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.a_propos, (ViewGroup) findViewById(R.id.customToast) );

                Toast toast = new Toast(getApplicationContext());

                toast.setView(layout);
                toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();
                return true;
            case R.id.funFacts:
                new android.app.AlertDialog.Builder(getApplicationContext())
                        .setTitle("@string/faits_amusants !")
                        .setMessage("Saviez-vous que cette section a ete cree dans le seul but " +
                                "de faire plaisir a Alexandre.")
                        .show();
            default :
                return super.onOptionsItemSelected(item);
        }
    }

    // ÉCRIRE LE FICHIER
    public void ecrireFichier(String nomFichier) {
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(FCONFIG, Context.MODE_APPEND);
            fos.write(nomFichier.getBytes());
            //System.out.println("Écriture dans le fichier "+FCONFIG+" réussie");
            //System.out.println("config écrite : " + nomFichier);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    // LIRE FICHIER
    public String lireFichier() {
        FileInputStream fis = null;
        try {
            fis = openFileInput(FCONFIG);
            InputStreamReader inputreader = new InputStreamReader(fis);
            BufferedReader buffreader = new BufferedReader(inputreader);
            String line, line1 = "";
            while ((line = buffreader.readLine()) != null)
                line1+=line;

            return line;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
