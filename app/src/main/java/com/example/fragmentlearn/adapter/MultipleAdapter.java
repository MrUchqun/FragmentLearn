package com.example.fragmentlearn.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentlearn.R;
import com.example.fragmentlearn.model.Post;

import java.util.ArrayList;

public class MultipleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Post> posts;

    private final int ITEM_VIEW_TYPE_IMAGE = 0;
    private final int ITEM_VIEW_TYPE_VIDEO = 1;

    public MultipleAdapter(Context context, ArrayList<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == ITEM_VIEW_TYPE_IMAGE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_post, parent, false);
            return new BaseAdapter.ImagePostViewHolder(view);
        }

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video_post, parent, false);
        return new BaseAdapter.VideoPostViewHolder(view);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Post post = posts.get(position);

        if (holder instanceof BaseAdapter.ImagePostViewHolder){
            ((BaseAdapter.ImagePostViewHolder) holder).profile.setImageResource(post.getProfile());
            ((BaseAdapter.ImagePostViewHolder) holder).userName.setText(post.getUserName());
            ((BaseAdapter.ImagePostViewHolder) holder).post.setImageResource(post.getResource());
            ((BaseAdapter.ImagePostViewHolder) holder).countLikes.setText(post.getCountLikes() + " likes");
            ((BaseAdapter.ImagePostViewHolder) holder).postText.setText(post.getPostText());
            ((BaseAdapter.ImagePostViewHolder) holder).profileSmile.setImageResource(post.getProfile());
        }

        if (holder instanceof BaseAdapter.VideoPostViewHolder){
            ((BaseAdapter.VideoPostViewHolder) holder).profile.setImageResource(post.getProfile());
            ((BaseAdapter.VideoPostViewHolder) holder).userName.setText(post.getUserName());
            ((BaseAdapter.VideoPostViewHolder) holder).post.setVideoURI(post.getResourceVideo());
            ((BaseAdapter.VideoPostViewHolder) holder).countLikes.setText(post.getCountLikes() + " likes");
            ((BaseAdapter.VideoPostViewHolder) holder).postText.setText(post.getPostText());
            ((BaseAdapter.VideoPostViewHolder) holder).profileSmile.setImageResource(post.getProfile());

            ((BaseAdapter.VideoPostViewHolder) holder).post.start();
        }
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    @Override
    public int getItemViewType(int position) {
        return (posts.get(position).isVideo())? ITEM_VIEW_TYPE_VIDEO : ITEM_VIEW_TYPE_IMAGE;
    }
}
