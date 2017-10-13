package com.volianskyi.taras.a71017_database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvName;
    private TextView tvPass;
    private EditText etName;
    private EditText etPass;
    private SQLiteDatabase sqLiteDatabase;
    private long numberOfChosedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        initViews();
    }

    private void initViews() {
        numberOfChosedItem = getIntent().getLongExtra("NumberOfChosedItem", 0);
        TextView tvID = (TextView) findViewById(R.id.tvIDThirdActivity);
        tvName = (TextView) findViewById(R.id.tvNameThirdActivity);
        tvPass = (TextView) findViewById(R.id.tvPassThirdActivity);
        etName = (EditText) findViewById(R.id.etNameThirdActivity);
        etPass = (EditText) findViewById(R.id.etPassThirdActivity);
        Button btnUpdate = (Button) findViewById(R.id.btnUpdateThirdActivity);
        Button btnDelete = (Button) findViewById(R.id.btnDeleteThirdActivity);
        tvID.setText("ID - " + numberOfChosedItem);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }

    private void showDataFromItem() {
        Cursor cursor = sqLiteDatabase.query("USERS", null, null, null, null, null, null);
        //  String size = "Cursor size is - " + cursor.getCount();
        int idOfNumber = (int) numberOfChosedItem;
        cursor.moveToPosition(idOfNumber);
        int id = cursor.getInt(cursor.getColumnIndex("_id"));
        String name = cursor.getString(cursor.getColumnIndex("NAME"));
        String pass = cursor.getString(cursor.getColumnIndex("PASS"));
        String allInfo = "ID is - " + id + " Name is - " + name + " Pass is - " + pass + " Size = ";
        tvName.setText(allInfo);
        tvPass.setText(pass);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnUpdateThirdActivity:
                tvName.setText(etName.getText().toString());
                tvPass.setText(etPass.getText().toString());
                ContentValues cv = new ContentValues();
                cv.put("NAME", etName.getText().toString());
                cv.put("PASS", etPass.getText().toString());
                sqLiteDatabase.update("USERS", cv, "_id =?", new String[]{"" + numberOfChosedItem});
                Toast.makeText(this, "Click update ", Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.btnDeleteThirdActivity:
                sqLiteDatabase.delete("USERS", "_id =?", new String[]{"" + numberOfChosedItem});
                Toast.makeText(this, "Click delete", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        DBHelper dbHelper = new DBHelper(this, 1);
        sqLiteDatabase = dbHelper.getWritableDatabase();
        showDataFromItem();
    }
}
