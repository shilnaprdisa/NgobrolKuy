package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private TextView login_button;
    private TextView forgetpass;
    private TextView register_button;
    private EditText et_username, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_button = findViewById(R.id.loginButton);
        et_username = findViewById(R.id.inputUsername);
        et_password = findViewById(R.id.inputPass);
        forgetpass= findViewById(R.id.lupaPass);
        register_button = findViewById(R.id.regButton);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                Intent pindah = new Intent(LoginActivity.this, Tampilanchat.class);
                pindah.putExtra("username", username);
                pindah.putExtra("password", password);
                startActivity(pindah);
            }
        });

        forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(LoginActivity.this, Recoverpass.class);
                startActivity(pindah);
            }
        });

        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(pindah);
            }
        });
    }
}