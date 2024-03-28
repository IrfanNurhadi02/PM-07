package com.example.praktikum2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText edBio, edLink;

    Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edBio = findViewById(R.id.bio);
        edLink = findViewById(R.id.link);
        buttonSave = findViewById(R.id.btnNext2);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                String image = getIntent().getStringExtra("image");
                String input_name = getIntent().getStringExtra("name");
                String input_username = getIntent().getStringExtra("username");
                String input_bio = edBio.getText().toString();
                String input_link = edLink.getText().toString();

                if (!input_bio.isEmpty() && !input_link.isEmpty()) {
                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                    intent.putExtra("image", image);
                    intent.putExtra("name", input_name);
                    intent.putExtra("username", input_username);
                    intent.putExtra("bio", input_bio);
                    intent.putExtra("link", input_link);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity2.this, "Harap mengisi kedua kolom", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}