package hr.petkovic.fleet.impl.vehicle;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.petkovic.fleet.entities.vehicle.CarDamageType;
import hr.petkovic.fleet.repositories.vehicle.CarDamageTypeRepository;
import hr.petkovic.fleet.service.vehicle.CarDamageTypeService;

@Service
public class CarDamageTypeServiceImpl implements CarDamageTypeService {

	@Autowired
	private CarDamageTypeRepository damageTypeRepo;

	public CarDamageTypeServiceImpl(CarDamageTypeRepository damageTypeRepo) {
		this.damageTypeRepo = damageTypeRepo;
	}

	@Override
	public List<CarDamageType> findAllDamageTypes() {
		return this.damageTypeRepo.findAll();
	}

	@Override
	public CarDamageType findDamageTypeById(Long id) {
		try {
			return this.damageTypeRepo.findById(id).get();
		} catch (NoSuchElementException ex) {
			return null;
		}
	}

	@Override
	public void deleteDamageTypeById(Long id) {
		this.damageTypeRepo.deleteById(id);

	}

	@Override
	public CarDamageType saveDamageType(CarDamageType damageType) {
		return this.damageTypeRepo.save(damageType);
	}

	@Override
	public CarDamageType updateDamageType(Long id, CarDamageType damageType) {
		Optional<CarDamageType> optDamType = this.damageTypeRepo.findById(id);
		if (optDamType.isPresent()) {
			CarDamageType damType = optDamType.get();
			damType.setType(damageType.getType());
			return this.damageTypeRepo.save(damType);
		} else {
			return this.damageTypeRepo.save(damageType);
		}
	}
}
