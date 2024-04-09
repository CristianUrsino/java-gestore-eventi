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
        this.time = time;
        this.price = price;
    }

    //METODI
    //setters
    //TODO aggiungere vals
    public void setTime(LocalTime time) {
        this.time = time;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
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
