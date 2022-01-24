package com.example.fragmentlearn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fragmentlearn.R;

public class MainActivity extends AppCompatActivity {

    Context context;
    Button buttonFragment;
    Button buttonContact;
    Button buttonViewPager;
    Button buttonBottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        context = this;
        checkPermission();

        buttonFragment = findViewById(R.id.btn_fragment);
        buttonContact = findViewById(R.id.btn_contact);
        buttonViewPager = findViewById(R.id.btn_view_pager);
        buttonBottomNav = findViewById(R.id.btn_bottom_nav);

        buttonFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, FragmentActivity.class));
            }
        });

        buttonContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, ContactListActivity.class));
            }
        });

        buttonViewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, ViewPagerActivity.class));
            }
        });

        buttonBottomNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, BottomNavigationActivity.class));
            }
        });
    }

    private void checkPermission() {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
            //when permission is not Granted
            //Request permission
            ActivityCompat.requestPermissions
                    ((Activity) context, new String[]{Manifest.permission.READ_CONTACTS}, 100);
        } else {

            //when permission is granted
            //Create Method

        }
    }
}