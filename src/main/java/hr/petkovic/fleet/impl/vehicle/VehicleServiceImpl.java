package hr.petkovic.fleet.impl.vehicle;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.petkovic.fleet.entities.vehicle.Vehicle;
import hr.petkovic.fleet.repositories.vehicle.VehicleRepository;
import hr.petkovic.fleet.service.vehicle.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepo;

	public VehicleServiceImpl(VehicleRepository vehicleRepo) {
		this.vehicleRepo = vehicleRepo;
	}

	@Override
	public List<Vehicle> findAllVehicles() {
		return this.vehicleRepo.findAll();
	}

	@Override
	public Vehicle findVehicleById(Long id) {
		try {
			return this.vehicleRepo.findById(id).get();
		} catch (NoSuchElementException ex) {
			return null;
		}
	}

	@Override
	public void deleteVehicleById(Long id) {
		this.vehicleRepo.deleteById(id);
	}

	@Override
	public Vehicle saveVehicle(Vehicle vehicle) {
		return this.vehicleRepo.save(vehicle);
	}

	@Override
	public Vehicle updateVehicle(Long id, Vehicle vehicle) {
		Optional<Vehicle> optVehicle = this.vehicleRepo.findById(id);
		if (optVehicle.isPresent()) {
			Vehicle veh = optVehicle.get();
			veh.setCarGroup(vehicle.getCarGroup());
			veh.setCurrentKM(vehicle.getCurrentKM());
			veh.setDamages(vehicle.getDamages());
			veh.setFuelLevel(vehicle.getFuelLevel());
			veh.setManufactoringYear(vehicle.getManufactoringYear());
			veh.setManufacturer(vehicle.getManufacturer());
			veh.setModel(vehicle.getModel());
			veh.setNavigation(vehicle.getNavigation());
			veh.setRegistrationNumber(vehicle.getRegistrationNumber());
			veh.setSpecification(vehicle.getSpecification());
			veh.setTire(vehicle.getTire());
			veh.setVIN(vehicle.getVIN());
			return this.vehicleRepo.save(veh);
		} else {
			return this.vehicleRepo.save(vehicle);
		}
	}

}
