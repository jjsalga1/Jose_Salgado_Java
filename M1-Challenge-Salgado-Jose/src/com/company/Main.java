package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    public static void main(String[] args) {
        // Create customer array
        List<Customer> customers = new ArrayList<>();

        // Go through all customer data
        for (String[] data : customerData) {
            // Filter out existing customer
            Optional<Customer> existing = customers.stream()
                    .filter(customer -> customer.getId() == Integer.parseInt(data[0]))
                    .findFirst();
            Customer currentCustomer = null;

            // If customer exists, set current customer
            if (existing.isPresent()) {
                currentCustomer = existing.get();
            }

            // If no customer exists, create one
            if (currentCustomer == null) {
                Customer newCustomer = new Customer();
                newCustomer.setId(Integer.parseInt(data[0]));
                newCustomer.setName(data[1]);

                // Add new customer to list
                customers.add(newCustomer);

                // Set current customer to new customer to add charge
                currentCustomer = newCustomer;
            }

            // Charge added to existing or created customer
            AccountRecord charge = new AccountRecord();
            charge.setCharge(Integer.parseInt(data[2]));
            charge.setChargeDate(data[3]);
            currentCustomer.addCharge(charge);
        }

        // Using streams to find account balances
        System.out.println("Positive accounts:");
        customers.stream()
                .filter(customer -> customer.getBalance() > 0)
                .forEach(System.out::println);
        System.out.println("Negative accounts:");
        customers.stream()
                .filter(customer -> customer.getBalance() < 0)
                .forEach(System.out::println);
    }
}
