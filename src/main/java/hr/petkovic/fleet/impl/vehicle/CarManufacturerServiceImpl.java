package hr.petkovic.fleet.impl.vehicle;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.petkovic.fleet.entities.vehicle.CarManufacturer;
import hr.petkovic.fleet.repositories.vehicle.CarManufacturerRepository;
import hr.petkovic.fleet.service.vehicle.CarManufacturerService;

@Service
public class CarManufacturerServiceImpl implements CarManufacturerService {

	@Autowired
	private CarManufacturerRepository manufacRepo;

	public CarManufacturerServiceImpl(CarManufacturerRepository manufacRepo) {
		this.manufacRepo = manufacRepo;
	}

	@Override
	public List<CarManufacturer> findAllManufacturers() {
		return this.manufacRepo.findAll();
	}

	@Override
	public CarManufacturer findManufacturerById(Long id) {
		try {
			return this.manufacRepo.findById(id).get();
		} catch (NoSuchElementException ex) {
			return null;
		}
	}

	@Override
	public void deleteManufacturerById(Long id) {
		this.manufacRepo.deleteById(id);
	}

	@Override
	public CarManufacturer saveManufacturer(CarManufacturer manufacturer) {
		return this.manufacRepo.save(manufacturer);
	}

	@Override
	public CarManufacturer updateManufacturer(Long id, CarManufacturer manufacturer) {
		Optional<CarManufacturer> optManu = this.manufacRepo.findById(id);
		if (optManu.isPresent()) {
			CarManufacturer manu = optManu.get();
			manu.setCarManufacturer(manufacturer.getCarManufacturer());
			return this.manufacRepo.save(manu);
		} else {
			return this.manufacRepo.save(manufacturer);
		}
	}
}
