package hr.petkovic.fleet.impl.vehicle;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.petkovic.fleet.entities.vehicle.TireType;
import hr.petkovic.fleet.repositories.vehicle.TireTypeRepository;
import hr.petkovic.fleet.service.vehicle.TireTypeService;

@Service
public class TireTypeServiceImpl implements TireTypeService {

	@Autowired
	private TireTypeRepository typeRepo;

	public TireTypeServiceImpl(TireTypeRepository typeRepo) {
		this.typeRepo = typeRepo;
	}

	@Override
	public List<TireType> findAllTypes() {
		return this.typeRepo.findAll();
	}

	@Override
	public TireType findTypeById(Long id) {
		try {
			return this.typeRepo.findById(id).get();
		} catch (NoSuchElementException ex) {
			return null;
		}
	}

	@Override
	public void deleteTypeById(Long id) {
		this.typeRepo.deleteById(id);
	}

	@Override
	public TireType saveType(TireType type) {
		return this.typeRepo.save(type);
	}

	@Override
	public TireType updateType(Long id, TireType type) {
		Optional<TireType> optType = this.typeRepo.findById(id);
		if (optType.isPresent()) {
			TireType typ = optType.get();
			typ.setType(type.getType());
			return this.typeRepo.save(typ);
		} else {
			return this.typeRepo.save(type);
		}
	}
}
