package hr.petkovic.fleet.repositories.vehicle;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.petkovic.fleet.entities.vehicle.Navigation;

public interface NavigationRepository extends JpaRepository<Navigation, Long>{

	List<Navigation> findAll();

	Optional<Navigation> findById(Long id);

	void deleteById(Long id);

	Navigation save(Navigation navigation);
}
