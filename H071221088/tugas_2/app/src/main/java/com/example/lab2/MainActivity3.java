package com.example.lab2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String username = intent.getStringExtra("username");
        String imageUri = intent.getStringExtra("imageUri");
        String judul = intent.getStringExtra("judul");
        String deskripsi = intent.getStringExtra("deskripsi");

        TextView textViewNama = findViewById(R.id.Nama);
        textViewNama.setText(name);

        TextView textViewUser = findViewById(R.id.user);
        textViewUser.setText(username);

        ImageView imageViewProfil = findViewById(R.id.profil);
        imageViewProfil.setImageURI(Uri.parse(imageUri));

        TextView textViewJudul = findViewById(R.id.Judul);
        textViewJudul.setText(judul);

        TextView textViewDeskripsi = findViewById(R.id.desk);
        textViewDeskripsi.setText(deskripsi);
    }
}
