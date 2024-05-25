package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DisplayData extends AppCompatActivity {

    TextView name , surname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);

        name = findViewById(R.id.name1);
        surname = findViewById(R.id.surname2);

        String nameintent = getIntent().getStringExtra("keyname");
        String surnameIntent = getIntent().getStringExtra("keysurname");

        name.setText(nameintent);
        surname.setText(surnameIntent);
    }
}