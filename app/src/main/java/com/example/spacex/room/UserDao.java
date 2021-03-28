package com.example.spacex.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.spacex.model.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM `table`")
    LiveData<List<User>> getAllUsers();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User users);

    @Query("DELETE FROM `table`")
    void deleteAll();

}
