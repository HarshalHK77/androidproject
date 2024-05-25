package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText logEmail,logPassword;
    Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logEmail = findViewById(R.id.etLogEmail);
        logPassword = findViewById(R.id.etLogPassword);
        loginButton = findViewById(R.id.btnLogin);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = logEmail.getText().toString();
                String password = logPassword.getText().toString();

                Intent intent = getIntent();
                String regName = intent.getStringExtra("name");
                String regEmail = intent.getStringExtra("email");
                String regPassword = intent.getStringExtra("password");

                if(email.isEmpty() || password.isEmpty())
                {
                    Toast.makeText(Login.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else if(email.equals(regEmail) && password.equals(regPassword))
                {
                    Intent profileIntent = new Intent(Login.this,Profile.class);
                    profileIntent.putExtra("name",regName);
                    profileIntent.putExtra("email",regEmail);
                    profileIntent.putExtra("password",regPassword);
                    startActivity(profileIntent);
                }
                else
                {
                    Toast.makeText(Login.this, "Email or password is Invalid!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}