package com.amicus.dz22_contactsapp;

public class Person {
    private String name;
    private  String email;
    private  String phone;

    public Person(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return  name  +
                "\ne-mail: " + email  +
                "\nphone: " + phone ;
    }

}