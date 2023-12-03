//https://youtu.be/UnD525Fa6eM
package com.example.myshows;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button botao_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao_login = findViewById(R.id.btn_fazer_login);
        botao_login.setOnClickListener(view -> {
            Intent ii = new Intent(getApplicationContext(), Login.class);
            startActivity(ii);
        });
    }
}