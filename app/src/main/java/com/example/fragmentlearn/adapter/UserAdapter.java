package com.example.fragmentlearn.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentlearn.R;
import com.example.fragmentlearn.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<User> users;

    public UserAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        User user = users.get(position);
        if (holder instanceof UserViewHolder){
            ((UserViewHolder) holder).textViewName.setText(user.getName());
            ((UserViewHolder) holder).textViewWork.setText(user.getWork());
        }
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    private class UserViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewWork;

        public UserViewHolder(View view) {
            super(view);
            textViewName = view.findViewById(R.id.tv_user_name);
            textViewWork = view.findViewById(R.id.tv_user_work);
        }
    }
}
