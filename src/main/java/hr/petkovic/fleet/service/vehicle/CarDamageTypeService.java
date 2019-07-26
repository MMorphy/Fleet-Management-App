package hr.petkovic.fleet.service.vehicle;

import java.util.List;

import hr.petkovic.fleet.entities.vehicle.CarDamageType;

public interface CarDamageTypeService {

	public abstract List<CarDamageType> findAllDamageTypes();

	public abstract CarDamageType findDamageTypeById(Long id);

	public abstract void deleteDamageTypeById(Long id);

	public abstract CarDamageType saveDamageType(CarDamageType damageType);

	public abstract CarDamageType updateDamageType(Long id, CarDamageType damageType);

}
