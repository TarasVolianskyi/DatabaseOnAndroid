package com.volianskyi.taras.a71017_database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class SecondActivity extends AppCompatActivity {

    private SQLiteDatabase sqLiteDatabase;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
       // listView = (ListView) findViewById(R.id.lvAllInfoSecondActivity);
        Cursor cursorList = sqLiteDatabase.query("USERS", null, null, null, null, null, null);
        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursorList, new String[]{"NAME"}, new int[]{android.R.id.text1}, Adapter.NO_SELECTION);
        listView.setAdapter(simpleCursorAdapter);
    }

    /*@Override
    protected void onStart() {
        super.onStart();
        DBHelper dbHelper = new DBHelper(this, 1);
        sqLiteDatabase = dbHelper.getWritableDatabase();//read & write to db

    }*/

}
