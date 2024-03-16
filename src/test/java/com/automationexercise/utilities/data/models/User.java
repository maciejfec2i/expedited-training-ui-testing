package com.automationexercise.utilities.data.models;

import com.automationexercise.utilities.data.models.user.Address;
import com.automationexercise.utilities.data.models.user.Name;

public class User {

    private Name name;
    private String email;
    private String password;
    private Address address;
    private String phoneNumber;

    public User(Name name, String email, String password, Address address, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Name getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public Address getAddress() {
        return this.address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }
}
