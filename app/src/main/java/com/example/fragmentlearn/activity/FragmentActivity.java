package com.example.fragmentlearn.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.fragmentlearn.R;
import com.example.fragmentlearn.fragment.FirstFragment;
import com.example.fragmentlearn.fragment.SecondFragment;
import com.example.fragmentlearn.model.User;

public class FragmentActivity extends AppCompatActivity implements FirstFragment.SendDataFirst, SecondFragment.SendDataSecond {

    FirstFragment firstFragment;
    SecondFragment secondFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        initViews();
    }

    private void initViews() {
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_first, firstFragment)
                .replace(R.id.frame_second, secondFragment)
                .commit();
    }

    @Override
    public void sendDataFirst(User user) {
        secondFragment.updateSecondText(user);
    }

    @Override
    public void sendDataSecond(User user) {
        firstFragment.updateFirstText(user);
    }
}
