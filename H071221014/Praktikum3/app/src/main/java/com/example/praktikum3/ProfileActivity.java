package com.example.praktikum3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
//
        TextView tvUsername = findViewById(R.id.tv_username);
        ImageView ivProfile = findViewById(R.id.iv_profile);
        TextView tvFollowers = findViewById(R.id.tv_followers);
        TextView tvFollowing = findViewById(R.id.tv_following);
        TextView tvName = findViewById(R.id.tv_name);
        TextView tvBio = findViewById(R.id.tv_bio);
        ImageView ivPost = findViewById(R.id.iv_post);

        Intent intent = getIntent();

        ProfileModel profileModel = intent.getParcelableExtra("profileModel");

        tvUsername = findViewById(R.id.tv_username);
        ivProfile = findViewById(R.id.iv_profile);
        tvFollowers = findViewById(R.id.tv_followers);
        tvFollowing = findViewById(R.id.tv_following);
        tvName = findViewById(R.id.tv_name);
        tvBio = findViewById(R.id.tv_bio);
        ivPost = findViewById(R.id.iv_post);

        tvUsername.setText(profileModel.getUsername());
        ivProfile.setImageResource(profileModel.getProfile());
        tvFollowers.setText(String.valueOf(profileModel.getFollowers()));
        tvFollowing.setText(String.valueOf(profileModel.getFollowing()));
        tvName.setText(String.valueOf(profileModel.getName()));
        tvBio.setText(String.valueOf(profileModel.getBio()));
        ivPost.setImageResource(profileModel.getFotoPostingan());

        ivPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, PostActivity.class);
                intent.putExtra("profileModel",profileModel);
                startActivity(intent);
            }
        });

        ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, StoryDetailActivity.class);
                intent.putExtra("profileModel", profileModel);
                startActivity(intent);
            }
        });
    }

    public void back(View v) {
        finish();
    }
}