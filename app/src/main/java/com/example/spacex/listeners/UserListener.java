package com.example.spacex.listeners;

import com.example.spacex.model.User;

public interface UserListener {

    void loadUrl(User users);

    void save(User users);

}
