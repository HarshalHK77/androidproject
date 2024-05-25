package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class registrationForm extends AppCompatActivity {

    private EditText etName, etEmail, etPassword;
    private RadioGroup rgGender;
    private RadioButton rbMale, rbFemale, rbOther;
    private Button btnRegister;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        rgGender = findViewById(R.id.rgGender);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        rbOther = findViewById(R.id.rbOther);
        btnRegister = findViewById(R.id.btnRegister);
        tvResult = findViewById(R.id.tvResult);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                handleRegistration();
            }
        });
    }

    private void handleRegistration() {
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        int selectedGenderId = rgGender.getCheckedRadioButtonId();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || selectedGenderId == -1) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
        } else {
            RadioButton selectedGender = findViewById(selectedGenderId);
            String gender = selectedGender.getText().toString();

            String result = "Name: " + name + "\nEmail: " + email + "\nPassword: " + password + "\nGender: " + gender;
            tvResult.setText(result);
        }
    }
}