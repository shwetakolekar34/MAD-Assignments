package com.example.menudemo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMessage = findViewById(R.id.txtMessage);

        // Register context menu
        registerForContextMenu(txtMessage);
    }

    // ---------------- OPTIONS MENU ----------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu_settings) {
            Toast.makeText(this, "Settings Opened", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.menu_about) {
            Toast.makeText(this, "Menu Demo App v1.0", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.menu_exit) {
            finish();
        }

        return true;
    }

    // ---------------- CONTEXT MENU ----------------
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Choose Action");
        menu.add(0, 1, 0, "Change Color 🔵");
        menu.add(0, 2, 1, "Change Color 🔴");
        menu.add(0, 3, 2, "Reset Color");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getItemId() == 1) {
            txtMessage.setBackgroundColor(Color.BLUE);
        }
        else if (item.getItemId() == 2) {
            txtMessage.setBackgroundColor(Color.RED);
        }
        else if (item.getItemId() == 3) {
            txtMessage.setBackgroundColor(Color.parseColor("#4A90E2"));
        }

        return true;
    }
}