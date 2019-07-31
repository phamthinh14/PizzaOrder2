package com.example.demo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

@Entity
public class PizzaOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //    @NotNull
//    @Size(min = 3)
    private boolean normalDough;
    //    @NotNull
//    @Size(min = 3)
    private boolean glutenFreeDough;
    //    @NotNull
//    @Size(min = 3)
    private boolean redSauce;

    private String time;

    private double price;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isNormalDough() {
        return normalDough;
    }

    public void setNormalDough(boolean normalDough) {
        this.normalDough = normalDough;
    }

    public boolean isGlutenFreeDough() {
        return glutenFreeDough;
    }

    public void setGlutenFreeDough(boolean glutenFreeDough) {
        this.glutenFreeDough = glutenFreeDough;
    }

    public boolean isRedSauce() {
        return redSauce;
    }

    public void setRedSauce(boolean redSauce) {
        this.redSauce = redSauce;
    }

    public double getPrice() {
        if (isNormalDough()) {
            this.price += 1;
        }
        if (isGlutenFreeDough()) {
            this.price += 1;
        }
        if (isRedSauce()) {
            this.price += 1;
        }
        return price;
    }

    public void setPrice(double price) {
        this.price = price;

    }

    public String getTime() {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 50);
        time = String.valueOf(calendar.getTime());
        return "Your Pizza will be ready at " + time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
