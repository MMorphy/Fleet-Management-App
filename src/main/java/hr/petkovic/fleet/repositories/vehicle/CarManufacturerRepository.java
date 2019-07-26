package hr.petkovic.fleet.repositories.vehicle;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.petkovic.fleet.entities.vehicle.CarManufacturer;

public interface CarManufacturerRepository extends JpaRepository<CarManufacturer, Long>{

	List<CarManufacturer> findAll();

	Optional<CarManufacturer> findById(Long id);

	void deleteById(Long id);

	CarManufacturer save(CarManufacturer manufacturer);
}
