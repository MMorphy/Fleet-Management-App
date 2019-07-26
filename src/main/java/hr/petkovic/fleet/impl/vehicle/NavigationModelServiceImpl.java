package hr.petkovic.fleet.impl.vehicle;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.petkovic.fleet.entities.vehicle.NavigationModel;
import hr.petkovic.fleet.repositories.vehicle.NavigationModelRepository;
import hr.petkovic.fleet.service.vehicle.NavigationModelService;

@Service
public class NavigationModelServiceImpl implements NavigationModelService {

	@Autowired
	private NavigationModelRepository modelRepo;

	public NavigationModelServiceImpl(NavigationModelRepository modelRepo) {
		this.modelRepo = modelRepo;
	}

	@Override
	public List<NavigationModel> findAllNavModels() {
		return this.modelRepo.findAll();
	}

	@Override
	public NavigationModel findNavModelById(Long id) {
		try {
			return this.modelRepo.findById(id).get();
		} catch (NoSuchElementException ex) {
			return null;
		}
	}

	@Override
	public void deleteNavModelById(Long id) {
		this.modelRepo.deleteById(id);
	}

	@Override
	public NavigationModel saveNavModel(NavigationModel navModel) {
		return this.modelRepo.save(navModel);
	}

	@Override
	public NavigationModel updateNavModel(Long id, NavigationModel navModel) {
		Optional<NavigationModel> optModel = this.modelRepo.findById(id);
		if (optModel.isPresent()) {
			NavigationModel model = optModel.get();
			model.setModel(navModel.getModel());
			return this.modelRepo.save(model);
		} else {
			return this.modelRepo.save(navModel);
		}
	}
}
