package hr.petkovic.fleet.impl.vehicle;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.petkovic.fleet.entities.vehicle.CarManufacturer;
import hr.petkovic.fleet.entities.vehicle.CarModel;
import hr.petkovic.fleet.repositories.vehicle.CarModelRepository;
import hr.petkovic.fleet.service.vehicle.CarModelService;

@Service
public class CarModelServiceImpl implements CarModelService {

	@Autowired
	private CarModelRepository modelRepo;

	public CarModelServiceImpl(CarModelRepository modelRepo) {
		this.modelRepo = modelRepo;
	}

	@Override
	public List<CarModel> findAllModels() {
		return this.modelRepo.findAll();

	}

	@Override
	public CarModel findModelById(Long id) {
		try {
			return this.modelRepo.findById(id).get();
		} catch (NoSuchElementException ex) {
			return null;
		}
	}

	@Override
	public void deleteModelById(Long id) {
		this.modelRepo.deleteById(id);
	}

	@Override
	public CarModel saveModel(CarModel model) {
		return this.modelRepo.save(model);
	}

	@Override
	public CarModel updateModel(Long id, CarModel model) {
		Optional<CarModel> optModel = this.modelRepo.findById(id);
		if (optModel.isPresent()) {
			CarModel mod = optModel.get();
			mod.setCarModel(model.getCarModel());
			return this.modelRepo.save(mod);
		} else {
			return this.modelRepo.save(model);
		}
	}

	@Override
	public List<CarModel> findAllModelsForManufacturer(CarManufacturer manufacturer) {
		return this.modelRepo.findByManufacturer_id(manufacturer.getId());
	}
}
