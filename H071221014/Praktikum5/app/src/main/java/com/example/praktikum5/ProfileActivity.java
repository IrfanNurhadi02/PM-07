package com.example.praktikum5;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProfileActivity extends AppCompatActivity {

    private LinearLayout container;
    private ProgressBar progressBar;

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
        ProgressBar progressBar = findViewById(R.id.progressBar);
        LinearLayout container = findViewById(R.id.layout);

        progressBar.setVisibility(ProgressBar.VISIBLE);
        container.setVisibility(LinearLayout.GONE);

        Intent intent = getIntent();
        ProfileModel profileModel = intent.getParcelableExtra("profileModel");

        tvUsername.setText(profileModel.getUsername());
        ivProfile.setImageResource(profileModel.getProfile());
        tvFollowers.setText(profileModel.getFollowers());
        tvFollowing.setText(profileModel.getFollowing());
        tvName.setText(profileModel.getName());
        tvBio.setText(profileModel.getBio());
        // Check if selectedImageUri is available
        if (profileModel.getSelectedImageUri() != null) {
            ivPost.setImageURI(profileModel.getSelectedImageUri());
        } else {
            // Use setImageResource if selectedImageUri is not available
            ivPost.setImageResource(profileModel.getFotoPostingan());
        }

        ivPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, PostActivity.class);
                intent.putExtra("profileModel", profileModel);
                startActivity(intent);
            }
        });

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> {
            try {
                Thread.sleep(1000);
                handler.post(() -> {
                    container.setVisibility(LinearLayout.VISIBLE);
                    progressBar.setVisibility(ProgressBar.GONE);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


    }


    public void back(View v) {
        finish();
    }
}