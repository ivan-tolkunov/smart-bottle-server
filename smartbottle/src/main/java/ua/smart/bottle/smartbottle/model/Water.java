package ua.smart.bottle.smartbottle.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Document(collection = "water")
public class Water {

    @Id
    private String id;
    private double amount;
    private DayOfWeek dayOfWeek;
    private LocalDateTime dateTime;

    public Water() {

    }

    public Water(double amount, DayOfWeek dayOfWeek, LocalDateTime dateTime) {
        super();
        this.amount = amount;
        this.dayOfWeek = dayOfWeek;
        this.dateTime = dateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

}
