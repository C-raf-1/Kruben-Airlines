package fr.efrei.factory;

import fr.efrei.domain.Flight;
import fr.efrei.domain.Plane;
import fr.efrei.util.Helper;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.Random;

public class FlightFactory {
    public static Flight createFlight(String idPlane, LocalDate date) {

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
        if (Helper.isNullOrEmpty(idPlane)) {
            return null;
        }
        int price = 400 + (int)(Math.random() * (701 - 400));
        long seed = generateSeed(idPlane, date);
        Random random = new Random(seed);

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

        return new Flight.FlightBuilder()
                .setIdFlight(idFlight)
                .setDestination(destination)
                .setDeparture(departure)
                .setIdPlane(idPlane)
                .setPrice(price)
                .setDate(date)
                .build();
    }

    private static long generateSeed(String idPlane, LocalDate date) {
        String input = idPlane + date;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            // Convertir les premiers 8 octets du hash en un long
            long seed = 0;
            for (int i = 0; i < Math.min(8, hash.length); i++) {
                seed = (seed << 8) | (hash[i] & 0xff);
            }
            return seed;
        } catch (NoSuchAlgorithmException e) {
            // Fallback si SHA-256 n'est pas disponible
            return input.hashCode();
        }
    }
}