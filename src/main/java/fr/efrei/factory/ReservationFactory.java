package fr.efrei.factory;

import fr.efrei.domain.Reservation;

import java.util.Random;

public class ReservationFactory {


    public static Reservation createReservation(String date, String seaty, int seatx, String name, String lastName,
                                                String planeNumber, String flightNumber,
                                                String destination, String departure) {
        Random random = new Random();

        // Génère un identifiant de réservation aléatoire
        int idBookingInt = random.nextInt();
        String idBooking = String.valueOf(idBookingInt);

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
