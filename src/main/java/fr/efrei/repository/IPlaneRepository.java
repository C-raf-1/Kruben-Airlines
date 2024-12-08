package fr.efrei.repository;

import fr.efrei.domain.Plane;
import fr.efrei.domain.Reservation;

import java.util.List;

public interface IPlaneRepository extends IRepository<Plane,String>{
        List<Plane> getall();
    }

