package com.example.fragmentlearn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.fragmentlearn.model.Post;

import java.util.ArrayList;

public class BaseFragment extends Fragment {

    public ArrayList<Post> getPosts(Post postOne, Post postTwo) {

        ArrayList<Post> posts = new ArrayList<Post>();

        for (int i = 1; i <= 20; i++) {
            posts.add( (i % 4 == 0) ? postTwo : postOne);
        }

        return posts;
    }

}
