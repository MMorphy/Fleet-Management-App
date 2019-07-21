package hr.petkovic.fleet.repositories.vehicle;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.petkovic.fleet.entities.vehicle.CarSpecification;

public interface CarSpecificationRepository extends JpaRepository<CarSpecification, Long>{

	List<CarSpecification> findAll();

	Optional<CarSpecification> findById(Long id);

	void deleteById(Long id);

	CarSpecification save(CarSpecification specification);
}
