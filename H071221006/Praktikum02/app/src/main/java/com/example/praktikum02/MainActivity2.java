package com.example.praktikum02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    EditText titleEditText, contentEditText;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        titleEditText = findViewById(R.id.title);
        contentEditText = findViewById(R.id.content);
        saveButton = findViewById(R.id.button2);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleEditText.getText().toString().trim();
                String content = contentEditText.getText().toString().trim();

                // Mendapatkan data dari Intent
                Intent intent = getIntent();
                if (intent != null) {
                    // Meneruskan data ke MainActivity3
                    Intent intent3 = new Intent(MainActivity2.this, MainActivity3.class);
                    intent3.putExtras(intent);
                    intent3.putExtra("title", title);
                    intent3.putExtra("content", content);
                    startActivity(intent3);
                }
            }
        });
    }
}
