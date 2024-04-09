package org.learning;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Concert extends Event{
    //ATTRUBUTI
    private LocalTime time;
    private BigDecimal price;

    //COSTRUTTORE
    public Concert(String title, LocalDate date, int totalSeats, LocalTime time, BigDecimal price) {
        super(title, date, totalSeats);
        //TODO aggiungere validazione campi
        this.time = validateTime(time);
        this.price = validatePrice(price);
    }

    //METODI
    //validazioni
    private LocalTime validateTime(LocalTime t)
            throws IllegalArgumentException {
        if (t == null) {
            //se l'orario è nullo lancio un'eccezione
            throw new IllegalArgumentException("Time cannot be null!");
        }
        return t;
    }
    private BigDecimal validatePrice(BigDecimal p) throws IllegalArgumentException {
        if (p == null) {
            //se il prezzo è nullo lancio un'eccezione
            throw new IllegalArgumentException("Price cannot be null");
        }
        if (p.compareTo(BigDecimal.ZERO) <= 0) {
            //se il prezzo è < 0 lancio un'eccezione
            throw new IllegalArgumentException("Price must be greater than zero");
        }
        return p;
    }
    //setters
    //TODO aggiungere vals
    public void setTime(LocalTime time)
            throws IllegalArgumentException{
        this.time = validateTime(time);
    }
    public void setPrice(BigDecimal price)
            throws IllegalArgumentException{
        this.price = validatePrice(price);
    }
    //getters
    public LocalTime getTime() {
        return time;
    }
    public BigDecimal getPrice() {
        return price;
    }
    //altri metodi
    public String getDataTime(){
        String formattedDate = super.formatDate();
        String formattedTime = formatTime(time);
        return formattedDate + " " + formattedTime;
    }
    private String formatTime(LocalTime t){
        return t.getHour() + ":" + t.getMinute();
    }
    public String getFormattedPrice(){
        return String.format("%.2f€",price);
    }
    @Override
    public String toString() {
        return getDataTime() + " - " + super.getTitle() + " - " + getFormattedPrice();
    }
}
