package com.we4.wordolio.localdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Ajay on 30-04-2017.
 */

public class LocalDB extends SQLiteOpenHelper {
    static final String DATABASE_NAME="word_olio";
    static final int DATABASE_VERSION=3;
    static final String Simple="simple";
    static final String SimpleScore="simplescore";
    private static SQLiteDatabase db;
    private static LocalDB sInstance;
    static final String CREATE_DB_SIMPLE=
            "CREATE TABLE "+Simple+
                    " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "level INTEGER, "+
                    "status VARCHAR );";
    static final String CREATE_DB_SSCORE=
            "CREATE TABLE "+SimpleScore+
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "level INTEGER, "+
                    "score INTEGER );";

    public static synchronized LocalDB initLocalDB(Context appContext) {
        if (sInstance == null) {
            sInstance = new LocalDB(appContext);
        }
        return sInstance;
    }

    public static synchronized LocalDB getInstance() {
        if (sInstance == null) {
            // TODO(sriram): Handle null
        }
        return sInstance;
    }

    public static synchronized LocalDB getInstance(Context context) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new LocalDB(context.getApplicationContext());
        }
        return sInstance;
    }

    public LocalDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db = getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL(CREATE_DB_SIMPLE);
        db.execSQL(CREATE_DB_SSCORE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Simple);
        db.execSQL("DROP TABLE IF EXISTS " + SimpleScore);
        onCreate(db);

    }
    public void insertToSimple(int level, String status){
        Log.i("LocalDB", "levelAndStatus: " + level+" "+status);
        ContentValues values = new ContentValues();
        values.put("level", level);
        values.put("status", status);
        long result = db.insertWithOnConflict(Simple, null, values, SQLiteDatabase.CONFLICT_IGNORE);
        //return result;
    }
    public  void insertToSimpleScore(int level,int score)
    {
        ContentValues values=new ContentValues();
        values.put("level",level);
        values.put("score",score);
        long result = db.insertWithOnConflict(SimpleScore, null, values, SQLiteDatabase.CONFLICT_IGNORE);
    }
    public String getSimpleStatus(int level) {
        String status = null;
        String selectQuery = "select * from " + Simple + " where level"
                + " = '" + level + "'";

        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null && c.moveToFirst()) {
            status = c.getString(c.getColumnIndex("status"));
            c.close();
        }
        return status;
    }
    public String getSimpleScoreStatus(int level) {
        String score = null;
        String selectQuery = "select * from " + SimpleScore + " where level"
                + " = '" + level + "'";

        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null && c.moveToFirst()) {
            score = c.getString(c.getColumnIndex("score"));
            c.close();
        }
        return score;
    }
    public  void updateSimpleStatus(int level,String status)
    {
        ContentValues values=new ContentValues();
        values.put("status",status);
        db.update(Simple, values, "level" + " = ?", new String[]{String.valueOf(level)});
    }
    public  void updateSimpleScoreStatus(int level,int score)
    {
        ContentValues values=new ContentValues();
        values.put("score",score);
        db.update(SimpleScore, values, "level" + " = ?", new String[]{String.valueOf(level)});
    }

}
