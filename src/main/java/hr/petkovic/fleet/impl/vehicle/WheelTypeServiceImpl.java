package hr.petkovic.fleet.impl.vehicle;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.petkovic.fleet.entities.vehicle.WheelType;
import hr.petkovic.fleet.repositories.vehicle.WheelTypeRepository;
import hr.petkovic.fleet.service.vehicle.WheelTypeService;

@Service
public class WheelTypeServiceImpl implements WheelTypeService {

	@Autowired
	private WheelTypeRepository wheelRepo;

	public WheelTypeServiceImpl(WheelTypeRepository wheelRepo) {
		this.wheelRepo = wheelRepo;
	}

	@Override
	public List<WheelType> findAllTypes() {
		return this.wheelRepo.findAll();
	}

	@Override
	public WheelType findTypeById(Long id) {
		try {
			return this.wheelRepo.findById(id).get();
		} catch (NoSuchElementException ex) {
			return null;
		}
	}

	@Override
	public void deleteTypeById(Long id) {
		this.wheelRepo.deleteById(id);
	}

	@Override
	public WheelType saveType(WheelType type) {
		return this.wheelRepo.save(type);
	}

	@Override
	public WheelType updateType(Long id, WheelType type) {
		Optional<WheelType> optWheel = this.wheelRepo.findById(id);
		if (optWheel.isPresent()) {
			WheelType wheel = optWheel.get();
			wheel.setType(type.getType());
			return this.wheelRepo.save(wheel);
		} else {
			return this.wheelRepo.save(type);
		}
	}
}
