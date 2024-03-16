package com.automationexercise.utilities.data.models.user;

public class Address {

    private String addressLine1;
    private String country;
    private String state;
    private String city;
    private String zipcode;

    public Address(String addressLine1, String country, String state, String city, String zipcode) {
        this.addressLine1 = addressLine1;
        this.country = country;
        this.state = state;
        this.city = city;
        this.zipcode = zipcode;
    }

    public String getAddressLine1() {
        return this.addressLine1;
    }

    public String getCountry() {
        return this.country;
    }

    public String getState() {
        return this.state;
    }

    public String getCity() {
        return this.city;
    }

    public String getZipcode() {
        return this.zipcode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressLine1='" + addressLine1 + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}
