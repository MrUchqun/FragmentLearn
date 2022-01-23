package com.example.fragmentlearn.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fragmentlearn.R;
import com.example.fragmentlearn.adapter.ContactAdapter;
import com.example.fragmentlearn.fragment.FirstFragmentContact;
import com.example.fragmentlearn.fragment.SecondFragmentContact;
import com.example.fragmentlearn.model.Contact;

public class ContactListActivity extends AppCompatActivity implements FirstFragmentContact.SendContact {

    FirstFragmentContact firstFragmentContact;
    SecondFragmentContact secondFragmentContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        initView();
    }

    private void initView() {
        firstFragmentContact = new FirstFragmentContact();
        secondFragmentContact = new SecondFragmentContact();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_first_contact, firstFragmentContact)
                .replace(R.id.frame_second_contact, secondFragmentContact)
                .commit();
    }

    @Override
    public void sendContact(Contact contact) {
        secondFragmentContact.updateData(contact, true);
    }

}