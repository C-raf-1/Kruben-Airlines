package fr.efrei.factory;

import fr.efrei.domain.Customer;
import fr.efrei.domain.Plane;
import fr.efrei.util.Helper;

public class CustomerFactory {
    public static Customer createCustomer(String numberPassport, String name, String lastName, String date, String mail, int account){
        if(Helper.isNullOrEmpty(numberPassport)||Helper.isNullOrEmpty(name)||Helper.isNullOrEmpty(lastName)||Helper.isNullOrEmpty(date)||Helper.isNullOrEmpty(mail)){
            return null;
        }
        return new Customer.CustomerBuilder()
                .setNumberPassport(numberPassport)
                .setName(name)
                .setLastName(lastName)
                .setDate(date)
                .setMail(mail)
                .setAccount(account)
                .build();

    }
}
