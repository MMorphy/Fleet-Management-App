package hr.petkovic.fleet.service.vehicle;

import java.util.List;

import hr.petkovic.fleet.entities.vehicle.Navigation;
import hr.petkovic.fleet.entities.vehicle.NavigationModel;

public interface NavigationService {

	public abstract List<Navigation> findAllNavs();

	public abstract List<Navigation> findAllNavsByModel(NavigationModel model);

	public abstract Navigation findNavById(Long id);

	public abstract void deleteNavById(Long id);

	public abstract Navigation saveNav(Navigation nav);

	public abstract Navigation updateNav(Long id, Navigation nav);
}
