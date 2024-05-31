package com.example.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button submitButton = findViewById(R.id.button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextJudul = findViewById(R.id.judul);
                String judul = editTextJudul.getText().toString();

                EditText editTextDeskripsi = findViewById(R.id.desk);
                String deskripsi = editTextDeskripsi.getText().toString();

                Intent intent1 = getIntent();
                String name = intent1.getStringExtra("name");
                String username = intent1.getStringExtra("username");
                String imageUri = intent1.getStringExtra("imageUri");

                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("imageUri", imageUri);
                intent.putExtra("name", name);
                intent.putExtra("username", username);
                intent.putExtra("judul", judul);
                intent.putExtra("deskripsi", deskripsi);

                startActivity(intent);
            }
        });
    }
}
