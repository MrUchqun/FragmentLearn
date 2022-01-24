package com.example.fragmentlearn.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentlearn.R;
import com.google.android.material.imageview.ShapeableImageView;

public class BaseAdapter  {

    public static class ImagePostViewHolder extends RecyclerView.ViewHolder {

        ShapeableImageView profile;
        TextView userName;
        ImageView post;
        TextView countLikes;
        TextView postText;
        ShapeableImageView profileSmile;

        public ImagePostViewHolder(@NonNull View itemView) {
            super(itemView);
            this.profile = itemView.findViewById(R.id.iv_profile_img_post);
            this.userName = itemView.findViewById(R.id.tv_profile_img_post);
            this.post = itemView.findViewById(R.id.iv_post);
            this.countLikes = itemView.findViewById(R.id.tv_count_like_img_post);
            this.postText = itemView.findViewById(R.id.tv_post_img_post);
            this.profileSmile = itemView.findViewById(R.id.iv_profile_img_post_smile);
        }
    }

    public static class VideoPostViewHolder extends RecyclerView.ViewHolder {

        ShapeableImageView profile;
        TextView userName;
        VideoView post;
        TextView countLikes;
        TextView postText;
        ShapeableImageView profileSmile;

        public VideoPostViewHolder(@NonNull View itemView) {
            super(itemView);
            this.profile = itemView.findViewById(R.id.iv_profile_video_post);
            this.userName = itemView.findViewById(R.id.tv_profile_video_post);
            this.post = itemView.findViewById(R.id.vv_post);
            this.countLikes = itemView.findViewById(R.id.tv_count_like_video_post);
            this.postText = itemView.findViewById(R.id.tv_post_video_post);
            this.profileSmile = itemView.findViewById(R.id.iv_profile_video_post_smile);
        }
    }

}
