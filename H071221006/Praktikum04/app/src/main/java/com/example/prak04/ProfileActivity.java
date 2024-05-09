package com.example.prak04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        // Mengambil data ekstra dari intent
        if (intent != null) {
            String username = intent.getStringExtra("username");
            String name = intent.getStringExtra("name");
            int profileImageId = intent.getIntExtra("profileImage", 0); // ID gambar profil

            // Mengatur TextView dengan data yang diterima
            TextView tvUsername = findViewById(R.id.tv_username);
            TextView tvName = findViewById(R.id.tv_name);
            ImageView ivProfile = findViewById(R.id.iv_profile); // ImageView untuk gambar profil

            tvUsername.setText(username);
            tvName.setText(name);
            ivProfile.setImageResource(profileImageId); // Mengatur gambar profil
        }
    }


}