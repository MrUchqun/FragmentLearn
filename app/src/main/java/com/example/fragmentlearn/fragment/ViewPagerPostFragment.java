package com.example.fragmentlearn.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentlearn.R;
import com.example.fragmentlearn.activity.BaseFragment;
import com.example.fragmentlearn.adapter.MultipleAdapter;
import com.example.fragmentlearn.model.Post;

public class ViewPagerPostFragment extends BaseFragment {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_custom_multiple, container, false);
        initView(view);
        refreshAdapter();
        return view;
    }


    private void refreshAdapter() {

        Post postOne = new Post(R.drawable.im_post_3,
                "feruza_karimova",
                R.drawable.im_post_1,
                455,
                "Ha ha ha ha ...",
                false
        );

        Post postTwo = new Post(R.drawable.im_post_4,
                "ibrat_mirzayev",
                Uri.parse("android.resource://com.example.fragmentlearn/raw/video_post_2"),
                800,
                "Zo'r zo'r zo'r ...",
                true
        );

        MultipleAdapter adapter = new MultipleAdapter(getContext(), getPosts(postOne, postTwo));
        recyclerView.setAdapter(adapter);
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.view_recycler_multiple);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

}
