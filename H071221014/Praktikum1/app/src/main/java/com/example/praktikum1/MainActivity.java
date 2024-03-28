package com.example.praktikum1;


import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textViewList;
    List<String> itemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = findViewById(R.id.editText);
        textViewList = findViewById(R.id.textViewList);

    }

    public void tambah(View view) {

        String newItem = editText.getText().toString().trim();

        if (!newItem.isEmpty()) {
            itemList.add(newItem);
            updateTextView();
            editText.setText("");
        }
    }

    private void updateTextView() {
        StringBuilder stringBuilder = new StringBuilder();

        for (String item : itemList) {
            stringBuilder.append(" ").append(item).append("\n");
        }

        textViewList.setText(stringBuilder.toString());
    }
}