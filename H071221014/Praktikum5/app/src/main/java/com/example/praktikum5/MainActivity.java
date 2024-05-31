package com.example.praktikum5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.praktikum5.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();

        HomeFragment homeFragment = new HomeFragment();

        Fragment fragment = fragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());

        if (!(fragment instanceof HomeFragment)){
            fragmentManager
                    .beginTransaction()
                    .add(R.id.frame_container, homeFragment)
                    .commit();
        }
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