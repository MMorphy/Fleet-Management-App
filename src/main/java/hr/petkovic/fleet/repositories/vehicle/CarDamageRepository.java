package hr.petkovic.fleet.repositories.vehicle;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.petkovic.fleet.entities.vehicle.CarDamage;

public interface CarDamageRepository extends JpaRepository<CarDamage, Long>{

	List<CarDamage> findAll();

	Optional<CarDamage> findById(Long id);

	void deleteById(Long id);

	CarDamage save(CarDamage damage);

	List<CarDamage> findByVehicle_id(Long id);
}
