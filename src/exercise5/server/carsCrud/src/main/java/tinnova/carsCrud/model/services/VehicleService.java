package tinnova.carsCrud.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tinnova.carsCrud.model.dtos.VehiclesFilterCriteria;
import tinnova.carsCrud.model.entities.Vehicle;
import tinnova.carsCrud.model.enumerations.VehicleBrand;
import tinnova.carsCrud.model.exceptions.InternalServerErrorException;
import tinnova.carsCrud.model.repositories.VehicleRepository;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


/**
 * A service class to provide methods that can be used to interact with the {@link Vehicle} entity
 *
 * @author Rafael Furtado
 */
@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    /**
     * Finds the list of vehicles using the given filter as query criteria. If all the attributes of the filter
     * are <b>null</b>, then it will query all the vehicles
     *
     * @param filter The filter to search for matches in the database
     * @return Returns the list of vehicles that matches with the given filter
     * @throws InternalServerErrorException If the filter object is invalid
     * @author Rafael Furtado
     */
    public List<Vehicle> findVehiclesByFilter(VehiclesFilterCriteria filter) throws InternalServerErrorException {
        boolean isFilterDefined;

        try {
            isFilterDefined = isFilterDefined(filter);

        } catch (IllegalAccessException e) {
            e.printStackTrace();

            throw new InternalServerErrorException("Ocorreu um erro interno ao tratar a requisição");
        }

        List<Vehicle> vehiclesFound;

        if (isFilterDefined) {
            VehicleBrand brand = filter.getBrand();

            String brandValue = null;

            if (brand != null) {
                brandValue = brand.getValue();

            }

            vehiclesFound = vehicleRepository.findByFilter(
                    brandValue, filter.getYear(),
                    filter.getDescription(), filter.getCreated(),
                    filter.getUpdated(), filter.getVehicle(),
                    filter.isSold());

        } else {
            vehiclesFound = vehicleRepository.findAll();

        }

        return vehiclesFound;
    }

    /**
     * Finds a particular vehicle by its ID
     *
     * @param id The ID of the vehicle to be found
     * @return Returns an optional of vehicle found
     * @author Rafael Furtado
     */
    public Optional<Vehicle> findVehicleById(String id) {
        Optional<Vehicle> vehicleFound = vehicleRepository.findById(id);

        return vehicleFound;
    }

    /**
     * Creates a new vehicle in the database
     *
     * @param vehicle The vehicle to be created
     * @author Rafael Furtado
     */
    public void createVehicle(Vehicle vehicle) {
        vehicle.setCreated(LocalDateTime.now());
        vehicle.setId(UUID.randomUUID().toString());

        saveVehicle(vehicle);

    }

    /**
     * Performs the save of the given vehicle in the database
     *
     * @param vehicle The vehicle to be persisted
     * @author Rafael Furtado
     */
    public void saveVehicle(Vehicle vehicle) {
        vehicle.setUpdated(LocalDateTime.now());

        vehicleRepository.save(vehicle);

    }

    /**
     * Partially updates a vehicle in the database
     * <br>
     * It will update the entity with the given ID with the new values coming from the given vehicle object
     *
     * @param id The ID of the vehicle to be updated
     * @param vehicle The new data to be set in the vehicle
     * @return Returns a boolean value that indicates if the update was successful or not
     * @throws InternalServerErrorException If the entity can not be updated
     * @author Rafael Furtado
     */
    public boolean partialUpdateVehicle(String id, Vehicle vehicle) throws InternalServerErrorException {
        Optional<Vehicle> vehicleFound = findVehicleById(id);

        if (vehicleFound.isPresent()) {
            try {
                mergeValues(vehicle, vehicleFound.get());

            } catch (IllegalAccessException e) {
                e.printStackTrace();

                throw new InternalServerErrorException("Ocorreu um erro interno ao tratar a requisição");
            }

            saveVehicle(vehicleFound.get());

            return true;
        }

        return false;
    }

    /**
     * Deletes a vehicle from the database that matches with the given ID
     *
     * @param id The ID of the vehicle to be deleted
     * @author Rafael Furtado
     */
    public void deleteVehicle(String id) {
        vehicleRepository.deleteById(id);

    }

    /**
     * Using reflection, merges two vehicles entities data
     * <br>
     * All the data in the source vehicle that isn't <b>null</b> will be passed to the target vehicle object
     *
     * @param sourceVehicle The source vehicle object
     * @param targetVehicle The target vehicle object
     * @throws IllegalAccessException If some field of the objects can't be accessed
     * @author Rafael Furtado
     */
    private void mergeValues(Vehicle sourceVehicle, Vehicle targetVehicle) throws IllegalAccessException {
        Field[] vehicleFields = sourceVehicle.getClass().getDeclaredFields();

        for (int i = 0; i < vehicleFields.length; i++) {
            Field field = vehicleFields[i];

            field.setAccessible(true);

            Object sourceFieldValue = field.get(sourceVehicle);

            if (sourceFieldValue != null) {
                field.set(targetVehicle, sourceFieldValue);

            }

        }

    }

    /**
     * Checks by reflection if the given filter has at least one attribute that isn't null
     *
     * @param filter The filter to be checked
     * @return Returns a boolean value to indicates if the filter has at least one attribute that isn't null
     * @throws IllegalAccessException If some field of the object can not be accessed
     * @author Rafael Furtado
     */
    private boolean isFilterDefined(VehiclesFilterCriteria filter) throws IllegalAccessException {
        Field[] filterFields = filter.getClass().getDeclaredFields();

        for (int i = 0; i < filterFields.length; i++) {
            Field field = filterFields[i];

            field.setAccessible(true);

            Object filterFieldValue = field.get(filter);

            if (filterFieldValue != null) {
                return true;
            }

        }

        return false;
    }

}
