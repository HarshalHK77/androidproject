package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class sharedPreferences extends AppCompatActivity {

    TextView textCounter;
    Button add;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        textCounter = findViewById(R.id.counter);
        add = findViewById(R.id.addBtn);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                textCounter.setText(String.valueOf(counter));
            }
        });
        loadData();

    }
    public void saveData()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("savecounter",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("counter",counter);
        editor.apply();
    }
    public void loadData()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("savecounter",MODE_PRIVATE);
        counter = sharedPreferences.getInt("counter",MODE_PRIVATE);
        textCounter.setText(String.valueOf(counter));

    }

    @Override
    protected void onPause() {
        saveData();
        super.onPause();
    }
}