package com.parkinglot;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SuperSmartParkingBoy {
    private List<ParkingLot> parkingLots;
    private ParkingLot parkingLot;

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingTicket park(Car car) {
        this.parkingLot = getParkingLotWithLargerAvailablePositionRate(parkingLots);
        System.out.print("Car is parked in Parking Lot " + (parkingLots.indexOf(parkingLot)+1));
        return parkingLot.park(car);
    }

    private ParkingLot getParkingLotWithLargerAvailablePositionRate(List<ParkingLot> parkingLots){
        return parkingLots
                .stream()
                .max(Comparator.comparingInt(currParkingLot -> ((currParkingLot.capacity - currParkingLot.parkedPosition.size())/currParkingLot.capacity)))
                .get();
    }

    public Car fetch(ParkingTicket parkingTicket) {
        if(!findParkingLotRelatedTo(parkingTicket).isEmpty()){
            return findParkingLotRelatedTo(parkingTicket).get(0).fetch(parkingTicket);
        }
        throw new UnrecognizedParkingTicketException();
    }

    private List<ParkingLot> findParkingLotRelatedTo(ParkingTicket parkingTicket) {
        return parkingLots
                .stream()
                .filter(currParkingLot -> currParkingLot.parkedPosition.containsKey(parkingTicket))
                .collect(Collectors.toList());
    }
}
