package fr.efrei.domain;

import java.time.LocalDate;

public class Flight {
    String idFlight;
    String destination;
    String departure;
    String idPlane;
    int price;
    LocalDate date;


    private Flight(FlightBuilder builder) {
        this.idFlight = builder.idFlight;
        this.destination = builder.destination;
        this.departure = builder.departure;
        this.idPlane = builder.idPlane;
        this.price = builder.price;
        this.date = builder.date;
    }


    public String getIdFlight() {
        return idFlight;
    }

    public String getDestination() {
        return destination;
    }

    public String getDeparture() {
        return departure;
    }

    public String getIdPlane() {
        return idPlane;
    }

    public int getPrice() {
        return price;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Flight :\n"
                +"=========================================================================\n"+
                "➜ Flight number : " + idFlight + "\n" +
                "➜ destination : " + destination + "\n" +
                "➜ departure : " + departure + "\n" +
                "➜ Plane number : " + idPlane + "\n" +
                "➜ price : " + price + "\n" +
                "➜ date : " + date + "\n" +
                "===========================================================================\n"
                +" ";
    }

    public static class FlightBuilder {
        String idFlight;
        String destination;
        String departure;
        String idPlane;
        int price;
        LocalDate date;

        public FlightBuilder setIdFlight(String idFlight) {
            this.idFlight = idFlight;
            return this;
        }

        public FlightBuilder setDestination(String destination) {
            this.destination = destination;
            return this;
        }

        public FlightBuilder setDeparture(String departure) {
            this.departure = departure;
            return this;
        }

        public FlightBuilder setIdPlane(String idPlane) {
            this.idPlane = idPlane;
            return this;
        }

        public FlightBuilder setPrice(int price) {
            this.price = price;
            return this;
        }

        public FlightBuilder setDate(LocalDate date) {
            this.date = date;
            return this;
        }


        public Flight build() {
            return new Flight(this);
        }
    }
}