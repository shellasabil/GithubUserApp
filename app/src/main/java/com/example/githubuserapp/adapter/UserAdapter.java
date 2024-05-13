package com.example.githubuserapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.githubuserapp.DetailActivity;
import com.example.githubuserapp.R;
import com.example.githubuserapp.databinding.ItemUserBinding;
import com.example.githubuserapp.model.ItemUser;

import java.util.List;

public class UserAdapter extends ListAdapter<ItemUser, UserAdapter.ViewHolder> {
    public UserAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemUserBinding binding = ItemUserBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        ItemUser item = getItem(position);
        holder.bind(item);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemUserBinding binding;

        public ViewHolder(ItemUserBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(ItemUser usersItem) {
            binding.tvNameProfile.setText(usersItem.getLogin());
            Glide.with(itemView.getContext())
                    .load(usersItem.getAvatarUrl())
                    .into(binding.imageProfile);

            itemView.setOnClickListener(view -> {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("nama", usersItem.getLogin());
                view.getContext().startActivity(intent);
            });
        }
    }

    private static final DiffUtil.ItemCallback<ItemUser> DIFF_CALLBACK = new DiffUtil.ItemCallback<ItemUser>() {
        @Override
        public boolean areItemsTheSame(@NonNull ItemUser oldItem, @NonNull ItemUser newItem) {
            return false;
        }

        @Override
        public boolean areContentsTheSame(ItemUser oldItem, ItemUser newItem) {
            return oldItem.getLogin().equals(newItem.getLogin()) &&
                    oldItem.getAvatarUrl().equals(newItem.getAvatarUrl()) &&
                    (oldItem.getBio() != null ? oldItem.getBio().equals(newItem.getBio()) : newItem.getBio() == null);
        }
    };
}