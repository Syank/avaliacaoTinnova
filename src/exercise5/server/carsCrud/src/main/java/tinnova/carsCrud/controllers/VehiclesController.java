package tinnova.carsCrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tinnova.carsCrud.model.dtos.VehiclesFilterCriteria;
import tinnova.carsCrud.model.entities.Vehicle;
import tinnova.carsCrud.model.services.VehicleService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/veiculos")
public class VehiclesController {

    @Autowired
    private VehicleService vehicleService;



    @GetMapping
    public ResponseEntity<List<Vehicle>> getVehiclesByFilters(VehiclesFilterCriteria filter) {
        List<Vehicle> vehiclesFound = vehicleService.findVehiclesByFilter(filter);

        return new ResponseEntity<List<Vehicle>>(vehiclesFound, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable String id) {
        Optional<Vehicle> vehicleFound = vehicleService.findVehicleById(id);

        if (vehicleFound.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Vehicle>(vehicleFound.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.createVehicle(vehicle);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateVehicleById(@RequestBody Vehicle vehicle) {
        vehicleService.saveVehicle(vehicle);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<HttpStatus> partialUpdateVehicleById(@PathVariable String id, @RequestBody Vehicle vehicle) {
        boolean updated = vehicleService.partialUpdateVehicle(id, vehicle);

        if (updated) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteVehicleById(@PathVariable String id) {
        vehicleService.deleteVehicle(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
