package com.responsi.ngobrolkuy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class SettingActivity extends AppCompatActivity {
    private TextView ubahDisplay;
    private TextView nama, email, password;
    private ImageView poto, back;
    private static final int GALLERY_REQUEST_CODE = 1;
    private static final String TAG = RegisterActivity.class.getCanonicalName();
    private Bitmap bitmap;
    private Uri imgUri = null;
    private boolean change_img = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        poto = findViewById(R.id.profpicsetting);
        back = findViewById(R.id.backtohomechat);
        ubahDisplay = findViewById(R.id.ubahBtn);
        nama = findViewById(R.id.usernametext);
        email = findViewById(R.id.emailtext);
        password = findViewById(R.id.passtext);
        String usname = getIntent().getExtras().getString("username");
        String pass = getIntent().getExtras().getString("password");



        nama.setText(usname);
        password.setText(pass);
        email.setText(usname +"@email.com");
        /*mundur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingActivity.this, HomeChatActivity.class);
                startActivity(intent);
            }
        });*/

        ubahDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI), GALLERY_REQUEST_CODE);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(SettingActivity.this, Tampilanchat.class);
                String image = imgUri.toString();
                pindah.putExtra("image", image);
                startActivity(pindah);
            }
        });

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED){
            Toast.makeText(this, "     Batal mengambil gambar     ", Toast.LENGTH_SHORT).show();
            return;
        } else {
            if (requestCode == GALLERY_REQUEST_CODE){
                if (data != null){
                    try {
                        change_img = true;
                        imgUri = data.getData();
                        bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),imgUri);
                        poto.setImageBitmap(bitmap);
                    } catch (IOException e) {
                        Toast.makeText(this, "     Gagal mengambil gambar     ", Toast.LENGTH_SHORT).show();
                        Log.e(TAG, e.getMessage());
                    }
                }
            }
        }
    }
}