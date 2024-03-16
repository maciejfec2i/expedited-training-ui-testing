package com.automationexercise.utilities.data.builders;

import com.automationexercise.utilities.data.models.User;
import com.automationexercise.utilities.data.models.user.Address;
import com.automationexercise.utilities.data.models.user.Name;

public class UserBuilder {

    private Name name;
    private String email;
    private String password;
    private Address address;
    private String phoneNumber;

    public UserBuilder() {
    }

    public UserBuilder setName(Name name) {
        this.name = name;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder setAddress(Address address) {
        this.address = address;
        return this;
    }

    public UserBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public User build() {
        return new User(this.name, this.email, this.password, this.address, this.phoneNumber);
    }
}
