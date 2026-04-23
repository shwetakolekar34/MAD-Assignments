package com.example.internalstorageapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText etNote;
    Button btnSave, btnLoad, btnDelete;

    String filename = "mynote.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNote = findViewById(R.id.etNote);
        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);
        btnDelete = findViewById(R.id.btnDelete);

        // SAVE DATA
        btnSave.setOnClickListener(v -> {
            String data = etNote.getText().toString();

            try {
                FileOutputStream fos = openFileOutput(filename, MODE_PRIVATE);
                fos.write(data.getBytes());
                fos.close();

                Toast.makeText(this, "✅ Note Saved", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // LOAD DATA
        btnLoad.setOnClickListener(v -> {
            try {
                FileInputStream fis = openFileInput(filename);
                int c;
                StringBuilder temp = new StringBuilder();

                while ((c = fis.read()) != -1) {
                    temp.append((char) c);
                }

                etNote.setText(temp.toString());
                Toast.makeText(this, "📂 Note Loaded", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                Toast.makeText(this, "⚠️ No Saved Note Found", Toast.LENGTH_SHORT).show();
            }
        });

        // DELETE DATA
        btnDelete.setOnClickListener(v -> {
            deleteFile(filename);
            etNote.setText("");
            Toast.makeText(this, "🗑 Note Deleted", Toast.LENGTH_SHORT).show();
        });
    }
}