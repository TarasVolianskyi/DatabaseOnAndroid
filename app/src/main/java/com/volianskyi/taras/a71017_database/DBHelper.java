package com.volianskyi.taras.a71017_database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by tarasvolianskyi on 07.10.17.
 */

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(Context context,  int version) {
        super(context, "myDB", null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(String.format("CREATE TABLE USERS (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT ," +
                "PASS TEXT)"));//запу3скає команду в  SQL
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
