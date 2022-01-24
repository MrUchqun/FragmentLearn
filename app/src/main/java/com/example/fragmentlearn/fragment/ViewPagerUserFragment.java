package com.example.fragmentlearn.fragment;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentlearn.R;
import com.example.fragmentlearn.adapter.ContactAdapter;
import com.example.fragmentlearn.adapter.UserAdapter;
import com.example.fragmentlearn.helper.ClickedContact;
import com.example.fragmentlearn.model.Contact;
import com.example.fragmentlearn.model.User;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerUserFragment extends Fragment {

    RecyclerView recyclerView;

    public static ViewPagerUserFragment newInstance(ArrayList<User> users) {
        ViewPagerUserFragment fragment = new ViewPagerUserFragment();

        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("USERS", users);

        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmant_user_list, container, false);
        initView(view);
        refreshAdapter();
        return view;
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.view_recycler_user);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    private void refreshAdapter() {

        ArrayList<User> users = new ArrayList<>();

        if (getArguments() != null){
            users = getArguments().getParcelableArrayList("USERS");
        }

        UserAdapter adapter = new UserAdapter(getContext(),users);
        recyclerView.setAdapter(adapter);
    }


}

