package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    private TextView tvProfileName, tvProfileEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvProfileName = findViewById(R.id.tvProfileName);
        tvProfileEmail = findViewById(R.id.tvProfileEmail);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");

        tvProfileName.setText("Name: " + name);
        tvProfileEmail.setText("Email: " + email);
    }
}