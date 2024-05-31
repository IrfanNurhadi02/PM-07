package com.example.praktikum3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.widget.ImageView;


import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class StoryDetailActivity extends AppCompatActivity {
    private ImageView iv_profile;
    private ImageView iv_story;
    private TextView tv_username;
    private boolean isFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_detail);

        Intent intent = getIntent();

        ProfileModel profileModel = intent.getParcelableExtra("profileModel");

        iv_profile = findViewById(R.id.iv_profile);
        iv_story = findViewById(R.id.iv_story);
        tv_username = findViewById(R.id.tv_username);

        iv_profile.setImageResource(profileModel.getProfile());
        iv_story.setImageResource(profileModel.getFotoStory());
        tv_username.setText(profileModel.getUsername());

        tv_username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StoryDetailActivity.this, ProfileActivity.class);
                intent.putExtra("profileModel", profileModel);
                startActivity(intent);
            }
        });

        iv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StoryDetailActivity.this, ProfileActivity.class);
                intent.putExtra("profileModel", profileModel);
                startActivity(intent);
            }
        });

    }

    public void back(View v) {
        finish();
    }


    // Metode toggleFavorite akan dipanggil ketika ImageView ditekan
    public void toggleFavorite(View view) {
        ImageView imageView = (ImageView) view;
        // Ganti gambar tergantung pada nilai isFavorite
        if (isFavorite) {
            imageView.setImageResource(R.drawable.favorite_icon);
        } else {
            imageView.setImageResource(R.drawable.pressed_favorite_icon);
        }
        // Perbarui nilai isFavorite
        isFavorite = !isFavorite;
    }


}



