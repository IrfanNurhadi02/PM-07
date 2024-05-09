package com.example.praktikum02;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    Button buttonPindah;
    ImageView buttonImage;
    Uri imageProfile;
    EditText namaEdit, usernameEdit;

    private ActivityResultLauncher<Intent> galleryIntent; //ambil gambar dari galeri

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPindah = findViewById(R.id.button1);
        buttonImage = findViewById(R.id.imageView);
        namaEdit = findViewById(R.id.nama);
        usernameEdit = findViewById(R.id.username);

        buttonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                galleryIntent.launch(toGallery);
            }
        });

        buttonPindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = namaEdit.getText().toString().trim();
                String username = usernameEdit.getText().toString().trim();

                if (imageProfile == null) {
                    Toast.makeText(MainActivity.this, "Please pick a profile image first!", Toast.LENGTH_SHORT).show();
                    return;
                } else if (nama.isEmpty()) {
                    namaEdit.setError("Nama harus diisi");
                    return;
                } else if (username.isEmpty()) {
                    usernameEdit.setError("Username harus diisi");
                    return;
                }

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("imageUri", imageProfile.toString());
                intent.putExtra("nama", nama);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

        galleryIntent = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                        imageProfile = result.getData().getData();
                        Glide.with(this).load(imageProfile).into(buttonImage); //memuat gambar
                    }
                });
    }
}
