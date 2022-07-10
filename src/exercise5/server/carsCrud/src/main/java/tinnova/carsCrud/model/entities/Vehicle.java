package tinnova.carsCrud.model.entities;

import tinnova.carsCrud.model.converters.VehicleBrandConverter;
import tinnova.carsCrud.model.enumerations.VehicleBrand;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * An entity class to map the Vehicle entity in the database
 *
 * @author Rafael Furtado
 */
@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    private String id;

    @Column
    private String vehicleName;

    @Column
    @Convert(converter = VehicleBrandConverter.class)
    private VehicleBrand brand;

    @Column
    private Integer carYear;

    @Column
    private String description;

    @Column
    private Boolean sold;

    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime updated;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public VehicleBrand getBrand() {
        return brand;
    }

    public void setBrand(VehicleBrand brand) {
        this.brand = brand;
    }

    public Integer getCarYear() {
        return carYear;
    }

    public void setCarYear(Integer carYear) {
        this.carYear = carYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isSold() {
        return sold;
    }

    public void setSold(Boolean sold) {
        this.sold = sold;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }
}
