package com.example.fragmentlearn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.fragmentlearn.R;
import com.example.fragmentlearn.adapter.ViewPagerAdapter;
import com.example.fragmentlearn.fragment.ViewPagerContactFragment;
import com.example.fragmentlearn.fragment.ViewPagerPostFragment;
import com.example.fragmentlearn.fragment.ViewPagerUserFragment;
import com.example.fragmentlearn.model.User;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class ViewPagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        initViews();
    }

    private void initViews() {

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.add(new ViewPagerContactFragment(), "Contacts");
        viewPagerAdapter.add(ViewPagerUserFragment.newInstance(getUsers()), "Users");
        viewPagerAdapter.add(new ViewPagerPostFragment(), "Posts");

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(viewPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }

    private ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        for (int i = 1; i < 31; i++) {
            users.add(new User("User Number " + i, "Mobile Developer"));
        }
        return users;
    }
}