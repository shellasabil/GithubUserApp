package com.example.githubuserapp.api;

import com.example.githubuserapp.model.ItemUser;
import com.example.githubuserapp.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GitHubService {
    @GET("search/users")
    @Headers("Authorization: Bearer " + TOKEN)
    Call<UserResponse> getUsers(@Query("q") String username);

    @GET("users/{username}")
    Call<ItemUser> getDetailUser(@Path("username") String username);

    String TOKEN = "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";
}
