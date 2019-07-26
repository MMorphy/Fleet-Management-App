package hr.petkovic.fleet.repositories.vehicle;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.petkovic.fleet.entities.vehicle.NavigationModel;

public interface NavigationModelRepository extends JpaRepository<NavigationModel, Long>{

	List<NavigationModel> findAll();

	Optional<NavigationModel> findById(Long id);

	void deleteById(Long id);

	NavigationModel save(NavigationModel model);
}
