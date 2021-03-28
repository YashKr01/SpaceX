package com.example.spacex.viewmodel;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.example.spacex.model.User;
import com.example.spacex.room.UserDatabase;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MyViewModel extends ViewModel {

    UserDatabase userDatabase;
    Executor executor= Executors.newSingleThreadExecutor();

    public void insert(Context context, User user) {
        userDatabase = UserDatabase.getDatabase(context);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                userDatabase.getDao().insertUser(user);
            }
        });

    }

}
