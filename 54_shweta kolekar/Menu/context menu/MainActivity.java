package com.example.contextmenuapp;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> items;
    int selectedPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        // Sample data
        items = new ArrayList<>();
        items.add("Android Development");
        items.add("Java Programming");
        items.add("Kotlin Basics");
        items.add("XML Layout Design");
        items.add("SQLite Database");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                items
        );

        listView.setAdapter(adapter);

        // Register context menu
        registerForContextMenu(listView);

        // Get selected item position
        listView.setOnItemClickListener((adapterView, view, i, l) ->
                Toast.makeText(this, "Long press for options", Toast.LENGTH_SHORT).show()
        );
    }

    // Create Context Menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.context_menu, menu);

        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) menuInfo;

        selectedPosition = info.position;
    }

    // Handle menu click
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        String selectedItem = items.get(selectedPosition);

        if (item.getItemId() == R.id.edit) {
            Toast.makeText(this, "Edit: " + selectedItem, Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.delete) {
            Toast.makeText(this, "Delete: " + selectedItem, Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.details) {
            Toast.makeText(this, "Details of: " + selectedItem, Toast.LENGTH_SHORT).show();
        }

        return super.onContextItemSelected(item);
    }
}