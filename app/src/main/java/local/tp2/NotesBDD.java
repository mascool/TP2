package local.tp2;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class NotesBDD {
    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "text.db";

    private static final String TABLE_LIVRES = "table_notes";
    private static final String COL_TITRE = "titre";
    private static final int NUM_COL_TITRE = 0;
    private static final String COL_DATE = "date";
    private static final int NUM_COL_DATE = 1;
    private static final String COL_MESSAGE = "message";
    private static final int NUM_COL_MESSAGE = 2;

    private SQLiteDatabase bdd;

    private NotesSQLite maBaseSQLite;

    public NotesBDD(Context context){
        //On crée la BDD et sa table
        maBaseSQLite = new NotesSQLite(context, NOM_BDD, null, VERSION_BDD);
    }

    public void open(){
        //on ouvre la BDD en écriture
        bdd = maBaseSQLite.getWritableDatabase();
    }

    public void close(){
        //on ferme l'accès à la BDD
        bdd.close();
    }

    public SQLiteDatabase getBDD(){
        return bdd;
    }

    public long insertNote(Note note){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associée à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(COL_DATE, note.getDate());
        values.put(COL_TITRE, note.getTitre());
        //on insère l'objet dans la BDD via le ContentValues
        return bdd.insert(TABLE_LIVRES, null, values);
    }

    public int updateLivre(int id, Note note){
        //La mise à jour d'un livre dans la BDD fonctionne plus ou moins comme une insertion
        //il faut simplement préciser quel livre on doit mettre à jour grâce à l'ID
        ContentValues values = new ContentValues();
        values.put(COL_DATE, note.getDate());
        values.put(COL_TITRE, note.getContenu());
        return bdd.update(TABLE_LIVRES, values, COL_TITRE + " = " +id, null);
    }

    public int removeLivreWithID(int id){
        //Suppression d'un livre de la BDD grâce à l'ID
        return bdd.delete(TABLE_LIVRES, COL_TITRE + " = " +id, null);
    }

    public Note getLivreWithTitre(String titre){
        //Récupère dans un Cursor les valeurs correspondant à un livre contenu dans la BDD (ici on sélectionne le livre grâce à son titre)
        Cursor c = bdd.query(TABLE_LIVRES, new String[] {COL_TITRE, COL_DATE, COL_TITRE}, COL_TITRE + " LIKE \"" + titre +"\"", null, null, null, null);
        return cursorToLivre(c);
    }

    //Cette méthode permet de convertir un cursor en un livre
    private Note cursorToLivre(Cursor c){
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;

        //Sinon on se place sur le premier élément
        c.moveToFirst();
        //On créé un livre
        Note note = new Note();
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        note.setTitre(c.getString(NUM_COL_TITRE));
        note.setDate(c.getString(NUM_COL_DATE));
        note.setContenu(c.getString(NUM_COL_MESSAGE));
        //On ferme le cursor
        c.close();

        //On retourne le livre
        return note;
    }

}
