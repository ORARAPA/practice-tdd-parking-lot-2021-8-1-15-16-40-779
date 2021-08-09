package com.parkinglot;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class SmartParkingBoy extends ParkingBoy {
    private final List<ParkingLot> parkingLots;
    private ParkingLot parkingLot;

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
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
                .min(Comparator.comparingInt(parkingLot -> parkingLot.parkedPosition.size()))
                .get();
    }

    public Car fetch(ParkingTicket parkingTicket) {
        Optional.ofNullable(findParkingLotRelatedTo(parkingTicket)).orElseThrow(UnrecognizedParkingTicketException::new);
        return Objects.requireNonNull(findParkingLotRelatedTo(parkingTicket)).fetch(parkingTicket);
    }

    private ParkingLot findParkingLotRelatedTo(ParkingTicket parkingTicket) {
        List<ParkingLot> currentParkingLot = parkingLots
                .stream()
                .filter(currParkingLot -> currParkingLot.parkedPosition.containsKey(parkingTicket))
                .collect(Collectors.toList());

        if(!currentParkingLot.isEmpty()){
            return this.parkingLot = currentParkingLot.get(0);
        }
        return null;

    }
}
