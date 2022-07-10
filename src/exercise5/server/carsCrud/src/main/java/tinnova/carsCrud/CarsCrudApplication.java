package tinnova.carsCrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tinnova.carsCrud.model.entities.Vehicle;
import tinnova.carsCrud.model.enumerations.VehicleBrand;
import tinnova.carsCrud.model.services.VehicleService;

import java.util.UUID;

@SpringBootApplication
public class CarsCrudApplication implements CommandLineRunner {

	@Autowired
	private VehicleService vehicleService;

	public static void main(String[] args) {
		SpringApplication.run(CarsCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Inserts some initial data in the database
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Ferrari v2");
		vehicle1.setBrand(VehicleBrand.FERRARI);
		vehicle1.setSold(false);
		vehicle1.setCarYear(2015);
		vehicle1.setDescription("Um carro muito rápido");
		vehicle1.setId(UUID.randomUUID().toString());

		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Uno");
		vehicle2.setBrand(VehicleBrand.FIAT);
		vehicle2.setSold(true);
		vehicle2.setCarYear(2009);
		vehicle2.setDescription("Fica mais rápido se tiver uma escada em cima");
		vehicle2.setId(UUID.randomUUID().toString());

		vehicleService.createVehicle(vehicle1);
		vehicleService.createVehicle(vehicle2);

	}

}
