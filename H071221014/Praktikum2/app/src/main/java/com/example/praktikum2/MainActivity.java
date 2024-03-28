package com.example.praktikum2;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edName,edUsername;
    ImageView imageView;

    Uri image;

    Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edName = findViewById(R.id.name);
        edUsername = findViewById(R.id.username);
        imageView = findViewById(R.id.image);
        buttonNext = findViewById(R.id.btnNext1);

        ActivityResultLauncher<Intent> launcherIntentGallery = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        image = data.getData();
                        imageView.setImageURI(image);
                    }
                }
        );

        imageView.setOnClickListener(view -> {
            Intent openGallery = new Intent(Intent.ACTION_PICK);
            openGallery.setType("image/*");
            launcherIntentGallery.launch(openGallery);
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edName.getText().toString();
                String username = edUsername.getText().toString();

                if(!name.isEmpty() && !username.isEmpty()) {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("name", name);
                    intent.putExtra("username", username);

                    if (image != null) {
                        intent.putExtra("image", image.toString());
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Harap mengisi gambar", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Harap mengisi name atau username", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}