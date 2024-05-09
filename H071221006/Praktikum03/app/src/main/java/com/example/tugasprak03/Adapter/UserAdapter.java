package com.example.tugasprak03.Adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugasprak03.Data.DataClass;
import com.example.tugasprak03.Data.StoryData;
import com.example.tugasprak03.Data.User;
import com.example.tugasprak03.DetailActivity;
import com.example.tugasprak03.R;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.viewHolder> {
    private final ArrayList<User> users;
    private final ArrayList<DataClass> dataClasses;
    private List<DataClass> dataList;
    private final ArrayList<StoryData> stories;
    private Context context;
    private int userId;

    public UserAdapter(Context context, ArrayList<User> users, ArrayList<DataClass> dataClasses, ArrayList<StoryData> stories, int userId) {
        this.users = users;
        this.dataClasses = dataClasses;
        this.stories = stories;
        this.context = context;
        this.userId = userId;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public UserAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_post, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.viewHolder holder, int position) {
        ArrayList<DataClass> postsByUser = new ArrayList<>();
        for (DataClass dataClass : dataClasses) {
            if(dataClass.getUserId() == userId){
                postsByUser.add(dataClass);
            }
        }
        DataClass dataClassByUser = postsByUser.get(position);
        holder.setData(dataClassByUser, position);
    }

    @Override
    public int getItemCount() {
        int count = 0;
        for (DataClass dataClass : dataClasses) {
            if(dataClass.getUserId() == userId){
                count += 1;
            }
        }
        return count;
    }

    public void setSearchList(List<DataClass> dataSearchList){
        this.dataList = dataSearchList;
        notifyDataSetChanged();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        private final ImageView imagePost;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imagePost = itemView.findViewById(R.id.imagePost);
        }
        public void setData(DataClass dataClass, Integer position){
            imagePost.setImageResource(dataClass.getPostPic());
            imagePost.setOnClickListener(v -> {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("idUser", dataClass.getUserId());
                intent.putExtra("idPost", dataClass.getId());
                intent.putExtra("users", users);
                intent.putExtra("posts", dataClasses);
                intent.putExtra("stories", stories);
                context.startActivity(intent);
            });
        }
    }
}
