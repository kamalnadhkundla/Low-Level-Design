package DesignCarParking.Entities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Floor {
     private static final AtomicInteger counter = new AtomicInteger(0);

    int id;
   Map<String, Spot> spots;

    public Floor(){
        spots= new HashMap<>();
      id=  counter.incrementAndGet();
    }
    public void addSpot(Spot s){
      spots.put(s.getId(),s);
    }
       public synchronized Optional<Spot> findAvailableSpot(Vehicle vehicle) {
        return spots.values().stream()
                .filter(spot -> !spot.isOccupied && spot.canFit(vehicle))
                .sorted(Comparator.comparing(Spot::getVehicleType))
                .findFirst();
    }
    public void showAvailableSpots(){
        System.out.println("floor number"+this.id);
       Map<VehicleType,Long> avaialableCounts= spots.values().stream().filter(s->!s.isOccupied).collect(Collectors.groupingBy(
        s->s.getVehicleType(),Collectors.counting()
       ));

       for(Entry<VehicleType, Long> entry : avaialableCounts.entrySet() ){
        System.out.println("Vehicle Type :"+entry.getKey()+"available"+":"+entry.getValue());
       }
    }
    
}
