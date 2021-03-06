package com.comejia.springselenium.basic_injection;

import org.springframework.stereotype.Component;

@Component
public class User {

    private final Address address;
    private final Salary salary;

    public User(Address address, Salary salary) {
        this.address = address;
        this.salary = salary;
    }

    public void printDetails() {
        System.out.println("Address: " + this.address.getStreet());
        System.out.println("Salary: " + this.salary.getAmount());
    }

    public void printDefaultValues() {
        System.out.println("Address: " + this.address.getAddress());
        System.out.println("Price: " + this.salary.getPrice());
        System.out.println("IVA: " + this.salary.getIva());
    }
}
