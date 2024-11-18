package fr.efrei.domain;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Plane {
    String[][] seats;
    String name;
    String idPlane;

    private Plane(PlaneBuilder builder) {
        this.seats = builder.seats;
        this.name = builder.name;
        this.idPlane = builder.idPlane;
    }

    public String[][] getSeats() {
        return seats;
    }

    public String getName() {
        return name;
    }

    public String getIdPlane() {
        return idPlane;
    }

    @Override
    public String toString() {
        return "Plane :" +
                " name='" + name + '\'' +
                ", idPlane='" + idPlane + '\'' ;
    }

    public void displaySeat() {
        System.out.println("  A B C D");
        for (int i = 0; i < 5; i++) {
            System.out.print(i);

            for (int j = 0; j < 4; j++) {
                System.out.print(" " + seats[i][j]);
            }
            System.out.println("");
        }
    }

    public int changeSeat(String seaty, int seatx) {
        // Convertir la lettre en majuscule (au cas où l'utilisateur entrerait en minuscule)
        seaty = seaty.toUpperCase();

        // Convertir la lettre en un index numérique (par exemple, A -> 0, B -> 1, etc.)
        int seatyIndex = seaty.charAt(0) - 'A';

        // Vérifier si la position du siège est valide
        if (seatx < 5 && seatx >= 0 && seatyIndex < 4 && seatyIndex >= 0) {
            // Vérifier si le siège contient le caractère '□'
            if (this.seats[seatx][seatyIndex].equals("□")) {
                this.seats[seatx][seatyIndex] = "▼"; // Marquer le siège comme occupé
                System.out.println("Seat successfully reserved!");
                return 1;
            } else {
                System.out.println("Seat already occupied!");
                return 0;
            }
        } else {
            System.out.println("Seat position not valid");
            return  0;
        }
    }

    public static class PlaneBuilder{
        String[][] seats;
        String name;
        String idPlane;

        public PlaneBuilder setName(String name){
            this.name = name;
            return this;
        }

        public PlaneBuilder setidPlane(String idPlane){
            this.idPlane = idPlane;
            return this;
        }

        public PlaneBuilder setSeats(String[][] seats){
            this.seats = seats;
            return this;
        }

        public Plane build(){

            return new Plane(this);
        }

    }
}