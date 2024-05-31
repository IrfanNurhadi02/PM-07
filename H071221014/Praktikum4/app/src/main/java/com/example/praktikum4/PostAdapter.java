package com.example.praktikum4;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.praktikum4.fragment.ProfileFragment;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private ArrayList<ProfileModel> profileModels;

    public PostAdapter(ArrayList<ProfileModel> profileModels) {
        this.profileModels = profileModels;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new PostAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {

        ProfileModel profileModel = profileModels.get(position);

        holder.tv_userProfile.setText(profileModel.getUsername());
        holder.iv_profile.setImageResource(profileModel.getProfile());
        holder.tv_userProfile2.setText(profileModel.getUsername());
        if (profileModel.getFotoPostingan() != null ) {
            holder.iv_post.setImageResource(profileModel.getFotoPostingan());
        }
        if (profileModel.getSelectedImageUri() != null) {
            holder.IV_post.setImageURI(profileModel.getSelectedImageUri());
        }
        holder.tv_caption.setText(profileModel.getCaption());

        holder.iv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.context, ProfileActivity.class);
                intent.putExtra("profileModel", profileModel);
                holder.context.startActivity(intent);
            }
        });

        holder.tv_userProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.context, ProfileActivity.class);
                intent.putExtra("profileModel", profileModel);
                holder.context.startActivity(intent);
            }
        });


        holder.ivDelete.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(holder.context);
            builder.setTitle("Konfirmasi");
            builder.setMessage("Apakah Anda yakin ingin menghapus postingan ini?");
            builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    int adapterPosition = holder.getAdapterPosition();
                    if (adapterPosition != RecyclerView.NO_POSITION) {
                        profileModels.remove(adapterPosition);
                        notifyItemRemoved(adapterPosition);
                    }
                }
            });
            builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.create().show();
        });
    }

    @Override
    public int getItemCount() {
        return profileModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_post, iv_profile, ivDelete, IV_post;
        TextView tv_caption, tv_userProfile, tv_userProfile2;
        Context context;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_profile = itemView.findViewById(R.id.iv_profile);
            tv_userProfile = itemView.findViewById(R.id.tv_userProfile);
            ivDelete = itemView.findViewById(R.id.IV_Delete);
            iv_post = itemView.findViewById(R.id.iv_post);
            IV_post = itemView.findViewById(R.id.iv_post);
            tv_userProfile2 = itemView.findViewById(R.id.tv_userProfile2);
            tv_caption = itemView.findViewById(R.id.tv_caption);
            context = itemView.getContext();
        }
    }
}
