package fr.efrei.factory;

import fr.efrei.domain.Flight;
import fr.efrei.domain.Plane;
import fr.efrei.util.Helper;

import java.util.Random;

public class FlightFactory {

    public static Flight createFlight( String idPlane, String date) {

        String[] Airport = new String[]{
                "Paris, France",
                "London, United Kingdom",
                "New York, USA",
                "Tokyo, Japan",
                "Dubai, UAE",
                "Sydney, Australia",
                "Berlin, Germany",
                "Rome, Italy",
                "Moscow, Russia",
                "Beijing, China",
                "Mumbai, India",
                "Cairo, Egypt",
                "São Paulo, Brazil",
                "Toronto, Canada",
                "Istanbul, Turkey",
                "Madrid, Spain",
                "Mexico City, Mexico",
                "Seoul, South Korea",
                "Bangkok, Thailand",
                "Johannesburg, South Africa"
        };
        String[] flightNumbers = new String[]{
                "FL123",
                "FL456",
                "FL789",
                "FL101",
                "FL112",
                "FL131",
                "FL415",
                "FL162",
                "FL718",
                "FL920"
        };
        Random random = new Random();

        int indexNumber = random.nextInt(flightNumbers.length);
        String idFlight = flightNumbers[indexNumber];

        // les destinations
        int index1 = random.nextInt(Airport.length);
        int index2;
        do {
            index2 = random.nextInt(Airport.length);
        } while (index1 == index2);

        String departure = Airport[index1];
        String destination = Airport[index2];

        int price = 542;

        if (Helper.isNullOrEmpty(idPlane)||Helper.isNullOrEmpty(date)){
            return null;
        }
        return new Flight.FlightBuilder()
                .setIdFlight(idFlight)
                .setDestination(destination)
                .setDeparture(departure)
                .setIdPlane(idPlane)
                .setPrice(price)
                .setDate(date)
                .build();
    }
}