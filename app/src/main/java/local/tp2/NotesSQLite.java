package local.tp2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

/**
 * Created by Hans Fontaine on 2017-12-10.
 */

public class NotesSQLite extends SQLiteOpenHelper {
    private static final String TABLE_NOTES = "table_notes";
    private static final String COL_TITRE = "titre";
    private static final String COL_DATE = "date";
    private static final String COL_MESSAGE = "Message";

    private static final String CREATE_BDD = "CREATE TABLE " + TABLE_NOTES + " ("
            + COL_TITRE + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_DATE + " TEXT NOT NULL, "
            + COL_MESSAGE + " TEXT NOT NULL);";

    public NotesSQLite(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BDD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_NOTES + ";");
        onCreate(db);
    }

}
