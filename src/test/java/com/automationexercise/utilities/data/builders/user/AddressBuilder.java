package com.automationexercise.utilities.data.builders.user;

import com.automationexercise.utilities.data.models.user.Address;

public class AddressBuilder {

    private String addressLine1;
    private String country;
    private String state;
    private String city;
    private String zipcode;

    public AddressBuilder() {
    }

    public AddressBuilder setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    public AddressBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    public AddressBuilder setState(String state) {
        this.state = state;
        return this;
    }

    public AddressBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public AddressBuilder setZipcode(String zipcode) {
        this.zipcode = zipcode;
        return this;
    }

    public Address build() {
        return new Address(this.addressLine1, this.country, this.state, this.city, this.zipcode);
    }
}
