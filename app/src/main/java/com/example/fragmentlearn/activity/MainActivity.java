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
import com.example.fragmentlearn.fragment.FirstFragmentContact;

import java.security.Permission;

public class MainActivity extends AppCompatActivity {

    Context context;
    Button button;
    Button buttonContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        context = this;
        button = findViewById(R.id.btn_fragment);
        buttonContact = findViewById(R.id.btn_contact);

        button.setOnClickListener(new View.OnClickListener() {
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
    }
}