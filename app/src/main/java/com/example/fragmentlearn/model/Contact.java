package com.example.fragmentlearn.model;

import android.net.Uri;

public class Contact {

    String fullName;
    Uri image;
    String phoneNumber;

    public Contact() {

    }

    public Contact(String fullName, Uri image, String phoneNumber) {
        this.fullName = fullName;
        this.image = image;
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Uri getImage() {
        return image;
    }

    public void setImage(Uri image) {
        this.image = image;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
