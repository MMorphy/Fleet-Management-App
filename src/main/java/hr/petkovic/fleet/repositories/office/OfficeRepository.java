package hr.petkovic.fleet.repositories.office;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.petkovic.fleet.entities.office.Office;

public interface OfficeRepository extends JpaRepository<Office, Long> {

	List<Office> findAll();

	Optional<Office> findById(Long id);

	Optional<Office> findByName(String name);

	Optional<Office> findByAddress(String address);

	Optional<Office> findByVehiclePool_id(Long id);

	void deleteById(Long id);

	Office save(Office office);
}
