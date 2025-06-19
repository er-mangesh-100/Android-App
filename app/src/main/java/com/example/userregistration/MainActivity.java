package com.example.userregistration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName, editTextEmail;
    private DatePicker datePicker;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize views
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        datePicker = findViewById(R.id.datePicker);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        // Set click listener for the submit button
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user input
                String name = editTextName.getText().toString();
                String email = editTextEmail.getText().toString();

                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth();
                int year = datePicker.getYear();
                String dob = (month + 1) + "/" + day + "/" + year;

                // Create an intent to start the second activity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                // Pass data to the second activity
                intent.putExtra("USER_NAME", name);
                intent.putExtra("USER_EMAIL", email);
                intent.putExtra("USER_DOB", dob);
                startActivity(intent);
            }
        });
    }
}
