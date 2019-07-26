package hr.petkovic.fleet.service.vehicle;

import java.util.List;

import hr.petkovic.fleet.entities.vehicle.Engine;

public interface EngineService {

	public abstract List<Engine> findAllEngines();

	public abstract Engine findEnginebyId(Long id);

	public abstract void deleteEngineById(Long id);

	public abstract Engine saveEngine(Engine engine);

	public abstract Engine updateEngine(Long id,Engine engine);
}
