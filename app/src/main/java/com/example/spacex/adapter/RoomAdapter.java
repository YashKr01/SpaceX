package com.example.spacex.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.spacex.R;
import com.example.spacex.listeners.UserListener;
import com.example.spacex.model.User;

import java.util.ArrayList;
import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<User> users;

    public RoomAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.room_single_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = users.get(position);

        holder.userName.setText("Name : " + user.getName());
        holder.userStatus.setText("Status : " + user.getStatus());
        holder.userAgency.setText("Agency : " + user.getAgency());

        Glide.with(context).load(user.getImageUrl()).into(holder.userImage);

    }

    public void setData(ArrayList<User> user) {
        users = user;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView userName, userStatus, userAgency;
        ImageView userImage;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            userName = itemView.findViewById(R.id.user_name2);
            userAgency = itemView.findViewById(R.id.user_agency2);
            userStatus = itemView.findViewById(R.id.user_status2);
            userImage = itemView.findViewById(R.id.user_image2);

        }

    }

}
