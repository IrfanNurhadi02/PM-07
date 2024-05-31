package com.example.praktikum3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PostActivity extends AppCompatActivity {
    private ImageView iv_profile;
    private TextView tv_userProfile;
    private ImageView iv_post;
    private TextView tv_userProfile2;
    private TextView tv_caption;


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


        iv_profile.setImageResource(profileModel.getProfile());
        tv_userProfile.setText(profileModel.getUsername());
        iv_post.setImageResource(profileModel.getFotoPostingan());
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
    }

    private boolean isFavorite;
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

    public void back(View v) {
        finish();
    }
}
