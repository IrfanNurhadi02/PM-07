package com.example.praktikum3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvStory = findViewById(R.id.rv_story);
        rvStory.setHasFixedSize(true);

        StoryAdapter storyAdapter = new StoryAdapter(DataSource.profiles);
        rvStory.setAdapter(storyAdapter);

        RecyclerView rvPost = findViewById(R.id.rv_posts);
        rvPost.setHasFixedSize(true);

        PostAdapter postAdapter = new PostAdapter(DataSource.profiles);
        rvPost.setAdapter(postAdapter);

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
}