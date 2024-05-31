package com.example.praktikum2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    TextView tvName, tvUsername, tvBio, tvLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tvName = findViewById(R.id.textview_name);
        tvUsername = findViewById(R.id.textview_username);
        tvBio = findViewById(R.id.textview_bio);
        tvLink = findViewById(R.id.textview_link);

        tvName.setText(getIntent().getStringExtra("name"));
        tvUsername.setText(getIntent().getStringExtra("username"));
        tvBio.setText(getIntent().getStringExtra("bio"));
        tvLink.setText(getIntent().getStringExtra("link"));

        ImageView imageView = findViewById(R.id.imageview);
        String imageUriString = getIntent().getStringExtra("image");

        if (imageUriString != null) {
            Uri imageUri = Uri.parse(imageUriString);
            imageView.setImageURI(imageUri);
        }
    }

    public void back(View v) {
        Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
        startActivity(intent);
    }
}