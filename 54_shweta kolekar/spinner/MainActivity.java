package com.example.spinnerapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    Button btnShow;

    String[] courses = {
            "Java Programming ☕",
            "Python 🐍",
            "C++ ⚙️",
            "Android Development 📱",
            "Web Development 🌐"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        btnShow = findViewById(R.id.btnShow);

        // Adapter for spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                courses
        );

        spinner.setAdapter(adapter);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selected = spinner.getSelectedItem().toString();
                Toast.makeText(MainActivity.this,
                        "Selected: " + selected,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}