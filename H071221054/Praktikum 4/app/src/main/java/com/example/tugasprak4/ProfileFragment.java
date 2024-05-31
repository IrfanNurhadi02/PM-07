package com.example.tugasprak4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;


public class ProfileFragment extends Fragment {
    public static String EXTRA_USER = "extra_user";
    private ImageView imgProfileIv;
    private TextView nameTv;
    private TextView usernameTv;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        User user;
        ProfileFragment.super.onViewCreated(view, savedInstanceState);
        changeActionBarTitle();
        this.imgProfileIv = view.findViewById(R.id.image_profile);
        this.usernameTv = view.findViewById(R.id.text_fullname);
        this.nameTv = view.findViewById(R.id.text_username);

        if (getArguments() != null) {
            user = getArguments().getParcelable(EXTRA_USER);
        } else {
            user = DataSource.user;
        }

        this.imgProfileIv.setImageResource(user.getProfileImg());
        this.nameTv.setText(user.getName());
        this.usernameTv.setText(user.getUsername());
    }

    public void changeActionBarTitle() {
        if (getActivity() instanceof AppCompatActivity) {
            AppCompatActivity activity = (AppCompatActivity) getActivity();
            if (activity.getSupportActionBar() != null) {
                activity.getSupportActionBar().setTitle("Profile");
            }
        }
    }
}