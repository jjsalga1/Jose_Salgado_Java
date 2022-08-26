package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        // For loop method
        /*int sum = 0;
        for (AccountRecord charge : charges) {
            sum += charge.getCharge();
        }
        return sum;*/

        // Stream method
        return this.charges.stream()
                .mapToInt(AccountRecord::getCharge)
                .sum();
    }

    public List<AccountRecord> getCharges() {
        return charges;
    }

    @Override
    public String toString() {
        return String.format("{ID: %d, Name: %s, Balance: %d}", this.id, this.name, this.getBalance());
    }
}
