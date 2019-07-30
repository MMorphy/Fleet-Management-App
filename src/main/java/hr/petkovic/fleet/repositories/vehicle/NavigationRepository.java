package hr.petkovic.fleet.repositories.vehicle;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.petkovic.fleet.entities.vehicle.Navigation;
import hr.petkovic.fleet.entities.vehicle.NavigationModel;

public interface NavigationRepository extends JpaRepository<Navigation, Long>{

	List<Navigation> findAll();

	Optional<Navigation> findById(Long id);

	List<Navigation> findByModel_ModelLike(String model);

	void deleteById(Long id);

	Navigation save(Navigation navigation);

	Navigation findByModel_Model(String model);
}
