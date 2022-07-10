package tinnova.carsCrud.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tinnova.carsCrud.model.dtos.VehiclesFilterCriteria;
import tinnova.carsCrud.model.entities.Vehicle;
import tinnova.carsCrud.model.repositories.VehicleRepository;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> findAllVehicles() {
        List<Vehicle> vehiclesFound = vehicleRepository.findAll();

        return vehiclesFound;
    }

    public List<Vehicle> findVehiclesByFilter(VehiclesFilterCriteria filter) throws IllegalAccessException {
        boolean isFilterDefined = isFilterDefined(filter);

        List<Vehicle> vehiclesFound;

        if (isFilterDefined) {
            vehiclesFound = vehicleRepository.findByFilter(
                    filter.getBrand(), filter.getYear(),
                    filter.getDescription(), filter.getCreated(),
                    filter.getUpdated(), filter.getVehicle(),
                    filter.isSold());

        } else {
            vehiclesFound = vehicleRepository.findAll();

        }

        return vehiclesFound;
    }

    public Optional<Vehicle> findVehicleById(String id) {
        Optional<Vehicle> vehicleFound = vehicleRepository.findById(id);

        return vehicleFound;
    }

    public void createVehicle(Vehicle vehicle) {
        vehicle.setCreated(LocalDateTime.now());
        vehicle.setId(UUID.randomUUID().toString());

        saveVehicle(vehicle);

    }

    public void saveVehicle(Vehicle vehicle) {
        vehicle.setUpdated(LocalDateTime.now());

        vehicleRepository.save(vehicle);

    }

    public boolean partialUpdateVehicle(String id, Vehicle vehicle) throws IllegalAccessException {
        Optional<Vehicle> vehicleFound = findVehicleById(id);

        if (vehicleFound.isPresent()) {
            mergeValues(vehicle, vehicleFound.get());

            saveVehicle(vehicleFound.get());

            return true;
        }

        return false;
    }

    public void deleteVehicle(String id) {
        vehicleRepository.deleteById(id);

    }

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
