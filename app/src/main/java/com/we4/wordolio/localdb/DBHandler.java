package com.we4.wordolio.localdb;

import android.content.Context;

/**
 * Created by Ajay on 30-04-2017.
 */

public class DBHandler {
    private static LocalDB db = null;

    public static LocalDB getLocalDBInstance() {
        return db;
    }

    public static LocalDB getLocalDBInstance(Context context) {
        if (db == null)
            db = LocalDB.getInstance();
        return db;
    }
}
