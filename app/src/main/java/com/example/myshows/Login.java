package com.example.myshows;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    TextInputEditText editEmail, editSenha;
    Button buttonLogin;
    FirebaseAuth mAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        editEmail = findViewById(R.id.caixa_email);
        editSenha = findViewById(R.id.caixa_senha);
        buttonLogin = findViewById(R.id.btn_fazer_login);
        progressBar = findViewById(R.id.progressBar);

        buttonLogin.setOnClickListener(view -> {
            progressBar.setVisibility(View.VISIBLE);
            String email, senha;
            email = String.valueOf(editEmail.getText());
            senha = String.valueOf(editSenha.getText());

            if(TextUtils.isEmpty(email)){
                Toast.makeText(Login.this, "Insira um e-mail", Toast.LENGTH_SHORT).show();
                return;
            }
            if(TextUtils.isEmpty(senha)){
                Toast.makeText(Login.this, "Insira ums senha", Toast.LENGTH_SHORT).show();
                return;
            }

            mAuth.signInWithEmailAndPassword(email, senha)
                    .addOnCompleteListener(task -> {
                        progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Login bem sucedido!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), ListaSeriesActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(Login.this, "Falha ao realizar Login!",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
        });
    }
}