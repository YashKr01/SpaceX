package com.example.spacex.api;

import com.example.spacex.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("crew")
    Call<List<User>> getAllUsers();

}
