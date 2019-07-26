package hr.petkovic.fleet.repositories.vehicle;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.petkovic.fleet.entities.vehicle.WheelType;

public interface WheelTypeRepository extends JpaRepository<WheelType, Long>{

	List<WheelType> findAll();

	Optional<WheelType> findById(Long id);

	void deleteById(Long id);

	WheelType save(WheelType type);
}
