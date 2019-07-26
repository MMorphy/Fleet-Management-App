package hr.petkovic.fleet.repositories.vehicle;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hr.petkovic.fleet.entities.vehicle.CarGroup;

public interface CarGroupRepository extends JpaRepository<CarGroup, Long>{

	List<CarGroup> findAll();

	Optional<CarGroup> findById(Long id);

	@Query("SELECT g FROM CarGroup g WHERE g.carGroup LIKE '__?1_'")
	List<CarGroup> findByGearShift(String gearShiftCode);

	List<CarGroup> findByCarGroupStartsWith(String subgroupCode);

	void deleteById(Long id);

	CarGroup save(CarGroup group);
}
