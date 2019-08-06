package hr.petkovic.fleet.repositories.vehicle;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.petkovic.fleet.entities.vehicle.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

	List<Vehicle> findAll();

	Optional<Vehicle> findById(Long id);

	void deleteById(Long id);

	Vehicle save(Vehicle vehicle);

	List<Vehicle> findByRentedAndCarGroup_carGroup(boolean rented, String carGroup);
}
