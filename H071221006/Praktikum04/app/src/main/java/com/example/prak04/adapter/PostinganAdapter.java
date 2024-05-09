package com.example.prak04.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.prak04.Postingan;
import com.example.prak04.ProfileActivity;
import com.example.prak04.R;
import java.util.ArrayList;

public class PostinganAdapter extends RecyclerView.Adapter<PostinganAdapter.ViewHolder> {

    private ArrayList<Postingan> daftarInstagram;

    public PostinganAdapter(ArrayList<Postingan> daftarInstagram) {
        this.daftarInstagram = daftarInstagram;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View tampilan = LayoutInflater.from(parent.getContext()).inflate(R.layout.postingan, parent, false);
        return new ViewHolder(tampilan);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Postingan dataInstagram = daftarInstagram.get(position);

        holder.tvUsername.setText(dataInstagram.getUsername());
        holder.tvNama.setText(dataInstagram.getName());
        holder.ivProfil.setImageResource(dataInstagram.getFotoProfile());
        holder.ivPost.setImageResource(dataInstagram.getFotoPostingan());
        holder.IVPost.setImageURI(dataInstagram.getSelectedImageUri());
        holder.tvKeterangan.setText(dataInstagram.getDesc());

        Context konteks = holder.context;

        holder.ivProfil.setOnClickListener(v -> tampilkanProfil(konteks, dataInstagram));
        holder.tvNama.setOnClickListener(v -> tampilkanProfil(konteks, dataInstagram));
        holder.tvUsername.setOnClickListener(v -> tampilkanProfil(konteks, dataInstagram));

        holder.ivHapus.setOnClickListener(v -> konfirmasiHapus(konteks, holder.getAdapterPosition()));
    }

    private void tampilkanProfil(Context konteks, Postingan dataInstagram) {
        Intent intent = new Intent(konteks, ProfileActivity.class);
        intent.putExtra("username", dataInstagram.getUsername());
        intent.putExtra("name", dataInstagram.getName());
        intent.putExtra("profileImage", dataInstagram.getFotoProfile());
        konteks.startActivity(intent);
    }


    private void konfirmasiHapus(Context konteks, int posisi) {
        AlertDialog.Builder pembuatDialog = new AlertDialog.Builder(konteks);
        pembuatDialog.setTitle("Konfirmasi");
        pembuatDialog.setMessage("Apakah Anda yakin ingin menghapus postingan ini?");
        pembuatDialog.setPositiveButton("Ya", (dialog, which) -> {
            daftarInstagram.remove(posisi);
            notifyItemRemoved(posisi);
        });
        pembuatDialog.setNegativeButton("Tidak", (dialog, which) -> dialog.dismiss());
        pembuatDialog.create().show();
    }

    @Override
    public int getItemCount() {
        return daftarInstagram.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivPost, ivProfil, ivHapus, IVPost;
        TextView tvKeterangan, tvUsername, tvNama;
        Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPost = itemView.findViewById(R.id.IV_Postingan);
            IVPost = itemView.findViewById(R.id.IV_Postingan);
            ivProfil = itemView.findViewById(R.id.IV_Profile);
            ivHapus = itemView.findViewById(R.id.IV_Delete);
            tvKeterangan = itemView.findViewById(R.id.TV_Desc);
            tvUsername = itemView.findViewById(R.id.TV_username);
            tvNama = itemView.findViewById(R.id.TV_name);
            context = itemView.getContext();
        }
    }
}
