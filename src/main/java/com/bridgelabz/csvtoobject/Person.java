package com.bridgelabz.csvtoobject;

public class Person {
    String name;
    String email;
    String phoneNumber;
    Person(String name, String email, String phoneNumber){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString() {
        return "Person{name='" + name + "', email='" + email + "', phoneNumber='" + phoneNumber + "'}";
    }
}
