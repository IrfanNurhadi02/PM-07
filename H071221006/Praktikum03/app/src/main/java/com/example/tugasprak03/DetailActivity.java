package com.example.tugasprak03;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tugasprak03.Data.DataClass;
import com.example.tugasprak03.Data.StoryData;
import com.example.tugasprak03.Data.User;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tvUsername = findViewById(R.id.tv_username);
        ImageView imagePost = findViewById(R.id.iv_post);
        TextView postDesc = findViewById(R.id.tv_postdesc);

        ArrayList<User> users = getIntent().getParcelableArrayListExtra("users");
        ArrayList<DataClass> dataClasses = getIntent().getParcelableArrayListExtra("posts");
        ArrayList<StoryData> stories = getIntent().getParcelableArrayListExtra("stories");
        int idUser = getIntent().getIntExtra("idUser", -1);
        int idPost = getIntent().getIntExtra("idPost", -1);

        for (User user : users) {
            for (DataClass dataClass : dataClasses) {
                if(user.getId() == idUser && dataClass.getUserId() == idUser && dataClass.getId() == idPost){
                    tvUsername.setText(user.getUsername());
                    imagePost.setImageResource(dataClass.getPostPic());
                    postDesc.setText(dataClass.getPostDesc());
                }
            }
        }
        tvUsername.setOnClickListener(v -> {
            Intent intent = new Intent(this, ProfileActivity.class);
            intent.putExtra("users",  users);
            intent.putExtra("posts", dataClasses);
            intent.putExtra("stories", stories);
            intent.putExtra("idUser", idUser);

            startActivity(intent);
        });
    }
}
