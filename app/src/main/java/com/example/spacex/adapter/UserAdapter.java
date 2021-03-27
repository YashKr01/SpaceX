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

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<User> users;
    private UserListener userListener;

    public UserAdapter(Context context, ArrayList<User> users, UserListener userListener) {
        this.context = context;
        this.users = users;
        this.userListener = userListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_single_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = users.get(position);

        holder.userName.setText("Name : " + user.getName());
        holder.userStatus.setText("Status : " + user.getStatus());
        holder.userAgency.setText("Agency : " + user.getAgency());

        Glide.with(context).load(user.getImageUrl()).into(holder.userImage);

        holder.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userListener.save(user);
            }
        });

        holder.url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userListener.loadUrl(user);
            }
        });

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView userName, userStatus, userAgency;
        ImageView userImage;
        Button save, url;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            userName = itemView.findViewById(R.id.user_name);
            userAgency = itemView.findViewById(R.id.user_agency);
            userStatus = itemView.findViewById(R.id.user_status);
            userImage = itemView.findViewById(R.id.user_image);
            save = itemView.findViewById(R.id.btn_save);
            url = itemView.findViewById(R.id.btn_url);

        }

    }

}
