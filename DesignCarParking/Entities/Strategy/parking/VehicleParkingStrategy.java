package DesignCarParking.Entities.Strategy.parking;

import java.util.List;
import java.util.Optional;
import DesignCarParking.Entities.*;
import DesignCarParking.Entities.Vehicle;

public interface VehicleParkingStrategy {


     Optional<Spot> findSpot(List<Floor> floors, Vehicle vehicle);
    
}
