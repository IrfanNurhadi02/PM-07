package com.example.tugasprak03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tugasprak03.Adapter.UserAdapter;
import com.example.tugasprak03.Data.DataClass;
import com.example.tugasprak03.Data.DataSource;
import com.example.tugasprak03.Data.StoryData;
import com.example.tugasprak03.Data.User;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageView imgProfile = findViewById(R.id.iv_imageProfile);
        TextView tvUsername = findViewById(R.id.tv_username);
        TextView tvNumFollowers = findViewById(R.id.tv_numFollowers);
        TextView tvNumFollowing = findViewById(R.id.tv_numFollowing);
        RecyclerView rvPost = findViewById(R.id.rv_post);

        ArrayList<User> users = getIntent().getParcelableArrayListExtra("users");
        ArrayList<DataClass> dataClasses = getIntent().getParcelableArrayListExtra("posts");
        ArrayList<StoryData> stories = getIntent().getParcelableArrayListExtra("stories");
        int idUser = getIntent().getIntExtra("idUser", -1);

        for (User user: users) {
            for (DataClass dataClass : dataClasses) {
                if(user.getId() == idUser && dataClass.getUserId() == idUser){
                    imgProfile.setImageResource(user.getProfilePic());
                    tvUsername.setText(user.getUsername());
                    tvNumFollowers.setText(String.valueOf(user.getFollowers()));
                    tvNumFollowing.setText(String.valueOf(user.getFollowing()));
                }
            }
        }

        imgProfile.setOnClickListener(v -> {
            Intent intent = new Intent(this, StoryActivity.class);
            intent.putExtra("idUser", idUser);
            intent.putExtra("users", users);
            intent.putExtra("posts", dataClasses);
            intent.putExtra("stories", stories);
            startActivity(intent);
        });

        rvPost.setHasFixedSize(true);
//        rvPost.setLayoutManager(new GridLayoutManager(this, 3));
        UserAdapter userAdapter = new UserAdapter(this, DataSource.users, DataSource.dataClasses, DataSource.stories, idUser);
        rvPost.setAdapter(userAdapter);
    }
}