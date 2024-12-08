package fr.efrei.factory;

import fr.efrei.domain.Plane;
import fr.efrei.util.Helper;

public class PlaneFactory {


    public static Plane creatPlane(String idPlane,String namePlane){
        String[][] seats = new String[5][4];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                int randomInt = (int) (Math.random() * 2); // Génère 0 ou 1
                if (randomInt == 0){
                    seats[i][j] = "□";
                }
                else{
                    seats[i][j] = "•";
                }
            }
        }
        if(Helper.isNullOrEmpty(namePlane)||Helper.isNullOrEmpty(idPlane)){
            return null;
        }
        return new Plane.PlaneBuilder()
                .setName(namePlane)
                .setidPlane(idPlane)
                .setSeats(seats).build();

    }
}
