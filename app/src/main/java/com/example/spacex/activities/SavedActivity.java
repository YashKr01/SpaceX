package com.example.spacex.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.spacex.R;
import com.example.spacex.adapter.RoomAdapter;
import com.example.spacex.model.User;
import com.example.spacex.viewmodel.SavedViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class SavedActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton fab;
    RoomAdapter adapter;
    SavedViewModel viewModel;
    ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);

        viewModel = new ViewModelProvider(this).get(SavedViewModel.class);
        recyclerView = findViewById(R.id.saved_recycler_view);
        fab = findViewById(R.id.floatingActionButton);
        users = new ArrayList<>();
        adapter = new RoomAdapter(this, users);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        viewModel.getAllUsers(this).observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                adapter.setData((ArrayList<User>) users);
            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.deleteAll(SavedActivity.this);
            }
        });


    }
}