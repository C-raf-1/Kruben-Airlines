package fr.efrei;

import fr.efrei.domain.Customer;
import fr.efrei.domain.Flight;
import fr.efrei.domain.Plane;
import fr.efrei.domain.Reservation;
import fr.efrei.repository.*;
import java.time.LocalDate;
import java.util.*;
import static fr.efrei.factory.FlightFactory.createFlight;
import static fr.efrei.factory.PlaneFactory.creatPlane;
import static fr.efrei.view.CustomerView.askingInformation;
import static fr.efrei.view.CustomerView.menu4;
import static fr.efrei.view.FlightView.BookingFlightAndCreateReservation;
import static fr.efrei.view.PlaneView.menu3;
import static fr.efrei.view.ReservationView.*;

public class Main {
    public static void main(String[] args) {
        IReservationRepository repositoryR = ReservationRepository.getRepository();
        IPlaneRepository repositoryP = PlaneRepository.getRepository();
        IFlightRepository repositoryF = FlightRepository.getRepository();
        Scanner scanner = new Scanner(System.in);
        List<Reservation> reservationList = null;
        Plane plane1 = creatPlane("FB554", "A300");
        Plane plane2 = creatPlane("FB45","A330");
        Plane plane3 = creatPlane("FB59","B777");
        repositoryP.create(plane1);
        repositoryP.create(plane2);
        repositoryP.create(plane3);
        Customer customer1;
        customer1 = askingInformation(); //creation de l'utilisateur
        ArrayList<String> alreadyType = new ArrayList<>();
        LocalDate date = checkDate();
        Flight flight1 = createFlight(plane1.getIdPlane(), date);
        Flight flight2 = createFlight(plane2.getIdPlane(), date);
        Flight flight3 = createFlight(plane3.getIdPlane(), date);
        flight1 = repositoryF.create(flight1);
        flight2 = repositoryF.create(flight2);
        flight3 = repositoryF.create(flight3);

        while (true) {//debut du menu
            System.out.println("\n" + "type 1 to books a flight \n" + "type 2 to see your booking \n" + "type 3 to see the seats of our 3 planes \n" + "type 4 to manage your information");
            String choice = scanner.nextLine();
            String seaty = null;
            int seatx = 0;
            int isGood = 0;
            switch (choice) {
                case "1": //cas pour choisir les vols
                    System.out.println(flight1+"\n"+flight2+"\n"+flight3+"\n");
                    String flightChoice;
                    while(true) {
                        System.out.println("choose your flight or tap 4 to go back ");
                        flightChoice = scanner.nextLine();
                        boolean exists = false;
                        if(flightChoice.equals("4")){
                            break;
                        }
                        if (alreadyType.contains(flightChoice)) {
                            System.out.println("Value already exists! Please enter a different value.");
                        } else {
                            // Ajouter le vol à la liste si ce n'est pas un doublon
                            alreadyType.add(flightChoice);
                            exists = true;
                        }
                        if (exists){
                            break;
                        }
                    }//on verifie que le user ne puisse pas reserver 2 fois le meme vol
                    if (flightChoice.equals("1")||flightChoice.equals("2")||flightChoice.equals("3")){
                        Reservation reservation1;
                        reservation1 = BookingFlightAndCreateReservation(plane1,plane2,plane3,flight1,flight2,flight3,customer1,flightChoice);
                        repositoryR.create(reservation1);//on ajoute la reservation a la ligne.
                        System.out.println("your reservation number is : " + reservation1.getIdBooking());
                    }
                    break;
                case "2":
                    reservationList = repositoryR.getall();
                    alreadyType = menu2(reservationList,isGood,seaty,seatx,alreadyType);
                    break;
                case "3":
                    menu3(plane1,plane2,plane3);
                    break;
                case "4":
                    customer1 = menu4(customer1);
                    break;
                default:
                    System.out.println("invalid input");
            }
        }
    }
}
