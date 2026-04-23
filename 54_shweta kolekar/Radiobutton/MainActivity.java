package com.example.radiobuttonapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton rbJava, rbPython, rbCpp;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        rbJava = findViewById(R.id.rbJava);
        rbPython = findViewById(R.id.rbPython);
        rbCpp = findViewById(R.id.rbCpp);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(view -> {

            int selectedId = radioGroup.getCheckedRadioButtonId();

            if (selectedId == -1) {
                Toast.makeText(this, "⚠️ Please select an option", Toast.LENGTH_SHORT).show();
            } else {
                RadioButton selectedRadioButton = findViewById(selectedId);
                String value = selectedRadioButton.getText().toString();

                Toast.makeText(this, "Selected: " + value, Toast.LENGTH_SHORT).show();
            }
        });
    }
}