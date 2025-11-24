package DesignCarParking.Entities;

import java.util.UUID;

public class Vehicle {
    String id;
    VehicleType vehicleSize;

public Vehicle(VehicleType vehicleSize){
    id = UUID.randomUUID().toString();
 this.vehicleSize = vehicleSize;
}
  
public VehicleType getVehicleSize(){
    return this.vehicleSize;
}
public String getVehicleID(){
    return this.id;
}
    
}
