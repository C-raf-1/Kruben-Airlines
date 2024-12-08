package fr.efrei.repository;

import fr.efrei.domain.Reservation;

import java.util.ArrayList;
import java.util.List;

public class ReservationRepository implements IReservationRepository{

    private static IReservationRepository repository = null;
    private List<Reservation> reservationList;
    private ReservationRepository(){
        reservationList = new ArrayList<Reservation>();
    }

    public static IReservationRepository getRepository(){
        if (repository == null){
            repository = new ReservationRepository();
        }
        return repository;
    }
    @Override
    public Reservation create(Reservation reservation) {
        boolean success = reservationList.add(reservation);
        if(success){
            return reservation;
        }
        return null;
    }

    @Override
    public Reservation read(String id) {
        for (Reservation e : reservationList){
            if(e.getIdBooking().equals(id)){
                return e;
            }
        }
        return null;
    }

    @Override
    public Reservation update(Reservation reservation) {
        String id = reservation.getIdBooking();
        Reservation reservationOld = read(id);
        if (reservationOld == null){
            return null;
        }
        boolean success = delete(id);
        if(success){
            if(reservationList.add(reservation)){
                return reservation;
            }
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Reservation reservationToDelete = read(id);
        if (reservationToDelete == null){
            return false;
        }
        return (reservationList.remove(reservationToDelete));
    }

    @Override
    public List<Reservation> getall() {
        return reservationList;
    }
}
