
package com.example.praktikum5;

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

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private ArrayList<ProfileModel> profileModels;

    public SearchAdapter(ArrayList<ProfileModel> profileModels) {
        this.profileModels = profileModels;
    }

    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search, parent, false);
        return new SearchAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, int position) {

        ProfileModel profileModel2 = profileModels.get(position);

        holder.IV_Search.setImageResource(profileModel2.getProfile());
        holder.tv_username.setText(profileModel2.getUsername());
        holder.tv_name.setText(profileModel2.getName());

        holder.IV_Search.setOnClickListener(v -> {
            Intent intent = new Intent(holder.context, ProfileActivity.class);
            intent.putExtra("profileModel", profileModel2);
            holder.context.startActivity(intent);
        });

        holder.tv_username.setOnClickListener(v -> {
            Intent intent = new Intent(holder.context, ProfileActivity.class);
            intent.putExtra("profileModel", profileModel2);
            holder.context.startActivity(intent);
        });
        holder.tv_name.setOnClickListener(v -> {
            Intent intent = new Intent(holder.context, ProfileActivity.class);
            intent.putExtra("profileModel", profileModel2);
            holder.context.startActivity(intent);
        });

    }

    public void filterList(ArrayList<ProfileModel> filteredList) {
        profileModels = filteredList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return profileModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView IV_Search;
        TextView tv_username, tv_name;
        Context context;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            IV_Search = itemView.findViewById(R.id.iv_search);
            tv_username = itemView.findViewById(R.id.tv_username);
            tv_name = itemView.findViewById(R.id.tv_name);
            context = itemView.getContext();
        }
    }
}
