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
                .sorted(Comparator.comparingInt(this::computeAvailablePositionRate))
                .collect(Collectors.toList()).get(parkingLots.indexOf(parkingLot)+1);
    }

    private int computeAvailablePositionRate(ParkingLot parkingLot){
        return parkingLots
                .stream()
                .map(currParkingLot -> (parkingLot.capacity - parkingLot.parkedPosition.size())/currParkingLot.capacity)
                .collect(Collectors.toList()).get(parkingLots.indexOf(parkingLot));
    }

}
