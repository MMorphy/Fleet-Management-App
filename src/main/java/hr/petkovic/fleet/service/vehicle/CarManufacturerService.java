package hr.petkovic.fleet.service.vehicle;

import java.util.List;

import hr.petkovic.fleet.entities.vehicle.CarManufacturer;

public interface CarManufacturerService {

	public abstract List<CarManufacturer> findAllManufacturers();

	public abstract CarManufacturer findManufacturerById(Long id);

	public abstract void deleteManufacturerById(Long id);

	public abstract CarManufacturer saveManufacturer(CarManufacturer manufacturer);

	public abstract CarManufacturer updateManufacturer(Long id,CarManufacturer manufacturer);
}
