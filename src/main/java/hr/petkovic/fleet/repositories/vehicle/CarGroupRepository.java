package hr.petkovic.fleet.repositories.vehicle;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hr.petkovic.fleet.entities.vehicle.CarGroup;

public interface CarGroupRepository extends JpaRepository<CarGroup, Long>{

	List<CarGroup> findAll();

	Optional<CarGroup> findById(Long id);

	Optional<CarGroup> findByCarGroup(String carGroup);

	void deleteById(Long id);

	CarGroup save(CarGroup group);
}
