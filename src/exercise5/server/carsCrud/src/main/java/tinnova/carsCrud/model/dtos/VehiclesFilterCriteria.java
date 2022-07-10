package tinnova.carsCrud.model.dtos;

import tinnova.carsCrud.model.enumerations.VehicleBrand;

import java.time.LocalDateTime;


/**
 * A DTO class to be used to map all the attributes that can be used as filter in queries to search for vehicles
 *
 * @author Rafael Furtado
 */
public class VehiclesFilterCriteria {

    private String vehicle;
    private VehicleBrand brand;
    private Integer year;
    private String description;
    private Boolean sold;
    private LocalDateTime created;
    private LocalDateTime updated;

    public String getVehicle() {
        return vehicle;
    }

    public VehicleBrand getBrand() {
        return brand;
    }

    public Integer getYear() {
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

    public void setBrand(VehicleBrand brand) {
        this.brand = brand;
    }

    public void setYear(Integer year) {
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
