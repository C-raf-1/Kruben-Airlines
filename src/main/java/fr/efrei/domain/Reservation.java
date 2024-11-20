package fr.efrei.domain;

public class Reservation {
    private String date;
    private String idBooking;         // Identifiant de réservation
    private String seaty;          // Lettre du siège
    private int seatx;             // Numéro de rangée du siège
    private String name;           // Prénom
    private String lastName;       // Nom de famille
    private String planeNumber;    // Numéro de l'avion
    private String flightNumber;   // Numéro du vol
    private String destination;    // Destination
    private String departure;        // Arrivée

    // Constructeur privé (utilisé par le Builder)
    private Reservation(ReservationBuilder builder) {
        this.date = builder.date;
        this.idBooking = builder.idBooking;
        this.seaty = builder.seaty;
        this.seatx = builder.seatx;
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.planeNumber = builder.planeNumber;
        this.flightNumber = builder.flightNumber;
        this.destination = builder.destination;
        this.departure = builder.departure;
    }

    // Getters

    public String getDate() {
        return date;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public String getSeaty() {
        return seaty;
    }

    public int getSeatx() {
        return seatx;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPlaneNumber() {
        return planeNumber;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public String getDeparture() {
        return departure;
    }

    // toString : Affiche les détails de la réservation
    @Override
    public String toString() {
        return " \n"+"Reservation : \n" +
                "➜ Date : "+ date + "\n"+
                "➜ idBooking : " + idBooking +"\n"+
                "➜ seat : " + seaty + seatx +"\n" +
                "➜ name : " + name +"\n" +
                "➜ lastName : " + lastName +"\n"+
                "➜ planeNumber : " + planeNumber +"\n" +
                "➜ flightNumber : " + flightNumber +"\n" +
                "➜ destination : " + destination +"\n" +
                "➜ departure : " + departure +"\n";
    }


    // Classe Builder
    public static class ReservationBuilder {
        private String date;
        private String idBooking;
        private String seaty;
        private int seatx;
        private String name;
        private String lastName;
        private String planeNumber;
        private String flightNumber;
        private String destination;
        private String departure;

        // Méthodes pour définir chaque champ
        public ReservationBuilder setDate(String date) {
            this.date = date;
            return this;
        }

        public ReservationBuilder setIdBooking(String idBooking) {
            this.idBooking = idBooking;
            return this;
        }

        public ReservationBuilder setSeaty(String seaty) {
            this.seaty = seaty;
            return this;
        }

        public ReservationBuilder setSeatx(int seatx) {
            this.seatx = seatx;
            return this;
        }

        public ReservationBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ReservationBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public ReservationBuilder setPlaneNumber(String planeNumber) {
            this.planeNumber = planeNumber;
            return this;
        }

        public ReservationBuilder setFlightNumber(String flightNumber) {
            this.flightNumber = flightNumber;
            return this;
        }

        public ReservationBuilder setDestination(String destination) {
            this.destination = destination;
            return this;
        }

        public ReservationBuilder setDeparture(String departure) {
            this.departure = departure;
            return this;
        }

        // Méthode build pour construire l'objet Reservation
        public Reservation build() {
            return new Reservation(this);
        }
    }
}

