package fr.efrei.view;

import fr.efrei.domain.Plane;
import fr.efrei.domain.Reservation;
import fr.efrei.repository.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReservationView {

    public static LocalDate checkDate(){
        Scanner scanner = new Scanner(System.in);
        String inputDate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = null;
        while (true) {
            System.out.println("Which date would you like to travel to? (format: yyyy-MM-dd)");

            inputDate = scanner.nextLine();
            try {
                // Tente de convertir la chaîne en LocalDate
                date = LocalDate.parse(inputDate, formatter);

                // Vérifie si la date est antérieure à aujourd'hui
                if (date.isBefore(LocalDate.now())) {
                    System.out.println("The date cannot be earlier than today. Please enter a valid date.");
                } else {
                    // Date valide
                    break;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use the format yyyy-MM-dd.");
            }
        }
        return date;
    }
    public static void displayReservation(List<Reservation> reservationList) {
        IPlaneRepository repositoryP = PlaneRepository.getRepository();

        System.out.println("\n" + "Reservation Details:");
        for (Reservation e : reservationList) {
            System.out.println("=====================================================");
            System.out.println(e);
            Plane plane = repositoryP.read(e.getPlaneNumber());//pour recup le plan du bon avion
            plane.displaySeat();
            System.out.println("=====================================================");
        }

    }

    public static String[] checkSeat(){
        Scanner scanner = new Scanner(System.in);

        String[] result= new String[2];
        while (true) {
            System.out.println("Select a seat column (A, B, C, or D):");
            String seaty = scanner.nextLine().toUpperCase(); // Convertir en majuscules pour uniformiser

            // Vérifier si l'entrée est valide
            if (seaty.matches("[A-D]")) { // Vérifie que seaty est entre A et D
                result[0] = seaty;
                break; // Sortir de la boucle si l'entrée est valide
            } else {
                System.out.println("Invalid input! Please select a seat between A and D.");
            }
        }

        while (true) {
            System.out.println("Select seat row (0, 1, 2, 3, or 4):");
            String seatx = scanner.nextLine(); // Lire l'entrée utilisateur comme une chaîne

            // Vérifie si l'entrée est un chiffre valide
            if (seatx.matches("[0-4]")) { // Utilise une expression régulière pour valider que l'entrée est entre "0" et "4"
                result[1] = seatx;
                break;
            } else {
                System.out.println("Invalid input! Please select a row between 0 and 4.");
            }
        }
        return result;
    }

    public static ArrayList<String> permettreDeRereserverUnVol(ArrayList<String> alreadyType,Reservation reservationTemp){
        if (reservationTemp.getPlaneNumber().equals("FB554")) {
            alreadyType.removeIf(e -> e.equals("1"));
        }
        if (reservationTemp.getPlaneNumber().equals("FB45")) {
            alreadyType.removeIf(e -> e.equals("2"));
        }
        if (reservationTemp.getPlaneNumber().equals("FB59")) {
            alreadyType.removeIf(e -> e.equals("3"));
        }
        return alreadyType;
    }

    public static ArrayList<String> menu2(List<Reservation> reservationList,int isGood,String seaty,int seatx,ArrayList<String> alreadyType){
        IReservationRepository repositoryR = ReservationRepository.getRepository();
        IPlaneRepository repositoryP = PlaneRepository.getRepository();
        Scanner scanner = new Scanner(System.in);
        reservationList = repositoryR.getall();
        if (!reservationList.isEmpty()) {
            displayReservation(reservationList);//affiche les voles
            System.out.println(" \n" + "Type 1 if you want to modify your reservation");
            String modif = scanner.nextLine();

            if (modif.equals("1")) {
                System.out.println("\n" + "Type the id of your reservation");
                String idReservation = scanner.nextLine();
                Reservation reservationTemp = repositoryR.read(idReservation);//la reservation sur laquelle je vais travailler
                boolean result = false;
                for (Reservation e :reservationList){
                    if (e.getIdBooking().equals(idReservation)){
                        result = true;
                    }
                }//on verifie si l'id taper est valide
                if(result){
                    System.out.println("what do you want to do, 1 to change your seat, 2 to delete your reservation ?");
                    String choceModif = scanner.nextLine();
                    String planeNombre = reservationTemp.getPlaneNumber();//l'avion sur lequelle la reservation est

                    switch (choceModif) {
                        case "1":
                            repositoryP.read(planeNombre).deletSeat();
                            while (isGood == 0){
                                String[] seat; //tableau pour le resultat de la fonction qui test les input du user
                                seat = checkSeat();
                                seaty = seat[0];
                                seatx = Integer.parseInt(seat[1]); // Convertir la chaîne en entier si nécessaire
                                isGood = repositoryP.read(planeNombre).changeSeat(seaty, seatx);
                            }//on rereserve un siege
                            break;
                        case "2":
                            alreadyType = permettreDeRereserverUnVol(alreadyType,reservationTemp);
                            repositoryR.delete(idReservation);
                            System.out.println("your reservation has been deleted");
                            repositoryP.read(planeNombre).deletSeat();//on supprime le siege reservé de l'avion
                    }

                }else{
                    System.out.println("invalid Id");
                }

            }
        } else {
            System.out.println("No reservation found. Please create a reservation first.\n" + " ");
        }
        return alreadyType;
    }



}
