package fr.efrei.repository;

import fr.efrei.domain.Reservation;

import java.util.List;

public interface IReservationRepository extends IRepository<Reservation,String>{

    List<Reservation> getall();
}
