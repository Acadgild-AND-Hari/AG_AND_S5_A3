package com.hari.aag.contactslist.data;

/**
 * Created by Hari Nivas Kumar R P on 12/14/2016.
 */

public class Contact {

    private String name;
    private String phoneNumber;

    public Contact (String name, String phoneNumber){
        setName(name);
        setPhoneNumber(phoneNumber);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    private void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
