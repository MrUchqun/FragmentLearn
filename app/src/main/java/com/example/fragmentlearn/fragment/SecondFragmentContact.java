package com.example.fragmentlearn.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragmentlearn.R;
import com.example.fragmentlearn.model.Contact;

public class SecondFragmentContact extends Fragment {

//    private ReceiveContact receiveContact;
    TextView description;
    LinearLayout contactInfo;
    TextView fullNameMore;
    TextView phoneNumber;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmant_second_contact,container,false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        description = view.findViewById(R.id.tv_description);
        contactInfo = view.findViewById(R.id.view_contact_info);
        fullNameMore = view.findViewById(R.id.tv_full_name_more);
        phoneNumber = view.findViewById(R.id.tv_phone_number);
    }

//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//        if (context instanceof ReceiveContact){
//            receiveContact = (ReceiveContact) context;
//        } else {
//            throw new RuntimeException(context.toString());
//        }
//    }

//    @Override
//    public void onDetach() {
//        super.onDetach();
//        receiveContact = null;
//    }

    public void updateData(Contact contact, boolean isClicked){
        if (isClicked) {
            description.setVisibility(View.GONE);
            contactInfo.setVisibility(View.VISIBLE);
            fullNameMore.setText(contact.getFullName());
            phoneNumber.setText(contact.getPhoneNumber());
        }
    }

//    public interface ReceiveContact {
//        public void receiveContact(Contact contact);
//    }
}
