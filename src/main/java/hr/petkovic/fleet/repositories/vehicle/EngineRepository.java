package hr.petkovic.fleet.repositories.vehicle;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.petkovic.fleet.entities.vehicle.Engine;

public interface EngineRepository extends JpaRepository<Engine, Long>{

	List<Engine> findAll();

	Optional<Engine> findById(Long id);

	void deleteById(Long id);

	Engine save(Engine engine);
}
