package tinnova.carsCrud.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tinnova.carsCrud.model.entities.Vehicle;

import java.time.LocalDateTime;
import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {

    @Query(nativeQuery = true, value = "SELECT * FROM VEHICLE WHERE BRAND = ?1 OR CAR_YEAR = ?2 OR DESCRIPTION = ?3 OR CREATED = ?4 OR UPDATED = ?5 OR VEHICLE_NAME = ?6 OR SOLD = ?7 ;")
    List<Vehicle> findByFilter(String brand, Integer carYear, String description,
                               LocalDateTime created, LocalDateTime updated, String vehicleName,
                               Boolean sold);
}
