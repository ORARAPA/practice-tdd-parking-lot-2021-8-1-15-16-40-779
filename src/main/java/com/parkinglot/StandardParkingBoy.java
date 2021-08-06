package com.parkinglot;

import java.util.List;
import java.util.stream.Collectors;

public class StandardParkingBoy {
    private boolean isParkingBoyManagingMoreThanOneParkingLot;
    private ParkingLot parkingLot;
    private List<ParkingLot> parkingLots;

    public StandardParkingBoy(ParkingLot parkingLot) {
        this.isParkingBoyManagingMoreThanOneParkingLot = false;
        this.parkingLot = parkingLot;
    }
    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        this.isParkingBoyManagingMoreThanOneParkingLot = true;
        this.parkingLots = parkingLots;
    }

    private ParkingLot getAvailableParkingLot(List<ParkingLot> parkingLots){
        this.parkingLots = parkingLots;
        for(ParkingLot currParkingLot: parkingLots){
            if(!currParkingLot.isParkingLotFull()){
                System.out.print("Car is parked in Parking Lot " + (parkingLots.indexOf(currParkingLot)+1));
                return this.parkingLot = currParkingLot;
            }
        }
        return null;
    }

    public ParkingTicket park(Car car) {
        if(isParkingBoyManagingMoreThanOneParkingLot){
            ParkingLot currentParkingLot = getAvailableParkingLot(parkingLots);
            if(currentParkingLot != null){
                return currentParkingLot.park(car);
            }else {
                throw new NoAvailablePositionException();
            }
        }
        return parkingLot.park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        ParkingLot foundInParkingLotNo = findParkingLotRelatedTo(parkingTicket);
        if(foundInParkingLotNo == null){
            throw new UnrecognizedParkingTicketException();
        }
        return foundInParkingLotNo.fetch(parkingTicket);
    }

    private ParkingLot findParkingLotRelatedTo(ParkingTicket parkingTicket){
        if(isParkingBoyManagingMoreThanOneParkingLot){
            for(ParkingLot currParkingLot: parkingLots){
                if(currParkingLot.parkedPosition.containsKey(parkingTicket)){
                    return currParkingLot;
                }
            }
        }
        return parkingLot;
    }
}
