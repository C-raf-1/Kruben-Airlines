package fr.efrei.domain;

public class Customer {
    String numberPassport;
    String name;
    String lastName;
    String date;
    String mail;

    private Customer(Customer.CustomerBuilder builder) {
        this.numberPassport = builder.numberPassport;
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.date = builder.date;
        this.mail = builder.mail;
    }

    public String getNumberPassport() {
        return numberPassport;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDate() {
        return date;
    }

    public String getMail() {
        return mail;
    }

    public static class CustomerBuilder{
        String numberPassport;
        String name;
        String lastName;
        String date;
        String mail;


        public CustomerBuilder setNumberPassport(String numberPassport){
            this.numberPassport = numberPassport;
            return this;
        }
        public CustomerBuilder setName(String name){
            this.name = name;
            return this;
        }
        public CustomerBuilder setLastName(String lastName){
            this.lastName = lastName;
            return this;
        }
        public CustomerBuilder setDate(String date){
            this.date = date;
            return this;
        }
        public CustomerBuilder setMail(String mail){
            this.mail = mail;
            return this;
        }
        public Customer build(){

            return new Customer(this);
        }

    }
}
