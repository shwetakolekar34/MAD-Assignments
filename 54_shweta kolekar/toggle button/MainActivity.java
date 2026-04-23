package com.example.toggleapp;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggleButton;
    TextView txtStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = findViewById(R.id.toggleButton);
        txtStatus = findViewById(R.id.txtStatus);

        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if (isChecked) {
                txtStatus.setText("Status: ON 🔥");
            } else {
                txtStatus.setText("Status: OFF ❌");
            }

        });
    }
}