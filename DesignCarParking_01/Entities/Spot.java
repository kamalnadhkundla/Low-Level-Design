package DesignCarParking.Entities;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

public class Spot {

    private String id;
    private VehicleType vehicleType;
    private LocalDateTime parkedAt;   
    public boolean isOccupied;
    public Vehicle parkedVehicle;
    public Spot(VehicleType veh) {
        this.id = UUID.randomUUID().toString();
        this.vehicleType = veh;
      
    }

    public String getId() {
        return this.id;
    }

    public VehicleType getVehicleType() {
        return this.vehicleType;
    }

    public LocalDateTime getParkedAt() {
        return this.parkedAt;
    }

    public synchronized void parkVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        this.isOccupied = true;
    }

    public synchronized void unparkVehicle() {
        this.parkedVehicle = null;
        this.isOccupied = false;
    }
    public long relieveVehicleTime() {
        if (this.vehicleType == null) {
            return 0; 
        }

        LocalDateTime exitTime = LocalDateTime.now();
        Duration duration = Duration.between(parkedAt, exitTime);

        long hoursParked = duration.toHours();

       
      
        return hoursParked;
    }

    public boolean isFree() {
        return this.vehicleType == null;
    }
    public boolean canFit(Vehicle vehicle){
        if (isOccupied) return false;

        switch (vehicle.getVehicleSize()) {
            case SMALL:
                return vehicleType == VehicleType.SMALL;
            case MEDIUM:
                return vehicleType == VehicleType.MEDIUM || vehicleType == VehicleType.LARGE;
            case LARGE:
                return vehicleType == VehicleType.LARGE;
            default:
                return false;

    }
}
}
