package hr.petkovic.fleet.repositories.vehicle;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.petkovic.fleet.entities.vehicle.CarModel;

public interface CarModelRepository extends JpaRepository<CarModel, Long>{

	List<CarModel> findAll();

	Optional<CarModel> findById(Long id);

	void deleteById(Long id);

	CarModel save(CarModel model);

	List<CarModel> findByManufacturer_id(Long id);
}
