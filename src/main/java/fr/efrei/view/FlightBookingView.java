package fr.efrei.view;


import fr.efrei.domain.Customer;
import fr.efrei.domain.Flight;
import fr.efrei.domain.Plane;
import fr.efrei.domain.Reservation;
import fr.efrei.repository.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import static fr.efrei.factory.ReservationFactory.createReservation;
import static fr.efrei.view.ReservationView.checkSeat;

public class FlightBookingView {

    public static LocalDate checkDate(){
        Scanner scanner = new Scanner(System.in);
        String inputDate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = null;
        while (true) {
            System.out.println("Which date would you like to travel to? (format: yyyy-MM-dd)");

            inputDate = scanner.nextLine();
            try {
                // Tente de convertir la chaîne en LocalDate
                date = LocalDate.parse(inputDate, formatter);

                // Vérifie si la date est antérieure à aujourd'hui
                if (date.isBefore(LocalDate.now())) {
                    System.out.println("The date cannot be earlier than today. Please enter a valid date.");
                } else {
                    // Date valide
                    break;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use the format yyyy-MM-dd.");
            }
        }
        return date;
    }

    public static Reservation Menu1(Plane plane1, Plane plane2, Plane plane3, Flight flight1, Flight flight2, Flight flight3, Customer customer1,String flightChoice){
        Scanner scanner = new Scanner(System.in);
        IPlaneRepository repositoryP = PlaneRepository.getRepository();
        IFlightRepository repositoryF = FlightRepository.getRepository();
        Plane planeChoose = null;
        Flight flightChoose = null;
        int isGood = 0;
        Reservation reservation1 = null;
        String seaty = null;
        int seatx = 10;
        switch (flightChoice){
            case "1":
                planeChoose = repositoryP.read(plane1.getIdPlane());
                flightChoose = repositoryF.read(flight1.getIdFlight());
                while (isGood == 0){
                    String[] seat; //tableau
                    plane1.displaySeat();
                    seat = checkSeat();
                    seaty = seat[0];
                    seatx = Integer.parseInt(seat[1]); // Convertir la chaîne en entier
                    isGood = plane1.changeSeat(seaty, seatx);
                }
                plane1.displaySeat();
                break;

            case "2":
                planeChoose = repositoryP.read(plane2.getIdPlane());
                flightChoose = repositoryF.read(flight2.getIdFlight());
                while (isGood == 0){
                    String[] seat; //tableau
                    plane2.displaySeat();
                    seat = checkSeat();
                    seaty = seat[0];
                    seatx = Integer.parseInt(seat[1]); // Convertir la chaîne en entier
                    isGood = plane2.changeSeat(seaty, seatx);
                }
                plane2.displaySeat();
                break;

            case "3":
                planeChoose = repositoryP.read(plane3.getIdPlane());
                flightChoose = repositoryF.read(flight3.getIdFlight());
                while (isGood == 0){
                    String[] seat; //tableau
                    plane3.displaySeat();
                    seat = checkSeat();
                    seaty = seat[0];
                    seatx = Integer.parseInt(seat[1]); // Convertir la chaîne en entier
                    isGood = plane3.changeSeat(seaty, seatx);
                }
                plane3.displaySeat();
                break;

            case "4":
                break;

            default:
                System.out.println("invalid input");
        }
        if (isGood == 1) { // je retourn 1 si la reservation a marcher et 0 sino
            reservation1 = createReservation(flightChoose.getDate(), seaty, seatx, customer1.getName(), customer1.getLastName(), planeChoose.getIdPlane(), flightChoose.getIdFlight(), flightChoose.getDestination(), flightChoose.getDeparture());
            System.out.println("you can use your credit card to pay");
            System.out.println("Type your confidential code");
            String code = scanner.nextLine();
            customer1.setAccount(customer1.getAccount()- flightChoose.getPrice());

        }
        return reservation1;
    }

}