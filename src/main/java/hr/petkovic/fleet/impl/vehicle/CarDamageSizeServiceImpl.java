package hr.petkovic.fleet.impl.vehicle;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.petkovic.fleet.entities.vehicle.CarDamageSize;
import hr.petkovic.fleet.repositories.vehicle.CarDamageSizeRepository;
import hr.petkovic.fleet.service.vehicle.CarDamageSizeService;

@Service
public class CarDamageSizeServiceImpl implements CarDamageSizeService {

	@Autowired
	private CarDamageSizeRepository damageSizeRepo;

	public CarDamageSizeServiceImpl(CarDamageSizeRepository damageSizeRepo) {
		this.damageSizeRepo = damageSizeRepo;
	}

	@Override
	public List<CarDamageSize> findAllDamageSizes() {
		return this.damageSizeRepo.findAll();
	}

	@Override
	public CarDamageSize findDamageSizeById(Long id) {
		try {
			return this.damageSizeRepo.findById(id).get();
		} catch (NoSuchElementException ex) {
			return null;
		}
	}

	@Override
	public void deleteDamageSizeById(Long id) {
		this.damageSizeRepo.deleteById(id);
	}

	@Override
	public CarDamageSize saveDamageSize(CarDamageSize damageSize) {
		return this.damageSizeRepo.save(damageSize);
	}

	@Override
	public CarDamageSize updateDamageSize(Long id, CarDamageSize damageSize) {
		Optional<CarDamageSize> optDamSize = this.damageSizeRepo.findById(id);
		if (optDamSize.isPresent()) {
			CarDamageSize damSize = optDamSize.get();
			damSize.setSize(damageSize.getSize());
			return this.damageSizeRepo.save(damSize);
		}
		else {
			return this.damageSizeRepo.save(damageSize);
		}
	}
}
