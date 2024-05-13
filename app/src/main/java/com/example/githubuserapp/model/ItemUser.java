package com.example.githubuserapp.model;

import com.google.gson.annotations.SerializedName;

public class ItemUser {
    @SerializedName("login")
    private String login;

    @SerializedName("avatar_url")
    private String avatarUrl;

    @SerializedName("bio")
    private String bio;

    public String getLogin() {
        return login;
    }

    public String getBio() {
        return bio;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }
}
