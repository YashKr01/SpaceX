package com.example.spacex.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.spacex.R;
import com.example.spacex.adapter.UserAdapter;
import com.example.spacex.api.ApiService;
import com.example.spacex.api.RetrofitInstance;
import com.example.spacex.listeners.UserListener;
import com.example.spacex.model.User;
import com.example.spacex.viewmodel.MyViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements UserListener {

    RecyclerView recyclerView;
    FloatingActionButton fab;
    UserAdapter userAdapter;
    ArrayList<User> usersList;
    MyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.user_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fab = findViewById(R.id.fab);
        usersList = new ArrayList<>();
        userAdapter = new UserAdapter(this, usersList, this);
        viewModel = new ViewModelProvider(this).get(MyViewModel.class);

        ApiService apiService = RetrofitInstance.getRetrofit().create(ApiService.class);
        Call<List<User>> call = apiService.getAllUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response != null && response.body() != null) {
                    usersList.clear();
                    usersList = (ArrayList<User>) response.body();
                    userAdapter = new UserAdapter(getApplicationContext(), usersList, MainActivity.this);
                    recyclerView.setAdapter(userAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.d("TAG", "onFailure: " + t.getMessage().toString());
            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SavedActivity.class));
            }
        });

    }

    @Override
    public void loadUrl(User users) {
        Log.d("TAG", "loadUrl: " + users.getHyperlink());
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(users.getHyperlink()));
        startActivity(browserIntent);
    }

    @Override
    public void save(User user) {

        Log.d("TAG", "save: " + user.toString());
        viewModel.insert(this, user);


    }

}