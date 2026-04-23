package com.example.relativelayoutapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText name, email;
    Button button;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        button = findViewById(R.id.button);
        result = findViewById(R.id.result);

        button.setOnClickListener(v -> {
            String n = name.getText().toString();
            String e = email.getText().toString();

            result.setText("Name: " + n + "\nEmail: " + e);
        });
    }
}