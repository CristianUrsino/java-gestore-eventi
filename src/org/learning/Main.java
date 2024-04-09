package org.learning;

import java.time.LocalDate;

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
    }
}
