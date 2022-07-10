package tinnova.carsCrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tinnova.carsCrud.model.dtos.VehiclesFilterCriteria;
import tinnova.carsCrud.model.entities.Vehicle;
import tinnova.carsCrud.model.exceptions.InternalServerErrorException;
import tinnova.carsCrud.model.services.VehicleService;

import java.util.List;
import java.util.Optional;


/**
 * A controller class to provide REST routes to the client for the entity {@link Vehicle}
 *
 * @author Rafael Furtado
 */
@CrossOrigin
@RestController
@RequestMapping("/veiculos")
public class VehiclesController {

    @Autowired
    private VehicleService vehicleService;


    /**
     * Get a list of {@link Vehicle}, using the provided url parameters to performs a search
     * query in the database
     *
     * @param filter A DTO class that is used to map the available parameters that can be used to query for the vehicles.
     *               If no parameter be passed as filter, then the list of all vehicles will be retrieved
     * @return Returns the list of vehicles that matches the parameters
     * @throws InternalServerErrorException If occurs some internal error while handling the request
     * @author Rafael Furtado
     */
    @GetMapping
    public ResponseEntity<List<Vehicle>> getVehiclesByFilters(VehiclesFilterCriteria filter) throws InternalServerErrorException {
        List<Vehicle> vehiclesFound = vehicleService.findVehiclesByFilter(filter);

        return new ResponseEntity<List<Vehicle>>(vehiclesFound, HttpStatus.OK);
    }

    /**
     * Get a {@link Vehicle} by its ID
     *
     * @param id The ID of the vehicle to be retrieved
     * @return Returns the vehicle entity for the given ID
     * @author Rafael Furtado
     */
    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable String id) {
        Optional<Vehicle> vehicleFound = vehicleService.findVehicleById(id);

        if (vehicleFound.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Vehicle>(vehicleFound.get(), HttpStatus.OK);
    }

    /**
     * Creates a new {@link Vehicle} and persists it in the database
     *
     * @param vehicle The vehicle object to be created
     * @return Returns a NO_CONTENT status code if the creation was successful
     * @author Rafael Furtado
     */
    @PostMapping
    public ResponseEntity<HttpStatus> createVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.createVehicle(vehicle);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Updates a {@link Vehicle} in the database
     *
     * The given object must contain its ID
     *
     * This update will change <b>ALL</b> the attributes of the entity for the new ones coming in the request
     *
     * @param vehicle The vehicle object to be updated
     * @return Returns a NO_CONTENT status code if the update was successful
     * @author Rafael Furtado
     */
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateVehicleById(@RequestBody Vehicle vehicle) {
        vehicleService.saveVehicle(vehicle);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Updates a {@link Vehicle} in the database
     *
     * The given object must contain its ID
     *
     * This update will change <b>ONLY</b> the attributes that are <b>NOT NULL</b> in the incoming request
     *
     * @param vehicle The vehicle object to be updated
     * @throws InternalServerErrorException If occurs some internal error while handling the request
     * @return Returns a NO_CONTENT status code if the update was successful
     * @author Rafael Furtado
     */
    @PatchMapping("/{id}")
    public ResponseEntity<HttpStatus> partialUpdateVehicleById(@PathVariable String id, @RequestBody Vehicle vehicle) throws InternalServerErrorException {
        boolean updated = vehicleService.partialUpdateVehicle(id, vehicle);

        if (updated) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Deletes a {@link Vehicle} that matches with the given ID
     *
     * @param id The ID of the vehicle to be deleted
     * @return Returns a NO_CONTENT status code if the deletion was successful
     * @author Rafael Furtado
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteVehicleById(@PathVariable String id) {
        vehicleService.deleteVehicle(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}



