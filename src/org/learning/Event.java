package org.learning;

import java.time.LocalDate;

public class Event {
    //ATTRIBUTI
    private String title;
    private LocalDate date;
    private int totalSeats;
    private int reservedSeats;

    //COSTRUTTORI
    public Event(String title, LocalDate date, int totalSeats) {
        //TODO aggiungere validazione per ogni campo tranne reservedSeats
        this.title = title;
        this.date = date;
        this.totalSeats = totalSeats;
        this.reservedSeats = 0;
    }
    //METODI

    //setter
    public void setTitle(String title) {
        this.title = title;
    }
    public void setdate(LocalDate date) {
        this.date = date;
    }
    //getter
    public String getTitle() {
        return title;
    }
    public LocalDate getdate() {
        return date;
    }
    public int getTotalSeats() {
        return totalSeats;
    }
    public int getReservedSeats() {
        return reservedSeats;
    }
    //altri metodi
    //TODO docs
    public void reservationSeats(int numberReservations)
            throws IllegalArgumentException{
        //TODO: fare eccezioni personalizzate?
        if((reservedSeats + numberReservations) > totalSeats){
            //se i posti prenotati + quelli che vengono attualmente prenotati sono maggiori di quelli totali, solleva un'eccezione
            throw new IllegalArgumentException("\nThe number of reservations is greater than the total number of");
        }
        LocalDate now = LocalDate.now();
        if(date.isBefore(now)) {
            //se l'evento è già passato sollevo un'eccezione
            throw new IllegalArgumentException("\nThe event was already happened");
        }
        //altrimenti aggiungo i posti da riservare
        reservedSeats += numberReservations;
    }
    //TODO docs
    public void cancelReservations(int numberCancelReservations)
            throws IllegalArgumentException{
        if((reservedSeats - numberCancelReservations) < 0){
            //se i posti prenotati - quelli che vengono attualmente cancellati sono minori di 0, solleva un'eccezione
            throw new IllegalArgumentException("\nThe number of reservations is greater than the total number of seats");
        }
        LocalDate now = LocalDate.now();
        if(date.isBefore(now)) {
            throw new IllegalArgumentException("\nThe event was already happened");
        }
        //altrimenti riduco i posti da riservare
        reservedSeats -= numberCancelReservations;
    }
    @Override
    public String toString() {
        int year = date.getYear();
        String month = String.format("%02d",date.getMonthValue());
        String day = String.format("%02d", date.getDayOfMonth());
        String formattedDate = day + "/" + month + "/" + year;
        return formattedDate + " - " + title;
    }
}
