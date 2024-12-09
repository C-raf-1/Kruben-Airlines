package fr.efrei.view;

import fr.efrei.domain.Plane;

public class PlaneView {
    public static void menu3(Plane plane1,Plane plane2,Plane plane3){
        System.out.println("Plane number 1 :");
        System.out.println(plane1);
        System.out.println("Seats of the first plane :");
        plane1.displaySeat();
        System.out.println();

        System.out.println("Plane number 2 :");
        System.out.println(plane2);
        System.out.println("Seats of the second plane :");
        plane2.displaySeat();
        System.out.println();

        System.out.println("Plane number 3 :");
        System.out.println(plane3);
        System.out.println("Seats of the third plane :");
        plane3.displaySeat();
        System.out.println();
    }
}