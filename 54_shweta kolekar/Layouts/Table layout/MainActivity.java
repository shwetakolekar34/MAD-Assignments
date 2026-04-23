package com.example.tablelayoutapp;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText name, age, branch;
    Button button;
    TableLayout table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        branch = findViewById(R.id.branch);
        button = findViewById(R.id.button);
        table = findViewById(R.id.table);

        button.setOnClickListener(v -> {

            String n = name.getText().toString();
            String a = age.getText().toString();
            String b = branch.getText().toString();

            // Create new row
            TableRow row = new TableRow(this);

            TextView t1 = new TextView(this);
            TextView t2 = new TextView(this);
            TextView t3 = new TextView(this);

            t1.setText(n);
            t2.setText(a);
            t3.setText(b);

            t1.setPadding(10,10,10,10);
            t2.setPadding(10,10,10,10);
            t3.setPadding(10,10,10,10);

            t1.setGravity(Gravity.CENTER);
            t2.setGravity(Gravity.CENTER);
            t3.setGravity(Gravity.CENTER);

            row.addView(t1);
            row.addView(t2);
            row.addView(t3);

            table.addView(row);

            // Clear fields
            name.setText("");
            age.setText("");
            branch.setText("");
        });
    }
}