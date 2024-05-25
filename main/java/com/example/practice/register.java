package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {

    EditText name,email,password;
    Button registerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.etRegName);
        email = findViewById(R.id.etRegEmail);
        password = findViewById(R.id.etRegPassword);
        registerButton = findViewById(R.id.btnRegister);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String regName = name.getText().toString();
                String regEmail = email.getText().toString();
                String regPassword = password.getText().toString();

                if(regName.isEmpty() || regEmail.isEmpty() || regPassword.isEmpty())
                {
                    Toast.makeText(register.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(register.this,Login.class);
                    intent.putExtra("name",regName);
                    intent.putExtra("email",regEmail);
                    intent.putExtra("password",regPassword);
                    startActivity(intent);
                }
            }
        });
    }
}