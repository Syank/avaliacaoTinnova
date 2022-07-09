package tinnova.carsCrud.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tinnova.carsCrud.model.entities.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {

}
