package com.example.imageratingapp;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RatingBar ratingBar;
    TextView ratingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar = findViewById(R.id.ratingBar);
        ratingText = findViewById(R.id.ratingText);

        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {

            String message = "Your Rating: " + rating;
            ratingText.setText(message);

            if (rating == 5) {
                Toast.makeText(this, "Excellent 😍", Toast.LENGTH_SHORT).show();
            } else if (rating >= 3) {
                Toast.makeText(this, "Good 👍", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Try Again 😅", Toast.LENGTH_SHORT).show();
            }
        });
    }
}