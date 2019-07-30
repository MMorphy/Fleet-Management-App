package hr.petkovic.fleet.impl.vehicle;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.petkovic.fleet.entities.vehicle.Navigation;
import hr.petkovic.fleet.entities.vehicle.NavigationModel;
import hr.petkovic.fleet.repositories.vehicle.NavigationRepository;
import hr.petkovic.fleet.service.vehicle.NavigationService;

@Service
public class NavigationServiceImpl implements NavigationService {

	@Autowired
	private NavigationRepository navRepo;

	public NavigationServiceImpl(NavigationRepository navRepo) {
		this.navRepo = navRepo;
	}

	@Override
	public List<Navigation> findAllNavs() {
		return this.navRepo.findAll();
	}

	@Override
	public List<Navigation> findAllNavsByModel(NavigationModel model) {
		return this.navRepo.findByModel_ModelLike(model.getModel());
	}

	@Override
	public Navigation findNavById(Long id) {
		try {
			return this.navRepo.findById(id).get();
		} catch (NoSuchElementException ex) {
			return null;
		}
	}

	@Override
	public void deleteNavById(Long id) {
		this.navRepo.deleteById(id);
	}

	@Override
	public Navigation saveNav(Navigation nav) {
		return this.navRepo.save(nav);
	}

	@Override
	public Navigation updateNav(Long id, Navigation nav) {
		Optional<Navigation> optNav= this.navRepo.findById(id);
		if (optNav.isPresent()) {
			Navigation nv = optNav.get();
			nv.setModel(nav.getModel());
			return this.navRepo.save(nv);
		} else {
			return this.navRepo.save(nav);
		}
	}

	@Override
	public Navigation findIntegratedNav() {
		return this.navRepo.findByModel_Model("INTEGRATED");
	}
}
