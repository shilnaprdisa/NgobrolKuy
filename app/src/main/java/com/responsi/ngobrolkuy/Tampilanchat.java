package com.responsi.ngobrolkuy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Tampilanchat extends AppCompatActivity {
    private ImageView settingicon;
    private LinearLayout bubblechat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tampilanchat);
        bubblechat = findViewById(R.id.firstchat);
        settingicon = findViewById(R.id.setting);

        settingicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tampilanchat.this, SettingActivity.class);
                startActivity(intent);
            }
        });

        bubblechat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tampilanchat.this, RoomChat.class);
                startActivity(intent);
            }
        });
        /*for (int i = 1; i <= 7; i++) {
            int id = getResources().getIdentifier("chat" + Integer.toString(i), "id", "com.responsi.ngobrolkuy");
            View view = findViewById(id);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(HomechatActivity.this, ChatPersonalActivity.class);
                    startActivity(intent);
                }
            });
        }*/
        /*keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomechatActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });*/
    }
}
