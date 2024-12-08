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

public class Sign_Up_Activity extends AppCompatActivity {

    TextView Login;
    EditText fullNameInput, emailInput, passwordInput, confirmPasswordInput;
    Button signUpButton;
    TextView loginText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        // Initialize UI components
        fullNameInput = findViewById(R.id.full_name);
        emailInput = findViewById(R.id.email_in_sign_up);
        passwordInput = findViewById(R.id.password_in_sign_up);
        confirmPasswordInput = findViewById(R.id.confirmpass_in_sign_up);
        signUpButton = findViewById(R.id.sign_up_button);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullName = fullNameInput.getText().toString().trim();
                String email = emailInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();
                String confirmPassword = confirmPasswordInput.getText().toString().trim();
                if (validateFullName(fullName) && validateEmail(email) && validatePassword(password, confirmPassword)) {
                    Toast.makeText(Sign_Up_Activity.this, "Sign-Up Successful!", Toast.LENGTH_SHORT).show();
                    // Proceed with further actions (e.g., Firebase Authentication)
                }
            }
        });

        Login = findViewById(R.id.login_text);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sign_Up_Activity.this, Login_Activity.class);
                startActivity(intent);
            }
        });


    }
    // Full Name Validation
    private boolean validateFullName(String fullName) {
        if (TextUtils.isEmpty(fullName)) {
            fullNameInput.setError("Full Name cannot be empty");
            return false;
        }
        return true;
    }

    // Email Validation
    private boolean validateEmail(String email) {
        if (TextUtils.isEmpty(email)) {
            emailInput.setError("Email cannot be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailInput.setError("Invalid Email Format");
            return false;
        }
        return true;
    }

    // Password and Confirm Password Validation
    private boolean validatePassword(String password, String confirmPassword) {
        String passwordPattern = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

        if (TextUtils.isEmpty(password)) {
            passwordInput.setError("Password cannot be empty");
            return false;
        } else if (!Pattern.compile(passwordPattern).matcher(password).matches()) {
            passwordInput.setError("Password must contain:\n- 8+ characters\n- 1 digit, uppercase, lowercase\n- 1 special character");
            return false;
        } else if (!password.equals(confirmPassword)) {
            confirmPasswordInput.setError("Passwords do not match");
            return false;
        }
        return true;
    }
}