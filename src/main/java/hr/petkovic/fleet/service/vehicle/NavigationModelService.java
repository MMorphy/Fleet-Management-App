package hr.petkovic.fleet.service.vehicle;

import java.util.List;

import hr.petkovic.fleet.entities.vehicle.NavigationModel;

public interface NavigationModelService {

	public abstract List<NavigationModel> findAllNavModels();

	public abstract NavigationModel findNavModelById(Long id);

	public abstract void deleteNavModelById(Long id);

	public abstract NavigationModel saveNavModel(NavigationModel navModel);

	public abstract NavigationModel updateNavModel(Long id, NavigationModel navModel);
}
