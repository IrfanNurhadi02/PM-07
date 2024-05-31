package com.example.praktikum3;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {

    private ArrayList<ProfileModel> profileModels;

    public StoryAdapter(ArrayList<ProfileModel> profileModels) {
        this.profileModels = profileModels;
    }

    @NonNull
    @Override
    public StoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_story, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryAdapter.ViewHolder holder, int position) {
        ProfileModel profileModel = profileModels.get(position);

        holder.iv_profile.setImageResource(profileModel.getProfile());
        holder.tv_username.setText(profileModel.getUsername());

        holder.iv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.context, StoryDetailActivity.class);
                intent.putExtra("profileModel", profileModel);
                holder.context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return profileModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_profile;
        TextView tv_username;
        Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            iv_profile = itemView.findViewById(R.id.iv_profile);
            tv_username = itemView.findViewById(R.id.tv_username);
            context = itemView.getContext();

        }
    }
}