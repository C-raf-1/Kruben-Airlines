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
    }

}
