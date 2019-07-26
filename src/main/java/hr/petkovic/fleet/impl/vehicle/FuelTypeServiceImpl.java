package hr.petkovic.fleet.impl.vehicle;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.petkovic.fleet.entities.vehicle.FuelType;
import hr.petkovic.fleet.repositories.vehicle.FuelTypeRepository;
import hr.petkovic.fleet.service.vehicle.FuelTypeService;

@Service
public class FuelTypeServiceImpl implements FuelTypeService {

	@Autowired
	private FuelTypeRepository typeRepo;

	public FuelTypeServiceImpl(FuelTypeRepository typeRepo) {
		this.typeRepo = typeRepo;
	}

	@Override
	public List<FuelType> findAllFuelTypes() {
		return this.typeRepo.findAll();
	}

	@Override
	public FuelType finddFuelTypeById(Long id) {
		try {
			return this.typeRepo.findById(id).get();
		} catch (NoSuchElementException ex) {
			return null;
		}
	}

	@Override
	public void deleteFuelTypeById(Long id) {
		this.typeRepo.deleteById(id);
	}

	@Override
	public FuelType saveFuelType(FuelType fuelType) {
		return this.typeRepo.save(fuelType);
	}

	@Override
	public FuelType updateFuelType(Long id, FuelType fuelType) {
		Optional<FuelType> optType = this.typeRepo.findById(id);
		if (optType.isPresent()) {
			FuelType type = optType.get();
			type.setType(fuelType.getType());
			return this.typeRepo.save(type);
		} else {
			return this.typeRepo.save(fuelType);
		}
	}
}
