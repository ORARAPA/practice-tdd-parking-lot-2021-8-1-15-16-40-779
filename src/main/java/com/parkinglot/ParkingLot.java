package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<ParkingTicket,Car> parkedPosition = new HashMap<>();
    private int capacity;

    public ParkingLot() {
    }

    public ParkingLot(int capacity) {
    }

    public ParkingTicket park(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        parkedPosition.put(parkingTicket,car);
        return parkingTicket;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        Car getCarUsingTicket = parkedPosition.get(parkingTicket);
        parkedPosition.remove(parkingTicket);
        return getCarUsingTicket;
    }
}
