package com.example.lab2;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityResultLauncher<Intent> openGallery;
    private ImageView imageView;
    private EditText editTextName, editTextUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.gambar);
        editTextName = findViewById(R.id.name);
        editTextUsername = findViewById(R.id.username);

        Button btnSubmit = findViewById(R.id.submit);
        btnSubmit.setOnClickListener(this);

        ImageView btnGambar = findViewById(R.id.gambar);
        btnGambar.setOnClickListener(this);

        openGallery = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
           if (result.getResultCode() == RESULT_OK && result.getData() != null) {
               Intent data = result.getData();
               Uri imageUri = data.getData();
               imageView.setImageURI(imageUri);
               imageView.setTag(imageUri.toString());
          }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.submit) {
            String name = editTextName.getText().toString().trim();
            String username = editTextUsername.getText().toString().trim();
            String imageUri = "";
            if (imageView.getTag() != null) {
                imageUri = imageView.getTag().toString();
            }

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("name", name);
            intent.putExtra("username", username);
            intent.putExtra("imageUri", imageUri);

            startActivity(intent);
        } else if (v.getId() == R.id.gambar) {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            openGallery.launch(Intent.createChooser(intent, "Pilih gambar"));
        }
    }
}
