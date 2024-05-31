package com.example.praktikum5.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.praktikum5.DataSource;
import com.example.praktikum5.PostAdapter;
import com.example.praktikum5.ProfileModel;
import com.example.praktikum5.R;

public class HomeFragment extends Fragment {

    public static final String EXTRA_INSTAGRAM = "extra_instagram";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rvPost = view.findViewById(R.id.rv_posts);
        rvPost.setHasFixedSize(true);
        PostAdapter postAdapter = new PostAdapter(DataSource.profiles);
        rvPost.setAdapter(postAdapter);

        // Ambil data postingan baru dari argument
        Bundle bundle = getArguments();
        if (bundle != null && bundle.containsKey(HomeFragment.EXTRA_INSTAGRAM)) {
            ProfileModel profileModel = bundle.getParcelable(HomeFragment.EXTRA_INSTAGRAM);
            if (profileModel != null) {
                // Tambahkan data postingan baru ke DataSource.profiles
                DataSource.profiles.add(0, profileModel);
                // Refresh RecyclerView
                postAdapter.notifyDataSetChanged();
            }
        }

        ImageView iv_search = view.findViewById(R.id.IV_Search);
        ImageView iv_posting = view.findViewById(R.id.IV_Post);
        ImageView iv_profile = view.findViewById(R.id.IV_Profile);

        iv_search.setOnClickListener(v -> {
            SearchFragment searchFragment = new SearchFragment();
            FragmentManager fragmentManager = getParentFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, searchFragment)
                    .addToBackStack(null)
                    .commit();
        });

        iv_posting.setOnClickListener(v -> {
            PostFragment postFragment = new PostFragment();
            FragmentManager fragmentManager = getParentFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, postFragment)
                    .addToBackStack(null)
                    .commit();
        });

        iv_profile.setOnClickListener(v -> {
            ProfileFragment profileFragment = new ProfileFragment();
            FragmentManager fragmentManager = getParentFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, profileFragment)
                    .addToBackStack(null)
                    .commit();
        });
    }

}