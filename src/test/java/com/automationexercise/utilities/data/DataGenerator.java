package com.automationexercise.utilities.data;

import com.automationexercise.utilities.data.builders.UserBuilder;
import com.automationexercise.utilities.data.builders.user.AddressBuilder;
import com.automationexercise.utilities.data.builders.user.NameBuilder;
import com.automationexercise.utilities.data.models.User;
import com.automationexercise.utilities.data.models.user.Address;
import com.automationexercise.utilities.data.models.user.Name;
import com.github.javafaker.Faker;

import java.util.Locale;

public class DataGenerator {

    private Faker faker;

    public DataGenerator() {
        this.faker = new Faker();
    }

    public DataGenerator(Locale locale) {
        this.faker = new Faker(locale);
    }

    private String getEmailFromName(Name name) {
        return String.format("%s.%s@fakemail.com", name.getFirstName(), name.getLastName());
    }

    public User getRandomUser(Countries country) {
        Name name = new NameBuilder()
                .setFirstName(this.faker.name().firstName())
                .setLastName(this.faker.name().lastName())
                .build();

        Address address = new AddressBuilder()
                .setAddressLine1(this.faker.address().streetAddress())
                .setCountry(country.getName())
                .setState(this.faker.address().state())
                .setCity(this.faker.address().city())
                .setZipcode(this.faker.address().zipCode())
                .build();

        System.out.println("ADDRESS:\n" + address.toString());

        return new UserBuilder()
                .setName(name)
                .setEmail(this.getEmailFromName(name))
                .setPassword("P@5$w0rd127127")
                .setAddress(address)
                .setPhoneNumber(this.faker.phoneNumber().phoneNumber())
                .build();
    }
}
