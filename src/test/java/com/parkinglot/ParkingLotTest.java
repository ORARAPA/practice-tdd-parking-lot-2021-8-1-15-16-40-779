package com.parkinglot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

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
        //Car actualCar = parkingLot.fetch(newParkingTicket);

        //then
        //assertNull(actualCar);
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class,() -> parkingLot.fetch(newParkingTicket));
        assertEquals("Unrecognized parking ticket.",exception.getMessage());
    }

    @Test
    public void should_return_nothing_when_fetch_given_a_used_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car aliceCar = new Car();
        ParkingTicket aliceParkingTicket = parkingLot.park(aliceCar);
        parkingLot.fetch(aliceParkingTicket); //used the ticket here

        //when
        //Car actualCar = parkingLot.fetch(aliceParkingTicket);

        //then
        //assertNull(actualCar);
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class,() -> parkingLot.fetch(aliceParkingTicket));
        assertEquals("Unrecognized parking ticket.",exception.getMessage());
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
        //ParkingTicket parkingTicket11 = parkingLot.park(car);


        //then
        //assertNull(parkingTicket11);

        Exception exception = assertThrows(NoAvailablePositionException.class,() -> parkingLot.park(car));
        assertEquals("No available position.",exception.getMessage());
    }

    @Test
    public void should_return_error_unrecognized_ticket_when_fetch_given_an_unrecognized_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket unrecognizedParkingTicket = new ParkingTicket();

        //when & then
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class,() -> parkingLot.fetch(unrecognizedParkingTicket));
        assertEquals("Unrecognized parking ticket.",exception.getMessage());
    }

    @Test
    public void should_return_error_unrecognized_ticket_when_fetch_given_a_used_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket parkingTicket = parkingLot.park(new Car());
        parkingLot.fetch(parkingTicket);

        //when & then
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class,() -> parkingLot.fetch(parkingTicket));
        assertEquals("Unrecognized parking ticket.",exception.getMessage());
    }

    @Test
    public void should_return_error_no_position_available_when_park_given_a_full_parking_lot_and_a_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        for (int i = 0; i < 10; i++) {
            parkingLot.park(car);
        }

        //when & then
        Exception exception = assertThrows(NoAvailablePositionException.class,() -> parkingLot.park(car));
        assertEquals("No available position.",exception.getMessage());
    }

    @Test
    public void should_return_parking_ticket_when_park_given_a_parking_lot_a_standard_parking_boy_and_a_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();

        //when
        ParkingTicket parkingTicket = parkingBoy.park(car);


        //then
        assertNotNull(parkingTicket);
    }

    @Test
    public void should_return_car_when_fetch_given_a_parking_lot_with_parked_car_a_standard_parking_boy_and_a_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot.park(car);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);

        //when
        Car actualCar = parkingBoy.fetch(parkingTicket);

        //then
        assertEquals(car,actualCar);
    }

    @Test
    public void should_return_right_car_for_each_ticket_when_fetch_twice_given_a_parking_lot_with_two_parked_cars_a_standard_parking_boy_and_two_parking_tickets() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingTicket parkingTicket1 = parkingLot.park(car1);
        ParkingTicket parkingTicket2 = parkingLot.park(car2);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);

        //when
        Car actualCar1 = parkingBoy.fetch(parkingTicket1);
        Car actualCar2 = parkingBoy.fetch(parkingTicket2);

        //then
        assertEquals(car1,actualCar1);
        assertEquals(car2,actualCar2);
    }

    @Test
    public void should_return_error_unrecognized_ticket_when_fetch_twice_given_a_parking_lot_a_standard_parking_boy_and_a_wrong_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        ParkingTicket wrongTicket = new ParkingTicket();

        //when & then
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class,() -> parkingBoy.fetch(wrongTicket));
        assertEquals("Unrecognized parking ticket.",exception.getMessage());
    }

    @Test
    public void should_return_error_unrecognized_ticket_when_fetch_given_a_parking_lot_a_standard_parking_boy_and_a_used_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        ParkingTicket parkingTicket = parkingLot.park(new Car());
        parkingLot.fetch(parkingTicket);

        //when & then
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class,() -> parkingBoy.fetch(parkingTicket));
        assertEquals("Unrecognized parking ticket.",exception.getMessage());
    }

    @Test
    public void should_return_error_no_position_available_when_park_given_a_full_parking_lot_a_standard_parking_boy_and_a_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        for (int i = 0; i < 10; i++) {
            parkingLot.park(car);
        }
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);

        //when & then
        Exception exception = assertThrows(NoAvailablePositionException.class,() -> parkingBoy.park(car));
        assertEquals("No available position.",exception.getMessage());
    }

    @Test
    public void should_return_car_parked_in_first_parking_lot_when_park_given_a_standard_parking_boy_manage_two_not_full_parking_lots_and_a_car() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLots);
        Car car = new Car();

        //when
        parkingBoy.park(car);

        //then
        assertEquals("Car is parked in Parking Lot 1",systemOut());

    }

    private String systemOut() {
        return outContent.toString();
    }

    @Test
    public void should_return_car_parked_in_second_parking_lot_when_park_given_a_standard_parking_boy_manage_first_full_parking_lot_and_second_with_position_available_and_a_car() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        parkingLots.add(parkingLot1);
        Car car = new Car();
        for (int i = 0; i < 10; i++) {
            parkingLot1.park(car);
        }
        parkingLots.add(parkingLot2);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLots);

        //when
        parkingBoy.park(car);

        //then
        assertEquals("Car is parked in Parking Lot 2",systemOut());

    }

    @Test
    public void should_return_right_car_for_each_ticket_when_fetch_twice_given_a_standard_parking_boy_manage_two_parking_lots_with_parked_cars_and_two_parking_tickets() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        Car aliceCar = new Car();
        Car bobCar = new Car();
        ParkingTicket aliceCarInParkingLot1 = parkingLot1.park(aliceCar);
        ParkingTicket bobCarInParkingLot2 = parkingLot2.park(bobCar);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLots);

        //when
        Car actualAliceCar = parkingBoy.fetch(aliceCarInParkingLot1);
        Car actualBobCar = parkingBoy.fetch(bobCarInParkingLot2);

        //then
        assertEquals(aliceCar,actualAliceCar);
        assertEquals(bobCar,actualBobCar);

    }

    @Test
    public void should_return_error_unrecognized_ticket_when_fetch_given_a_standard_parking_boy_managing_two_parking_lots_and_an_unrecognized_ticket() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLots);
        ParkingTicket unrecognizedTicket = new ParkingTicket();

        //when & then
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class,() -> parkingBoy.fetch(unrecognizedTicket));
        assertEquals("Unrecognized parking ticket.",exception.getMessage());
    }

    @Test
    public void should_return_error_unrecognized_ticket_when_fetch_given_a_standard_parking_boy_managing_two_parking_lots_and_a_used_ticket() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLots);
        ParkingTicket parkingTicket = parkingLot2.park(new Car());
        parkingLot2.fetch(parkingTicket);

        //when & then
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class,() -> parkingBoy.fetch(parkingTicket));
        assertEquals("Unrecognized parking ticket.",exception.getMessage());
    }

    @Test
    public void should_return_error_no_position_available_when_fetch_given_a_standard_parking_boy_managing_two_full_parking_lots_and_a_car() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        Car car = new Car();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLots);
        for (int i = 0; i < 20; i++) {
            parkingBoy.park(car);
        }


        //when & then
        Exception exception = assertThrows(NoAvailablePositionException.class,() -> parkingBoy.park(car));
        assertEquals("No available position.",exception.getMessage());
    }

    @Test
    public void should_return_car_parked_in_second_parking_lot_when_park_given_a_smart_parking_boy_with_first_parking_lot_has_two_parked_cars_second_lot_has_one_parked_car_and_a_car() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        Car car = new Car();
        parkingLot1.park(car);
        parkingLot1.park(car);
        parkingLot2.park(car);
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLots);

        //when
        parkingBoy.park(car);

        //then
        assertEquals("Car is parked in Parking Lot 2",systemOut());

    }

    @Test
    public void should_return_right_parking_lot_for_each_car_when_park_thrice_given_a_smart_parking_boy_with_two_empty_parking_lots_and_three_cars() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        Car car = new Car();
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLots);
        String expected1 = "Car is parked in Parking Lot 1";
        String expected2 = "Car is parked in Parking Lot 2";
        String expected3 = "Car is parked in Parking Lot 1";

        //when
        parkingBoy.park(car);
        parkingBoy.park(car);
        parkingBoy.park(car);

        //then
        assertEquals(expected1+expected2+expected3,systemOut());

    }

    @Test
    public void should_return_right_car_for_each_ticket_when_fetch_twice_given_a_smart_parking_boy_manage_two_parking_lots_with_parked_cars_and_two_parking_tickets() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        Car aliceCar = new Car();
        Car bobCar = new Car();
        ParkingTicket aliceCarInParkingLot1 = parkingLot1.park(aliceCar);
        ParkingTicket bobCarInParkingLot2 = parkingLot2.park(bobCar);
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLots);

        //when
        Car actualAliceCar = parkingBoy.fetch(aliceCarInParkingLot1);
        Car actualBobCar = parkingBoy.fetch(bobCarInParkingLot2);

        //then
        assertEquals(aliceCar,actualAliceCar);
        assertEquals(bobCar,actualBobCar);

    }

    @Test
    public void should_return_error_unrecognized_ticket_when_fetch_given_a_smart_parking_boy_managing_two_parking_lots_and_an_unrecognized_ticket() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLots);
        ParkingTicket unrecognizedTicket = new ParkingTicket();

        //when & then
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class,() -> parkingBoy.fetch(unrecognizedTicket));
        assertEquals("Unrecognized parking ticket.",exception.getMessage());
    }

    @Test
    public void should_return_error_unrecognized_ticket_when_fetch_given_a_smart_parking_boy_managing_two_parking_lots_and_a_used_ticket() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLots);
        ParkingTicket parkingTicket = parkingLot2.park(new Car());
        parkingLot2.fetch(parkingTicket);

        //when & then
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class,() -> parkingBoy.fetch(parkingTicket));
        assertEquals("Unrecognized parking ticket.",exception.getMessage());
    }

    @Test
    public void should_return_error_no_position_available_when_fetch_given_a_smart_parking_boy_managing_two_full_parking_lots_and_a_car() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        Car car = new Car();
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLots);
        for (int i = 0; i < 20; i++) {
            parkingBoy.park(car);
        }


        //when & then
        Exception exception = assertThrows(NoAvailablePositionException.class,() -> parkingBoy.park(car));
        assertEquals("No available position.",exception.getMessage());
    }


}
