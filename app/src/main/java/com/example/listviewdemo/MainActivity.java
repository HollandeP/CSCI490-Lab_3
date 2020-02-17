package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView classSched;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toast setup
        Context context = getApplicationContext();
        String toastMsg = "Toast Initiated";
        final Toast toast = Toast.makeText(context, toastMsg, Toast.LENGTH_SHORT);


        classSched = findViewById(R.id.class_schedule);
        String[] classes = {"CSCI 310", "CSCI 370","CSCI 230","CSCI 345","CSCI 380"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, classes);
        classSched.setAdapter(adapter);

        classSched.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                toast.setText("You tapped " + parent.getItemAtPosition(position).toString());
                toast.show();
            }
        });

        classSched.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                toast.setText("You held " + parent.getItemAtPosition(position).toString());
                toast.show();
                return true;
            }
        });
    }
}
