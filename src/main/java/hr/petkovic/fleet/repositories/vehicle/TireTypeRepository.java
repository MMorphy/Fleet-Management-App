package hr.petkovic.fleet.repositories.vehicle;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.petkovic.fleet.entities.vehicle.TireType;

public interface TireTypeRepository extends JpaRepository<TireType, Long>{

	List<TireType> findAll();

	Optional<TireType> findById(Long id);

	void deleteById(Long id);

	TireType save(TireType type);
}
