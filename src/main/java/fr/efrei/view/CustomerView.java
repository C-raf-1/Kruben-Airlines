package fr.efrei.view;

import fr.efrei.domain.Customer;

import java.util.Scanner;

import static fr.efrei.factory.CustomerFactory.createCustomer;

public class CustomerView {
    public static Customer askingInformation(){
        Scanner scanner = new Scanner(System.in);
        Customer customer = null;
        while(customer == null) {
            System.out.println("pour poursuivre votre inscription veuillez vous identifier");
            System.out.println("PassportId : ");
            String numberPassport = scanner.nextLine();
            System.out.println("nom : ");
            String name = scanner.nextLine();
            System.out.println("prenom : ");
            String lastName = scanner.nextLine();
            String date;
            while(true) {
                System.out.println("Date : ");
                date = scanner.nextLine();
                if (date.length() == 10) {
                    // La date a bien 10 caractères
                    break;
                }else {
                    System.out.println("Date not valid");
                }
            }
            System.out.println("Mail : ");
            String mail = scanner.nextLine();
            String accountType;
            while(true) {
                System.out.println("what is the amount in your account : ");
                accountType = scanner.nextLine();
                if (accountType.matches("-?\\d+")){
                    break;
                }
            }// on verifie que c'est bien un int
            int account = Integer.parseInt(accountType);

            customer = createCustomer(numberPassport, name, lastName, date, mail, account);
            if (!(customer == null)) {
                break;
            }
        }
        return customer;
    }

    public static Customer menu4(Customer customer1){
        Scanner scanner = new Scanner(System.in);
        System.out.println("type 1 to see your informations or 2 to modify your information");
        String choix = scanner.nextLine();
        switch (choix){
            case "1":
                System.out.println(customer1);
                break;
            case "2":
                customer1 = askingInformation();
                break;
        }
        return customer1;
    }

}