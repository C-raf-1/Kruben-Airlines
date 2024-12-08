package fr.efrei.repository;

import fr.efrei.domain.Flight;


import java.util.ArrayList;
import java.util.List;

public class FlightRepository implements IFlightRepository {
    private static IFlightRepository repository = null;
    private List<Flight> flightList;
    private FlightRepository(){
        flightList = new ArrayList<Flight>();
    }

    public static IFlightRepository getRepository(){
        if (repository == null){
            repository = new FlightRepository();
        }
        return repository;
    }
    @Override
    public Flight create(Flight flight) {
        boolean success = flightList.add(flight);
        if(success){
            return flight;
        }
        return null;
    }

    @Override
    public Flight read(String id) {
        for (Flight e : flightList){
            if(e.getIdFlight().equals(id)){
                return e;
            }
        }
        return null;
    }

    @Override
    public Flight update(Flight flight) {
        String id = flight.getIdFlight();
        Flight flightOld = read(id);
        if (flightOld == null){
            return null;
        }
        boolean success = delete(id);
        if(success){
            if(flightList.add(flight)){
                return flight;
            }
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Flight flightToDelete = read(id);
        if (flightToDelete == null){
            return false;
        }
        return (flightList.remove(flightToDelete));
    }

    @Override
    public List<Flight> getall() {
        return flightList;
    }
}