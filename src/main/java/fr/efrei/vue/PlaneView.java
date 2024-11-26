package fr.efrei.vue;

import fr.efrei.domain.Plane;

public class PlaneView {
    public static void display3Plane(Plane plane1,Plane plane2,Plane plane3){
        System.out.println("Seats of the first plane :");
        plane1.displaySeat();
        System.out.println("\n"+"Seats of the second plane :");
        plane2.displaySeat();
        System.out.println("\n"+"Seats of the third plane :");
        plane3.displaySeat();
    }
}
