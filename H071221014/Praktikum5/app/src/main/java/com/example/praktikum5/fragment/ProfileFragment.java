package com.example.praktikum5.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.praktikum5.ProfileModel;
import com.example.praktikum5.R;

public class ProfileFragment extends Fragment {

    public static final String EXTRA_INSTAGRAM = "extra_instagram";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inisialisasi view dan objek
        TextView tvUsername = view.findViewById(R.id.tv_username);
        ImageView ivProfile = view.findViewById(R.id.iv_profile);
        TextView tvFollowers = view.findViewById(R.id.tv_followers);
        TextView tvFollowing = view.findViewById(R.id.tv_following);
        TextView tvName = view.findViewById(R.id.tv_name);
        TextView tvBio = view.findViewById(R.id.tv_bio);
        ImageView ivPost = view.findViewById(R.id.iv_post);

        // Ambil data postingan baru dari argument
        Bundle bundle = getArguments();
        if (bundle != null && bundle.containsKey("profileModel")) {
            ProfileModel profileModel = bundle.getParcelable("profileModel");
            if (profileModel != null) {
                // Tampilkan data postingan baru di dalam ProfileFragment
                tvUsername.setText(profileModel.getUsername());
                ivProfile.setImageResource(profileModel.getProfile());
                tvFollowers.setText(profileModel.getFollowers());
                tvFollowing.setText(profileModel.getFollowing());
                tvName.setText(profileModel.getName());
                tvBio.setText(profileModel.getBio());
                if (profileModel.getSelectedImageUri() != null) {
                    ivPost.setImageURI(profileModel.getSelectedImageUri());
                }
            }
        }

        ImageView IV_Home = view.findViewById(R.id.IV_Home);
        ImageView iv_search = view.findViewById(R.id.IV_Search);
        ImageView IV_Postingan = view.findViewById(R.id.IV_Post);

        iv_search.setOnClickListener(v -> {
            SearchFragment searchFragment = new SearchFragment();
            FragmentManager fragmentManager = getParentFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, searchFragment)
                    .addToBackStack(null)
                    .commit();
        });

        IV_Home.setOnClickListener(v -> {
            HomeFragment homeFragment = new HomeFragment();
            FragmentManager fragmentManager = getParentFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, homeFragment)
//                    .addToBackStack(null)
                    .commit();
        });

        IV_Postingan.setOnClickListener(v -> {
            PostFragment postinganFragment = new PostFragment();
            FragmentManager fragmentManager = getParentFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, postinganFragment)
//                    .addToBackStack(null)
                    .commit();
        });
    }
}