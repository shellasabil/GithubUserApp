package com.example.githubuserapp;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.githubuserapp.api.Config;
import com.example.githubuserapp.databinding.ActivityDetailBinding;
import com.example.githubuserapp.model.ItemUser;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String nama = getIntent().getStringExtra("nama");

        Call<ItemUser> api = Config.getApiService().getDetailUser(nama);
        api.enqueue(new Callback<ItemUser>() {
            @Override
            public void onResponse(@NonNull Call<ItemUser> call, @NonNull Response<ItemUser> response) {
                if (response.isSuccessful()){
                    binding.textviewName.setText(response.body().getLogin());
                    binding.textviewBio.setText(response.body().getBio());
                    Glide.with(DetailActivity.this)
                            .load(response.body().getAvatarUrl())
                            .into(binding.imageviewProfile);

                }
            }

            @Override
            public void onFailure(@NonNull Call<ItemUser> call, @NonNull Throwable t) {
                Log.e("error", Objects.requireNonNull(t.getMessage()));
            }
        });
    }
}