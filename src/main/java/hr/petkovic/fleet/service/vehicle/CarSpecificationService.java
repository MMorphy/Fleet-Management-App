package hr.petkovic.fleet.service.vehicle;

import java.util.List;

import hr.petkovic.fleet.entities.vehicle.CarSpecification;

public interface CarSpecificationService {

	public abstract List<CarSpecification> findAllSpecs();

	public abstract CarSpecification findSpecById(Long id);

	public abstract void deleteSpecById(Long id);

	public abstract CarSpecification saveSpec(CarSpecification spec);

	public abstract CarSpecification updateSpec(Long id, CarSpecification spec);
}
