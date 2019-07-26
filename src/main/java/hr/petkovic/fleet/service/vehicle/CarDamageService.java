package hr.petkovic.fleet.service.vehicle;

import java.util.List;

import hr.petkovic.fleet.entities.vehicle.CarDamage;

public interface CarDamageService {

	public abstract List<CarDamage> findAllDamages();

	public abstract CarDamage findDamageById(Long id);

	public abstract void deleteDamageById(Long id);

	public abstract CarDamage saveDamage(CarDamage damage);

	public abstract CarDamage updateDamage(Long id, CarDamage damage);

	public abstract CarDamage fixDamage(Long id);
}
