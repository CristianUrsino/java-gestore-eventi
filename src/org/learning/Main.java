package org.learning;

import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;


//TODO migliorare rendendolo un do-while "infinito" potenzialmente, dividere in funzioni, implementare funzioni per MS2 e MS bonus, migliorare commenti, ricontrollare eccezioni (specialmente disdetta prenotazioni)


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String title;
        String inputDate;
        int totalSeats;
        Event event = null;
        do {
            try {
                //input di title
                System.out.print("Enter title of event: ");
                title = scanner.nextLine();
                //input della data
                System.out.print("Enter date of event(year-month-day): ");
                inputDate = scanner.nextLine();
                // Divido la stringa dell'input in parti usando il carattere '-'
                String[] parts = inputDate.split("-");
                // Estraggo anno, mese e giorno dalla stringa dell'input
                int year = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int day = Integer.parseInt(parts[2]);
                // Creare un oggetto LocalDate con i valori estratti
                LocalDate date = LocalDate.of(year, month, day);
                //input di totalNumberSeats
                System.out.print("Enter total seats: ");
                totalSeats = Integer.parseInt(scanner.nextLine());
                event = new Event(title,date,totalSeats);
            }catch (NumberFormatException e){
                System.out.println("the field total seats must be a positive integer number");
            } catch (DateTimeException | IndexOutOfBoundsException e) {
                System.out.println("Error in field date\n");
            }catch (IllegalArgumentException e){
                System.out.println("Error"+e+"\n");
            }
        }while(event == null);
        //chiedo se vuole prenotare
        boolean wantToBook = false;
        int inputwantToBook = -1;
        do {
            System.out.print("If you want to book a seats enter 1, else enter 0: ");
            inputwantToBook = Integer.parseInt(scanner.nextLine());
            if(inputwantToBook > 1 || inputwantToBook < 0){
                //se diverso da 1 o 0 segnalo l'errore e setto un valore che faccia ripetere l'iterazione del do-while
                System.out.println("Input must be either 0 or 1");
                inputwantToBook = -1;
            }
            wantToBook = inputwantToBook == 1;
        }while (inputwantToBook > 1 || inputwantToBook < 0);
        //se vuole prenotare dei posti
        if(wantToBook){
            int reservedSeats = 0;
            //input del numero di posti da prenotare
            do{
                try{
                    System.out.print("how many seats: ");
                    reservedSeats = Integer.parseInt(scanner.nextLine());
                    event.reservationSeats(reservedSeats);
                } catch (NumberFormatException e){
                    System.out.println("Reserved Seats must be a integer positive number\n");
                } catch (IllegalArgumentException e){
                    System.out.println("Error: " + e + "\n");
                    reservedSeats = 0;
                }
            }while(reservedSeats < 0);
            System.out.println("Reserved seats: " + event.getReservedSeats() + " seats bookable: " + (event.getTotalSeats()-event.getReservedSeats()));
        }
        //chiedo se l'utente vuole disdire dei posti
        boolean wantCancelReservation = false;
        int inputWantCancelReservation = -1;
        do {
            System.out.print("If you want cancel reservation of a seats enter 1, else enter 0: ");
            inputWantCancelReservation = Integer.parseInt(scanner.nextLine());
            if(inputWantCancelReservation > 1 || inputWantCancelReservation < 0){
                //se diverso da 1 o 0 segnalo l'errore e setto un valore che faccia ripetere l'iterazione del do-while
                System.out.println("Input must be either 0 or 1");
                inputWantCancelReservation = -1;
            }
            wantCancelReservation = inputWantCancelReservation == 1;
        }while (inputWantCancelReservation > 1 || inputWantCancelReservation < 0);
        //se vuole prenotare dei posti
        if(wantCancelReservation) {
            int cancelReservedSeats = 0;
            //input del numero di posti da prenotare
            do {
                try {
                    System.out.print("how many seats reserved cancel: ");
                    cancelReservedSeats = Integer.parseInt(scanner.nextLine());
                    event.cancelReservations(cancelReservedSeats);
                } catch (NumberFormatException e) {
                    System.out.println("Reserved Seats cancel must be a integer positive number\n");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e + "\n");
                    cancelReservedSeats = 0;
                }
            } while (cancelReservedSeats < 0);
            System.out.println("Reserved seats: " + event.getReservedSeats() + " seats bookable: " + (event.getTotalSeats() - event.getReservedSeats()));
        }
    }
}
