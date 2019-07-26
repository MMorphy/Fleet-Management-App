package hr.petkovic.fleet.repositories.vehicle;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.petkovic.fleet.entities.vehicle.TireBrand;

public interface TireBrandRepository extends JpaRepository<TireBrand, Long>{

	List<TireBrand> findAll();

	Optional<TireBrand> findById(Long id);

	void deleteById(Long id);

	TireBrand save(TireBrand brand);
}
