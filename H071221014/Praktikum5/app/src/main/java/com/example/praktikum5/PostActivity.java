package com.example.praktikum5;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PostActivity extends AppCompatActivity {
    private ImageView iv_profile;
    private TextView tv_userProfile;
    private ImageView iv_post;
    private TextView tv_userProfile2;
    private TextView tv_caption;

    private boolean isFavorite = false;
    private ImageView ivFavorite;

    private GestureDetector gestureDetector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        Intent intent = getIntent();

        ProfileModel profileModel = intent.getParcelableExtra("profileModel");

        iv_profile = findViewById(R.id.iv_profile);
        tv_userProfile = findViewById(R.id.tv_userProfile);
        iv_post = findViewById(R.id.iv_post);
        tv_userProfile2 = findViewById(R.id.tv_userProfile2);
        tv_caption = findViewById(R.id.tv_caption);
        ivFavorite = findViewById(R.id.iv_favorite);


        iv_profile.setImageResource(profileModel.getProfile());
        tv_userProfile.setText(profileModel.getUsername());
        if (profileModel.getSelectedImageUri() != null) {
            iv_post.setImageURI(profileModel.getSelectedImageUri());
        } else {
            // Use setImageResource if selectedImageUri is not available
            iv_post.setImageResource(profileModel.getFotoPostingan());
        }
        tv_userProfile2.setText(profileModel.getUsername());
        tv_caption.setText(String.valueOf(profileModel.getCaption()));

        tv_userProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PostActivity.this, ProfileActivity.class);
                intent.putExtra("profileModel", profileModel);
                startActivity(intent);
            }
        });

        tv_userProfile2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PostActivity.this, ProfileActivity.class);
                intent.putExtra("profileModel", profileModel);
                startActivity(intent);
            }
        });

        iv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PostActivity.this, ProfileActivity.class);
                intent.putExtra("profileModel", profileModel);
                startActivity(intent);
            }
        });

        // Inisialisasi GestureDetector
        gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                toggleFavorite();
                return true;
            }
        });

        iv_post.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return true;
            }
        });

        ivFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleFavorite();
            }
        });
    }

    public void toggleFavorite() {
        if (isFavorite) {
            // Gambar tidak favorit
            ivFavorite.setImageResource(R.drawable.favorite_icon);
            isFavorite = false;
        } else {
            // Gambar favorit
            ivFavorite.setImageResource(R.drawable.pressed_favorite_icon); // Gambar merah
            isFavorite = true;
        }
    }

    public void back(View v) {
        finish();
    }
}
