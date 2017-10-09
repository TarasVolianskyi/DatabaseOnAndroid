package com.volianskyi.taras.a71017_database;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private SQLiteDatabase sqLiteDatabase;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnRead = (Button) findViewById(R.id.btnReaderMainActivity);
        Button btnAdd = (Button) findViewById(R.id.btnAddMainActivity);
        Button btnUpdateList = (Button) findViewById(R.id.btnUpdateListMainActivity);
        btnRead.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnUpdateList.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        DBHelper dbHelper = new DBHelper(this, 1);
        sqLiteDatabase = dbHelper.getWritableDatabase();//read & write to db

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnReaderMainActivity:
                Cursor cursor = sqLiteDatabase.query("USERS", null, null, null, null, null, null);
                Log.d("Database", "Cursor size is - " + cursor.getCount());
                cursor.moveToFirst();
                do {
                    int id = cursor.getInt(cursor.getColumnIndex("_id"));
                    String name = cursor.getString(cursor.getColumnIndex("NAME"));
                    String pass = cursor.getString(cursor.getColumnIndex("PASS"));
                    Log.d("Database", "ID is - " + id + " Name is - " + name + " Pass is - " + pass);
                } while (cursor.moveToNext());
                break;
            case R.id.btnAddMainActivity:
                sqLiteDatabase.execSQL(String.format("INSERT INTO USERS (NAME, PASS) VALUES ('%s','%s')", "Roman", "qwerty"));
                break;
            case R.id.btnUpdateListMainActivity:
                Log.d("Database", "Cursor size is - " + 5);
                intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
                /*Cursor cursorList = sqLiteDatabase.query("USERS", null, null, null, null, null, null);
                SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursorList, new String[]{"NAME"}, new int[]{android.R.id.text1}, Adapter.NO_SELECTION);
                listView.setAdapter(simpleCursorAdapter);*/
                break;
        }

    }
}
