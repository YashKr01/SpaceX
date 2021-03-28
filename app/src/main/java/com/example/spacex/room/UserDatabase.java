package com.example.spacex.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.spacex.model.User;

@Database(entities = User.class, version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {

    public abstract UserDao getDao();

    private static UserDatabase database;

    public static UserDatabase getDatabase(Context context) {
        if (database == null) {
            database = Room.databaseBuilder(context, UserDatabase.class, "table").build();
        }
        return database;
    }

}
