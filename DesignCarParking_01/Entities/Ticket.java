package DesignCarParking.Entities;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class Ticket {
    public final static AtomicInteger counter = new AtomicInteger(0);
     private final int ticketId;
    private final Vehicle vehicle;
    private final Spot spot;
    private final long entryTimestamp;
    private long exitTimestamp;
   public long price;
    public Ticket(Vehicle vehicle, Spot spot) {
        this.ticketId = counter.incrementAndGet();
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTimestamp = new Date().getTime();
    }

    public int getTicketId() { return ticketId; }
    public Vehicle getVehicle() { return vehicle; }
    public Spot getSpot() { return spot; }
    public long getEntryTimestamp() { return entryTimestamp; }
    public long getExitTimestamp() { return exitTimestamp; }

    public void setExitTimestamp() {
        this.exitTimestamp = new Date().getTime();
    }
    public long paymentGenerator(){
        switch (vehicle.getVehicleSize()) {
            case SMALL:
                return (exitTimestamp-entryTimestamp)*5;
            case MEDIUM :
                return (exitTimestamp-entryTimestamp)*10;
            case LARGE :
                return (exitTimestamp-entryTimestamp)*15;
        
            default:
                return 0;
                
        }
               
    }
}
