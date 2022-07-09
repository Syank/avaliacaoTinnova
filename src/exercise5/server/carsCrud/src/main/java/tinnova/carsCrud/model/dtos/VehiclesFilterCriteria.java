package tinnova.carsCrud.model.dtos;

import javax.persistence.Column;
import javax.persistence.Lob;
import java.time.LocalDate;

public class VehiclesFilterCriteria {

    private String vehicle;
    private String brand;
    private int year;
    private String description;
    private boolean sold;
    private LocalDate created;

    public String getVehicle() {
        return vehicle;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public String getDescription() {
        return description;
    }

    public boolean isSold() {
        return sold;
    }

    public LocalDate getCreated() {
        return created;
    }

    public LocalDate getUpdated() {
        return updated;
    }

    private LocalDate updated;

}
