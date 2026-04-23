package com.example.backgroundcolorapp;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    LinearLayout mainLayout;
    Button btnChangeColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.mainLayout);
        btnChangeColor = findViewById(R.id.btnChangeColor);

        btnChangeColor.setOnClickListener(v -> {

            // Change background color randomly
            int red = (int)(Math.random() * 255);
            int green = (int)(Math.random() * 255);
            int blue = (int)(Math.random() * 255);

            mainLayout.setBackgroundColor(Color.rgb(red, green, blue));
        });
    }
}