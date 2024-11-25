package fr.efrei.factory;

import fr.efrei.domain.Customer;
import fr.efrei.domain.Plane;

public class CustomerFactory {
    public static Customer createCustomer(String numberPassport, String name, String lastName, String date, String mail){

        return new Customer.CustomerBuilder()
                .setNumberPassport(numberPassport)
                .setName(name)
                .setLastName(lastName)
                .setDate(date)
                .setMail(mail)
                .build();

    }
}
