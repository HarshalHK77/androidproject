package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button Send = findViewById(R.id.send);
        TextView name = findViewById(R.id.Name);
        TextView surname = findViewById(R.id.Surname);
        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameString = name.getText().toString();
                String surnameString = surname.getText().toString();

                Intent intent = new Intent(MainActivity2.this,DisplayData.class);
                intent.putExtra("keyname",nameString);
                intent.putExtra("keysurname",surnameString);
                startActivity(intent);
            }
        });
    }
}