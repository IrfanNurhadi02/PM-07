package com.example.tugasprak03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.tugasprak03.Adapter.MyAdapter;
import com.example.tugasprak03.Adapter.StoryAdapter;
import com.example.tugasprak03.Data.DataClass;
import com.example.tugasprak03.Data.DataSource;
import com.example.tugasprak03.Data.StoryData;
import com.example.tugasprak03.Data.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<User> users = DataSource.users;
    private List<DataClass> dataClasses = DataSource.dataClasses;
    private List<StoryData> stories = DataSource.stories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<User> userList = new ArrayList<>(users);
        ArrayList<DataClass> dataClassList = new ArrayList<>(dataClasses);
        ArrayList<StoryData> storyDataList = new ArrayList<>(stories);

        RecyclerView rvStory = findViewById(R.id.rv_stories);
        rvStory.setHasFixedSize(true);
        StoryAdapter storyAdapter = new StoryAdapter(MainActivity.this, userList, dataClassList, storyDataList);

        RecyclerView rvAllPost = findViewById(R.id.rv_all_posts);
        rvAllPost.setHasFixedSize(true);
        MyAdapter myAdapter = new MyAdapter(MainActivity.this, userList, dataClassList, storyDataList);

        rvStory.setAdapter(storyAdapter);
        rvAllPost.setAdapter(myAdapter);

        // Inisialisasi SearchView
        SearchView searchView = findViewById(R.id.search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Tidak ada aksi ketika teks dikirim
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Panggil metode pencarian
                searchByUsername(newText);
                return true;
            }
        });
    }


    private void searchByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                // Temukan pengguna yang sesuai dan arahkan ke profil pengguna
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                intent.putExtra("users", new ArrayList<>(users));
                intent.putExtra("posts", new ArrayList<>(dataClasses));
                intent.putExtra("stories", new ArrayList<>(stories));
                intent.putExtra("idUser", user.getId());
                startActivity(intent);
                return;
            }
        }
        // Jika pengguna tidak ditemukan, tampilkan pesan
        Toast.makeText(MainActivity.this, "User not found", Toast.LENGTH_SHORT).show();
    }
}
