package com.example.tugasprak03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tugasprak03.Data.DataClass;
import com.example.tugasprak03.Data.StoryData;
import com.example.tugasprak03.Data.User;

import java.util.ArrayList;

public class StoryActivity extends AppCompatActivity {

    ImageView imgProfile, imgStory;
    TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        imgProfile = findViewById(R.id.profileStory);
        imgStory = findViewById(R.id.imageStory);
        username = findViewById(R.id.usernameStory);

        ArrayList<User> users = getIntent().getParcelableArrayListExtra("users");
        ArrayList<DataClass> dataClasses = getIntent().getParcelableArrayListExtra("posts");
        ArrayList<StoryData> stories = getIntent().getParcelableArrayListExtra("stories");
        int idUser = getIntent().getIntExtra("idUser", -1);

        for (User user: users) {
            for (StoryData storyData : stories) {
                if (idUser == user.getId() && idUser == storyData.getUserId()){
                    imgProfile.setImageResource(user.getProfilePic());
                    username.setText(user.getUsername());
                    imgStory.setImageResource(storyData.getStoryPic());
                }
            }
        }
        imgProfile.setOnClickListener(v -> {
            Intent intent = new Intent(this, ProfileActivity.class);
            intent.putExtra("users",  users);
            intent.putExtra("posts", dataClasses);
            intent.putExtra("stories", stories);
            intent.putExtra("idUser", idUser);
            startActivity(intent);
        });
        username.setOnClickListener(v -> {
            Intent intent = new Intent(this, ProfileActivity.class);
            intent.putExtra("users",  users);
            intent.putExtra("posts", dataClasses);
            intent.putExtra("stories", stories);
            intent.putExtra("idUser", idUser);
            startActivity(intent);
        });
    }
}