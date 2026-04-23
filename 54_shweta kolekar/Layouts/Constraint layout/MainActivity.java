package com.example.constraintlayoutapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button topBtn, bottomBtn, centerBtn, leftBtn, rightBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topBtn = findViewById(R.id.topBtn);
        bottomBtn = findViewById(R.id.bottomBtn);
        centerBtn = findViewById(R.id.centerBtn);
        leftBtn = findViewById(R.id.leftBtn);
        rightBtn = findViewById(R.id.rightBtn);

        topBtn.setOnClickListener(v ->
                Toast.makeText(this, "Top Button Clicked", Toast.LENGTH_SHORT).show()
        );

        bottomBtn.setOnClickListener(v ->
                Toast.makeText(this, "Bottom Button Clicked", Toast.LENGTH_SHORT).show()
        );

        centerBtn.setOnClickListener(v ->
                Toast.makeText(this, "Center Button Clicked", Toast.LENGTH_SHORT).show()
        );

        leftBtn.setOnClickListener(v ->
                Toast.makeText(this, "Left Button Clicked", Toast.LENGTH_SHORT).show()
        );

        rightBtn.setOnClickListener(v ->
                Toast.makeText(this, "Right Button Clicked", Toast.LENGTH_SHORT).show()
        );
    }
}