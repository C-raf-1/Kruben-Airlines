package fr.efrei.repository;

import fr.efrei.domain.Plane;
import fr.efrei.domain.Reservation;

import java.util.ArrayList;
import java.util.List;

public class PlaneRepository implements IPlaneRepository {
    private static IPlaneRepository repository = null;
    private List<Plane> planeList;
    private PlaneRepository(){
        planeList = new ArrayList<Plane>();
    }

    public static IPlaneRepository getRepository(){
        if (repository == null){
            repository = new PlaneRepository();
        }
        return repository;
    }
    @Override
    public Plane create(Plane plane) {
        boolean success = planeList.add(plane);
        if(success){
            return plane;
        }
        return null;
    }

    @Override
    public Plane read(String id) {
        for (Plane e : planeList){
            if(e.getIdPlane().equals(id)){
                return e;
            }
        }
        return null;
    }

    @Override
    public Plane update(Plane plane) {
        String id = plane.getIdPlane();
        Plane planeOld = read(id);
        if (planeOld == null){
            return null;
        }
        boolean success = delete(id);
        if(success){
            if(planeList.add(plane)){
                return plane;
            }
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Plane planeToDelete = read(id);
        if (planeToDelete == null){
            return false;
        }
        return (planeList.remove(planeToDelete));
    }

    @Override
    public List<Plane> getall() {
        return planeList;
    }
}
