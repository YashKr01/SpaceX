package com.example.spacex.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.spacex.model.User;
import com.example.spacex.room.UserDatabase;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SavedViewModel extends ViewModel {

    UserDatabase userDatabase;
    Executor executor= Executors.newSingleThreadExecutor();

    public LiveData<List<User>> getAllUsers(Context context){
        userDatabase = UserDatabase.getDatabase(context);
        return userDatabase.getDao().getAllUsers();
    }

    public void deleteAll(Context context){
        userDatabase = UserDatabase.getDatabase(context);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                userDatabase.getDao().deleteAll();
            }
        });
    }

}
