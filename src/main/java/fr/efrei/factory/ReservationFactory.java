package fr.efrei.factory;

import fr.efrei.domain.Reservation;
import fr.efrei.util.Helper;

import java.util.Random;

public class ReservationFactory {


    public static Reservation createReservation(String date, String seaty, int seatx, String name, String lastName,
                                                String planeNumber, String flightNumber,
                                                String destination, String departure) {
        Random random = new Random();

        // Génère un identifiant de réservation aléatoire
        int idBookingInt = random.nextInt();
        String idBooking = String.valueOf(idBookingInt);

        if(Helper.isNullOrEmpty(date)||Helper.isNullOrEmpty(seaty)||Helper.isNullOrEmpty(name)||Helper.isNullOrEmpty(lastName)||Helper.isNullOrEmpty(planeNumber)
        ||Helper.isNullOrEmpty(flightNumber)||Helper.isNullOrEmpty(destination)||Helper.isNullOrEmpty(departure)){
            return null;
        }

        // Crée et retourne une instance de Reservation
        return new Reservation.ReservationBuilder()
                .setDate(date)
                .setIdBooking(idBooking)
                .setSeaty(seaty)
                .setSeatx(seatx)
                .setName(name)
                .setLastName(lastName)
                .setPlaneNumber(planeNumber)
                .setFlightNumber(flightNumber)
                .setDestination(destination)
                .setDeparture(departure)
                .build();
    }

}
