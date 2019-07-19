package hr.petkovic.fleet.repositories.office;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.petkovic.fleet.entities.office.WorkingHours;

public interface WorkingHoursRepository extends JpaRepository<WorkingHours, Long> {

	List<WorkingHours> findAll();

	Optional<WorkingHours> findById(Long id);

	void deleteById(Long id);

	WorkingHours save(WorkingHours workingHours);
}
