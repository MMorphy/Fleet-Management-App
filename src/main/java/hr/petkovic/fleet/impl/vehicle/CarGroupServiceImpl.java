package hr.petkovic.fleet.impl.vehicle;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.petkovic.fleet.entities.vehicle.CarGroup;
import hr.petkovic.fleet.repositories.vehicle.CarGroupRepository;
import hr.petkovic.fleet.service.vehicle.CarGroupService;

@Service
public class CarGroupServiceImpl implements CarGroupService {

	@Autowired
	private CarGroupRepository groupRepo;

	public CarGroupServiceImpl(CarGroupRepository groupRepo) {
		this.groupRepo = groupRepo;
	}

	@Override
	public List<CarGroup> findAllGroups() {
		return this.groupRepo.findAll();
	}

	@Override
	public CarGroup findGroupById(Long id) {
		try {
			return this.groupRepo.findById(id).get();
		} catch (NoSuchElementException ex) {
			return null;
		}
	}

	@Override
	public void deleteCarGroupById(Long id) {
		this.groupRepo.deleteById(id);
	}

	@Override
	public CarGroup saveGroup(CarGroup group) {
		return this.groupRepo.save(group);
	}

	@Override
	public CarGroup updateGroup(Long id, CarGroup group) {
		Optional<CarGroup> optGroup = this.groupRepo.findById(id);
		if (optGroup.isPresent()) {
			CarGroup grp = optGroup.get();
			grp.setCarGroup(group.getCarGroup());
			return this.groupRepo.save(grp);
		} else {
			return this.groupRepo.save(group);
		}
	}
}
