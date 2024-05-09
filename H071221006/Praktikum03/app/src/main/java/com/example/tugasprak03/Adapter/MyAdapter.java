package com.example.tugasprak03.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugasprak03.Data.DataClass;
import com.example.tugasprak03.Data.StoryData;
import com.example.tugasprak03.Data.User;
import com.example.tugasprak03.R;
import com.example.tugasprak03.StoryActivity;
import com.example.tugasprak03.ProfileActivity;

import java.util.ArrayList;
import java.util.Objects;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private final ArrayList<User> users;
    private final ArrayList<DataClass> dataClasses;
    private final ArrayList<StoryData> stories;
    private Context context;

    public MyAdapter(Context context, ArrayList<User> users, ArrayList<DataClass> dataClasses, ArrayList<StoryData> stories) {
        this.context = context;
        this.users = users;
        this.dataClasses = dataClasses;
        this.stories = stories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_detail, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataClass dataClass = dataClasses.get(position);
        holder.setData(dataClass);
    }

    @Override
    public int getItemCount() {
        return dataClasses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView ivProfile, ivPost;
        private final TextView tvUsername, tvPostDesc;

        public ViewHolder(View itemView) {
            super(itemView);
            ivProfile = itemView.findViewById(R.id.iv_profile);
            ivPost = itemView.findViewById(R.id.iv_post);
            tvPostDesc = itemView.findViewById(R.id.tv_postdesc);
            tvUsername = itemView.findViewById(R.id.tv_username);
        }

        public void setData(DataClass dataClass){
            Integer foreignKey = dataClass.getUserId();
            for (User user: users) {
                if(Objects.equals(foreignKey, user.getId())){
                    ivProfile.setImageResource(user.getProfilePic());
                    tvUsername.setText(user.getUsername());
                }
            }
            ivPost.setImageResource(dataClass.getPostPic());
            tvPostDesc.setText(dataClass.getPostDesc());

            ivProfile.setOnClickListener(v -> {
                Intent intent = new Intent(context, StoryActivity.class);
                intent.putExtra("idUser", dataClass.getUserId());
                intent.putExtra("users", users);
                intent.putExtra("posts", dataClasses);
                intent.putExtra("stories", stories);
                context.startActivity(intent);
            });
            tvUsername.setOnClickListener(v -> {
                Intent intent = new Intent(context, ProfileActivity.class);
                intent.putExtra("users",  users);
                intent.putExtra("posts", dataClasses);
                intent.putExtra("stories", stories);
                intent.putExtra("idUser", dataClass.getUserId());
                context.startActivity(intent);
            });
        }
    }
}
