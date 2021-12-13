package com.cybertek.tests;

import com.cybertek.tests.day2_webdriver_basics.CloseAndQuit;
import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;

public class FirstClass {
    public static void main(String[] args) {
        System.out.println("Hello World");

        Faker faker = new Faker();

        System.out.println(faker.name().fullName());
        System.out.println("Harrry Potter characters: " + faker.harryPotter().character());

        System.out.println("Animal names: " + faker.animal().name());

        System.out.println(faker.finance().creditCard(CreditCardType.VISA));

        System.out.println("**********************");

    }
}
