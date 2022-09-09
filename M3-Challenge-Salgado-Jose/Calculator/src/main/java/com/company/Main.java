package com.company;

public class Main {
    public static void main(String[] args) {
        // User stories
        Calculator calculator = new Calculator();
        int a = 10;
        int b = 3;

        // As a user, I would like to add integers and receive the result.
        System.out.println(a + " + " + b + " = " + calculator.add(a, b));

        //As a user, I would like to subtract integers and receive the result.
        System.out.println(a + " - " + b + " = " + calculator.subtract(a, b));

        //As a user, I would like to multiply integers and receive the result.
        System.out.println(a + " * " + b + " = " + calculator.multiply(a, b));
    }
}
