package com.example.fragmentlearn.fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentlearn.R;
import com.example.fragmentlearn.adapter.ContactAdapter;
import com.example.fragmentlearn.model.Contact;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.zip.Inflater;

import android.provider.ContactsContract;

public class FirstFragmentContact extends Fragment {

    FirstFragmentContact context;
    RecyclerView recyclerView;
    List<Contact> contacts;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmant_first_contact, container, false);
        initView(view);
        checkPermission();
        refreshAdapter();
        getAllContacts();
        return view;
    }

    private void initView(View view) {
        context = this;
        contacts = new ArrayList<>();
        recyclerView = view.findViewById(R.id.view_recycler_contact);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    private void checkPermission() {
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
            //when permission is not Granted
            //Request permission
            ActivityCompat.requestPermissions
                    ((Activity) getContext(), new String[]{Manifest.permission.READ_CONTACTS}, 100);
        } else {

            //when permission is granted
            //Create Method

        }
    }

    private void getAllContacts() {
        Contact contactVO;

        ContentResolver contentResolver = getContext().getContentResolver();
        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI,
                null, null, null,
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC");

        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {

                @SuppressLint("Range") int hasPhoneNumber = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)));
                if (hasPhoneNumber > 0) {
                    @SuppressLint("Range") String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                    @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

                    contactVO = new Contact();
                    contactVO.setFullName(name);

                    Cursor phoneCursor = contentResolver.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                            new String[]{id},
                            null);

                    if (phoneCursor.moveToNext()) {
                        @SuppressLint("Range") String phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        contactVO.setPhoneNumber(phoneNumber);
                    }

                    phoneCursor.close();

                    contacts.add(contactVO);
                }
            }
        }
    }

    private void refreshAdapter() {
        ContactAdapter adapter = new ContactAdapter(getContext(), contacts);
        recyclerView.setAdapter(adapter);
    }
}

