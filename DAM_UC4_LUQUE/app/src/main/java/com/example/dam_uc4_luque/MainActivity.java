package com.example.dam_uc4_luque;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;   // Faltaba importar esta clase
import android.view.View;       // Faltaba importar esta clase
import android.widget.Button; // Faltaba importar esta clase


public class MainActivity extends AppCompatActivity {
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Definir el evento click sobre el botón Login
        btnLogin = findViewById(R.id.buttonLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, NotasActivity.class);
                startActivity(i);
            }

        });

    }
}