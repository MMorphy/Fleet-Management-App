package hr.petkovic.fleet.service.vehicle;

import java.util.List;

import hr.petkovic.fleet.entities.vehicle.Tire;

public interface TireService {

	public abstract List<Tire> findAllTires();

	public abstract Tire findTireById(Long id);

	public abstract void deleteTireById(Long id);

	public abstract Tire saveTire(Tire tire);

	public abstract Tire updateTire(Long id, Tire tire);

	public abstract List<Tire> findUnusedTires();
}
