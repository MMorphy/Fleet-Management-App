package hr.petkovic.fleet.service.vehicle;

import java.util.List;

import hr.petkovic.fleet.entities.vehicle.CarManufacturer;
import hr.petkovic.fleet.entities.vehicle.CarModel;

public interface CarModelService {

	public abstract List<CarModel> findAllModels();

	public abstract CarModel findModelById(Long id);

	public abstract void deleteModelById(Long id);

	public abstract CarModel saveModel(CarModel model);

	public abstract CarModel updateModel(Long id, CarModel model);

	public abstract List<CarModel> findAllModelsForManufacturer(CarManufacturer manufacturer);
}
