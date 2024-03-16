package com.automationexercise.utilities.data.builders.user;

import com.automationexercise.utilities.data.models.user.Name;

public class NameBuilder {

    private String firstName;
    private String lastName;

    public NameBuilder() {
    }

    public NameBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public NameBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Name build() {
        return new Name(this.firstName, this.lastName);
    }
}
