package local.tp2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView rv = (RecyclerView) findViewById(R.id.list);

        //Arraylist des Notes
        ArrayList<NoteActivity> noteActivities = new ArrayList<NoteActivity>();
        noteActivities.add(new NoteActivity("Nouvelle Note", df.format(Calendar.getInstance().getTime()),""));

        //set le RecyclerView/
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new MyAdapter(noteActivities));
    }

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        private ArrayList<NoteActivity> noteActivities;
        public MyAdapter(ArrayList<NoteActivity> noteActivities) {this.noteActivities = noteActivities;
        }

        @Override
        //Compte le numero du bouton
        public int getItemCount() {return noteActivities.size();}

        @Override
        //Layout dans le boutons
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.case_liste, parent,false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            NoteActivity noteActivity = noteActivities.get(position);
            holder.display(noteActivity);
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
                ligne1 = ((TextView) itemView.findViewById(R.id.ligne1));

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        //OUVRIR LA NOTE OU ON A CLIQUÉ





                    }
                });
            }

            //Afficher l'unité (dans le bouton)
            public void display(NoteActivity noteActivityy) {
                currentNote = noteActivityy;
                titre.setText(noteActivityy.getTitre());
                date.setText(noteActivityy.getDate());
                ligne1.setText(noteActivityy.getLigne1());
            }
        }


    }
}
