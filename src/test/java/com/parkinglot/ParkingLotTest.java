package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    @Test
    public void should_return_parking_ticket_when_park_given_parking_lot_and_a_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        //when
        ParkingTicket parkingTicket = parkingLot.park(car);

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    public void should_return_car_when_fetch_given_a_parked_car_and_a_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot.park(car);

        //when
        Car actualCar = parkingLot.fetch(parkingTicket);

        //then
        assertEquals(car,actualCar);
    }

    @Test
    public void should_return_right_car_when_fetch_twice_given_two_parked_cars_and_two_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car aliceCar = new Car();
        Car bobCar = new Car();
        ParkingTicket aliceParkingTicket = parkingLot.park(aliceCar);
        ParkingTicket bobParkingTicket = parkingLot.park(bobCar);

        //when
        Car actualAliceCar = parkingLot.fetch(aliceParkingTicket);
        Car actualBobCar = parkingLot.fetch(bobParkingTicket);

        //then
        assertEquals(aliceCar,actualAliceCar);
        assertEquals(bobCar,actualBobCar);
    }

    @Test
    public void should_return_nothing_when_fetch_given_a_wrong_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot.park(car);
        ParkingTicket newParkingTicket = new ParkingTicket();

        //when
        Car actualCar = parkingLot.fetch(newParkingTicket);

        //then
        assertNull(actualCar);
    }

    @Test
    public void should_return_nothing_when_fetch_given_a_used_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car aliceCar = new Car();
        ParkingTicket aliceParkingTicket = parkingLot.park(aliceCar);
        parkingLot.fetch(aliceParkingTicket); //used the ticket here

        //when
        Car actualCar = parkingLot.fetch(aliceParkingTicket);

        //then
        assertNull(actualCar);
    }

    @Test
    public void should_return_nothing_when_park_given_a_full_parking_lot_and_a_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        ParkingTicket parkingTicket1 = parkingLot.park(car);
        ParkingTicket parkingTicket2 = parkingLot.park(car);
        ParkingTicket parkingTicket3 = parkingLot.park(car);
        ParkingTicket parkingTicket4 = parkingLot.park(car);
        ParkingTicket parkingTicket5 = parkingLot.park(car);
        ParkingTicket parkingTicket6 = parkingLot.park(car);
        ParkingTicket parkingTicket7 = parkingLot.park(car);
        ParkingTicket parkingTicket8 = parkingLot.park(car);
        ParkingTicket parkingTicket9 = parkingLot.park(car);
        ParkingTicket parkingTicket10 = parkingLot.park(car);

        //when
        ParkingTicket parkingTicket11 = parkingLot.park(car);


        //then
        assertNull(parkingTicket11);
    }

}
