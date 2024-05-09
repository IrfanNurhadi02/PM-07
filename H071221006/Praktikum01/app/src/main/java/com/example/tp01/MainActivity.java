package com.example.tp01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils; // Import TextUtils
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText inputText = findViewById(R.id.lainnya);
        Button buttonOK = findViewById(R.id.button1);
        final LinearLayout linearLayout = findViewById(R.id.listinputan);

        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newText = inputText.getText().toString().trim();

                if (!newText.isEmpty()) {
                    TextView textView = new TextView(MainActivity.this);
                    textView.setLayoutParams(new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    ));
                    textView.setText(newText);
                    textView.setTextSize(20);
                    textView.setTypeface(null, Typeface.BOLD);

                    linearLayout.addView(textView);
                    inputText.getText().clear();
                }
            }
        });
    }
}

