package com.example.fragmentlearn.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.fragmentlearn.R;
import com.example.fragmentlearn.fragment.ViewPagerContactFragment;
import com.example.fragmentlearn.fragment.ViewPagerPostFragment;
import com.example.fragmentlearn.fragment.ViewPagerUserFragment;
import com.example.fragmentlearn.model.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class BottomNavigationActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    ViewPagerContactFragment viewPagerContactFragment;
    ViewPagerUserFragment viewPagerUserFragment;
    ViewPagerPostFragment viewPagerPostFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        initViews();
    }

    private void initViews() {
        viewPagerContactFragment = new ViewPagerContactFragment();
        viewPagerUserFragment = ViewPagerUserFragment.newInstance(getUsers());
        viewPagerPostFragment = new ViewPagerPostFragment();

        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.bnv_user);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bnv_contact:
                getSupportFragmentManager().beginTransaction().replace(R.id.view_container, viewPagerContactFragment).commit();
                return true;

            case R.id.bnv_user:
                getSupportFragmentManager().beginTransaction().replace(R.id.view_container, viewPagerUserFragment).commit();
                return true;

            case R.id.bnv_post:
                getSupportFragmentManager().beginTransaction().replace(R.id.view_container, viewPagerPostFragment).commit();
                return true;
        }
        return false;
    }

    private ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        for (int i = 1; i < 31; i++) {
            users.add(new User("User Number " + i, "Mobile Developer"));
        }
        return users;
    }
}