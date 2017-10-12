package com.volianskyi.taras.a71017_database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvName;
    private TextView tvPass;
    private EditText etName;
    private EditText etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        initViews();
    }

    private void initViews() {
        long numberOfChosedItem = getIntent().getLongExtra("NumberOfChosedItem", 0);
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnUpdateListMainActivity:
                tvName.setText(etName.getText().toString());
                tvPass.setText(etPass.getText().toString());
                break;
            case R.id.btnDeleteThirdActivity:

                break;
        }
    }
}
