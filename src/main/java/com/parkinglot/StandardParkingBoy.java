package com.parkinglot;

import java.util.List;
import java.util.stream.Collectors;

public class StandardParkingBoy {
    private ParkingLot parkingLot;

    public StandardParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLot = getAvailableParkingLot(parkingLots);
    }

    private ParkingLot getAvailableParkingLot(List<ParkingLot> parkingLots){
        for(ParkingLot currParkingLot: parkingLots){
            if(!currParkingLot.isParkingLotFull()){
                System.out.print("Car is parked in Parking Lot " + (parkingLots.indexOf(currParkingLot)+1));
                return this.parkingLot = currParkingLot;
            }
        }
        return null;
    }

    public ParkingTicket park(Car car) {
        return parkingLot.park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        return parkingLot.fetch(parkingTicket);
    }
}
