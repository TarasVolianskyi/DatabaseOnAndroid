package com.volianskyi.taras.a71017_database;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private SQLiteDatabase sqLiteDatabase;
    // private ListView listView;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv = (TextView) findViewById(R.id.tvHelloTextSecondActivity);
        //onStart();
    }

    @Override
    protected void onStart() {
        super.onStart();
        DBHelper dbHelper = new DBHelper(this, 1);
        sqLiteDatabase = dbHelper.getWritableDatabase();//read & write to db
        //listView = (ListView) findViewById(R.id.lvAllInfoSecondActivity);
        initListView();
    }

    private void initListView() {
        ListView listView = (ListView) findViewById(R.id.lvAllInfoSecondActivity);
        Cursor cursorList = sqLiteDatabase.query("USERS", null, null, null, null, null, null);
        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursorList, new String[]{"NAME"}, new int[]{android.R.id.text1}, Adapter.NO_SELECTION);
        listView.setAdapter(simpleCursorAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SecondActivity.this, "You click here - ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                intent.putExtra("NumberOfChosedItem", view.getTag()+"");
                startActivity(intent);
            }
        });


    }


}
