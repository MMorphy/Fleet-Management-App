package hr.petkovic.fleet.repositories.vehicle;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.petkovic.fleet.entities.vehicle.CarDamageType;

public interface CarDamageTypeRepository extends JpaRepository<CarDamageType, Long>{

	List<CarDamageType> findAll();

	Optional<CarDamageType> findById(Long id);

	void deleteById(Long id);

	CarDamageType save(CarDamageType damageType);
}
