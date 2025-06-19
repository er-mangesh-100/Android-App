package com.example.userregistration;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TableLayout tableLayout;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tableLayout = findViewById(R.id.tableLayout);
        dbHelper = new DBHelper(this);

        // Get the intent that started this activity
        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("USER_NAME");
            String email = intent.getStringExtra("USER_EMAIL");
            String dob = intent.getStringExtra("USER_DOB");

            // Add data to the table
            addTableRow(name, dob, email);

            // Save data to the database
            dbHelper.addUser(name, email, dob);
        }
    }
    private void addTableRow(String name, String dob, String email) {
        TableRow tableRow = new TableRow(this);

        TextView textName = new TextView(this);
        textName.setText(name);
        textName.setPadding(12, 12, 12, 12);
        textName.setGravity(android.view.Gravity.CENTER);

        TextView textDob = new TextView(this);
        textDob.setText(dob);
        textDob.setPadding(12, 12, 12, 12);
        textDob.setGravity(android.view.Gravity.CENTER);

        TextView textEmail = new TextView(this);
        textEmail.setText(email);
        textEmail.setPadding(12, 12, 12, 12);
        textEmail.setGravity(android.view.Gravity.CENTER);

        tableRow.addView(textName);
        tableRow.addView(textDob);
        tableRow.addView(textEmail);

        tableLayout.addView(tableRow);
    }
}

