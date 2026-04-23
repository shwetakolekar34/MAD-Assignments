package com.example.ratingbarapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RatingBar ratingBar;
    TextView txtRating;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar = findViewById(R.id.ratingBar);
        txtRating = findViewById(R.id.txtRating);
        btnSubmit = findViewById(R.id.btnSubmit);

        // Live rating update
        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            txtRating.setText("Rating: " + rating);
        });

        // Submit button
        btnSubmit.setOnClickListener(v -> {
            float rating = ratingBar.getRating();

            if (rating == 0) {
                Toast.makeText(this, "⚠️ Please give rating", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this,
                        "⭐ Thank you! Rating: " + rating,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}