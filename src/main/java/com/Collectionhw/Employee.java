package com.Collectionhw;

public class Employee {
    private final String firstName;
    private final String lastName;

    public Employee ( String firstName, String lastName ) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return "Фамилия: " + this.lastName + ", имя: " + this.firstName;
    }
}
