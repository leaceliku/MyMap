package com.example.pcadministrator.mymap;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DataActivity extends AppCompatActivity {
    public TextView table_db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        table_db=(TextView)findViewById(R.id.text_db);
        DatabaseHelper c = new DatabaseHelper(getApplicationContext());
        table_db.setText(c.viewAll());
    }
}
