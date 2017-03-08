package com.example.russo.todolistcomplete;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by russo on 08/03/2017.
 */

public class Database extends SQLiteOpenHelper {

    // Notes Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_TITOLO = "titolo";
    private static final String KEY_DESCRIZIONE = "descrizione";
    private static final String KEY_DATA = "data";

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "list";

    // Contacts table name
    private static final String TABLE_ITEMS = "items";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_NOTE_TABLE = "CREATE TABLE " + TABLE_ITEMS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TITOLO + " TEXT,"
                + KEY_DESCRIZIONE + " TEXT, " + KEY_DATA + " TEXT )";
        db.execSQL(CREATE_NOTE_TABLE);

    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);
        // Create tables again
        onCreate(db);

    }


    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */


    public long addNote(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TITOLO, item.getTitolo());
        values.put(KEY_DESCRIZIONE, item.getDescrizione());
        values.put(KEY_DATA, item.getDataCreazione());

        // Inserting Row
        long insert = db.insert(TABLE_ITEMS, null, values);
        item.setID((int)insert);
        db.close(); // Closing database connection
        return insert;
    }

    // Getting All Notes
    public ArrayList<Item> getAllNotes() {
        ArrayList<Item> notesList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ITEMS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Item item = new Item(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3));
                // Adding note to list
                notesList.add(item);
            } while (cursor.moveToNext());
        }

        // return notes list
        return notesList;
    }

    // Updating single note
    public int updateNote(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TITOLO, item.getTitolo());
        values.put(KEY_DESCRIZIONE, item.getDescrizione());
        // updating row
        return db.update(TABLE_ITEMS, values, KEY_ID + " = ?",
                new String[]{String.valueOf(item.getID())});
    }

    // Deleting single note
    public void deletNote(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ITEMS, KEY_ID + " = ?",
                new String[]{String.valueOf(item.getID())});
        db.close();
    }


}