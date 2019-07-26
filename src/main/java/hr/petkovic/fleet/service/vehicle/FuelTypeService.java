package hr.petkovic.fleet.service.vehicle;

import java.util.List;

import hr.petkovic.fleet.entities.vehicle.FuelType;

public interface FuelTypeService {

	public abstract List<FuelType> findAllFuelTypes();

	public abstract FuelType finddFuelTypeById(Long id);

	public abstract void deleteFuelTypeById(Long id);

	public abstract FuelType saveFuelType(FuelType fuelType);

	public abstract FuelType updateFuelType(Long id, FuelType fuelType);
}
