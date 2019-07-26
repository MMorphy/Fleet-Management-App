package hr.petkovic.fleet.repositories.vehicle;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.petkovic.fleet.entities.vehicle.FuelType;

public interface FuelTypeRepository extends JpaRepository<FuelType, Long>{

	List<FuelType> findAll();

	Optional<FuelType> findById(Long id);

	void deleteById(Long id);

	FuelType save(FuelType type);
}
