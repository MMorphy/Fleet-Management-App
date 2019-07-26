package hr.petkovic.fleet.service.vehicle;

import java.util.List;

import hr.petkovic.fleet.entities.vehicle.CarDamageSize;

public interface CarDamageSizeService {

	public abstract List<CarDamageSize> findAllDamageSizes();

	public abstract CarDamageSize findDamageSizeById(Long id);

	public abstract void deleteDamageSizeById(Long id);

	public abstract CarDamageSize saveDamageSize(CarDamageSize damageSize);

	public abstract CarDamageSize updateDamageSize(Long id, CarDamageSize damageSize);
}
