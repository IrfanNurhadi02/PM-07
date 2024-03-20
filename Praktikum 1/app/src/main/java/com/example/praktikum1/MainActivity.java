package com.example.praktikum1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    TextView textViewDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        textViewDisplay = findViewById(R.id.textViewDisplay);
    }

    public void onOkButtonClick(View view) {
        String inputText = editTextName.getText().toString();
        textViewDisplay.append(inputText + "\n");
        editTextName.setText("");
    }
}
