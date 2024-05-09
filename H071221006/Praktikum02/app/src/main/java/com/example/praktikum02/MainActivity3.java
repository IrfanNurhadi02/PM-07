package com.example.praktikum02;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    ImageView imageView;
    TextView nameTextView, usernameTextView, titleTextView, contentTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // Inisialisasi view
        imageView = findViewById(R.id.imageUser);
        nameTextView = findViewById(R.id.name);
        usernameTextView = findViewById(R.id.username);
        titleTextView = findViewById(R.id.title);
        contentTextView = findViewById(R.id.content);

        // Mendapatkan data dari Intent
        Intent intent = getIntent();
        if (intent != null) {
            // Mendapatkan data string dari Intent
            String nama = intent.getStringExtra("nama");
            String username = intent.getStringExtra("username");
            String title = intent.getStringExtra("title");
            String content = intent.getStringExtra("content");

            // Mengatur data string ke TextView
            nameTextView.setText(nama);
            usernameTextView.setText(username);
            titleTextView.setText(title);
            contentTextView.setText(content);

            // Mendapatkan data Uri dari Intent
            Uri imageUri = Uri.parse(intent.getStringExtra("imageUri"));
            if (imageUri != null) {
                imageView.setImageURI(imageUri);
            }
        }
    }
}
