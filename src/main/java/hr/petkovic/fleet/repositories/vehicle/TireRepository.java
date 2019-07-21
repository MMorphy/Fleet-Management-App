package hr.petkovic.fleet.repositories.vehicle;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.petkovic.fleet.entities.vehicle.Tire;

public interface TireRepository extends JpaRepository<Tire, Long>{

	List<Tire> findAll();

	Optional<Tire> findById(Long id);

	void deleteById(Long id);

	Tire save(Tire tire);
}
