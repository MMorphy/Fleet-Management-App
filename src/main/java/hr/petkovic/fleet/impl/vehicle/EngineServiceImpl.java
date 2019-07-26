package hr.petkovic.fleet.impl.vehicle;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.petkovic.fleet.entities.vehicle.Engine;
import hr.petkovic.fleet.repositories.vehicle.EngineRepository;
import hr.petkovic.fleet.service.vehicle.EngineService;

@Service
public class EngineServiceImpl implements EngineService {

	@Autowired
	private EngineRepository engineRepo;

	public EngineServiceImpl(EngineRepository engineRepo) {
		this.engineRepo = engineRepo;
	}

	@Override
	public List<Engine> findAllEngines() {
		return this.engineRepo.findAll();
	}

	@Override
	public Engine findEnginebyId(Long id) {
		try {
			return this.engineRepo.findById(id).get();
		} catch (NoSuchElementException ex) {
			return null;
		}
	}

	@Override
	public void deleteEngineById(Long id) {
		this.engineRepo.deleteById(id);
	}

	@Override
	public Engine saveEngine(Engine engine) {
		return this.engineRepo.save(engine);
	}

	@Override
	public Engine updateEngine(Long id, Engine engine) {
		Optional<Engine> optEngine = this.engineRepo.findById(id);
		if (optEngine.isPresent()) {
			Engine eng = optEngine.get();
			eng.setCapacity(engine.getCapacity());
			eng.setConsumption(engine.getConsumption());
			eng.setMaxPower(engine.getMaxPower());
			return this.engineRepo.save(eng);
		} else {
			return this.engineRepo.save(engine);
		}
	}
}
