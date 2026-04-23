package com.example.popupmenuapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMenu = findViewById(R.id.btnMenu);

        btnMenu.setOnClickListener(this::showPopupMenu);
    }

    private void showPopupMenu(View view) {

        PopupMenu popupMenu = new PopupMenu(this, view);

        // Attach menu
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        // Force icons to show (important trick)
        try {
            java.lang.reflect.Field[] fields = popupMenu.getClass().getDeclaredFields();
            for (java.lang.reflect.Field field : fields) {
                if ("mPopup".equals(field.getName())) {
                    field.setAccessible(true);
                    Object menuPopupHelper = field.get(popupMenu);
                    java.lang.reflect.Method setForceIcons =
                            menuPopupHelper.getClass().getMethod("setForceShowIcon", boolean.class);
                    setForceIcons.invoke(menuPopupHelper, true);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Click handling
        popupMenu.setOnMenuItemClickListener(item -> {

            if (item.getItemId() == R.id.edit) {
                Toast.makeText(this, "✨ Edit Selected", Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.delete) {
                Toast.makeText(this, "🗑 Delete Selected", Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.settings) {
                Toast.makeText(this, "⚙️ Settings Opened", Toast.LENGTH_SHORT).show();
            }

            return true;
        });

        popupMenu.show();
    }
}