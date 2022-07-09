package tinnova.carsCrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tinnova.carsCrud.model.entities.Vehicle;
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
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicle("corsa");
		vehicle.setBrand("mercedes");
		vehicle.setSold(false);
		vehicle.setCarYear(1997);
		vehicle.setDescription("um carrito qualquer");
		vehicle.setId(UUID.randomUUID().toString());

		vehicleService.createVehicle(vehicle);

	}

}
