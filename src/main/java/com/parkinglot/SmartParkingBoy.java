package com.parkinglot;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SmartParkingBoy {
    private List<ParkingLot> parkingLots;
    private ParkingLot parkingLot;

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingTicket park(Car car) {
        this.parkingLot = getParkingLotWithMoreEmptyPositions(parkingLots);
        System.out.print("Car is parked in Parking Lot " + (parkingLots.indexOf(parkingLot)+1));
        return parkingLot.park(car);
    }

    private ParkingLot getParkingLotWithMoreEmptyPositions(List<ParkingLot> parkingLots){
        return parkingLots
                .stream()
                .sorted(Comparator.comparingInt(parkingLot -> parkingLot.parkedPosition.size()))
                .collect(Collectors.toList())
                .get(0);
    }
}
