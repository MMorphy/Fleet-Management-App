package hr.petkovic.fleet.impl.vehicle;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.petkovic.fleet.entities.vehicle.CarSpecification;
import hr.petkovic.fleet.repositories.vehicle.CarSpecificationRepository;
import hr.petkovic.fleet.service.vehicle.CarSpecificationService;

@Service
public class CarSpecificationServiceImpl implements CarSpecificationService {

	@Autowired
	private CarSpecificationRepository specRepo;

	public CarSpecificationServiceImpl(CarSpecificationRepository specRepo) {
		this.specRepo = specRepo;
	}

	@Override
	public List<CarSpecification> findAllSpecs() {
		return this.specRepo.findAll();
	}

	@Override
	public CarSpecification findSpecById(Long id) {
		try {
			return this.specRepo.findById(id).get();
		} catch (NoSuchElementException ex) {
			return null;
		}
	}

	@Override
	public void deleteSpecById(Long id) {
		this.specRepo.deleteById(id);
	}

	@Override
	public CarSpecification saveSpec(CarSpecification spec) {
		return this.specRepo.save(spec);
	}

	@Override
	public CarSpecification updateSpec(Long id, CarSpecification spec) {
		Optional<CarSpecification> optSpec = this.specRepo.findById(id);
		if (optSpec.isPresent()) {
			CarSpecification spc = optSpec.get();
			spc.setDoors(spec.getDoors());
			spc.setEngine(spec.getEngine());
			spc.setFuelTankCapacity(spec.getFuelTankCapacity());
			spc.setNumberOfSeats(spec.getNumberOfSeats());
			spc.setTopSpeed(spec.getTopSpeed());
			return this.specRepo.save(spc);
		} else {
			return this.specRepo.save(spec);

		}
	}
}
