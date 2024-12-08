package com.example.pharmaease;


import android.util.Patterns;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.regex.Pattern;

public class Login_Activity extends AppCompatActivity {
    EditText emailInput, passwordInput;
    Button submitButton;
    TextView create_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // all code must be writtend after the above codes thus the layout activity is loaded

        emailInput = findViewById(R.id.email_input);
        passwordInput = findViewById(R.id.password_input);
        submitButton = findViewById(R.id.submit_button);
        create_account = findViewById(R.id.create_account);

       submitButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String email = emailInput.getText().toString().trim();  //.trim() cuts the spaces in the string
               String password = passwordInput.getText().toString().trim();

               if (validateEmail(email) && validatePassword(password)) {
                   Toast.makeText(Login_Activity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                   // Proceed with Firebase Authentication or further actions
               }


           }
       });


     // Create account functionalities
        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_Activity.this, Sign_Up_Activity.class);
                startActivity(intent);
            }
        });


    }
    private boolean validatePassword(String password) {
        // Regex for password validation
        String passwordPattern = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

        if (TextUtils.isEmpty(password)) {
            passwordInput.setError("Password cannot be empty");
            return false;
        } else if (!Pattern.compile(passwordPattern).matcher(password).matches()) {
            passwordInput.setError("Password must contain:\n 8+ characters\n 1 digit, uppercase, lowercase\n 1 special character");
            return false;
        }
        return true;
    }
    private boolean validateEmail(String email){
        if(TextUtils.isEmpty(email)){
            emailInput.setError("Email cannot be empty");
            return false;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailInput.setError("Invalid Email Format");
            return false;
        }
        return true;

    }


}