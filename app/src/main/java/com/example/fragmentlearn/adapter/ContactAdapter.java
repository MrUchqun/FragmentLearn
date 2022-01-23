package com.example.fragmentlearn.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentlearn.R;
import com.example.fragmentlearn.fragment.FirstFragmentContact;
import com.example.fragmentlearn.fragment.SecondFragmentContact;
import com.example.fragmentlearn.helper.ClickedContact;
import com.example.fragmentlearn.model.Contact;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Contact> contacts;
    private final ClickedContact clickedContact;

    public ContactAdapter(Context context, List<Contact> contacts, ClickedContact clickedContact) {
        this.context = context;
        this.contacts = contacts;
        this.clickedContact = clickedContact;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Contact contact = contacts.get(position);
        if (holder instanceof ContactViewHolder) {
            ((ContactViewHolder) holder).textView.setText(contact.getFullName());
            ((ContactViewHolder) holder).imageView.setImageURI(contact.getImage());
            ((ContactViewHolder) holder).layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickedContact.clickedContact(contact);
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    private static class ContactViewHolder extends RecyclerView.ViewHolder {

        ShapeableImageView imageView;
        TextView textView;
        LinearLayout layout;

        public ContactViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.iv_profile);
            textView = view.findViewById(R.id.tv_full_name);
            layout = view.findViewById(R.id.view_contact_click);
        }
    }

}
