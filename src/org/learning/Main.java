package org.learning;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2024,4,20);
        Event e = new Event("sagra", date, 100);
        System.out.println(e.toString());
        e.reservationSeats(50);
        System.out.println(e.getReservedSeats());
        e.reservationSeats(20);
        System.out.println(e.getReservedSeats());
        e.cancelReservations(30);
        System.out.println(e.getReservedSeats());

        LocalTime time = LocalTime.of(16,30,10);
        Concert c = new Concert("concerto",date,1000, time, new BigDecimal("30.5021251141"));
        c.reservationSeats( 500);
        System.out.println("\n\n"+c.getReservedSeats());
        c.cancelReservations(400);
        System.out.println(c.getReservedSeats());
        System.out.println(c.toString());
    }
}
