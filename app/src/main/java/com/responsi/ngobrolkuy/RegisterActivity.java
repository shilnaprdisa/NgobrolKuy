package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
    private TextView btnRegister, btnSudahPunya;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnRegister = findViewById(R.id.registerBtn);
        btnSudahPunya = findViewById(R.id.sudahPunyaAkun);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent (RegisterActivity.this, Tampilanchat.class);
                startActivity(pindah);
            }
        });
        btnSudahPunya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent (RegisterActivity.this, LoginActivity.class);
                startActivity(intent2);
            }
        });
    }
}