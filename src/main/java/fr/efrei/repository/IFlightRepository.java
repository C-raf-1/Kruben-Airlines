package fr.efrei.repository;

import fr.efrei.domain.Flight;
import fr.efrei.domain.Plane;

import java.util.List;

public interface IFlightRepository extends IRepository<Flight,String>{
    List<Flight> getall();
}
