package com.example.githubuserapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserResponse {
    @SerializedName("total_count")
    private int totalCount;

    @SerializedName("incomplete_results")
    private boolean incompleteResults;

    @SerializedName("items")
    private List<ItemUser> items;
    public List<ItemUser> getItems() {
        return items; // Metode getItems() untuk mengakses list pengguna
    }
}
