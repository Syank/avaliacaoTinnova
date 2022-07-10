package tinnova.carsCrud.model.dtos;

import javax.persistence.Column;
import javax.persistence.Lob;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class VehiclesFilterCriteria {

    private String vehicle;
    private String brand;
    private int year;
    private String description;
    private Boolean sold;
    private LocalDateTime created;
    private LocalDateTime updated;

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

    public Boolean isSold() {
        return sold;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSold(Boolean sold) {
        this.sold = sold;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }
}
