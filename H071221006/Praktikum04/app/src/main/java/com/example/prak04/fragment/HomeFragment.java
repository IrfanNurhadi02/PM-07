package com.example.prak04.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.prak04.data.DataSource;
import com.example.prak04.Postingan;
import com.example.prak04.adapter.PostinganAdapter;
import com.example.prak04.R;

public class HomeFragment extends Fragment {

    public static final String EXTRA_POSTINGAN = "extra_postingan"; //kirim data postingan

    @Override
    // menginflate fragment_home.xml
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    // inisialisasi dan pengaturan tampilan serta listener pada fragment.
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rvPostingan = view.findViewById(R.id.rv_post);
        rvPostingan.setHasFixedSize(true);
        PostinganAdapter postinganAdapter = new PostinganAdapter(DataSource.instagrams);
        rvPostingan.setAdapter(postinganAdapter);

        Bundle bundle = getArguments();
        // Cek apakah ada data postingan yang dikirim melalui Bundle.
        // Jika ada, tambahkan postingan tersebut ke DataSource dan update adapter.
        if (bundle != null) {
            Postingan instagram = bundle.getParcelable(EXTRA_POSTINGAN);
            if (instagram != null) {
                DataSource.instagrams.add(0, instagram);
                postinganAdapter.notifyDataSetChanged();
            }
        }

        ImageView iv_posting = view.findViewById(R.id.IV_Post);
        ImageView iv_profile = view.findViewById(R.id.IV_Profile);

        // Ketika salah satu ImageView diklik,
        // fragment yang sesuai akan ditampilkan dengan menggantikan HomeFragment di dalam frame_container.
        iv_posting.setOnClickListener(v -> {
            PostinganFragment postinganFragment = new PostinganFragment();
            FragmentManager fragmentManager = getParentFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, postinganFragment)
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