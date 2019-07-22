package hr.petkovic.fleet.service.vehicle;

import java.util.List;

import hr.petkovic.fleet.entities.vehicle.Vehicle;

public interface VehicleService {

	public abstract List<Vehicle> findAllVehicles();

	public abstract Vehicle findVehicleById(Long id);

	public abstract void deleteVehicleById(Long id);

	public abstract Vehicle saveVehicle(Vehicle vehicle);

	public abstract Vehicle updateVehicle(Long id, Vehicle vehicle);
}
