package com.example.pharmaease;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

Button start_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start_button = findViewById(R.id.start_button);
     start_button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             //Toast.makeText(MainActivity.this, "Button Clicked", Toast.LENGTH_SHORT).show();
             Intent intent = new Intent(MainActivity.this, Login_Activity.class);
             startActivity(intent);
         }
     });

    }
}