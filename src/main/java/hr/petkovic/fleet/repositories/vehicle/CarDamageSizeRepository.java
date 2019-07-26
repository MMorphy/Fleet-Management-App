package hr.petkovic.fleet.repositories.vehicle;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.petkovic.fleet.entities.vehicle.CarDamageSize;

public interface CarDamageSizeRepository extends JpaRepository<CarDamageSize, Long>{

	List<CarDamageSize> findAll();

	Optional<CarDamageSize> findById(Long id);

	void deleteById(Long id);

	CarDamageSize save (CarDamageSize damageSize);
}
