package hr.petkovic.fleet.impl.vehicle;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.petkovic.fleet.entities.vehicle.CarDamage;
import hr.petkovic.fleet.repositories.vehicle.CarDamageRepository;
import hr.petkovic.fleet.service.vehicle.CarDamageService;

@Service
public class CarDamageServiceImpl implements CarDamageService {

	@Autowired
	private CarDamageRepository damageRepo;

	public CarDamageServiceImpl(CarDamageRepository damageRepo) {
		this.damageRepo = damageRepo;
	}

	@Override
	public List<CarDamage> findAllDamages() {
		return this.damageRepo.findAll();
	}

	@Override
	public CarDamage findDamageById(Long id) {
		try {
			return this.damageRepo.findById(id).get();
		} catch (NoSuchElementException ex) {
			return null;
		}
	}

	@Override
	public void deleteDamageById(Long id) {
		this.damageRepo.deleteById(id);
	}

	@Override
	public CarDamage saveDamage(CarDamage damage) {
		return this.damageRepo.save(damage);
	}

	@Override
	public CarDamage updateDamage(Long id, CarDamage damage) {
		Optional<CarDamage> optDam = this.damageRepo.findById(id);
		if (optDam.isPresent()) {
			CarDamage dam = optDam.get();
			dam.setRa(damage.getRa());
			dam.setRepaired(damage.getRepaired());
			dam.setSize(damage.getSize());
			dam.setType(damage.getType());
			return this.damageRepo.save(dam);
		} else {
			return this.damageRepo.save(damage);
		}
	}

	@Override
	public CarDamage fixDamage(Long id) {
		Optional<CarDamage> optDam = this.damageRepo.findById(id);
		if (optDam.isPresent()) {
			CarDamage dam = optDam.get();
			dam.setRepaired(true);
			return this.damageRepo.save(dam);
		} else {
			return null;
		}
	}

}
