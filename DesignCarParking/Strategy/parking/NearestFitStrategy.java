package DesignCarParking.Entities.Strategy.parking;

import java.util.List;
import java.util.Optional;

import DesignCarParking.Entities.Floor;
import DesignCarParking.Entities.Spot;
import DesignCarParking.Entities.Vehicle;

public class NearestFitStrategy implements VehicleParkingStrategy {

    @Override
    public Optional<Spot> findSpot(List<Floor> floors, Vehicle vehicle) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findSpot'");
    }
    
    
}
