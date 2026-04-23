package com.example.framelayoutapp;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView frame1, frame2, frame3, frame4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link XML IDs
        frame1 = findViewById(R.id.frame1);
        frame2 = findViewById(R.id.frame2);
        frame3 = findViewById(R.id.frame3);
        frame4 = findViewById(R.id.frame4);

        // Click Events
        frame1.setOnClickListener(v ->
                Toast.makeText(this, "Frame 1 Clicked", Toast.LENGTH_SHORT).show()
        );

        frame2.setOnClickListener(v ->
                Toast.makeText(this, "Frame 2 Clicked", Toast.LENGTH_SHORT).show()
        );

        frame3.setOnClickListener(v ->
                Toast.makeText(this, "Frame 3 Clicked", Toast.LENGTH_SHORT).show()
        );

        frame4.setOnClickListener(v ->
                Toast.makeText(this, "Frame 4 Clicked", Toast.LENGTH_SHORT).show()
        );
    }
}