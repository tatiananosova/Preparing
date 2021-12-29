package com.interview.preparing.homework1;

public class PersonBuilder {
    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    public PersonBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonBuilder middleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public PersonBuilder country(String country) {
        this.country = country;
        return this;
    }

    public PersonBuilder address(String address) {
        this.address = address;
        return this;
    }

    public PersonBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }

    public PersonBuilder age(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder gender(String gender) {
        this.gender = gender;
        return this;
    }

    public Person build() {
        return new Person(firstName, lastName, middleName, country, address, phone, age, gender);
    }
}
