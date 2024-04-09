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
        this.title = validateTitle(title);
        this.date = validateDate(date);
        this.totalSeats = validateTotalSeats(totalSeats);
        this.reservedSeats = 0;
    }
    //METODI
    //per il costruttore
    private String validateTitle(String s)
            throws IllegalArgumentException{
        if(s.isEmpty()){
            //se la stringa è vuota lancia un'eccezione
            throw new IllegalArgumentException("The field title is empty!");
        }
        return s;
    }
    private LocalDate validateDate(LocalDate d)
            throws IllegalArgumentException{
        LocalDate now = LocalDate.now();
        if(d.isBefore(now)){
            //se la data inserita è passata lancia un'eccezione
            throw new IllegalArgumentException("The field date is set to a past date");
        }
        return d;
    }
    private int validateTotalSeats(int ts)
            throws IllegalArgumentException{
        if(ts < 1){
            //se il totale dei posti è minore di 1 lancia un'eccezione
            throw new IllegalArgumentException("The field totalSeats is minor of 1");
        }
        return ts;
    }
    //setter
    public void setTitle(String title)
            throws IllegalArgumentException{
        this.title = validateTitle(title);
    }
    public void setdate(LocalDate date)
            throws IllegalArgumentException{
        this.date = validateDate(date);
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
    /**
     * Reserves a specified number of seats for the current event.
     *
     * @param numberReservations The number of seats to reserve.
     * @throws IllegalArgumentException If the total number of reservations exceeds the total number of seats available.
     */
    public void reservationSeats(int numberReservations)
            throws IllegalArgumentException{
        //valido il numero inserito
        if((reservedSeats + numberReservations) > totalSeats){
            //se i posti prenotati + quelli che vengono attualmente prenotati sono maggiori di quelli totali, solleva un'eccezione
            throw new IllegalArgumentException("\nThe number of reservations is greater than the total number of seats!");
        }
        //verifico che la data non sia passata
        date = validateDate(date);
        //altrimenti aggiungo i posti da riservare
        reservedSeats += numberReservations;
    }

    /**
     * Cancel a specified number of reserved seats for the current event
     *
     * @param numberCancelReservations The number of reserved seats to cancel
     * @throws IllegalArgumentException If the total seats remained is negative
     */
    public void cancelReservations(int numberCancelReservations)
            throws IllegalArgumentException{
        //valido il numero inserito
        if((reservedSeats - numberCancelReservations) < 0){
            //se i posti prenotati - quelli che vengono attualmente cancellati sono minori di 0, solleva un'eccezione
            throw new IllegalArgumentException("\nThe number of reservations is greater than the total number of seats");
        }
        //verifico che la data non sia passata
        date = validateDate(date);
        //altrimenti riduco i posti da riservare
        reservedSeats -= numberCancelReservations;
    }
    @Override
    public String toString() {
        //prendo anno, mese formattato e giorno formattato
        int year = date.getYear();
        String month = String.format("%02d",date.getMonthValue());
        String day = String.format("%02d", date.getDayOfMonth());
        //li unisco, formattando l'insieme
        String formattedDate = day + "/" + month + "/" + year;
        //ritorno una stringa completa di data formatta + titolo evento
        return formattedDate + " - " + title;
    }
}
